package br.com.estudos.enem.service.impl;

import br.com.estudos.enem.entity.Tarefa;
import br.com.estudos.enem.repository.TarefaRepository;
import br.com.estudos.enem.service.TarefaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;
    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public Tarefa save(Tarefa newTask) {
       if(newTask.getTitulo() == null || newTask.getTitulo().isBlank()){
           throw  new IllegalArgumentException("O titulo é obrigatorio");
       }
       if(newTask.getUsuario() == null || !newTask.getUsuario().isAtivo()){
           throw new IllegalArgumentException("O usuario é invalido");
       }
       newTask.setDataCriacao(LocalDateTime.now());
       newTask.setConcluida(false);
       newTask.setDataConclusao(null);

       return tarefaRepository.save(newTask);
    }

    @Override
    public Tarefa update(Long id, Tarefa updatedTask) {

        Tarefa existingTask = tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));

        if (updatedTask.getTitulo() == null || updatedTask.getTitulo().isBlank()) {
            throw new IllegalArgumentException("O título é obrigatório");
        }

        existingTask.setTitulo(updatedTask.getTitulo());
        existingTask.setDescricao(updatedTask.getDescricao());

        return tarefaRepository.save(existingTask);
    }

    @Override
    public void delete(Long id) {
        tarefaRepository.deleteById(id);
    }
    @Override
    public Tarefa findById(Long id) {
        return tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }
    @Override
    public Tarefa concluir(Long id) {

        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));

        if (!tarefa.isConcluida()) {
            tarefa.setConcluida(true);
            tarefa.setDataConclusao(LocalDateTime.now());
        }

        return tarefaRepository.save(tarefa);
    }

}
