
package br.com.estudos.enem.controller;

import br.com.estudos.enem.dto.SimuladoRequest;
import br.com.estudos.enem.dto.SimuladoResponse;
import br.com.estudos.enem.entity.EnumStatus;
import br.com.estudos.enem.entity.Simulado;
import br.com.estudos.enem.entity.Usuario;
import br.com.estudos.enem.repository.SimuladoRepository;
import br.com.estudos.enem.repository.UsuarioRepository;
import br.com.estudos.enem.service.SimuladoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulados")
public class SimuladoController {

    private final SimuladoService simuladoService;
    private final SimuladoRepository simuladoRepository;
    private final UsuarioRepository usuarioRepository;

    public SimuladoController(SimuladoService simuladoService, SimuladoRepository simuladoRepository, UsuarioRepository usuarioRepository) {

        this.simuladoService = simuladoService;
        this.simuladoRepository = simuladoRepository;
        this.usuarioRepository = usuarioRepository;
    }


    private SimuladoResponse converter(Simulado simulado){
        return new SimuladoResponse(
                simulado.getId(),
                simulado.getDataInicio(),
                simulado.getDataFim(),
                simulado.getStatus(),
                simulado.getQtdQuestao()
        );
    }



    @PostMapping
    public SimuladoResponse save(@RequestParam Long usuarioId, @RequestBody SimuladoRequest request) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Simulado simulation = new Simulado();
        simulation.setQtdQuestao(request.getQtdQuestoes());
        simulation.setUsuario(usuario);

        Simulado savedSimulation = simuladoService.save(simulation);

        return converter(savedSimulation);
    }

    @PutMapping("/{id}")
    public SimuladoResponse update(@PathVariable Long id, @RequestBody SimuladoRequest request) {

        Simulado simulation = new Simulado();
        simulation.setQtdQuestao(request.getQtdQuestoes());

        Simulado newSimulation = simuladoService.update(id, simulation);

        return converter(newSimulation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        simuladoService.delete(id);
    }

    @GetMapping("/{id}")
    public SimuladoResponse findById(@PathVariable Long id) {
        return converter(simuladoService.findById(id));

    }


    @GetMapping
    public List<SimuladoResponse> findByStatus(@RequestParam EnumStatus status) {
        return simuladoService.findByStatus(status).stream().map(this::converter).toList();
    }

    @PatchMapping("/{id}/status")
    public SimuladoResponse alterarStatus(@PathVariable Long id, @RequestParam EnumStatus status) {

        return converter(simuladoService.alterarStatus(id, status));
    }
}
