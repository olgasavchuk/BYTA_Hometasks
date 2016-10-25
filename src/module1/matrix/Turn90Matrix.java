package module1.matrix;

import static module1.matrix.MatrixOperations.*;

public class Turn90Matrix {

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.showMatrix("new");
        Matrix resultMatrix = turn90Matrix(matrix);
        resultMatrix.showMatrix("turned to 90 degrees");
    }
}
