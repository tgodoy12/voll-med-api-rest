package med.voll.api.medico;

public record ListarMedicoDTO(
        long id,
        String nombre,
        String email,
        String documento,
        Especialidad especialidad) {

    public ListarMedicoDTO(Medico medico) {
        this(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getEspecialidad());
    }
}
