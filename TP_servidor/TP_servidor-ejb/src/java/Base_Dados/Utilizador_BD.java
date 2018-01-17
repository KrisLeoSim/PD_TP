/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_Dados;
import Entidades.Utilizador;
import javax.persistence.EntityManager;



//entity gerada pelo ejb


public class Utilizador_BD {
    
   
    private final EntityManager em;

    public Utilizador_BD(EntityManager em) {
        this.em = em;
    }
    
    public Utilizador guardar(Utilizador u) throws Exception{ //guardar e actuaiza caso ja exista
   
       // em.getTransaction().begin();
       
        
        if(u.getId() == null) { //utilizador novo , inserir na BD
        em.persist(u);        
        }else{
//            if(!em.contains(u)){ //caso o entity nao contenha o utilizador
//                if(em.find(Utilizador.class, u.getId()) == null){ //vai tentar encontra-lo se entretanto for apagado ... executa a escepção
//               throw new Exception("Erro ao actualizar o utilizador");
              u = em.merge(u); 
        }
           
                 
        
   //em.getTransaction().commit();
   return u; 
   }
    
    public void remover(int id){
    
        Utilizador u = consultarPorId(id);
        em.remove(u);
         
    }
    
    public Utilizador consultarPorId(int id){
    return em.find(Utilizador.class, id);    
    }
    
    
}
