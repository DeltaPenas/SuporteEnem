package br.com.estudos.enem.service;
import br.com.estudos.enem.entity.QuestaoSalva;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface QuestaoSalvaService {
    QuestaoSalva save(QuestaoSalva question);
    QuestaoSalva update(Long id, QuestaoSalva question);
    QuestaoSalva findById(Long id);
    void delete(Long id);
    List<QuestaoSalva> findByUsuarioId(Long id);
    List<QuestaoSalva> findAll();

}
