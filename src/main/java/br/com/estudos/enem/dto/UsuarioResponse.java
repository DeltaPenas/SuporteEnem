package br.com.estudos.enem.dto;

import br.com.estudos.enem.entity.Usuario;

public class UsuarioResponse {

    private long id;
    private String nome;
    private String email;
    private boolean ativo;

    public UsuarioResponse(){

    }

    public UsuarioResponse(long id, String nome, String email, boolean ativo){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
    }

    public long getId(){
        return  id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public boolean getAtivo(){
        return ativo;
    }
    public void setAtivo(Boolean ativo){
        this.ativo = ativo;
    }

    private UsuarioResponse converterParaResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.isAtivo()
        );
    }


}


