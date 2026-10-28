package br.com.estudos.enem.controller;


import br.com.estudos.enem.entity.RespostaSimulado;
import br.com.estudos.enem.repository.RespostaSimuladoRepository;
import br.com.estudos.enem.service.RespostaSimuladoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*

    RespostaSimulado confirm(RespostaSimulado respostaSimulado);
*/


@RestController
@RequestMapping("/respostasSimulado")
public class RespostaSimuladoController {


    private final RespostaSimuladoService respostaSimuladoService;

    public RespostaSimuladoController(RespostaSimuladoService respostaSimuladoService) {
        this.respostaSimuladoService = respostaSimuladoService;
    }

    @PostMapping
    public RespostaSimulado save(@RequestBody RespostaSimulado response){
        return respostaSimuladoService.save(response);
    }
    @PutMapping("/{id}")
    public RespostaSimulado update(@PathVariable RespostaSimulado response){
        return respostaSimuladoService.update(response.getId(), response);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        respostaSimuladoService.delete(id);
    }
    @GetMapping("/{id}")
    public RespostaSimulado findById(@RequestParam Long id){
        return respostaSimuladoService.findById(id);
    }
    @GetMapping
    public List<RespostaSimulado> findAll(){
        return respostaSimuladoService.findAll();
    }
    @PatchMapping("/{id}")
    public RespostaSimulado confirm(RespostaSimulado response){
        return respostaSimuladoService.confirm(response);

    }



}
