/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author anna9
 */
public class Entrada implements Serializable {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    private Integer numero;
    private Date data;
    private String entrada;
    
    private Usuari escriptor;
    private Usuari novaAssignacio;
    private Estat nouEstat;

    protected Entrada() {
    }

    public Entrada(Integer numero, Date data, String entrada, Usuari escriptor) {
        setNumero(numero);
        setData(data);
        setEntrada(entrada);
        setEscriptor(escriptor);
    }

    public Entrada(Integer numero, Date data, String entrada, Usuari escriptor, Usuari novaAssignacio, Estat nouEstat) {
        setNumero(numero);
        setData(data);
        setEntrada(entrada);
        setEscriptor(escriptor);
        setNovaAssignacio(novaAssignacio);
        setNouEstat(nouEstat);
    }

    
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        if (numero <= 0){
            throw new RuntimeException("El numero es obligatori i positiu");
        }
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }
    
    public String getDataFormatada() {
        return sdf.format(data);
    }
    
    public void setData(Date data) {
        if (data.after(new Date())){
            throw new RuntimeException("La data ha de ser anterior a la data actual");
        }
        this.data = data;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        if (entrada == null || entrada.length() <= 0){
            throw new RuntimeException("La entrada es obligatoria i no nula");
        }
        this.entrada = entrada;
    }

    public Usuari getEscriptor() {
        return escriptor;
    }

    
    /*
        Ho posso com a privat perque considero que el valor s'ha de ficar desde el constructor,
        un cop estigui la tasca creada, si es vol assignar a un nou usuari, es fara desde la variable
        nova assignacio, per tant, no s'ha de poder modificar aquest valor.
    */
    private void setEscriptor(Usuari escriptor) {
        if (escriptor == null){
           throw new RuntimeException("L'escriptor es obligatori"); 
        }
        this.escriptor = escriptor;
    }

    public Usuari getNovaAssignacio() {
        return novaAssignacio;
    }

    public void setNovaAssignacio(Usuari novaAssignacio) {
        if (novaAssignacio != null && novaAssignacio.equals(escriptor)){
            throw new RuntimeException("No es pot tornar a assignar al mateix usuari"); 
        }
        this.novaAssignacio = novaAssignacio;
    }

    public Estat getNouEstat() {
        return nouEstat;
    }

    public void setNouEstat(Estat nouEstat) {
        this.nouEstat = nouEstat;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.numero);
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
        final Entrada other = (Entrada) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entrada{" + "numero=" + numero + ", data=" + data + ", entrada=" + entrada + ", escriptor=" + escriptor + ", novaAssignacio=" + novaAssignacio + ", nouEstat=" + nouEstat + '}';
    }

}
