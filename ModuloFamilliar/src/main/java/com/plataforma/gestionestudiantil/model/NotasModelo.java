package com.plataforma.gestionestudiantil.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notas")
public class NotasModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false) // length no aplica a Float
    private Float nota;

    @Column(name = "observaciones", length = 250)
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_estudiantes", referencedColumnName = "id")
    @JsonBackReference(value = "relacionesestudiantenotas")
    private EstudianteModelo estudianteModelo;

    @OneToMany(
            mappedBy = "notasModelo", // <-- debe coincidir con el nombre del campo en Materia.java
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference(value = "relacionnotasmateria")
    private List<Materia> materias = new ArrayList<>();

    public NotasModelo() {}

    public NotasModelo(Integer id, Float nota, String observaciones) {
        this.id = id;
        this.nota = nota;
        this.observaciones = observaciones;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Float getNota() { return nota; }
    public void setNota(Float nota) { this.nota = nota; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public EstudianteModelo getEstudianteModelo() { return estudianteModelo; }
    public void setEstudianteModelo(EstudianteModelo estudianteModelo) { this.estudianteModelo = estudianteModelo; }

    public List<Materia> getMaterias() { return materias; }
    public void setMaterias(List<Materia> materias) { this.materias = materias; }

    // Helpers para mantener la bidireccionalidad
    public void addMateria(Materia m) {
        materias.add(m);
        m.setNotasModelo(this);
    }

    public void removeMateria(Materia m) {
        materias.remove(m);
        m.setNotasModelo(null);
    }
}
