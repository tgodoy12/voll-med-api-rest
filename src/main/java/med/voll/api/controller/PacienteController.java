package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.ListarPacienteDTO;
import med.voll.api.paciente.PacienteDTO;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid PacienteDTO pacienteDTO) {
        pacienteRepositorio.save(new Paciente(pacienteDTO));
    }

    /**
     * Endpoint GET /pacientes
     *
     * Retorna una lista paginada de pacientes, ordenados por nombre.
     *
     * Utiliza la interfaz Pageable de Spring Data para soportar:
     * - Paginación automática mediante los parámetros page y size.
     * - Ordenamiento dinámico usando el parámetro sort (por defecto: nombre ascendente).
     *
     * Ejemplo de uso:
     *   /pacientes?page=0&size=5&sort=nombre,desc
     *
     * Cada entidad Paciente es mapeada a un objeto ListaPacienteDTO
     * para exponer solo los datos necesarios en la respuesta.
     *
     * @param pageable parámetros de paginación y orden (inyectados automáticamente)
     * @return una página de objetos ListaPacienteDTO
     */
    @GetMapping
    public Page<ListarPacienteDTO> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable pageable) {
        return pacienteRepositorio.findAll(pageable).map(ListarPacienteDTO::new);
    }


}
