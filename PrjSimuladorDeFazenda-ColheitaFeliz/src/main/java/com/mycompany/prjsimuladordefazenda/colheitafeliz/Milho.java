
package com.mycompany.prjsimuladordefazenda.colheitafeliz;

public class Milho extends Cultura {
    
    public Milho() {
        super("Milho", 5, -1, 10);
    }
    
    @Override
    public int colher(){
        if (diasDeCrescimento == tempoDeCrescimento){
            diasDeCrescimento = -1;
            return valorDeVenda;
        } else if (diasDeCrescimento == 8){
            diasDeCrescimento = -1;
            return valorDeVenda * 180/100;
        } else if (diasDeCrescimento > -1 && diasDeCrescimento < 8){
            diasDeCrescimento = -1;
            return valorDeVenda;
        }
        return 0;
    }
}
