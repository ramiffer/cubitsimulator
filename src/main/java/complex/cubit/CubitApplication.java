package complex.cubit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CubitApplication {

	public static void main(String[] args) {
		SpringApplication.run(CubitApplication.class, args);

		int n = 2, size = (int) Math.pow(2, n);

		// ESTADO INICIAL |00⟩
		Complex[] initialState = new Complex[size];
        Arrays.fill(initialState, new Complex(0, 0));
		initialState[0] = new Complex(1,0);


		// APLICO HADAMARD A TODOS LOS CUBITS
		QuantumMatrix H = QuantumGates.hadamard(n);
		Complex[] state = H.apply(initialState);

		// APLICO ORACLE
		QuantumMatrix oracle = QuantumGates.oracle(n, true);
		state = oracle.apply(state);

		// HADAMARD DE NUEVO
		state = H.apply(state);

		// MIDO ESTADO FINAL
		double[] prob = new double[size];
		for (int i = 0; i < size; i++) {
			prob[i] = state[i].magnitudeSquared();
		}


		// RESULTADOS
		for (int i = 0; i < size; i++) {
			System.out.printf("Estado |%s⟩: %.2f%%\n", toBinaryString(i, n), prob[i] * 100);
		}

		// Determinar si la función es constante o balanceada
		if (prob[0] > 0.5) System.out.println("La función es constante.");
		else System.out.println("La función es balanceada.");

	}

	private static String toBinaryString(int number, int length) {
		return String.format("%" + length + "s", Integer
				.toBinaryString(number)).replace(' ', '0');
	}

}
