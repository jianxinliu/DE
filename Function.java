package DEAForgithub.function;

import DEAForgithub.Common;

/**
 * The base class for benchmark functions. All benchmark functions are for
 * minimization and have the same global optimum: <code>0</code>.
 */
public class Function {

	/** the best possible objective value */
	public static final double BEST = 0d;

	/** the dimension of the function */
	protected static int dimension;

	/** some common things */
	public Common common = new Common();

	/** the maximum value which the decision variables can take on */
	protected static double m_max;
	
	/** the minimum value which the decision variables can take on */
	protected static double m_min;

	/**
	 * Create the benchmark function
	 * 
	 * @param dimension
	 *            the dimension of the function
	 * @param min
	 *            the minimum value which the decision variables can take on
	 * @param max 
	 * 			  the maximum value which the decision variables can take on
	 */
	public Function() {

	}

	public Function(final int dimension, final double min, final double max) {
		super();
		this.dimension = dimension;
		this.m_min = min;
		this.m_max = max;
	}

	/**
	 * get the dimension of the function.
	 * @return the dimension of the function
	 */
	public final int getDimension() {
		return this.dimension;
	}

	/**
	 * get the minimum value which the decision variables can take on
	 * @return the minimum value which the decision variables can take on
	 */
	public final double getMin() {
		return this.m_min;
	}

	/**
	 * get the maximum value which the decision variables can take on
	 * 
	 * @return the maximum value which the decision variables can take on
	 */
	public final double getMax() {
		return this.m_max;
	}

	/**
	 * Compute the value of the benchmark function. This function takes into
	 * consideration only the first {{@link #getDimension()} elements of the
	 * candidate vector.
	 * 
	 * @param x
	 *            the candidate solution vector
	 * @return the value of the function
	 */
	public double compute(double[] x) {
		return 0;
	}
}
