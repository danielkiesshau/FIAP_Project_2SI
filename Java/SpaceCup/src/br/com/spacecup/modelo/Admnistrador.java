package br.com.spacecup.modelo;

public class Admnistrador extends Usuario {

    private int codigo_admnistrador;

    public Admnistrador(String nome, String senha, int codigo_administrador) {
        super(nome, senha);
        this.codigo_admnistrador = codigo_administrador;
    }

}
