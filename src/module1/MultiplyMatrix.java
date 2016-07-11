package module1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MultiplyMatrix {

    public static void main(String[] args) throws Exception {

        System.out.println("Define matrix sizes");

        System.out.println("Matrix 1");
        int[][] matrix1 = createMatrix();
        showMatrix(matrix1);

        System.out.println("Matrix 2");
        int[][] matrix2 = createMatrix();
        showMatrix(matrix2);

        multiplyMatrix(matrix1,matrix2);

    }

    public static int[][] createMatrix() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("x = ");
        int x = Integer.parseInt(reader.readLine());
        System.out.print("y = ");
        int y = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = (int)(10 * Math.random());
            }
        }
        return matrix;
    }

    private static void showMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }

    }

    private static void multiplyMatrix(int[][] matrix1, int[][] matrix2) {

        int[][] matrix3 = new int[matrix1.length][matrix2[1].length];
        int sum;

        if (matrix1[0].length == matrix2.length) {
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    sum = 0;
                    for (int m = 0; m < matrix1[0].length; m++) {
                        sum += matrix1[i][m] * matrix2[m][j];
                    }
                    matrix3[i][j] = sum;
                }
            }
            System.out.println("Result Matrix is: ");
            showMatrix(matrix3);
        } else {
            System.out.println("Matrix should be consistent. Please try again. Bye!");
        }
    }
}
