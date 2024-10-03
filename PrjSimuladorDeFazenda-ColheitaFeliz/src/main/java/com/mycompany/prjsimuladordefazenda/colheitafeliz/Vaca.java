
package com.mycompany.prjsimuladordefazenda.colheitafeliz;

public class Vaca extends Animal{
    
    protected int diasAlimentados;
    
    public Vaca() {
        super("Vaca", 4, 5, 2, false, false, false);
        this.diasAlimentados = 0;
    }

    public void resetarDiasAlimento(){
        diasAlimentados = 0;
    }
    
    @Override
    public int alimentar(){
        diasAlimentados++;
        return producaoDiaria;
    }
    
    @Override
    public int coletar(){
        if (diasAlimentados > 5){
            return producaoDiaria + 3;
        }
        return producaoDiaria;
    }
            
}
