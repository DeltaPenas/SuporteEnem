package br.com.estudos.enem.repository;
import br.com.estudos.enem.entity.RespostaSimulado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaSimuladoRepository extends JpaRepository<RespostaSimulado, Integer> {}
