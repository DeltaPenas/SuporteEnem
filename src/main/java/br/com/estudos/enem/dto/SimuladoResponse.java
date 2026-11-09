package br.com.estudos.enem.dto;

import br.com.estudos.enem.entity.EnumStatus;

import java.time.LocalDateTime;


public class SimuladoResponse {
    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private EnumStatus status;
    private int qtdQuestoes;

    public SimuladoResponse(){

    }

    public SimuladoResponse(Long id, LocalDateTime dataInicio, LocalDateTime dataFim, EnumStatus status, int qtdQuestoes){
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.qtdQuestoes = qtdQuestoes;
    }

    public long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }


    public LocalDateTime getDataInicio(){
        return dataInicio;
    }
    public void setDataInicio(LocalDateTime dataInicio){
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDateTime dataFim){
        this.dataFim = dataFim;
    }

    public EnumStatus getStatus(){
        return status;
    }
    public void setStatus(EnumStatus status){
        this.status = status;
    }

    public int getQtdQuestoes(){
        return  qtdQuestoes;
    }
    public void setQtdQuestoes(int qtdQuestoes){
        this.qtdQuestoes = qtdQuestoes;
    }
    
}
