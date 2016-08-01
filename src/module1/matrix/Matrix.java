package module1.matrix;

import module1.reader.Reader;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Matrix {

    int n;
    int m;
    double[][] matrix;

    final static int multiplier = 10;

    public Matrix() {
        Reader reader = new Reader();

        try {
            System.out.print("n = ");
            this.n = Integer.parseInt(reader.getLine());
            System.out.print("m = ");
            this.m = Integer.parseInt(reader.getLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.matrix = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.matrix[i][j] = (int) (multiplier * Math.random());
            }
        }
    }

    public Matrix(int n) {
        this.matrix = new double[n][n];
    }

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.matrix = new double[n][m];
    }

    public void showMatrix(String type) {
        System.out.printf("The %s matrix is: \n", type);
        for (double[] aMatrix : this.matrix) {
            for (double anAMatrix : aMatrix) {
                anAMatrix = Math.round(1000.0 * anAMatrix) / 1000.0;
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
        // print matrix in line
        //System.out.println(Arrays.deepToString(this.matrix));
    }

    public double getElement(int i, int j) {
        return this.matrix[i][j];
    }

    public void setElement(int i, int j, double value) {
        this.matrix[i][j] = value;
    }

    public int getN() {
        return this.matrix.length;
    }

    public int getM() {
        return this.matrix[1].length;
    }

    public int determinant() {

        int determinant = 0;
        int n = this.matrix.length;
        int l = 0;

        if (n > 2) {
            for (int k = 0; k < n; k++) {
                int deleted_rows;
                int deleted_columns;
                SquareMatrix matrixM = new SquareMatrix(n-1);
                deleted_rows = 0;
                for (int i = 0; i < n; i++) {
                    if (i != 0) {
                        deleted_columns = 0;
                        for (int j = 0; j < n; j++) {
                            if (j != k) {
                                matrixM.setElement(i-deleted_rows, j-deleted_columns, this.matrix[i][j]);
                            } else {
                                deleted_columns++;
                            }
                        }
                    } else {
                        deleted_rows++;
                    }
                }
                determinant += Math.pow(-1, l + k) * (int)this.matrix[l][k] * matrixM.determinant();
            }
        } else {
            determinant = (int)(this.matrix[0][0] * this.matrix[1][1] - this.matrix[0][1] * this.matrix[1][0]);
        }
        return determinant;
    }
}
