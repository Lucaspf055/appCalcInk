package com.lucaspf.appcalcink.model;

public class Wall {
    private Double altura;
    private Double largura;
    private  int portas;
    private int janelas;

    public Wall(Double altura, Double largura, int portas, int janelas) {
        this.altura = altura;
        this.largura = largura;
        this.portas = portas;
        this.janelas = janelas;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public int getJanelas() {
        return janelas;
    }

    public void setJanelas(int janelas) {
        this.janelas = janelas;
    }
}
