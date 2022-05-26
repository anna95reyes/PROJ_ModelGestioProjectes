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
    
    private Integer idProjecte;
    private Integer idUsuari;
    
    private Projecte projecte;
    private Usuari usuari;
    private Rol rol;

    protected ProjecteUsuariRol() {
    }

    public ProjecteUsuariRol(Projecte projecte, Usuari usuari, Rol rol) {
        setProjecte(projecte);
        setUsuari(usuari);
        setRol(rol);
    }

    public Projecte getProjecte() {
        return projecte;
    }

    public void setProjecte(Projecte projecte) {
        this.projecte = projecte;
        this.idProjecte = projecte.getId();
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
        this.idUsuari = usuari.getId();
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
