public class Matrix {
    int[][] matrix = new int[2][3];
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }
    public int sum() {
        if (matrix == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6, 7 }, { 8 } };
        Matrix m = new Matrix(matrix);
        System.out.println(m.sum());
    }
}