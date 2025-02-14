package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.AtualizarTutorDto;
import br.com.alura.adopet.api.dto.CadastrarTutorDto;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.service.TutorService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    TutorService service;

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastrarTutorDto dto) {
        try {
            service.cadastrar(dto);
            return ResponseEntity.ok().build();
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }



    }

    @PutMapping
    public ResponseEntity<String> atualizar(@RequestBody @Valid AtualizarTutorDto dto) {
        try {
            service.atualizar(dto);
            return ResponseEntity.ok().build();
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
