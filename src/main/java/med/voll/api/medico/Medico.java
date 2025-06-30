package med.voll.api.medico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")  // dos objetos son iguales si tienen el mismo id
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded
    private Direccion direccion; //atributo multivaluado, se transforma en atributos simples en la tabla

    public Medico(MedicoDTO medicoDTO) {
        this.nombre = medicoDTO.nombre();
        this.email = medicoDTO.email();
        this.telefono = medicoDTO.telefono();
        this.documento = medicoDTO.documento();
        this.especialidad = medicoDTO.especialidad();
        this.direccion = new Direccion(medicoDTO.direccion());
    }

    public void actualizarDatos(@Valid ActualizarMedicoDTO actualizarMedicoDTO) {
        if(actualizarMedicoDTO.nombre() != null) this.nombre = actualizarMedicoDTO.nombre();
        if(actualizarMedicoDTO.telefono() != null) this.telefono = actualizarMedicoDTO.telefono();
        if(actualizarMedicoDTO.direccion() != null) this.direccion.actualizarDireccion(actualizarMedicoDTO.direccion());
    }
}
