package complex.cubit;

public class QuantumGates {
    public static QuantumMatrix hadamard(int n) {
        final int size = (int) Math.pow(2, n);
        QuantumMatrix H = new QuantumMatrix(size);
        final double scale = 1.0 / Math.sqrt(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Complex value = new Complex(
                        scale * ((Integer.bitCount(i & j) % 2 == 0) ? 1 : -1), 0);
                H.set(i, j, value);
            }
        }
        return H;
    }

    public static QuantumMatrix oracle(int n, boolean C) {
        final int size = (int)Math.pow(2, n);
        QuantumMatrix oracle = new QuantumMatrix(size);

        if (C) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    oracle.set(i, j, (i == j) ?
                            new Complex(1, 0) :
                            new Complex(0, 0));
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if ((i & j) == 0) {
                        oracle.set(i, j, new Complex(1, 0));
                    } else {
                        oracle.set(i, j, new Complex(0, 0));
                    }
                }
            }
        }

        return oracle;
    }
}
