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
public class ProjecteUsuariRol implements Serializable {
    private Projecte projecte;
    private Usuari usuari;
    private Rol rol;

    protected ProjecteUsuariRol() {
    }

    public ProjecteUsuariRol(Projecte projecte, Usuari usuari, Rol rol) {
        this.projecte = projecte;
        this.usuari = usuari;
        this.rol = rol;
    }

    public Projecte getProjecte() {
        return projecte;
    }

    public void setProjecte(Projecte projecte) {
        this.projecte = projecte;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
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
        final ProjecteUsuariRol other = (ProjecteUsuariRol) obj;
        if (!Objects.equals(this.projecte, other.projecte)) {
            return false;
        }
        if (!Objects.equals(this.usuari, other.usuari)) {
            return false;
        }
        if (this.rol != other.rol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjecteUsuari{" + "projecte=" + projecte + ", usuari=" + usuari + ", rol=" + rol + '}';
    }
    
}
