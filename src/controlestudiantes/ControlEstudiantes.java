/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlestudiantes;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlEstudiantes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estudiante est = null;
        int op = 0;
        System.out.println("=== SISTEMA DE GESTION ACADEMICA ===");
        
        do {
            System.out.println("--- MENU DE OPCIONES ---");
            System.out.println("1. Registrar nuevo estudiante");
            System.out.println("2. Actualizar promedio");
            System.out.println("3. Mostrar informacion del estudiante");
            System.out.println("4. Salir del programa");
            System.out.print("Seleccione una opcion: ");
        
            try {
                op= sc.nextInt();
                sc.nextLine(); 

                    switch (op) {
                        case 1:
                            System.out.println("Registrar Estudiante");
                            System.out.print("Ingrese el nombre: ");
                            String nombre = sc.nextLine();
                            System.out.print("Ingrese la carrera: ");
                            String carrera = sc.nextLine();
                            System.out.print("Ingrese el promedio (0 a 20): ");
                            double promedio = sc.nextDouble();
                            sc.nextLine(); 

                            est = new Estudiante(nombre, carrera, promedio);
                            System.out.println("Estudiante registrado con exito!");
                            break;

                        case 2:
                            System.out.println("Actualizar Promedio");
                            if (est == null) {
                                System.out.println("ERROR: Primero debe registrar un estudiante en la opcion 1.");
                            } else {
                                System.out.print("Ingrese el nuevo promedio (0 a 20): ");
                                double nuevoPromedio = sc.nextDouble();
                                sc.nextLine(); 

                                est.actualizarPromedio(nuevoPromedio);
                                System.out.println("Promedio y estado actualizados con exito!");
                            }
                            break;

                        case 3:
                            if (est == null) {
                                System.out.println("ERROR: No hay ningún estudiante registrado todavía.");
                            } else {
                                est.mostrarInformation();
                            }
                            break;

                        case 4:
                            System.out.println("Saliendo del sistema...");
                            break;

                        default:
                            System.out.println("ERROR: Opción no válida. Intente de nuevo.");
                            break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Debe ingresar un número entero para las opciones del menú.");
                    sc.nextLine(); 
                } catch (Exception e) {

                    System.out.println(" " + e.getMessage());
                }

        } while (op != 4);

        sc.close();
        System.out.println("Programa finalizado.");
    }
}