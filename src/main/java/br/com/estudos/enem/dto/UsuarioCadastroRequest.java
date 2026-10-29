package br.com.estudos.enem.dto;

public class UsuarioCadastroRequest {

    private String nome;
    private String email;
    private String senha;

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEmail(){
        return email;
    }
    public void SetEmail(String email){
        this.email = email;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }




}
