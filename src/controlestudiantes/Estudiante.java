/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlestudiantes;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author PILARHUILCA
 */
public class Estudiante {
    // Atributos privados
    private String nombre;
    private String carrera;
    private double promedio;
    private String estado;

    // Constructor

    public Estudiante() {
    }

    // CONSTRUCTOR CORREGIDO: Recibe 3 parámetros para alinearse con la clase principal
    public Estudiante(String nombre, String carrera, double promedio) throws Exception {
        this.nombre = nombre;
        this.carrera = carrera;
        this.actualizarPromedio(promedio); // Valida y asigna el estado desde el inicio
    }


    // Métodos Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public String getEstado() { return estado; }

    public double getPromedio() { return promedio; }

    // Método para modificar el promedio con control de rangos
    public void actualizarPromedio(double promedio) throws Exception {
        if (promedio < 0 || promedio > 20) {
            throw new Exception("ERROR: El promedio debe estar estrictamente entre 0 y 20.");
        }
        this.promedio = promedio;
        this.evaluarEstado();
    }

    // Método interno para evaluar el estado
    private void evaluarEstado() {
        if (this.promedio >= 14) {
            this.estado = "Aprobado";
        } else {
            this.estado = "Reprobado";
        }
    }

    public void mostrarInformation() {
        System.out.println("===INFORMACION DEL ESTUDIANTE===");
        System.out.println("Nombre:    " + this.nombre);
        System.out.println("Carrera:   " + this.carrera);
        System.out.println("Promedio:  " + this.promedio);
        System.out.println("Estado:    " + this.estado);
    }
}