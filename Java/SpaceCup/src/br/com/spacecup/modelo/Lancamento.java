package br.com.spacecup.modelo;

import java.sql.Date;

public class Lancamento {
    
    private int nr_lancamento;
    private double angulolancamento;
    private double distalvo;
    private double velvento;
    private double altMax;
    private double velMax;
    private double tempoProp;
    private double picoAcel;
    private double acelMedia;
    private double tmpApogDesc;
    private double tempoEje;
    private double altEje;
    private double taxDesc;
    private double durVoo;
    private Date data;
    private String hora;
    private Foguete foguete;

    public Lancamento(int nr_lancamento, double angulolancamento, double distalvo, 
            double velvento, double altMax, double velMax, double tempoProp, 
            double picoAcel, double acelMedia, double tmpApogDesc, double tempoEje, 
            double altEje, double taxDesc, double durVoo, Date data, String hora, 
            Foguete foguete) {
        this.nr_lancamento = nr_lancamento;
        this.angulolancamento = angulolancamento;
        this.distalvo = distalvo;
        this.velvento = velvento;
        this.altMax = altMax;
        this.velMax = velMax;
        this.tempoProp = tempoProp;
        this.picoAcel = picoAcel;
        this.acelMedia = acelMedia;
        this.tmpApogDesc = tmpApogDesc;
        this.tempoEje = tempoEje;
        this.altEje = altEje;
        this.taxDesc = taxDesc;
        this.durVoo = durVoo;
        this.data = data;
        this.hora = hora;
        this.foguete = foguete;
    }

    public int getNr_lancamento() {
        return nr_lancamento;
    }

    public void setNr_lancamento(int nr_lancamento) {
        this.nr_lancamento = nr_lancamento;
    }

    public double getAngulolancamento() {
        return angulolancamento;
    }

    public void setAngulolancamento(double angulolancamento) {
        this.angulolancamento = angulolancamento;
    }

    public double getDistalvo() {
        return distalvo;
    }

    public void setDistalvo(double distalvo) {
        this.distalvo = distalvo;
    }

    public double getVelvento() {
        return velvento;
    }

    public void setVelvento(double velvento) {
        this.velvento = velvento;
    }

    public double getAltMax() {
        return altMax;
    }

    public void setAltMax(double altMax) {
        this.altMax = altMax;
    }

    public double getVelMax() {
        return velMax;
    }

    public void setVelMax(double velMax) {
        this.velMax = velMax;
    }

    public double getTempoProp() {
        return tempoProp;
    }

    public void setTempoProp(double tempoProp) {
        this.tempoProp = tempoProp;
    }

    public double getPicoAcel() {
        return picoAcel;
    }

    public void setPicoAcel(double picoAcel) {
        this.picoAcel = picoAcel;
    }

    public double getAcelMedia() {
        return acelMedia;
    }

    public void setAcelMedia(double acelMedia) {
        this.acelMedia = acelMedia;
    }

    public double getTmpApogDesc() {
        return tmpApogDesc;
    }

    public void setTmpApogDesc(double tmpApogDesc) {
        this.tmpApogDesc = tmpApogDesc;
    }

    public double getTempoEje() {
        return tempoEje;
    }

    public void setTempoEje(double tempoEje) {
        this.tempoEje = tempoEje;
    }

    public double getAltEje() {
        return altEje;
    }

    public void setAltEje(double altEje) {
        this.altEje = altEje;
    }

    public double getTaxDesc() {
        return taxDesc;
    }

    public void setTaxDesc(double taxDesc) {
        this.taxDesc = taxDesc;
    }

    public double getDurVoo() {
        return durVoo;
    }

    public void setDurVoo(double durVoo) {
        this.durVoo = durVoo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Foguete getFoguete() {
        return foguete;
    }

    public void setFoguete(Foguete foguete) {
        this.foguete = foguete;
    }

}
