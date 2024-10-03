
package com.mycompany.prjsimuladordefazenda.colheitafeliz;

import java.util.List;
import java.util.ArrayList;

public class Fazenda {
    
    protected List <Cultura> culturas;
    protected List <Animal>  animais;
    protected int aguaDisponivel;
    protected int fertilizanteDisponiveis;
    protected int racaoDisponivel;
    protected int moedas;
    protected int diasPassados;
    
    public Fazenda (int aguaDisponivel, int fertilizanteDisponiveis, int racaoDisponivel, int moedas, int diasPassados){
        this.animais = new ArrayList<>();
        this.culturas = new ArrayList<>();
        this.aguaDisponivel = aguaDisponivel;
        this.fertilizanteDisponiveis = fertilizanteDisponiveis;
        this.racaoDisponivel = racaoDisponivel;
        this.moedas = moedas;
        this.diasPassados = diasPassados;
    }
    
    // Preço de custo direto no método pois não havia na documentação
    public void plantarCultura(Cultura cultura) {
        if (cultura.diasDeCrescimento == -1){
            culturas.add(cultura);
            cultura.plantar();
            moedas = moedas - (cultura.valorDeVenda * 50/100);
            System.out.println(cultura.getNome() + " plantado com sucesso!");
        }
        switch (cultura.nome) {
            case "Milho":
                aguaDisponivel--;
                fertilizanteDisponiveis--;
                break;
            case "Tomate":
                aguaDisponivel -= 2;
                fertilizanteDisponiveis--;
                break;
            case "Batata":
                aguaDisponivel--;
                fertilizanteDisponiveis -=2;
                break;
            default:
                break;
        }
    }

    // Precisei atribuir uma uma excessão para o milho conseguir ter dois valores em sua colheita
    public void colherCultura(Cultura cultura) {
        if (cultura.diasDeCrescimento == cultura.tempoDeCrescimento){
            moedas += cultura.colher(); 
            culturas.remove(cultura); 
            System.out.println("Cultura " + cultura.getNome() + " colhida com sucesso!");
        } else if (cultura.nome.equals("Milho") && cultura.diasDeCrescimento > 5 && cultura.diasDeCrescimento <= 8){
            moedas += cultura.colher(); 
            culturas.remove(cultura); 
            System.out.println("Cultura " + cultura.getNome() + " colhida com sucesso!");
        } else {
            System.out.println("Este cultivo ainda nao esta pronto !");
        }
    }
    
    // Metódo simples que não estava no pdf, porém adicionei pois ajuda a saber o estado de cultivo 
    public void mostrarDetalhesCultura(Cultura cultura) {
        if (cultura.diasDeCrescimento == -1) {
            System.out.println("Nenhum(a) " + cultura.getNome() + " Plantado(a)");
        } else if (cultura.diasDeCrescimento < cultura.tempoDeCrescimento) {
            System.out.println(cultura.getNome() + "...: " + cultura.diasDeCrescimento + "/" + cultura.tempoDeCrescimento);
        } else if(cultura.nome.equals("Milho")){
            System.out.println("O milho esta verde, colha agora ou na estacao para um lucro maior : " + cultura.diasDeCrescimento + "/8");
        } else {
            System.out.println("O " + cultura.getNome() + " esta maduro(a)");
        }
    }
    
    public void alimentar(Animal animal){
        if(animal.animalAlimentado == true){
            System.out.println("O animal ja foi alimentado");
        } else {
            animal.animalAlimentado = true;
            racaoDisponivel -= animal.alimentar();
            System.out.println("Animal alimentado !");
        }
    }
    
    public void coletarProducaoAnimal(Animal animal){
        if (animal.animalColetado == false){
            animal.animalColetado = true;
            switch (animal.nome) {
                case "Vaca":
                    moedas += 4 * animal.coletar();
                break;
                case "Galinha":
                    moedas += 3 * animal.coletar();
                break;
                case "Ovelha":
                    moedas += 20 * animal.coletar();
                break;
                default:
                    System.out.println("Animal invalido ");
            } 
        } else {
            System.out.println("O animal ja foi coletado !");
        }
        
    }
    public void comprarRecursos(int a){
        
        switch (a) {
            case 1:
                moedas -= 10;
                fertilizanteDisponiveis += 5;
                System.out.println("Fertilizante comprado com sucesso");
            break;
            case 2:
                moedas -= 7;
                aguaDisponivel += 4;
                System.out.println("Agua comprada com sucesso");
            break;
            default:
                System.out.println("Numero invalido !");
        }
    }
    // Método de um mercado que eu fiz para comprar os animais
    public void comprarAnimais(Animal animal){
        switch (animal.nome) {
                case "Vaca":
                   if(moedas >= 60){
                       moedas -= 60;
                       animal.animalComprado = true;
                       animais.add(animal);
                   } else {
                       System.out.println("Dinheiro insuficiente!");
                   }
                break;
                case "Galinha":
                    if(moedas >= 30){
                       moedas -= 30;
                       animal.animalComprado = true;
                       animais.add(animal);
                    } else {
                        System.out.println("Dinheiro insuficiente!");
                    }
                break;
                case "Ovelha":
                    if(moedas >= 40){
                       moedas -= 40;
                       animal.animalComprado = true;
                       animais.add(animal);
                    } else {
                        System.out.println("Dinheiro insuficiente!");
                    }
                break;
                default:
                    System.out.println("Animal invalido ");
            }
    }
}
