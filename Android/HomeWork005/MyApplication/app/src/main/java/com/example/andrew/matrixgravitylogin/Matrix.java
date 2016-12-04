package com.example.andrew.matrixgravitylogin;

/**
 * Created by Andrew on 29.11.2016.
 */

public class Matrix {

    private Matrix(){

    }

    public double[][] multiply(double[][] matrixA, double[][] matrixB){

        int rowsA = matrixA.length;
        int rowsB = matrixB.length;

        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        if (colsA != rowsB){
            throw new ArithmeticException(
                    "Number of columns for matrix A should match number of rows for matrix B.");
        }

        double[][] C = new double[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                C[i][j] = 0d;
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return C;
    }
}
