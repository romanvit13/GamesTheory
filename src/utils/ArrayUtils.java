package utils;

public enum ArrayUtils {

    INSTANCE;

    public int[] getArrayFromColumn(int column, int[][] matrix) {
        int[] strategy = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            strategy[i] = matrix[i][column];
        }
        return strategy;
    }

    public int[] sumArrays(int[] array1, int[] array2) {
        int[] sumArr = array1.length > array2.length ? new int[array1.length] : new int[array2.length];
        int smallLength = Math.min(array1.length, array2.length);

        for (int i = 0; i < smallLength; i++) {
            sumArr[i] = array1[i] + array2[i];
        }

        return sumArr;
    }

    public void initArray(int[] array) {
        if (array.length <= 0) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    public double[][] transpose(int[][] matrix) {
        int rowsAmount = matrix.length;
        int columnsAmount = matrix[0].length;

        double[][] transposedMatrix = new double[columnsAmount][rowsAmount];

        for (int i = 0; i < rowsAmount; i++) {
            for (int j = 0; j < columnsAmount; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public void printArray(int[] array, String header) {
        System.out.println("\n" + header);
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println("\n");
    }

    public void printMatrix(int[][] matrix, String header) {
        System.out.println("\n" + header);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
