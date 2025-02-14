package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AtualizarTutorDto;
import br.com.alura.adopet.api.dto.CadastrarTutorDto;
import br.com.alura.adopet.api.excpetion.ValidacaoException;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

   public void cadastrar(CadastrarTutorDto dto) {
       boolean jaCadastrado = repository.existsByEmailOrEmail(dto.telefone(),dto.email());

       if (jaCadastrado) {
           throw new ValidacaoException("Dados ja cadastrados");
       }

       repository.save(new Tutor(dto));
   }

   public void atualizar(AtualizarTutorDto dto) {
       Tutor tutor = repository.getReferenceById(dto.id());
       tutor.atualizatDados(dto);

   }


}
