package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

@Table(name = "pacientes")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;

    @Embedded
    private Direccion direccion;  // atributo multivaluado

    public Paciente(PacienteDTO pacienteDTO) {
        this.nombre = pacienteDTO.nombre();
        this.email = pacienteDTO.email();
        this.telefono = pacienteDTO.telefono();
        this.documento = pacienteDTO.documento();
        this.direccion = new Direccion(pacienteDTO.direccion());
    }
}
