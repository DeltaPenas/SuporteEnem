package br.com.estudos.enem.service.impl;


import br.com.estudos.enem.entity.RespostaSimulado;
import br.com.estudos.enem.repository.RespostaSimuladoRepository;
import br.com.estudos.enem.service.RespostaSimuladoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaSimuladoServiceImpl implements RespostaSimuladoService {

    private final RespostaSimuladoRepository respostaSimuladoRepository;
    public RespostaSimuladoServiceImpl(RespostaSimuladoRepository respostaSimuladoRepository) {
        this.respostaSimuladoRepository = respostaSimuladoRepository;
    }

    @Override
    public RespostaSimulado save(RespostaSimulado newResponse){
        if(newResponse.getSimulado() == null){
            throw new RuntimeException("erro ao salvar resposta simulado");
        }
        return respostaSimuladoRepository.save(newResponse);
    }

    @Override
    public RespostaSimulado update(Long id, RespostaSimulado updateResponse) {
        RespostaSimulado newResponse = respostaSimuladoRepository.findById(id).orElseThrow(() -> new RuntimeException("erro ao atualizar resposta simulado"));

        newResponse.setSimulado(updateResponse.getSimulado());
        newResponse.setDataResposta(updateResponse.getDataResposta());
        newResponse.setAlternativaSelecionada(updateResponse.getAlternativaSelecionada());
        newResponse.setQuestaoIdExterna(updateResponse.getQuestaoIdExterna());
        newResponse.setCorreta(updateResponse.getCorreta());


        return  respostaSimuladoRepository.save(newResponse);
    }
    @Override
    public void delete(Long id) {
        respostaSimuladoRepository.deleteById(id);
    }
    @Override
    public RespostaSimulado findById(Long id) {
        return respostaSimuladoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Resposta não encontrada"));
    }
    @Override
    public List<RespostaSimulado> findAll(){
        return respostaSimuladoRepository.findAll();
    }

    @Override
    public RespostaSimulado confirm(RespostaSimulado confirmResponse){

       confirmResponse.setCorreta(true);
       return respostaSimuladoRepository.save(confirmResponse);
        
    }


}
