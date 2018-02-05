package br.com.spacecup.modelo;

public class Aluno {
    
    private int rm;
    private String nome;
    private Equipe equipe;

    public Aluno(int rm, String nome, Equipe equipe) {
        this.rm = rm;
        this.nome = nome;
        this.equipe = equipe;
    }

    public int getRm() {
        return rm;
    }

    public void setRm(int rm) {
        this.rm = rm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

}
