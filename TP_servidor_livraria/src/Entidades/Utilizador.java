/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "utilizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilizador.findAll", query = "SELECT u FROM Utilizador u")
    , @NamedQuery(name = "Utilizador.findById", query = "SELECT u FROM Utilizador u WHERE u.id = :id")
    , @NamedQuery(name = "Utilizador.findByNome", query = "SELECT u FROM Utilizador u WHERE u.nome = :nome")
    , @NamedQuery(name = "Utilizador.findByPerfil", query = "SELECT u FROM Utilizador u WHERE u.perfil = :perfil")})
@SequenceGenerator(name = "ui", sequenceName = "ui", initialValue = 1 , allocationSize = 1)
public class Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ui") 
    @Column(name = "id")
    private Short id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "perfil")
    private String perfil;

    public Utilizador() {
    }

    public Utilizador(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilizador)) {
            return false;
        }
        Utilizador other = (Utilizador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Utilizador[ id=" + id + " ]";
    }
    
}
