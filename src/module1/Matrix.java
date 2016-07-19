package module1;

public class Matrix {

    int n;
    int m;
    int[][] matrix;

    final static int multiplier = 10;

    public Matrix() throws Exception {
        Reader reader = new Reader();
        System.out.print("n = ");
        this.n = Integer.parseInt(reader.getLine());
        System.out.print("m = ");
        this.m = Integer.parseInt(reader.getLine());

        this.matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.matrix[i][j] = (int) (multiplier * Math.random());
            }
        }
    }

    public Matrix(int n) {
        this.matrix = new int[n][n];
    }

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.matrix = new int[n][m];
    }

    public void showMatrix() {
        System.out.println("The matrix is: ");
        for (int[] aMatrix : this.matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }

    public int getElement(int i, int j) {
        return this.matrix[i][j];
    }

    public void setElement(int i, int j, int value) {
        this.matrix[i][j] = value;
    }

    public int getN() {
        return this.matrix.length;
    }

    public int getM() {
        return this.matrix[1].length;
    }
}
