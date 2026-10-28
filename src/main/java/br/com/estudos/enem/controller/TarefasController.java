package br.com.estudos.enem.controller;

import br.com.estudos.enem.entity.Tarefa;
import br.com.estudos.enem.service.TarefaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefaService tarefaService;

    public TarefasController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }
    @PostMapping
    public Tarefa salvar(@RequestBody Tarefa tarefa) {
        return tarefaService.save(tarefa);
    }
    @PutMapping("/{id}")
    public Tarefa update(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.update(id, tarefa);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {

        tarefaService.delete(id);
    }
    @GetMapping("/{id}")
    public Tarefa findbyId(@PathVariable Long id) {

        return tarefaService.findById(id);
    }
    @PatchMapping("/{id}/concluir")
    public Tarefa concluir(@PathVariable Long id) {

        return tarefaService.concluir(id);
    }
}
