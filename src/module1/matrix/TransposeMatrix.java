package module1.matrix;

import module1.matrix.Matrix;

public class TransposeMatrix {

    public static Matrix transposeMatrix(Matrix matrix) {

        Matrix matrixT = new Matrix(matrix.m, matrix.n);
        for (int j = 0; j < matrixT.n; j++) {
            for (int i = 0; i < matrixT.m; i++) {
                matrixT.setElement(j, i, matrix.getElement(i, j));
            }
        }
        matrixT.showMatrix();
        return matrixT;
    }

    public static void main(String[] args) throws Exception {

        Matrix matrix = new Matrix();
        matrix.showMatrix();
        transposeMatrix(matrix);
    }
}

