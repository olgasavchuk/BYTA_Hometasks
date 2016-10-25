package module1.matrix;

public class Determinant {

    public static void main(String[] args) {

        SquareMatrix matrix;

        do {
            matrix = new SquareMatrix();
            if (matrix.getN() != matrix.getM()) {
                System.out.println("n should be equal to m. Try again");
            }
        } while (matrix.getN() != matrix.getM());
        matrix.showMatrix("new");
        System.out.println("Determinant is: " + matrix.determinant());
    }
}
