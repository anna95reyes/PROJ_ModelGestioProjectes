/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author anna9
 */
public class Tasca implements Serializable {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    private Integer id;
    private Date dataCreacio;
    private String nom;
    private String descripcio;
    private Date dataLimit;
    
    private Usuari propietari;
    private Usuari responsable;
    private Estat estat;
    private List<Entrada> entrades = new ArrayList();
    
    
    protected Tasca(){
    }

    public Tasca(Integer id, Date dataCreacio, String nom, Estat estat) {
        setId(id);
        setDataCreacio(dataCreacio);
        setNom(nom);
        setPropietari(propietari);
        setEstat(estat);
    }

    public Tasca(Integer id, Date dataCreacio, String nom, String descripcio, Date dataLimit, Estat estat) {
        setId(id);
        setDataCreacio(dataCreacio);
        setNom(nom);
        setDescripcio(descripcio);
        setDataLimit(dataLimit);
        setPropietari(propietari);
        setResponsable(responsable);
        setEstat(estat);
    }

    public Tasca(Integer id, Date dataCreacio, String nom, String descripcio, Date dataLimit, Usuari propietari, Usuari responsable, Estat estat, List<Entrada> entrades) {
        setId(id);
        setDataCreacio(dataCreacio);
        setNom(nom);
        setDescripcio(descripcio);
        setDataLimit(dataLimit);
        setPropietari(propietari);
        setResponsable(responsable);
        setEstat(estat);
        this.entrades = entrades;
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

    public Date getDataCreacio() {
        return dataCreacio;
    }

    public String getDataCreacioFormatada() {
        return sdf.format(dataCreacio);
    }
    
    public void setDataCreacio(Date dataCreacio) {
        if (dataCreacio.after(new Date())){
            throw new RuntimeException("La data de creacio ha de ser anterior a la data actual");
        }
        this.dataCreacio = dataCreacio;
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

    public Date getDataLimit() {
        return dataLimit;
    }

    public String getDataLimitFormatada() {
        return sdf.format(dataLimit);
    }
    
    public void setDataLimit(Date dataLimit) {
        if (dataLimit != null && dataLimit.before(dataCreacio)) {
            throw new RuntimeException("La data limit es nula o posterior a la data de creacio");
        }
        this.dataLimit = dataLimit;
    }

    public Usuari getPropietari() {
        return propietari;
    }

    public void setPropietari(Usuari propietari) {
        if (propietari == null){
            throw new RuntimeException("L'usuari que ha creat la tasca es obligatori");
        }
        this.propietari = propietari;
    }

    public Usuari getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuari responsable) {
        this.responsable = responsable;
    }
    
    public Iterator<Entrada> iteEntrades(){
        return entrades.iterator();
    }
    
    public void addEntrada(Entrada entrada){
        if (entrades == null){
            throw new RuntimeException("Intent d'afegir un projecte null");
        }
        if (entrada.getNouEstat()!= null){
            if (entrada.getNouEstat().equals(estat)){
                throw new RuntimeException("El nou estat no pot ser el mateix que l'estat actual");
            }
        }
        
        entrades.add(entrada);
    }
    
    public void removeEntrada(Entrada entrada){
        if(entrades.contains(entrada)){
            entrades.remove(entrada);
        }
    }

    public Estat getEstat() {
        return estat;
    }

    /*
        Ho posso com a privat perque considero que l'estat s'ha d'entrar desde el constructor,
        i en cas de que es volgues cambiar d'estat, s'ha de generar una nova entrada per fer-ho,
        per tant, no s'ha de poder cambiar l'estat desde la tasca.
    */
    private void setEstat(Estat estat) { 
        this.estat = estat;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Tasca other = (Tasca) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tasca{" + "id=" + id + ", dataCreacio=" + dataCreacio + ", nom=" + nom + ", descripcio=" + descripcio + ", dataLimit=" + dataLimit + ", propietari=" + propietari + ", responsable=" + responsable + ", estat=" + estat + ", entrades=" + entrades + '}';
    }
    
}
