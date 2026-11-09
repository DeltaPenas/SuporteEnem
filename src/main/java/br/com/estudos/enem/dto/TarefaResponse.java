package br.com.estudos.enem.dto;

import br.com.estudos.enem.entity.Usuario;

import java.time.LocalDateTime;

public class TarefaResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;
    private boolean concluida;

    public TarefaResponse(Long id, String titulo, LocalDateTime dataCriacao, LocalDateTime dataConclusao, Usuario usuario){

    }

    public TarefaResponse(long id, String titulo, String descricao, LocalDateTime dataCriacao, LocalDateTime dataConclusao, boolean concluida){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataConclusao = dataConclusao;
    }

    public long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao(){
        return dataCriacao;
    }
    public void setDataCriacao(LocalDateTime dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataConclusao(){
        return  dataConclusao;
    }
    public void setDataConclusao(LocalDateTime dataConclusao){
        this.dataConclusao = dataConclusao;
    }

}


