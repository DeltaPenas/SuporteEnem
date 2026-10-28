package br.com.estudos.enem.service;
import br.com.estudos.enem.entity.RespostaSimulado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RespostaSimuladoService {
    RespostaSimulado save(RespostaSimulado respostaSimulado);
    RespostaSimulado update(Long id, RespostaSimulado respostaSimulado);
    void delete(Long id);
    RespostaSimulado findById(Long id);
    List<RespostaSimulado> findAll();
    RespostaSimulado confirm(RespostaSimulado respostaSimulado);
}
