package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DireccionDTO;

public record PacienteDTO(
        @NotBlank String nombre,
        @NotBlank String email,
        @NotBlank String telefono,
        @NotBlank String documento,
        @NotNull @Valid DireccionDTO direccion
) {

}
