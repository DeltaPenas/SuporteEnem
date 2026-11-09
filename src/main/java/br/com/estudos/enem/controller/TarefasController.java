package br.com.estudos.enem.controller;

import br.com.estudos.enem.dto.TarefaRequest;
import br.com.estudos.enem.dto.TarefaResponse;
import br.com.estudos.enem.entity.Tarefa;
import br.com.estudos.enem.entity.Usuario;
import br.com.estudos.enem.repository.UsuarioRepository;
import br.com.estudos.enem.service.TarefaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefaService tarefaService;
    private final UsuarioRepository usuarioRepository;

    public TarefasController(TarefaService tarefaService, UsuarioRepository usuarioRepository) {

        this.tarefaService = tarefaService;
        this.usuarioRepository = usuarioRepository;
    }

    private TarefaResponse converter(Tarefa tarefa) {
        return new TarefaResponse(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getDataCriacao(),
                tarefa.getDataConclusao(),
                tarefa.isConcluida()
        );
    }

    @PostMapping
    public TarefaResponse save(@RequestParam Long usuarioId, @RequestBody TarefaRequest request) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Tarefa task = new Tarefa();
        task.setTitulo(request.getTitulo());
        task.setDescricao(request.getDescricao());
        task.setUsuario(usuario);

        Tarefa savedTask = tarefaService.save(task);

        return converter(savedTask);
    }

    @PutMapping("/{id}")
    public TarefaResponse update(@PathVariable Long id, @RequestBody TarefaRequest request) {

        Tarefa task = new Tarefa();

        task.setTitulo(request.getTitulo());
        task.setDescricao(request.getDescricao());

        Tarefa updatedTask = tarefaService.update(id, task);

        return converter(updatedTask);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        tarefaService.delete(id);
    }

    @GetMapping("/{id}")
    public TarefaResponse findById(@PathVariable Long id) {
        return converter(tarefaService.findById(id));
    }

    @PatchMapping("/{id}/concluir")
    public TarefaResponse concluir(@PathVariable Long id) {
        return converter(tarefaService.concluir(id));
    }
}
