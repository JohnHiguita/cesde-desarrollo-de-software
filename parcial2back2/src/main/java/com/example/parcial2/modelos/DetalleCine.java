package com.example.parcial2.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "detalles_cine")
public class DetalleCine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "direccion", length = 250, nullable = false,  unique = true)
    private String direccion;
    @Column(name = "ciudad", length = 250, nullable = false,  unique = true) // <--
    private String ciudad;
    @Column(name = "telefono", length = 250, nullable = false,  unique = true)
    private String telefono;

    @OneToOne
    @JoinColumn(name = "cine_id", nullable = false, unique = true)
    private Cine cine;

    public DetalleCine() {
    }

    public DetalleCine(String direccion, String ciudad, String telefono, Cine cine) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.cine = cine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }
}
