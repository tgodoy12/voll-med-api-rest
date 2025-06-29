package med.voll.api.direccion;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(
        @NotBlank String calle,
        String numero,
        String complemento,
        @NotBlank String barrio,
        @NotBlank String ciudad,
        @NotBlank String estado,
        @NotBlank String codigoPostal) {
}
