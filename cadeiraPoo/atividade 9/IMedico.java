import java.util.Collection;
interface IMedico {
    public String getId();
    public void addPaciente(IPaciente paciente);
    public void removerPaciente(String idPaciente);
    public Collection<IPaciente> getPacientes();
    public String getClasse();
}