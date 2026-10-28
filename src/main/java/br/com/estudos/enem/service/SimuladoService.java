package br.com.estudos.enem.service;

import br.com.estudos.enem.entity.EnumStatus;
import br.com.estudos.enem.entity.Simulado;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SimuladoService {
    Simulado save(Simulado simulado);
    Simulado update(Long id, Simulado simulado);
    void delete(Long id);
    Simulado findById(Long id);
    Simulado alterarStatus(Long id, EnumStatus status); // usa o enum com os status
    List<Simulado> findByStatus(EnumStatus status);
}
