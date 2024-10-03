
package com.mycompany.prjsimuladordefazenda.colheitafeliz;

import java.util.Scanner;

public class GerenciadorDeFazenda {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Milho milho = new Milho();
        Tomate tomate = new Tomate();
        Batata batata = new Batata();
        Vaca vaca = new Vaca();
        Ovelha ovelha = new Ovelha();
        Galinha galinha = new Galinha();
        
        Fazenda fazenda = new Fazenda(10, 10, 10, 50, 0); 
        int i = -1;
        int ii;
        int iii;
        int iv;
        int v;
        int vi;
        
        while (i != 0) {
            
            if (fazenda.moedas <= 0){
                i = 0;
            }
            
            System.out.println("\n------Reserva-De-Recursos-----");
            System.out.println("Dias.Passados.: " + fazenda.diasPassados);
            System.out.println("Agua..........: " + fazenda.aguaDisponivel);
            System.out.println("Racao.........: " + fazenda.racaoDisponivel);
            System.out.println("Fertilizante..: " + fazenda.fertilizanteDisponiveis);
            System.out.println("Moedas........: " + fazenda.moedas + "$");
            System.out.println("---------Quadro-De-Avisos--------");
            fazenda.mostrarDetalhesCultura(milho);
            fazenda.mostrarDetalhesCultura(tomate);
            fazenda.mostrarDetalhesCultura(batata);
            System.out.println("---------------------------------");
            
            System.out.println("0. Fechar o programa");
            System.out.println("1. Plantar algum tipo de cultura");
            System.out.println("2. Colher alguma cultura");
            System.out.println("3. Alimentar os animais");
            System.out.println("4. Coletar produto animal");
            System.out.println("5. Ir ao Mercado");
            System.out.println("6. Passar o dia");
            System.out.print("Qual opcao deseja escolher ?.: ");
            i = sc.nextInt();
                    
            switch (i) {
                case 0:
                    System.out.println("Fechando o programa...");
                break;
                case 1:
                    
                    menu:
                    
                    System.out.println("0. Voltar");
                    System.out.println("1. Milho  $5");
                    System.out.println("2. Tomate $5");
                    System.out.println("3. Batata $10");
                    System.out.print("Qual tipo de cultura deseja plantar ? :");
                    ii = sc.nextInt();
                    
                    switch (ii) {
                        case 0:
                        break;
                        case 1:
                            fazenda.plantarCultura(milho);
                        break;
                        case 2:
                            fazenda.plantarCultura(tomate);
                        break;
                        case 3:
                            fazenda.plantarCultura(batata);
                        break; 
                        default:
                            System.out.println("Insira uma opcao valida");
                    }                  
                break;
                case 2:
                    
                    if(fazenda.culturas.isEmpty()){
                        System.out.println("Nao tem nenhuma cultura plantada !");
                    } else {
                        System.out.println("0. Voltar");
                        System.out.println("1. Milho");
                        System.out.println("2. Tomate");
                        System.out.println("3. Batata");
                        System.out.print("Qual tipo de cultura deseja colher ? :");
                        iii = sc.nextInt();

                        switch (iii) {
                            case 0:
                            break;
                            case 1:
                                fazenda.colherCultura(milho);
                            break;
                            case 2:
                                fazenda.colherCultura(tomate);
                            break;
                            case 3:
                                fazenda.colherCultura(batata);
                            break;
                            default:
                                System.out.println("Insira um valor valido!");
                        }
                    }

                    break;
                
                case 3:
                    System.out.println("0. Voltar");
                    System.out.println("1. Vaca");
                    System.out.println("2. Galinha");
                    System.out.println("3. Ovelha");
                    System.out.println("Qual voce desejar alimentar ? : ");
                    iv = sc.nextInt();
                    
                    switch (iv) {
                        case 0:
                        break;
                        case 1:
                            if(vaca.animalComprado == true){
                                fazenda.alimentar(vaca);
                            } else {
                                System.out.println("Voce nao possui esse animal");
                            }
                        break;
                        case 2:
                            if(galinha.animalComprado == true){
                                fazenda.alimentar(galinha);
                            } else {
                                System.out.println("Voce nao possui esse animal");
                            }
                        break;
                        case 3:
                            if(ovelha.animalComprado == true){
                                fazenda.alimentar(ovelha);
                            } else {
                                System.out.println("Voce nao possui esse animal");
                            }
                        break;
                        default:
                            System.out.println("Opcao invalida !");
                    }
                break;
                case 4:
                    System.out.println("0. Voltar");
                    System.out.println("1. Vaca");
                    System.out.println("2. Galinha");
                    System.out.println("3. Ovelha");
                    System.out.println("Qual voce desejar coletar ? : ");
                    v = sc.nextInt();
                    
                    switch (v) {
                        case 0:
                        break;
                        case 1:
                            if(vaca.animalComprado == true){
                                if(vaca.animalAlimentado == true){
                                    fazenda.coletarProducaoAnimal(vaca);
                            }
                        } else { System.out.println("Voce nao possui esse animal"); }
                        break;
                        case 2:
                            if(galinha.animalComprado == true){
                                if(galinha.animalAlimentado == true){
                                    fazenda.coletarProducaoAnimal(galinha);
                            }
                        } else { System.out.println("Voce nao possui esse animal"); }
                        break;
                        case 3:
                            if(ovelha.animalComprado == true){
                                if(ovelha.animalAlimentado == true){
                                    fazenda.coletarProducaoAnimal(ovelha);
                            }
                        } else { System.out.println("Voce nao possui esse animal"); }
                        break;
                        default:
                            System.out.println("Opcao invalida !");
                    }
                break;
                case 5:
                    System.out.println("------Bem vindo ao mercado !------ ");
                    System.out.println("0. Voltar");
                    System.out.println("1. Fertilizante $10 5-uni");
                    System.out.println("2. Agua         $7  4-uni");
                    System.out.println("3. Vaca         $60");
                    System.out.println("4. Galinha      $30");
                    System.out.println("5. Ovelha       $40");
                    System.out.print("Escolha uma opcao : ");
                    vi = sc.nextInt();
                    
                    switch (vi) {
                        case 0:
                        break;
                        case 1:
                            fazenda.comprarRecursos(vi);
                        break;
                        case 2:
                            fazenda.comprarRecursos(vi);
                        break;
                        case 3:
                            fazenda.comprarAnimais(vaca);
                        break;
                        case 4:
                            fazenda.comprarAnimais(galinha);
                        break;
                        case 5:
                            fazenda.comprarAnimais(ovelha);
                        break;
                        default:
                            System.out.println("Numero invalido !");
                    }
                case 6:
                    if(vaca.animalAlimentado == false){
                        vaca.resetarDiasAlimento();
                    }
                    
                    fazenda.diasPassados++;
                    vaca.animalColetado = false;
                    vaca.animalAlimentado = false;
                    
                    if(milho.diasDeCrescimento > -1 && milho.diasDeCrescimento < 8 ){
                        milho.crescer();
                    }
                    if(tomate.diasDeCrescimento > -1 && tomate.diasDeCrescimento < 4 ){
                        tomate.crescer();
                    }
                    if(batata.diasDeCrescimento > -1 && batata.diasDeCrescimento < 6 ){
                        batata.crescer();
                    }
                    
                break;
                default:
                    System.out.println("Insira uma opcao valida");
            }
        }
    }
}


