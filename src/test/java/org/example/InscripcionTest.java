package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class InscripcionTest {
    @Test
    public void testInscripcionAprobada() {
        // Crear materias
        Materia algoritmo = new Materia("Algoritmos y Estructuras de Datos");
        Materia paradigmas = new Materia("Paradigmas de Programación");
        Materia disenoSistemas = new Materia("Diseño de Sistemas");

        // Establecer correlativas
        paradigmas.agregarCorrelativa(algoritmo);
        disenoSistemas.agregarCorrelativa(paradigmas);

        // Crear alumno y aprobar materias
        Alumno alumno = new Alumno("Juan");
        alumno.aprobarMateria(algoritmo);
        alumno.aprobarMateria(paradigmas);
        alumno.aprobarMateria(disenoSistemas);

        // Crear inscripción
        List<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(disenoSistemas);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        // Comprobar que la inscripción es aprobada
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionNoAprobada() {
        // Crear materias
        Materia algoritmo = new Materia("Algoritmos y Estructuras de Datos");
        Materia paradigmas = new Materia("Paradigmas de Programación");
        Materia disenoSistemas = new Materia("Diseño de Sistemas");

        // Establecer correlativas
        paradigmas.agregarCorrelativa(algoritmo);
        disenoSistemas.agregarCorrelativa(paradigmas);

        // Crear alumno y aprobar solo algunas materias
        Alumno alumno = new Alumno("Juan");
        alumno.aprobarMateria(algoritmo);
        // No aprueba Paradigmas de Programación

        // Crear inscripción
        List<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(disenoSistemas);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        // Comprobar que la inscripción no es aprobada
        assertFalse(inscripcion.aprobada());
    }
}
