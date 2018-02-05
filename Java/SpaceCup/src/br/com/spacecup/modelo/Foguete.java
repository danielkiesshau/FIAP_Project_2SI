package br.com.spacecup.modelo;

public class Foguete {
    
    private String nome;
    private double peso;
    private String cor;    
    private Equipe equipe;

    public Foguete(String nome, double peso, String cor, Equipe equipe) {
        this.nome = nome;
        this.peso = peso;
        this.cor = cor;
        this.equipe = equipe;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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
