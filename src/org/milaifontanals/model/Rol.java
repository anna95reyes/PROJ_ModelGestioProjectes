/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author anna9
 */
public class Rol {
    private Integer id;
    private String nom;
    
    private List<ProjecteUsuariRol> usuarisProjectes = new ArrayList();

    protected Rol() {
    }

    public Rol(Integer id, String nom) {
        setId(id);
        setNom(nom);
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

    public Iterator<ProjecteUsuariRol> iteUsuarisProjectes(){
        return usuarisProjectes.iterator();
    }
    
    public void addUsuariProjecte(ProjecteUsuariRol usuariProjecte){
        if (usuariProjecte == null){
            throw new RuntimeException("Intent d'afegir un usuariProjecte null");
        }
        if (usuariProjecte.getProjecte() == null){
            if (!this.usuarisProjectes.contains(usuariProjecte)){
                usuarisProjectes.add(usuariProjecte);
            }
        }
    }
    
    public void removeUsuariProjecte (ProjecteUsuariRol usuariProjecte){
        if(usuarisProjectes.contains(usuariProjecte)){
            usuarisProjectes.remove(usuariProjecte);
        }
    }
}
