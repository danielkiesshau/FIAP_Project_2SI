package br.com.spacecup.dao;

import br.com.spacecup.conexao.Conexao;
import br.com.spacecup.modelo.Aluno;
import br.com.spacecup.modelo.Equipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EquipeDAO {
    private Connection conexao;
    private String sql;
    private PreparedStatement p;
    private ResultSet rs;
    
    public EquipeDAO() {
        this.conexao = Conexao.getConnection();
    }
    
    public List<Aluno> retornarComponentes(Equipe equipe){

        sql = "select * from spacecup_alunos where nome_equipe = ?";
        List<Aluno> lista = new ArrayList<Aluno>();
        
        try {
            p = conexao.prepareStatement(sql);
            p.setString(1, equipe.getNome());
            rs = p.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome_aluno");
                int rm = rs.getInt("rm");
                Aluno aluno = new Aluno(rm, nome, equipe);
                lista.add(aluno);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de listagem no banco\n" + ex);
        }
        return lista;
    }
}
