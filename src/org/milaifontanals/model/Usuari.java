/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author anna9
 */

public class Usuari implements Serializable {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    private Integer id;
    private String nom;
    private String cognom1;
    private String cognom2;
    private Date dataNaixement;
    private String login;
    private String passwrdHash;
    
    private List<ProjecteUsuariRol> projectesRol = new ArrayList();
    private List<Tasca> tasquesAssignades = new ArrayList();

    protected Usuari() {
    }

    public Usuari(Integer id, String nom, String cognom1, Date dataNaixement, String login, String passwrdHash) {
        setId(id);
        setNom(nom);
        setCognom1(cognom1);
        setDataNaixement(dataNaixement);
        setLogin(login);
        setPasswrdHash(passwrdHash);
    }

    public Usuari(Integer id, String nom, String cognom1, String cognom2, Date dataNaixement, String login, String passwrdHash) {
        setId(id);
        setNom(nom);
        setCognom1(cognom1);
        setCognom2(cognom2);
        setDataNaixement(dataNaixement);
        setLogin(login);
        setPasswrdHash(passwrdHash);
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

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        if (cognom1 == null || cognom1.length() <= 0){
            throw new RuntimeException("El cognom1 es obligatori i no buit");
        }
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        if (cognom2 != null && cognom2.length() <= 0){
            throw new RuntimeException("El cognom2 es null o amb contingut");
        }
        this.cognom2 = cognom2;
    }

    public Date getDataNaixement() {
        return dataNaixement;
    }
    
    public String getDataNaixementFormatada() {
        return sdf.format(dataNaixement);
    }

    public void setDataNaixement(Date dataNaixement) {
        if (dataNaixement.after(new Date())){
            throw new RuntimeException("La data de naixement ha de ser anterior a la data actual");
        }
        this.dataNaixement = dataNaixement;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null || login.length() <= 0){
            throw new RuntimeException("El login es obligatori i no buit");
        }
        this.login = login;
    }

    public String getPasswrdHash() {
        return passwrdHash;
    }

    public void setPasswrdHash(String passwrdHash) {
        if (passwrdHash == null || passwrdHash.length() <= 0){
            throw new RuntimeException("El passwrdHash es obligatori i no buit");
        }
        this.passwrdHash = passwrdHash;
    }

    
    public Iterator<ProjecteUsuariRol> iteProjectesRols(){
        return projectesRol.iterator();
    }
    
    public void addProjecteRol(ProjecteUsuariRol projecteRol){
        if (projectesRol == null){
            throw new RuntimeException("Intent d'afegir un projecteRol null");
        }
        if (projecteRol.getUsuari() == null){
            if (!this.projectesRol.contains(projecteRol)){
                projectesRol.add(projecteRol);
            }
        }
    }
    
    public void removeProjecteRol(ProjecteUsuariRol projecteRol){
        if(projectesRol.contains(projecteRol)){
            projectesRol.remove(projecteRol);
        }
    }
    
    public Iterator<Tasca> iteTasquesAssignades(){
        return tasquesAssignades.iterator();
    }
    
    public void addTasca(Tasca tascaAsignada){
        if (tasquesAssignades == null){
            throw new RuntimeException("Intent d'afegir una tasca nulla");
        }
        tasquesAssignades.add(tascaAsignada);
    }
    
    public void removeTasca(Tasca tascaAsignada){
        if(tasquesAssignades.contains(tascaAsignada)){
            tasquesAssignades.remove(tascaAsignada);
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Usuari other = (Usuari) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuari{" + "id=" + id + ", nom=" + nom + ", cognom1=" + cognom1 + ", cognom2=" + cognom2 + ", dataNaixement=" + dataNaixement + ", login=" + login + ", passwrdHash=" + passwrdHash + ", projectes=" + projectesRol + ", tasques=" + tasquesAssignades + '}';
    }

}
