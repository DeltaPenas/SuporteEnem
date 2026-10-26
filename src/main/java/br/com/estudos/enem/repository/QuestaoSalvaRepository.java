package br.com.estudos.enem.repository;
import br.com.estudos.enem.entity.QuestaoSalva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestaoSalvaRepository extends JpaRepository<QuestaoSalva, Long> {}
