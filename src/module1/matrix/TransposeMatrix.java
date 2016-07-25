package module1.matrix;

import module1.matrix.Matrix;

public class TransposeMatrix {

    public static Matrix transposeMatrix(Matrix matrix) {

        Matrix matrixT = new Matrix(matrix.getM(), matrix.getN());
        for (int j = 0; j < matrixT.getN(); j++) {
            for (int i = 0; i < matrixT.getM(); i++) {
                matrixT.setElement(j, i, matrix.getElement(i, j));
            }
        }
        return matrixT;
    }

    public static void main(String[] args) throws Exception {

        Matrix matrix = new Matrix();
        matrix.showMatrix();
        transposeMatrix(matrix).showMatrix();
    }
}

