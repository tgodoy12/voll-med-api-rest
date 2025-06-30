package med.voll.api.paciente;

public record ListarPacienteDTO(
        long id,
        String nombre,
        String email,
        String documento
) {
    public ListarPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getDocumento());
    }
}
