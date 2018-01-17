/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente_tp;

import java.util.Scanner;



/**
 *
 * @author sergio
 */
public abstract class ClassBase {
    
    
    
    public static int obtemOpcaoMenu(int max) {
       Scanner sc = new Scanner(System.in); 

        int opcao;

        String texto;

        while (true) {

            try {
                System.out.print("Opção -> ");
                //opcao = sc.nextInt();  -- mais falível e difícil de controlar

                texto = sc.next();

                opcao = Integer.parseInt(texto);

                if ( (opcao > 0) && (opcao <= max) )

                    return opcao;

                System.out.println("Opcao errada, por favor escolha uma opção correta.");

            }

            catch (NumberFormatException e) {

                System.out.println("problema de keybord");

            }

        }

    }
    
    public static String obtem_palavra(){
        Scanner sc = new Scanner(System.in); 
    return sc.next();   
    }
    
    public static String obtem_linha_palavras(){
        Scanner sc = new Scanner(System.in); 
    return sc.nextLine();   
    }
}
