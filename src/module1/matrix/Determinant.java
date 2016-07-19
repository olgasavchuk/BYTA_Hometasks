package module1.matrix;

public class Determinant {


    public static void main(String[] args) throws Exception {

        int determinant;
        SquareMatrix matrix;

        do {
            matrix = new SquareMatrix();
            if (matrix.getN() != matrix.getM()) {
                System.out.println("N should be equal to M. Try again");
            }
        } while (matrix.getN() != matrix.getM());
        matrix.showMatrix();
        determinant = findDeterminant(matrix);
        System.out.println("Determinant is: " + determinant);
    }

    public static int findDeterminant(SquareMatrix matrix) throws Exception {

        int determinant = 0;
        int n = matrix.getN();

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
                                    matrixM.setElement(i-deleted_rows, j-deleted_columns, matrix.getElement(i, j));
                                } else {
                                    deleted_columns++;
                                }
                            }
                        } else {
                            deleted_rows++;
                        }
                    }
                    determinant += Math.pow(-1, 1 + k) * matrix.getElement(0, k) * findDeterminant(matrixM);
                }
        } else {
            determinant = matrix.getElement(0, 0) * matrix.getElement(1, 1) - matrix.getElement(0, 1) * matrix.getElement(1, 0);
        }
        return determinant;
    }

}
