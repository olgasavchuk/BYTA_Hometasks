package module1.matrix;

public class SquareMatrix extends Matrix {

    public SquareMatrix() {
        super();
    }

    public SquareMatrix (int n) {
        super(n);
    }

    //Минор Mij элемента aij
    public double minorOfMatrixElement (int l, int k) {
        int n = this.matrix.length;
        int deleted_rows = 0;
        int deleted_columns;
        double minorOfElement;
        SquareMatrix matrixM = new SquareMatrix(n - 1);
        for (int i = 0; i < n; i++) {
            if (i != l) {
                deleted_columns = 0;
                for (int j = 0; j < n; j++) {
                    if (j != k) {
                        matrixM.setElement(i - deleted_rows, j - deleted_columns, this.matrix[i][j]);
                    } else {
                        deleted_columns++;
                    }
                }
            } else {
                deleted_rows++;
            }
        }
        minorOfElement = matrixM.determinant();
        return minorOfElement;
    }

    //Алгебраическое дополнение Aij элемента aij
    public double cofactorOfMatrixElement (int i, int j) {
        return Math.pow((-1), i + j) * this.minorOfMatrixElement(i, j);
    }
}
