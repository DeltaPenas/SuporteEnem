package br.com.estudos.enem.repository;
import br.com.estudos.enem.entity.QuestaoSalva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestaoSalvaRepository extends JpaRepository<QuestaoSalva, Long> {

    List<QuestaoSalva> findByUsuarioId(Long id);
}
