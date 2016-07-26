package module1.matrix;

import static module1.matrix.MatrixOperations.*;

public class MultiplyAndTranspose {

    public static void main(String[] args) throws Exception {

        // Multiply Matrix
        Matrix matrix1;
        Matrix matrix2;

        System.out.println("Define matrix sizes");

        do {
            System.out.println("Matrix 1");
            matrix1 = new Matrix();
            System.out.println("Matrix 2");
            matrix2 = new Matrix();
            if (matrix1.getM() != matrix2.getN()){
                System.out.println("Matrix should be consistent. Please try again");
            }
        } while (matrix1.getM() != matrix2.getN());
        Matrix resultMatrix = multiplyMatrix(matrix1, matrix2);
        resultMatrix.showMatrix("resulted");

        //Transpose Matrix
        transposeMatrix(resultMatrix).showMatrix("transposed");
    }
}
