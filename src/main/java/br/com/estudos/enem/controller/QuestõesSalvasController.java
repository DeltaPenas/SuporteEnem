package br.com.estudos.enem.controller;



import br.com.estudos.enem.entity.QuestaoSalva;
import br.com.estudos.enem.service.QuestaoSalvaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questoes")
public class QuestõesSalvasController {

    private final QuestaoSalvaService questaoSalvaService;

    public QuestõesSalvasController(QuestaoSalvaService questaoSalvaService) {
        this.questaoSalvaService = questaoSalvaService;
    }

    @PostMapping
    public QuestaoSalva salvar(@RequestBody QuestaoSalva question) {

        return questaoSalvaService.save(question);
    }
    @PutMapping("/{id}")
    public QuestaoSalva update(@PathVariable Long id, @RequestBody QuestaoSalva question) {
        return questaoSalvaService.update(id, question);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        questaoSalvaService.delete(id);
    }
    @GetMapping("/{id}")
    public QuestaoSalva findById(@PathVariable Long id) {

        return questaoSalvaService.findById(id);
    }
    @GetMapping("/{id}/user")
    public List<QuestaoSalva> findByUsuarioId(@PathVariable Long id) {
        return questaoSalvaService.findByUsuarioId(id);
    }
    @GetMapping
    public List<QuestaoSalva> findAll() {
        return questaoSalvaService.findAll();
    }
}
