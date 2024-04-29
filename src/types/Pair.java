package src.types;

import src.config.PairType;

public class Pair {
	/**
	 * The method `resolve` creates a PairType object with two values, val1 and
	 * val2, and returns it.
	 *
	 * @param val1
	 *            The `val1` parameter is of type T1 and represents the first value
	 *            of the PairType object.
	 * @param val2
	 *            The `val2` parameter is of type T2 and represents the second value
	 *            of the PairType object.
	 *
	 * @return The method `resolve` returns a PairType object containing the values
	 *         val1 and val2.
	 */
	public static <T1, T2> PairType<T1, T2> resolve(T1 val1, T2 val2) {
		return new PairType<T1, T2>() {
			@Override
			public T1 getValue1() {
				return val1;
			}

			@Override
			public T2 getValue2() {
				return val2;
			}
		};
	}
}
