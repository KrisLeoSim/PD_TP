/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_controlos;

import Entidades.Utilizador;
import javax.ejb.Remote;

/**
 *
 * @author sergio
 */
@Remote
public interface Utilizador_Remote_BeanRemote {
    
    public Utilizador guardar(Utilizador u) throws Exception;
    
    public Utilizador consultarPorId(int id);
    
    public void remover(int id);
}
