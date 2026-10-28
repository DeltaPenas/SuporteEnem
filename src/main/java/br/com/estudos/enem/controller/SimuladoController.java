
package br.com.estudos.enem.controller;

import br.com.estudos.enem.entity.EnumStatus;
import br.com.estudos.enem.entity.Simulado;
import br.com.estudos.enem.service.SimuladoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulados")
public class SimuladoController {

    private final SimuladoService simuladoService;

    public SimuladoController(SimuladoService simuladoService) {
        this.simuladoService = simuladoService;
    }

    @PostMapping
    public Simulado save(@RequestBody Simulado simulado) {
        return simuladoService.save(simulado);
    }

    @PutMapping("/{id}")
    public Simulado update(
            @PathVariable Long id,
            @RequestBody Simulado simulado) {
        return simuladoService.update(id, simulado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        simuladoService.delete(id);
    }

    @GetMapping("/{id}")
    public Simulado findById(@PathVariable Long id) {
        return simuladoService.findById(id);
    }

    @GetMapping
    public List<Simulado> findByStatus(
            @RequestParam EnumStatus status) {
        return simuladoService.findByStatus(status);
    }

    @PatchMapping("/{id}/status")
    public Simulado alterarStatus(
            @PathVariable Long id,
            @RequestParam EnumStatus status) {
        return simuladoService.alterarStatus(id, status);
    }
}
