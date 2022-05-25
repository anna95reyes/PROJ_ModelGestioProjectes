/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author anna9
 */
public class Projecte implements Serializable {
    
    private Integer id;
    private String nom;
    private String descripcio;
    
    private Usuari capProjecte;
    private List<Tasca> tasques = new ArrayList();
    private List<ProjecteUsuariRol> usuarisRol = new ArrayList();
    
    protected Projecte() {
    }

    public Projecte(Integer id, String nom, Usuari capProjecte) {
        setId(id);
        setNom(nom);
        setCapProjecte(capProjecte);
    }

    public Projecte(Integer id, String nom, String descripcio, Usuari capProjecte) {
        setId(id);
        setNom(nom);
        setDescripcio(descripcio);
        setCapProjecte(capProjecte);
    }

    public Projecte(Integer id, String nom, String descripcio, Usuari capProjecte, List<Tasca> tasques, List<ProjecteUsuariRol> usuaris) {
        setId(id);
        setNom(nom);
        setDescripcio(descripcio);
        setCapProjecte(capProjecte);
        this.tasques = tasques;
        this.usuarisRol = usuaris;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("La id es obligatoria i positiva");
        }
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null || nom.length() <= 0){
            throw new RuntimeException("El nom es obligatori i no buit");
        }
        
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        if (descripcio != null && descripcio.length() <= 0){
            throw new RuntimeException("La descripcio es nula o amb contingut");
        }
        this.descripcio = descripcio;
    }

    public void setCapProjecte(Usuari capProjecte) {
        if (capProjecte == null) {
            throw new RuntimeException("El cap del projecte es obligatori");
        }
        this.capProjecte = capProjecte;
    }

    public Usuari getCapProjecte() {
        return capProjecte;
    }
    
    //add, remove, iterator
    public Iterator<Tasca> iteTasques(){
        return tasques.iterator();
    }
    
    public void addTasca(Tasca tasca){
        if (tasca == null){
            throw new RuntimeException("Intent d'afegir una tasca nulla");
        }
        tasques.add(tasca);
    }
    
    public void removeTasca(Tasca tasca){
        if(tasques.contains(tasca)){
            tasques.remove(tasca);
        }
    }
    
    public Iterator<ProjecteUsuariRol> iteUsuarisRols(){
        return usuarisRol.iterator();
    }
    
    public void addUsuariRol(ProjecteUsuariRol usuariRol){
        if (usuariRol == null){
            throw new RuntimeException("Intent d'afegir un usuariRol null");
        }
        if (usuariRol.getProjecte() == null){
            if (!this.usuarisRol.contains(usuariRol)){
                usuarisRol.add(usuariRol);
            }
        }
    }
    
    public void removeUsuariRol (ProjecteUsuariRol usuariRol){
        if(usuarisRol.contains(usuariRol)){
            usuarisRol.remove(usuariRol);
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Projecte other = (Projecte) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Projecte{" + "id=" + id + ", nom=" + nom + ", descripcio=" + descripcio + ", capProjecte=" + capProjecte + ", tasques=" + tasques + ", usuaris=" + usuarisRol + '}';
    }

    
}
