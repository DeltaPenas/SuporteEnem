package br.com.estudos.enem.dto;

public class UsuarioUpdateRequest {

    private String nome;
    private String email;

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email = email;
    }
}
