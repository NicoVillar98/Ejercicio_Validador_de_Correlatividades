package org.example;

import java.util.List;
import java.util.ArrayList;

class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativa(Materia materia) {
        correlativas.add(materia);
    }

    public boolean esCorrelativaDe(Materia materia) {
        return correlativas.contains(materia);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

}

class Alumno {
    private String nombre;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();
    }

    public void aprobarMateria(Materia materia) {
        materiasAprobadas.add(materia);
    }

    public boolean haAprobado(Materia materia) {
        return materiasAprobadas.contains(materia);
    }

    public String getNombre() {
        return nombre;
    }
}

class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public boolean aprobada() {
        for (Materia materia : materias) {
            for (Materia correlativa : materia.getCorrelativas()) {
                if (!alumno.haAprobado(correlativa)) {
                    return false;
                }
            }
        }
        return true;
    }
}

