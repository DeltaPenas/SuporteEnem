package br.com.estudos.enem.service.impl;

import br.com.estudos.enem.entity.QuestaoSalva;
import br.com.estudos.enem.repository.QuestaoSalvaRepository;
import br.com.estudos.enem.service.QuestaoSalvaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestaoSalvaServiceImpl implements QuestaoSalvaService {

    private final QuestaoSalvaRepository questaoSalvaRepository;
    public QuestaoSalvaServiceImpl(QuestaoSalvaRepository questaoSalvaRepository){
        this.questaoSalvaRepository = questaoSalvaRepository;
    }

    @Override
    public QuestaoSalva save(QuestaoSalva question) {
        return questaoSalvaRepository.save(question);
    }
    @Override
    public QuestaoSalva update(Long id, QuestaoSalva updatedQuestion) {
        QuestaoSalva newQuestion = questaoSalvaRepository.findById(id).orElseThrow(() -> new RuntimeException("questao não encontrado"));

        newQuestion.setQuestaoIdExterna(updatedQuestion.getQuestaoIdExterna());
        newQuestion.setUsuario(updatedQuestion.getUsuario());
        newQuestion.setDataSalvamento(updatedQuestion.getDataSalvamento());

        return questaoSalvaRepository.save(newQuestion);
    }
    @Override
    public void delete(Long id) {

        questaoSalvaRepository.deleteById(id);
    }
    @Override
    public QuestaoSalva findById(Long id) {
        return questaoSalvaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Questão não encontrada"));
    }
    @Override
    public List<QuestaoSalva> findByUsuarioId(Long id) {

        return questaoSalvaRepository.findByUsuarioId(id);
    }
    @Override
    public List<QuestaoSalva> findAll() {

        return questaoSalvaRepository.findAll();
    }


}
