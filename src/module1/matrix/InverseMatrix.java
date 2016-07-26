package module1.matrix;

import static module1.matrix.MatrixOperations.*;

public class InverseMatrix {

    public static void main(String[] args) {

        SquareMatrix matrix;
        SquareMatrix inverseMatrix;
        SquareMatrix cofactor;
        double determinant;
        int n;

        do {
            matrix = new SquareMatrix();
            matrix.showMatrix("new square");
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
        inverseMatrix.showMatrix("inverse");
    }
}
