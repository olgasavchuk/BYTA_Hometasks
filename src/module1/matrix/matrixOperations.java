package module1.matrix;

public class MatrixOperations {

    public static Matrix multiplyMatrix(Matrix matrix1, Matrix matrix2) {

        Matrix resultMatrix = new Matrix(matrix1.getN(), matrix2.getM());
        int sum;

        for (int i = 0; i < matrix1.getN(); i++) {
            for (int j = 0; j < matrix2.getM(); j++) {
                sum = 0;
                for (int m = 0; m < matrix1.getM(); m++) {
                    sum += matrix1.getElement(i, m) * matrix2.getElement(m, j);
                }
                resultMatrix.setElement(i, j, sum);
            }
        }
        return resultMatrix;
    }


    public static Matrix transposeMatrix(Matrix matrix) {

        Matrix resultMatrix = new Matrix(matrix.getM(), matrix.getN());
        for (int j = 0; j < resultMatrix.getN(); j++) {
            for (int i = 0; i < resultMatrix.getM(); i++) {
                resultMatrix.setElement(j, i, matrix.getElement(i, j));
            }
        }
        return resultMatrix;
    }

    public static SquareMatrix findCofactorMatrix(SquareMatrix matrix) {
        int n = matrix.getN();
        SquareMatrix cofactorMatrix = new SquareMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cofactorMatrix.setElement(i, j, matrix.cofactorOfMatrixElement(i, j));
            }
        }
        return cofactorMatrix;
    }

    public static SquareMatrix inverseMatrix(int n, double determinant, Matrix cofactor) {
        SquareMatrix inverseMatrix = new SquareMatrix(n);
        for (int i = 0; i < cofactor.getN(); i++) {
            for (int j = 0; j < cofactor.getN(); j++) {
                inverseMatrix.setElement(i, j, ((1 / determinant) * cofactor.getElement(i, j)));
            }
        }
        return inverseMatrix;
    }

}
