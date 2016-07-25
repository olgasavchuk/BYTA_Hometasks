package module1.matrix;

import static module1.matrix.TransposeMatrix.*;

public class InverseMatrix {

    public static void main(String[] args) {

        SquareMatrix matrix;
        SquareMatrix inverseMatrix;
        SquareMatrix cofactor;
        Matrix cofactorT;
        double determinant;
        int n;

        do {
            matrix = new SquareMatrix();
            matrix.showMatrix();
            determinant = matrix.determinant();
            System.out.println("Determinant is: " + determinant);
            n = matrix.getN();
            if (matrix.getN() != matrix.getM()) {
                System.out.println("N should be equal to M. Try again");
            } else if (determinant == 0 ) {
                System.out.println("Inverse Matrix doesn't exist. Try again");
            }
        } while ((matrix.getN() != matrix.getM()) || (determinant == 0));

        cofactor = findCofactorMatrix(matrix);
        inverseMatrix = inverseMatrix(n, determinant, transposeMatrix(cofactor));
        inverseMatrix.showMatrix();
    }

    private static SquareMatrix findCofactorMatrix(SquareMatrix matrix) {
        int n = matrix.getN();
        SquareMatrix cofactorMatrix = new SquareMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cofactorMatrix.setElement(i, j, matrix.cofactorOfMatrixElement(i, j));
            }
        }
        return cofactorMatrix;
    }

    private static SquareMatrix inverseMatrix(int n, double determinant, Matrix cofactor) {
        SquareMatrix inverseMatrix = new SquareMatrix(n);
        for (int i = 0; i < cofactor.getN(); i++) {
            for (int j = 0; j < cofactor.getN(); j++) {
                inverseMatrix.setElement(i, j, ((1 / determinant) * cofactor.getElement(i, j)));
            }
        }
        return inverseMatrix;
    }
}
