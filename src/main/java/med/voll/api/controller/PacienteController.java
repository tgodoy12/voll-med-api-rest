package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.PacienteDTO;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
