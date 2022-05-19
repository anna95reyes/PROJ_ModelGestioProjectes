/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author anna9
 */
public class ProjecteUsuariRolId implements Serializable {
    
    private Integer idProjecte;
    private Integer idUsuari;

    protected ProjecteUsuariRolId() {
    }

    public ProjecteUsuariRolId(Integer idProjecte, Integer idUsuari) {
        setIdProjecte(idProjecte);
        setIdUsuari(idUsuari);
    }

    public Integer getIdProjecte() {
        return idProjecte;
    }

    public void setIdProjecte(Integer idProjecte) {
        this.idProjecte = idProjecte;
    }

    public Integer getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(Integer idUsuari) {
        this.idUsuari = idUsuari;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.idProjecte);
        hash = 47 * hash + Objects.hashCode(this.idUsuari);
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
        final ProjecteUsuariRolId other = (ProjecteUsuariRolId) obj;
        if (!Objects.equals(this.idProjecte, other.idProjecte)) {
            return false;
        }
        if (!Objects.equals(this.idUsuari, other.idUsuari)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjecteUsuariRolId{" + "idProjecte=" + idProjecte + ", idUsuari=" + idUsuari + '}';
    }
    
    
    
}
