package br.com.spacecup.dao;

import br.com.spacecup.conexao.Conexao;
import br.com.spacecup.modelo.Equipe;
import br.com.spacecup.modelo.Foguete;
import br.com.spacecup.modelo.Lancamento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LancamentoDAO {

    private Connection conexao;
    private String sql;
    private PreparedStatement p;
    private ResultSet rs;

    public LancamentoDAO() {
        this.conexao = Conexao.getConnection();
    }

    public boolean registrarLancamento(Lancamento lancamento) {
        boolean status = false;
        sql = "insert into spacecup_lancamentos values (?,?,?,?,?,?,?,?,?,?,?,?"
                + ",?,?,?,?,?)";
        try {
            p = conexao.prepareStatement(sql);
            p.setInt(1, lancamento.getNr_lancamento());
            p.setDouble(2, lancamento.getAngulolancamento());
            p.setDouble(3, lancamento.getDistalvo());
            p.setDouble(4, lancamento.getVelvento());
            p.setDouble(5, lancamento.getAltMax());
            p.setDouble(6, lancamento.getVelMax());
            p.setDouble(7, lancamento.getTempoProp());
            p.setDouble(8, lancamento.getPicoAcel());
            p.setDouble(9, lancamento.getAcelMedia());
            p.setDouble(10, lancamento.getTmpApogDesc());
            p.setDouble(11, lancamento.getTempoEje());
            p.setDouble(12, lancamento.getAltEje());
            p.setDouble(13, lancamento.getTaxDesc());
            p.setDouble(14, lancamento.getDurVoo());
            p.setDate(15, lancamento.getData());
            p.setString(16, lancamento.getHora());
            p.setString(17, lancamento.getFoguete().getNome());
            p.execute();
            status = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir lançamento no banco\n" + ex);
        } catch (NullPointerException | NumberFormatException ex) {

        }
        return status;
    }

    public void alterarLancamento_aux(Lancamento lancamento) {
        sql = "update spacecup_lancamentos set angulolancamento = ?,"
                + "distalvo = ?, velvento = ?, altmax = ?, velmax = ?, tempoprop = ?,"
                + "picoacel = ?, acelmedia = ?, tmpapogdesc = ?, tempoeje = ?, alteje = ?,"
                + "taxdesc = ?, durvoo = ?, data = ?, hora = ? where nr_lancamento = ? and nome_foguete = ?";
        try {
            p = conexao.prepareStatement(sql);
            p.setDouble(1, lancamento.getAngulolancamento());
            p.setDouble(2, lancamento.getDistalvo());
            p.setDouble(3, lancamento.getVelvento());
            p.setDouble(4, lancamento.getAltMax());
            p.setDouble(5, lancamento.getVelMax());
            p.setDouble(6, lancamento.getTempoProp());
            p.setDouble(7, lancamento.getPicoAcel());
            p.setDouble(8, lancamento.getAcelMedia());
            p.setDouble(9, lancamento.getTmpApogDesc());
            p.setDouble(10, lancamento.getTempoEje());
            p.setDouble(11, lancamento.getAltEje());
            p.setDouble(12, lancamento.getTaxDesc());
            p.setDouble(13, lancamento.getDurVoo());
            p.setDate(14, lancamento.getData());
            p.setString(15, lancamento.getHora());
            p.setInt(16, lancamento.getNr_lancamento());
            p.setString(17, lancamento.getFoguete().getNome());            
            p.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar lançamento no banco\n" + ex);
        } catch (NullPointerException | NumberFormatException ex) {

        }
    }

    public void excluirLancamento_aux(int id, Foguete foguete) {
        sql = "delete from spacecup_lancamentos where nr_lancamento = ? and nome_foguete = ?";
        try {
            p = conexao.prepareStatement(sql);
            p.setInt(1, id);
            p.setString(2, foguete.getNome());
            p.execute();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir lançamento no banco\n" + ex);
        } catch (NullPointerException | NumberFormatException ex) {

        }
    }
    
    public boolean alterarLancamento(Lancamento lancamento){
        boolean status = false;
        sql = "select * from spacecup_lancamentos where nr_lancamento = ? and nome_foguete = ?";
        
        try {
            p = conexao.prepareStatement(sql);
            p.setInt(1, lancamento.getNr_lancamento());
            p.setString(2, lancamento.getFoguete().getNome());
            rs = p.executeQuery();
            if(rs.next()){
                alterarLancamento_aux(lancamento);
                status = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar lançamento no banco\n" + ex);
        }
        return status;
    }
    
    public boolean excluirLancamento(int id, Foguete foguete) {
        boolean status = false;
        sql = "select * from spacecup_lancamentos where nr_lancamento = ? and nome_foguete = ?";
        try {
            p = conexao.prepareStatement(sql);
            p.setInt(1, id);
            p.setString(2, foguete.getNome());
            rs = p.executeQuery();
            if(rs.next()){
                excluirLancamento_aux(id, foguete);
                status = true;
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir lançamento no banco\n" + ex);
        } catch (NullPointerException | NumberFormatException ex) {

        }
        return status;
    }

    
    public Lancamento pesquisarLancamento(int id, Foguete foguete) {
        Lancamento aux = null;

        sql = "select * from spacecup_lancamentos where nr_lancamento = ? and nome_foguete = ?";
        try {
            p = conexao.prepareStatement(sql);
            p.setInt(1, id);
            p.setString(2, foguete.getNome());
            rs = p.executeQuery();
            if (rs.next()) {
                double angulolancamento = rs.getDouble("angulolancamento");
                double distalvo = rs.getDouble("distalvo");
                double velvento = rs.getDouble("velvento");
                double altMax = rs.getDouble("altMax");
                double velMax = rs.getDouble("velMax");
                double tempoProp = rs.getDouble("tempoProp");
                double picoAcel = rs.getDouble("picoAcel");
                double acelMedia = rs.getDouble("acelMedia");
                double tmpApogDesc = rs.getDouble("tmpApogDesc");
                double tempoEje = rs.getDouble("tempoEje");
                double altEje = rs.getDouble("altEje");
                double taxDesc = rs.getDouble("taxDesc");
                double durVoo = rs.getDouble("durVoo");
                Date data = rs.getDate("data");
                String hora = rs.getString("hora");
                aux = new Lancamento(id, angulolancamento, distalvo, velvento, 
                        altMax, velMax, tempoProp, picoAcel, acelMedia, tmpApogDesc, 
                        tempoEje, altEje, taxDesc, durVoo, data, hora, foguete);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar lançamento no banco\n" + ex);
        }

        return aux;
    }

    public boolean verificarIdExistente(int id, Foguete foguete) {
        boolean status = false;
        sql = "select * from spacecup_lancamentos where nr_lancamento = ? and nome_foguete = ?";

        try {
            p = conexao.prepareStatement(sql);
            p.setInt(1, id);
            p.setString(2, foguete.getNome());
            rs = p.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}
