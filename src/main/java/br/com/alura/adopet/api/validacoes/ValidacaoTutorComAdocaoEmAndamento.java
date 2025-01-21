package br.com.alura.adopet.api.validacoes;


import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.excpetion.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidacaoTutorComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;


    public void validar(SolicitacaoAdocaoDto dto) {
        List<Adocao> adocoes = adocaoRepository.findAll();

        boolean tutorComAdocaoEmAndamento = adocaoRepository.
                existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO);

        //Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());
        adocoes.forEach(a -> {
            if (tutorComAdocaoEmAndamento) {
                throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
                //return ResponseEntity.badRequest().body("Tutor já possui outra adoção aguardando avaliação!");
            }
        });
    }
}
