
package com.mycompany.prjsimuladordefazenda.colheitafeliz;

public abstract class Cultura {

    protected String nome;
    protected int tempoDeCrescimento;
    protected int diasDeCrescimento;
    protected int valorDeVenda;

    public Cultura(String nome, int tempoDeCrescimento, int diasDeCrescimento, int valorDeVenda) {
        this.nome = nome;
        this.tempoDeCrescimento = tempoDeCrescimento;
        this.diasDeCrescimento = diasDeCrescimento;
        this.valorDeVenda = valorDeVenda;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void plantar(){
        diasDeCrescimento = 0;
    }
    
    public void crescer(){
        diasDeCrescimento++;
    }
    
    public int colher(){
        diasDeCrescimento = -1;
        return valorDeVenda;
    }
}
