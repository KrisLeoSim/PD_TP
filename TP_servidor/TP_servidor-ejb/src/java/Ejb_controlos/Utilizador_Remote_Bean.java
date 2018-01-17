/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_controlos;

import Base_Dados.Utilizador_BD;
import Entidades.Utilizador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sergio
 */

@Stateless
public class Utilizador_Remote_Bean implements Utilizador_Remote_BeanRemote {

  private final EntityManager em;
    
    private final EntityManagerFactory factory;

    public Utilizador_Remote_Bean() {
        this.factory = Persistence.createEntityManagerFactory("TPservidorPU");
        em = factory.createEntityManager();
    }
    
    @Override
    public Utilizador guardar(Utilizador u) throws Exception {
        Utilizador_BD uti_bd = new Utilizador_BD(em);
        return uti_bd.guardar(u);
    }

    @Override
    public Utilizador consultarPorId(int id) {
        Utilizador_BD uti_bd = new Utilizador_BD(em);
        return uti_bd.consultarPorId(id);
    }

    @Override
    public void remover(int id) {
        Utilizador_BD uti_bd = new Utilizador_BD(em);
       uti_bd.remover(id);
    }

}
