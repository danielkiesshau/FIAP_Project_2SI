package br.com.spacecup.dao;

import br.com.spacecup.conexao.Conexao;
import br.com.spacecup.modelo.Aluno;
import br.com.spacecup.modelo.Equipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorDAO {
    private Connection conexao;
    private String sql;
    private PreparedStatement p;
    private ResultSet rs;
    
    public AdministradorDAO(){
        this.conexao = Conexao.getConnection();
    }
    
    public void registrarEquipe(Equipe equipe) throws SQLException{
        sql = "insert into spacecup_equipes values (?,?,?)";

            p = conexao.prepareStatement(sql);
            p.setString(1, equipe.getNome());
            p.setString(2, equipe.getSenha());
            p.setString(3, equipe.getTurma());
            p.execute();                      

    }
    
    public void registrarAluno(Aluno aluno) throws SQLException {
        sql = "insert into spacecup_alunos values (?,?, ?)";

            p = conexao.prepareStatement(sql);
            p.setInt(1, aluno.getRm());
            p.setString(2, aluno.getNome());
            p.setString(3, aluno.getEquipe().getNome());
            p.execute();
            
    }   
    
    public boolean verificarEquipeExistente (String nome){
        boolean status = false;
        sql = "select * from spacecup_equipes where nome_equipe = ?";
        
        try {
            p = conexao.prepareStatement(sql);
            p.setString(1, nome);
            rs = p.executeQuery();
            if(rs.next()){
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return status;
    }
    
    public boolean verificarRMExistente (int rm){
        boolean status = false;
        sql = "select * from spacecup_alunos where rm = ?";
        
        try {
            p = conexao.prepareStatement(sql);
            p.setInt(1, rm);
            rs = p.executeQuery();
            if(rs.next()){
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return status;
    }
    
    public void deletarEquipe (String nome){
        sql = "delete from spacecup_equipes where nome_equipe = ?";
        
        try {
            p = conexao.prepareStatement(sql);
            p.setString(1, nome);
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletarAluno (int rm){
        sql = "delete from spacecup_alunos where rm = ?";
        
        try {
            p = conexao.prepareStatement(sql);
            p.setInt(1, rm);
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
