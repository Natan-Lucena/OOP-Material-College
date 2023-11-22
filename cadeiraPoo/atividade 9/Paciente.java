import java.util.TreeMap;
import java.util.Collection;
class Paciente implements IPaciente {
    protected String sender;
    protected String diagnostico;
    protected TreeMap<String, IMedico> medicos = new TreeMap<>();
    
    public Paciente(String sender, String diagnostico){
        this.sender = sender;
        this.diagnostico = diagnostico;
    }
    public String getId(){
        return this.sender;
    }
    public void addMedico(IMedico medico){
        this.medicos.put(medico.getId(), medico);
    }
    public void removerMedico(String idMedico){
        this.medicos.remove(idMedico);
    }
    public Collection<IMedico> getMedicos(){
        return medicos.values();
    }
    public String getDiagnostico(){
        return this.diagnostico;
    }
    @Override
    public String toString(){
        return "Paciente{" +
                "sender='" + sender + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", medicos=" + medicos.values() +
                '}';
    }
}