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

    public void actualizarDireccion(DireccionDTO direccionDTO) {
        if(direccionDTO.calle() != null) this.calle = direccionDTO.calle();
        if(direccionDTO.numero() != null) this.numero = direccionDTO.numero();
        if(direccionDTO.complemento() != null) this.complemento = direccionDTO.complemento();
        if(direccionDTO.barrio() != null) this.barrio = direccionDTO.barrio();
        if(direccionDTO.ciudad() != null) this.ciudad = direccionDTO.ciudad();
        if(direccionDTO.estado() != null) this.estado = direccionDTO.estado();
        if(direccionDTO.codigoPostal() != null) this.codigoPostal = direccionDTO.codigoPostal();
    }
}
