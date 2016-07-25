package module1.matrix;

public class MultiplyMatrix {

    public static void main(String[] args) throws Exception {

        System.out.println("Define matrix sizes");

        System.out.println("Matrix 1");
        Matrix matrix1 = new Matrix();
        matrix1.showMatrix();

        System.out.println("Matrix 2");
        Matrix matrix2 = new Matrix();
        matrix2.showMatrix();

        multiplyMatrix(matrix1, matrix2);
    }

    private static void multiplyMatrix(Matrix matrix1, Matrix matrix2) {

        Matrix matrix3 = new Matrix(matrix1.n, matrix2.m);
        int sum;

        if (matrix1.m == matrix2.n) {
            for (int i = 0; i < matrix1.n; i++) {
                for (int j = 0; j < matrix2.m; j++) {
                    sum = 0;
                    for (int m = 0; m < matrix1.m; m++) {
                        sum += matrix1.getElement(i, m) * matrix2.getElement(m, j);
                    }
                    matrix3.setElement(i, j, sum);
                }
            }
            System.out.println("Result Matrix is: ");
            matrix3.showMatrix();
        } else {
            System.out.println("Matrix should be consistent. Please try again. Bye!");
        }
    }
}
