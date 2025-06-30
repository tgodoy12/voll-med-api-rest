package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepositorio medicoRepositorio;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid MedicoDTO medicoDTO) {
        medicoRepositorio.save(new Medico(medicoDTO));
    }


    /**
     * Endpoint GET /medicos
     *
     * Retorna una lista paginada de médicos activos, ordenados por nombre.
     *
     * Utiliza la clase Pageable de Spring Data para soportar:
     * - Paginación automática (page, size)
     * - Ordenamiento (por defecto ordena por "nombre")
     *
     * Ejemplo de uso desde Postman o navegador:
     *   /medicos?page=0&size=5&sort=especialidad,desc
     *
     * El resultado es mapeado a ListaMedicoDTO para no exponer directamente la entidad Medico.
     *
     * @param pageable parámetros de paginación y orden (inyectados automáticamente)
     * @return una página de objetos ListaMedicoDTO
     */
    @GetMapping
    public Page<ListarMedicoDTO> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable pageable) {
        return medicoRepositorio.findAll(pageable).map(ListarMedicoDTO::new);
    }

    /**
     * Escribir una descripcion detallada del metodo actualizar
     */
    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid ActualizarMedicoDTO actualizarMedicoDTO) {
        var medico = medicoRepositorio.getReferenceById(actualizarMedicoDTO.id());
        medico.actualizarDatos(actualizarMedicoDTO);
    }



}
