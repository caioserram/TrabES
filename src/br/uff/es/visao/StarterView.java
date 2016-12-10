package br.uff.es.visao;

import br.uff.es.controle.ControladorMaterial;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StarterView {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            String continua = "S";
            String nome, descricao;
            double preco = 0;
            while (continua.equalsIgnoreCase("s")) {
                System.out.println("-----MATERIAL-----");
                System.out.print("NOME: ");
                nome = teclado.nextLine();
                boolean precoValido = false;
                while (!precoValido || preco < 0) {
                    precoValido = true;
                    System.out.print("PREÇO: ");
                    try {
                        preco = teclado.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("PREÇO INVÁLIDO");
                        precoValido = false;
                        teclado.next();
                    }
                }
                System.out.print("DESCRIÇÃO: ");
                teclado.next();
                descricao = teclado.nextLine();
                System.out.println("Deseja continuar? (S/N)");
                continua = teclado.nextLine();
                
                ControladorMaterial.inserirMaterial(nome, descricao, preco);
                
            }
        }
            ControladorMaterial.recuperarListaMaterial().forEach((m) -> {
            System.out.println(m);
        });
    }

}
