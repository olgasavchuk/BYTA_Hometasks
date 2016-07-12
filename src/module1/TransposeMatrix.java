package module1;

public class TransposeMatrix {

    public static void transposeMatrix(Matrix matrix) {

        Matrix matrixT = new Matrix(matrix.m, matrix.n);
        for (int j = 0; j < matrixT.n; j++) {
            for (int i = 0; i < matrixT.m; i++) {
                matrixT.setElement(j, i, matrix.getElement(i, j));
            }
        }
        matrixT.showMatrix();
    }

    public static void main(String[] args) throws Exception {

        Matrix matrix = new Matrix();
        matrix.showMatrix();
        transposeMatrix(matrix);
    }
}

