/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matrices;
import java.util.Scanner;

/**
 *
 * @author Santiago Rubiano Garzón
 */

public class Matrices {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de filas de la primera matriz: ");
        int f1 = scanner.nextInt();
        System.out.println("Ingrese el número de columnas de la primera matriz: ");
        int c1 = scanner.nextInt();

        double[][]   matriz1 = new double[f1][c1];

        System.out.println("Ingrese los elementos de la primera matriz:");
        for (int i = 0; i < f1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.print("Ingrese el elemento (" + (i + 1) + "," + (j + 1) + "): ");
                matriz1[i][j] = scanner.nextDouble();
            }
        }

        System.out.print("Ingrese el número de filas de la segunda matriz: ");
        int filaMatriz2 = scanner.nextInt();
        System.out.print("Ingrese el número de columnas de la segunda matriz: ");
        int columnaMatriz2 = scanner.nextInt();

        double[][] matriz2 = new double[filaMatriz2][columnaMatriz2];

        System.out.println("Ingrese los elementos de la segunda matriz:");
        for (int i = 0; i < filaMatriz2; i++) {
            for (int j = 0; j < columnaMatriz2; j++) {
                System.out.print("Ingrese el elemento (" + (i + 1) + "," + (j + 1) + "): ");
                matriz2[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Seleccione una operación:");
        System.out.println("1. Suma de matrices");
        System.out.println("2. Producto de matrices");
        System.out.println("3. Producto de un escalar con una matriz");
        System.out.println("4. Traspuesta de una matriz");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                if (f1 == filaMatriz2 && c1 == columnaMatriz2) {
                    double[][] sumaMatrices = sumarMatrices(matriz1, matriz2);
                    imprimirMatriz(sumaMatrices);
                } else {
                    System.out.println("No se puede realizar la suma de matrices. Las dimensiones no coinciden.");
                }
                break;

            case 2:
                if (c1 == filaMatriz2) {
                    double[][] productoMatrices = multiplicarMatrices(matriz1, matriz2);
                    imprimirMatriz(productoMatrices);
                } else {
                    System.out.println("No se puede realizar el producto de matrices. Las dimensiones no coinciden.");
                }
                break;

            case 3:
                System.out.print("Ingrese el escalar: ");
                double escalar = scanner.nextDouble();
                double[][] productoEscalarMatriz = multiplicarEscalarMatriz(escalar, matriz1);
                imprimirMatriz(productoEscalarMatriz);
                break;

            case 4:
                double[][] matrizTranspuesta = calcularMatrizTranspuesta(matriz1);
                imprimirMatriz(matrizTranspuesta);
                break;

            default:
                System.out.println("Opción no válida.");
        }

        scanner.close();
    }

    // Función para sumar dos matrices
    public static double[][] sumarMatrices(double[][] matriz1, double[][] matriz2) {
        int fila = matriz1.length;
        int columna = matriz1[0].length;
        double[][] resultado = new double[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return resultado;
    }

    // Función para multiplicar dos matrices
    public static double[][] multiplicarMatrices(double[][] matriz1, double[][] matriz2) {
        int fila1 = matriz1.length;
        int columna1 = matriz1[0].length;
        int fila2 = matriz2.length;
        int columna2 = matriz2[0].length;
        double[][] resultado = new double[fila1][columna2];

        for (int i = 0; i < fila1; i++) {
            for (int j = 0; j < columna2; j++) {
                for (int k = 0; k < columna1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        return resultado;
    }

    // Función para multiplicar un escalar por una matriz
    public static double[][] multiplicarEscalarMatriz(double escalar, double[][] matriz) {
        int fila = matriz.length;
        int columna = matriz[0].length;
        double[][] resultado = new double[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                resultado[i][j] = escalar * matriz[i][j];
            }
        }

        return resultado;
    }

    // Función para calcular la traspuesta de una matriz
    public static double[][] calcularMatrizTranspuesta(double[][] matriz) {
        int fila = matriz.length;
        int columna = matriz[0].length;
        double[][] resultado = new double[columna][fila];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                resultado[j][i] = matriz[i][j];
            }
        }

        return resultado;
    }

    // Función para imprimir una matriz
    public static void imprimirMatriz(double[][] matriz) {
        int fila = matriz.length;
        int columna = matriz[0].length;

        System.out.println("Matriz resultante:");

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}