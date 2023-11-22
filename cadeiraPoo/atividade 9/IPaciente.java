import java.util.Collection;
interface IPaciente {
    public String getId();
    public void addMedico(IMedico medico);
    public void removerMedico(String idMedico);
    public Collection<IMedico> getMedicos();
    public String getDiagnostico();
}