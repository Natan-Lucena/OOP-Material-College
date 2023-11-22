import java.util.TreeMap;
import java.util.Collection;
class Medico implements IMedico{
    String sender;
    String classe;
    TreeMap<String, IPaciente> pacientes = new TreeMap<>();
    public Medico(String sender, String classe){
        this.sender = sender;
        this.classe = classe;
    }
    public String getId(){
        return this.sender;
    }
    public void addPaciente(IPaciente paciente){
        this.pacientes.put(paciente.getId(),paciente);
    }
    public void removerPaciente(String idPaciente){
        this.pacientes.remove(idPaciente);
    }
    public Collection<IPaciente> getPacientes(){
        return pacientes.values();
    }
    public String getClasse(){
        return this.classe;
    }
    @Override
    public String toString(){
        return "Medico{" +
                "sender='" + sender + '\'' +
                ", classe='" + classe + '\'' +
                ", pacientes=" + pacientes +
                '}';
    }
}