package br.com.estudos.enem.service;
import org.springframework.stereotype.Service;
import br.com.estudos.enem.entity.Tarefa;

@Service
public interface TarefaService {
    Tarefa save(Tarefa tarefa);
    Tarefa update(Long id, Tarefa tarefa);
    void delete(Long id);
    Tarefa findById(Long id);
    Tarefa concluir(Long id);

}
