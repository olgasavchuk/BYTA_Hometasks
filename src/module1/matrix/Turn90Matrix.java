package module1.matrix;

import static module1.matrix.MatrixOperations.*;

public class Turn90Matrix {

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.showMatrix("new");
        Matrix resultMatrix = turnMatrix(matrix);
        resultMatrix.showMatrix("turned to 90 degrees");
    }
}
