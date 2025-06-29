package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Direccion {
    private String calle;
    private String numero;
    private String complemento;
    private String barrio;
    private String ciudad;
    private String estado;
    private String codigoPostal;

    public Direccion(DireccionDTO direccionDTO) {
        this.calle = direccionDTO.calle();
        this.numero = direccionDTO.numero();
        this.complemento = direccionDTO.complemento();
        this.barrio = direccionDTO.barrio();
        this.ciudad = direccionDTO.ciudad();
        this.estado = direccionDTO.estado();
        this.codigoPostal = direccionDTO.codigoPostal();
    }
}
