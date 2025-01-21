package br.com.alura.adopet.api.repository;

import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

    boolean existsByPetIdAndStatus(Long idPet, StatusAdocao status);

    boolean existsByPetId(Long idPet);

    boolean existsByTutorIdAndStatus(Long idTutor, StatusAdocao status);

    int countByTutorIdAndStatus(Long tutorId, StatusAdocao status);
}
