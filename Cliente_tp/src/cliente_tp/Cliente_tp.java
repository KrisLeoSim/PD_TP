/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente_tp;

import Ejb_controlos.Utilizador_Remote_BeanRemote;
import Entidades.Utilizador;
import javax.naming.InitialContext;

import java.util.Properties;
import java.util.Scanner;
import javax.naming.NamingException;


/**
 *
 * @author sergio
 */
public class Cliente_tp {

    static Utilizador_Remote_BeanRemote ejb;

    static Scanner sc = new Scanner(System.in);
    
    public static void getRemoteReferences() {

        InitialContext ctx = null;

        Properties prop = new Properties();

        

        prop.setProperty("java.naming.factory.initial",

                     "com.sun.enterprise.naming.SerialInitContextFactory");

        prop.setProperty("java.naming.factory.url.pkgs",

                     "com.sun.enterprise.naming");

        prop.setProperty("java.naming.factory.state",

                     "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

        prop.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.56.175");

        prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");



        try {

            ctx = new InitialContext(prop);

        }catch (NamingException e) {

            System.out.println(e.getMessage());

            System.exit(1);

        }

        System.out.println("InitialContext done");



        //String remotename = "java:global/exemplo-ea/exemplo-ea-ejb/GuardaString!logica.GuardaStringRemote";

        try {

            System.out.println("start lookup");

            ejb = (Utilizador_Remote_BeanRemote)  ctx.lookup("Ejb_controlos.Utilizador_Remote_BeanRemote");

        }catch(NamingException e) {

            System.out.println(e.getMessage());

            e.printStackTrace();  // melhor -> mandar para log

            System.exit(1);

        }

        System.out.println("JNDI lookup done");

    }
    
    
    
      
    public static void main(String[] args) throws Exception {
 
       
        int opcao;
        String nome = "0";
       // Login log= new Login(ejb);
        
        boolean proceed = true;

        getRemoteReferences();

        int estado = 0;
 
       // String perfil = log.Interface_Login();
         
        
        //adiciona um utilizador
        while(proceed)  {
        System.out.println("adicionar utilizador");
        Utilizador um = new Utilizador(); 
        
        um.setNome("Joao");
        //um.setDataNascimento(df.parce("11/5/2000"));
        um = ejb.guardar(um);
        System.out.println("utilizador salvo com id: "+ um.getId());
        
        
        proceed = false;
        }
       

        
        
        
        
    }
    
}
