package module1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TransposeMatrix {

    public static int[][] createMatrix(int x, int y) throws Exception {

        int[][] array = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print("Insert element [" + i + "][" + j + "]: ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                array[i][j] = Integer.parseInt(reader.readLine());
            }
        }
        return array;
    }

    public static int[][] transposeMatrix(int[][] array, int x, int y) {

        int[][] arrayT = new int[y][x];
        for (int j = 0; j < arrayT.length; j++) {
            for (int i = 0; i < arrayT[j].length; i++) {
                arrayT[j][i] = array[i][j];
            }
        }
        return arrayT;
    }

    private static void showMatrix(int[][] array){
        System.out.println("The matrix is: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Insert matrix size");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("x:");
        int x = Integer.parseInt(reader.readLine());

        System.out.print("y:");
        int y = Integer.parseInt(reader.readLine());

        int[][] array = createMatrix(x,y);
        showMatrix(array);

        int[][] arrayT = transposeMatrix(array, x, y);
        showMatrix(arrayT);
    }
}

