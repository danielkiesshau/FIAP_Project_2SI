package br.com.spacecup.modelo;

public class Equipe extends Usuario{
    
    private String turma;

    public Equipe(String nome, String senha, String turma) {
        super(nome, senha);
        this.turma = turma;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
}
