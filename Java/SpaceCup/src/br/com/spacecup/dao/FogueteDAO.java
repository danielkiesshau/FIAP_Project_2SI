
package br.com.spacecup.dao;

import br.com.spacecup.conexao.Conexao;
import br.com.spacecup.modelo.Equipe;
import br.com.spacecup.modelo.Foguete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FogueteDAO {
    private Connection conexao;
    private String sql;
    private PreparedStatement p;
    private ResultSet rs;
    
    public FogueteDAO() {
        this.conexao = Conexao.getConnection();
    }
    
    public boolean registrarFoguete(Foguete foguete){
        boolean status = false;
        sql = "insert into spacecup_foguetes values (?,?,?,?)";
        
        try {
            p = conexao.prepareStatement(sql);
            p.setString(1, foguete.getNome());
            p.setDouble(2, foguete.getPeso());
            p.setString(3, foguete.getCor()); 
            p.setString(4, foguete.getEquipe().getNome());
            p.execute();
            status = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir foguete no banco\n" + ex);
        }
        return status;
    }
    
    public Foguete pesquisarFoguete(Equipe equipe){
        Foguete foguete = null;
        
        sql = "select * from spacecup_foguetes where nome_equipe = ?";
        
        try {
            p = conexao.prepareStatement(sql);
            p.setString(1, equipe.getNome());
            rs = p.executeQuery();
            if(rs.next()){
                String nome = rs.getString("nome_foguete");
                Double peso = rs.getDouble("peso");
                String cor = rs.getString("cor");                
                foguete = new Foguete(nome, peso, cor, equipe);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar foguete no banco\n" + ex);
        }
        
        return foguete;
    }
}
