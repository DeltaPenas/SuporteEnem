package br.com.estudos.enem.dto;

public class UsuarioUpdateRequest {

    private String nome;
    private String email;

    private String getNome(){
        return nome;
    }
    private void setNome(String nome){
        this.nome = nome;
    }

    private String getEmail(){
        return email;
    }
    private void setEmail(){
        this.email = email;
    }
}
