package br.com.estudos.enem.repository;
import br.com.estudos.enem.entity.Simulado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimuladoRepository extends JpaRepository<Simulado, Long> {}
