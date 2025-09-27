package com.plataforma.gestionestudiantil.model;

import com.plataforma.gestionestudiantil.ayudas.Estados;
import com.plataforma.gestionestudiantil.ayudas.Roles;
import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", length = 50, nullable = false, unique = false)
    private String nombre;
    @Column(name = "correo", length = 50, nullable = false, unique = true)
    private String correo;
    @Column(name = "contraseña", length = 10, nullable = false, unique = false)
    private String contraseña;

    @Column(name = "rol", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private Roles roles;

    @Column(name = "estado", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private Estados estados;

    //RELACIONANDOME CON 1 ESTUDIANTE

    public Usuario() {

    }

    public Usuario(Integer id, String nombre, String correo, String contraseña, Roles rol, Estados estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.roles = rol;
        this.estados = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Roles getRol() {
        return roles;
    }

    public void setRol(Roles rol) {
        this.roles = rol;
    }

    public Estados getEstado() {
        return estados;
    }

    public void setEstado(Estados estado) {
        this.estados = estado;
    }
}

