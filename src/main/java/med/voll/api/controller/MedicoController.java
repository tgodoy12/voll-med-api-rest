package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.ListaMedicoDTO;
import med.voll.api.medico.MedicoDTO;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<ListaMedicoDTO> listar() {
        return medicoRepositorio.findAll().stream().map(ListaMedicoDTO::new).toList();
    }



}
