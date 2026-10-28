package br.com.estudos.enem.service.impl;

import br.com.estudos.enem.entity.EnumStatus;
import br.com.estudos.enem.entity.Simulado;
import br.com.estudos.enem.repository.SimuladoRepository;
import br.com.estudos.enem.service.SimuladoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SimuladoServiceImpl implements SimuladoService {

    private final SimuladoRepository simuladoRepository;
    public SimuladoServiceImpl(SimuladoRepository simuladoRepository) {
        this.simuladoRepository = simuladoRepository;
    }


    @Override
    public Simulado save(Simulado newSimulation) {
        if( newSimulation.getUsuario() == null || newSimulation.getDataInicio() == null || newSimulation.getStatus() == null){
            throw new RuntimeException("Erro ao criar o simulado");
        }
        return simuladoRepository.save(newSimulation);
    }
    @Override
    public  Simulado update(Long id, Simulado updatedSimulation) {
        Simulado newSimulation = simuladoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Simulado não encontrado"));

        newSimulation.setUsuario(updatedSimulation.getUsuario());
        newSimulation.setDataInicio(updatedSimulation.getDataInicio());
        newSimulation.setDataFim(updatedSimulation.getDataFim());
        newSimulation.setStatus(updatedSimulation.getStatus());
        newSimulation.setQtdQuestao(updatedSimulation.getQtdQuestao());

        return simuladoRepository.save(newSimulation);
    }

    @Override
    public void delete(Long id){
        simuladoRepository.deleteById(id);
    }

    @Override
    public Simulado findById(Long id){
        return simuladoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Simulado não encontrado"));
    }

    @Override
    public Simulado alterarStatus(Long id, EnumStatus status) {
        Simulado simuladoAlterado = simuladoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Simulado não encontrado"));
        simuladoAlterado.setStatus(status);
        return simuladoRepository.save(simuladoAlterado);
    }

    @Override
    public List<Simulado> findByStatus(EnumStatus status){
        return simuladoRepository.findByStatus(status);
    }








}

