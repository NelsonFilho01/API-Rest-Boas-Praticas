package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.excpetion.ValidacaoException;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(SolicitacaoAdocaoDto dto) {

        boolean petEstaDisponivel = adocaoRepository.existsByPetId(dto.idPet());

        if (petEstaDisponivel) {
            throw new ValidacaoException("Pet já foi adotado!");
            // return ResponseEntity.badRequest().body("");
        }
    }

}
