import java.util.TreeMap;
class Hospital {
    private TreeMap<String, IPaciente> pacientes = new TreeMap<>();
    private TreeMap<String, IMedico> medicos = new TreeMap<>();
    public Hospital() {}
    public void removerPaciente(String sender){
        this.pacientes.remove(sender);
    }
    public void removerMedico(String sender){
        this.medicos.remove(sender);
    }
    public void addPaciente(IPaciente paciente){
        this.pacientes.put(paciente.getId(), paciente);
    }
    public void addMedico(IMedico medico){
        this.medicos.put(medico.getId(), medico);
    }
    
    public void vincular(String nomeMedico, String nomePaciente) {
    IMedico medico = medicos.get(nomeMedico);
    IPaciente paciente = pacientes.get(nomePaciente);

    if (medico != null && paciente != null) {
        boolean mesmoDiagnostico = false;

        for (IMedico pacienteMedico : paciente.getMedicos()) {
            if (pacienteMedico.getClasse().equals(medico.getClasse())) {
                mesmoDiagnostico = true;
                break;
            }
        }

        if (!mesmoDiagnostico) {
            medico.addPaciente(paciente);
            paciente.addMedico(medico);
        } else {
            System.out.println("fail: ja existe outro medico da especialidade " + medico.getClasse());
        }
    }
}


@Override
public String toString() {
    StringBuilder result = new StringBuilder();

    for (IPaciente paciente : pacientes.values()) {
        result.append(String.format("Pac: %-17sMeds: [", paciente.getId() + ":" + paciente.getDiagnostico()));
        int medicoCount = 0;
        for (IMedico medico : paciente.getMedicos()) {
            result.append(medico.getId());
            medicoCount++;
            if (medicoCount < paciente.getMedicos().size()) {
                result.append(", "); 
            }
        }
        result.append("]\n");
    }

    for (IMedico medico : medicos.values()) {
        result.append(String.format("Med: %-17sPacs: [", medico.getId() + ":" + medico.getClasse()));
        int pacienteCount = 0; 
        for (IPaciente paciente : medico.getPacientes()) {
            result.append(paciente.getId());
            pacienteCount++;
            if (pacienteCount < medico.getPacientes().size()) {
                result.append(", "); 
            }
        }
        result.append("]\n");
    }

    return result.toString();
}








}