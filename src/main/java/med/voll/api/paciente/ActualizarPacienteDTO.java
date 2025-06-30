package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DireccionDTO;

public record ActualizarPacienteDTO(
        @NotNull long id,
        String nombre,
        String telefono,
        @Valid DireccionDTO direccion
) {
}
