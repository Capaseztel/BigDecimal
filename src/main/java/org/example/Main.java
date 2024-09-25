package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ejercicios ej = new Ejercicios();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número del ejercicio que desea ejecutar: ");
        switch (sc.nextLine()) {
            case "1":
                // Ejercicio 1
                System.out.println("Ingrese un número: ");
                int num = sc.nextInt();
                System.out.println("El factorial de " + num + " es: " + ej.Factorial(num));
                break;
            case "2":
                // Ejercicio 2
                System.out.println("Ingrese el monto: ");
                double monto = sc.nextDouble();
                System.out.println("Ingrese el interés: ");
                double interes = sc.nextDouble();
                System.out.println("Ingrese los meses: ");
                int meses = sc.nextInt();
                System.out.println("El monto final es: " + ej.InteresCompuesto(monto, interes, meses));
                break;
            case "3":
                // Ejercicio 3
                monto = 200000;
                interes = 0.05;
                meses = 360;
                ej.PagoMensual(monto, interes, meses);
                break;
            case "4":
                // Ejercicio 4
                double lat1 = 40.416775;
                double lon1 = -3.703790;
                double lat2 = 41.385063;
                double lon2 = 2.173404;
                System.out.println("La distancia entre Madrid y Barcelona es: " + ej.FormulaHaversine(lat1, lon1, lat2, lon2) + " km");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        sc.close();
    }
}