package med.voll.api.medico;

public record ListaMedicoDTO(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad) {

    public ListaMedicoDTO(Medico medico) {
        this(
                medico.getNombre(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getEspecialidad());
    }
}
