package br.com.estudos.enem.repository;
import br.com.estudos.enem.entity.EnumStatus;
import br.com.estudos.enem.entity.Simulado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimuladoRepository extends JpaRepository<Simulado, Long> {

    List<Simulado> findByStatus(EnumStatus status);
}
