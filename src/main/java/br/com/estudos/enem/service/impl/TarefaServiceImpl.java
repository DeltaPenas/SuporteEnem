package br.com.estudos.enem.service.impl;

import br.com.estudos.enem.entity.Tarefa;
import br.com.estudos.enem.repository.TarefaRepository;
import br.com.estudos.enem.service.TarefaService;
import org.springframework.stereotype.Service;

@Service
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;
    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public Tarefa save(Tarefa newTask) {
        if(newTask.getTitulo() == null|| newTask.getTitulo().isBlank() || newTask.getUsuario() == null || !newTask.getUsuario().isAtivo()||
                newTask.getDataCriacao() == null || newTask.getDataConclusao() == null){
            throw new IllegalArgumentException("tarefa Invalida");
        }
        return tarefaRepository.save(newTask);
    }

    @Override
    public Tarefa update(Long id, Tarefa updatedTask) {
        Tarefa newTask = tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));

        newTask.setTitulo(updatedTask.getTitulo());
        newTask.setUsuario(updatedTask.getUsuario());
        newTask.setDataCriacao(updatedTask.getDataCriacao());
        newTask.setDataCriacao(updatedTask.getDataCriacao());
        newTask.setDataConclusao(updatedTask.getDataConclusao());

        return tarefaRepository.save(newTask);
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
        Tarefa completedTask = tarefaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("tarefa a ser concluida não encontrada"));
        completedTask.setConcluida(true);
        return tarefaRepository.save(completedTask);
    }

}
