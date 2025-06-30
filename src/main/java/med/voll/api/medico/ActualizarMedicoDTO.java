package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DireccionDTO;

public record ActualizarMedicoDTO(
        @NotNull long id,
        String nombre,
        String telefono,
        @Valid DireccionDTO direccion
) {
}
