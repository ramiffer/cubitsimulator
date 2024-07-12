package complex.cubit;

public class QuantumMatrix {

    private final int size;
    private final Complex[][] matrix;

    public QuantumMatrix(int size) {
        this.size = size;
        this.matrix = new Complex[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.matrix[i][j] = new Complex(0,0);
            }
        }
    }

    public void set(int i, int j, Complex v) {
        matrix[i][j] = v;
    }

    public Complex get(int i, int j) {
        return matrix[i][j];
    }

    /**
     * OPERACIONES COMPLEJAS
     */

    public QuantumMatrix multiply(QuantumMatrix other) {
        QuantumMatrix result = new QuantumMatrix(this.size);
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                Complex sum = new Complex(0, 0);
                for (int k = 0; k < this.size; k++) {
                    sum = sum.add(this.get(i, k).multiply(other.get(k, j)));
                }
                result.set(i , j, sum);
            }
        }
        return result;
    }

    public Complex[] apply(Complex[] state) {
        Complex[] result = new Complex[size];
        for (int i = 0; i < size; i++) {
            result[i] = new Complex(0,0);
            for (int j = 0; j < size; j++) {
                result[i] = result[i].add(matrix[i][j].multiply(state[j]));
            }
        }
        return result;
    }

}
