
package com.mycompany.prjsimuladordefazenda.colheitafeliz;

public abstract class Animal {
    
    protected String nome;
    protected int idade;
    protected int producaoDiaria;
    protected int consumoDeRacao;
    protected boolean animalColetado;
    protected boolean animalAlimentado;
    protected boolean animalComprado;
    
    public Animal(String nome, int idade, int producaoDiaria, int consumoDeRacao, boolean animalColetado, boolean animalAlimentado, boolean animalComprado){
        this.idade = idade;
        this.nome = nome;
        this.consumoDeRacao = consumoDeRacao;
        this.producaoDiaria = producaoDiaria;
        this.animalColetado = animalColetado;
        this.animalAlimentado = animalAlimentado;
        this.animalComprado = animalComprado;
    }
    
    public int alimentar(){
        return consumoDeRacao;
    }
    
    public int coletar(){
        animalColetado = true;
        return producaoDiaria;
    }
    
}
