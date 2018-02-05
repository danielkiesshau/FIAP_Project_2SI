/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spacecup.dao;

import br.com.spacecup.conexao.Conexao;
import br.com.spacecup.modelo.Equipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesley
 */
public class LoginDAO {
    
    private Connection conexao;
    private String sql;
    private PreparedStatement p;
    private ResultSet rs;
    
    public LoginDAO(){
        this.conexao = Conexao.getConnection();
    }
    
    public boolean validarLogin(String nome, String senha){
        boolean status = false;
        sql = "select * from spacecup_equipes where nome_equipe = ? and senha = ?";
        
        try {
            p = conexao.prepareStatement(sql);
            p.setString(1, nome);
            p.setString(2, senha);
            rs = p.executeQuery();
            if(rs.next()){
                status = true;              
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar equipe no banco\n"+ex);
        }
        
        return status;
    }
    
    public Equipe retornarEquipe(String nome, String senha){
        Equipe aux = null;
        
        sql = "select * from spacecup_equipes where nome_equipe = ? and senha = ?";
        
        try {
            p = conexao.prepareStatement(sql);
            p.setString(1, nome);
            p.setString(2, senha);
            rs = p.executeQuery();
            if(rs.next()){
                String nome_equipe = rs.getString("nome_equipe");
                String senha_equipe = rs.getString("senha");
                String turma = rs.getString("turma");
                aux = new Equipe(nome_equipe, senha_equipe, turma);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar equipe no banco\n"+ex);
        }
        
        return aux;
    }

}
