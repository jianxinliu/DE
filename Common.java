package DEAForgithub;

public class Common {

	/** number of individual */
	private int NP = 1000;

	/** the rate of zoom in or out */
	private double ZOOM = 0.5;

	/** crossover rate */
	private double CROSSOVER = 0.9;

	/** parameter minimum value */
	private double parmin = -100;

	/** parameter maximum value */
	private double parmax = 100;

	public int getNP() {
		return NP;
	}

	public void setNP(int np) {
		NP = np;
	}

	public double getZOOM() {
		return ZOOM;
	}

	public void setZOOM(double zOOM) {
		ZOOM = zOOM;
	}

	public double getCROSSOVER() {
		return CROSSOVER;
	}

	public void setCROSSOVER(double cROSSOVER) {
		CROSSOVER = cROSSOVER;
	}

	public double getParmin() {
		return parmin;
	}

	public void setParmin(double parmin) {
		this.parmin = parmin;
	}

	public double getParmax() {
		return parmax;
	}

	public void setParmax(double parmax) {
		this.parmax = parmax;
	}

	/**
	 * @param x
	 *            the candidate solution vector
	 * @param b
	 *            true for absolute value
	 * @return sum of element of array x
	 */
	public double sum(double[] x, boolean b) {
		double temp = 0.0;
		for (int i = 0; i < x.length; i++) {
			if (b) {
				x[i] = Math.abs(x[i]);
			}
			temp += x[i];
		}
		return temp;
	}

	/**
	 * @param x
	 *            the candidate solution vector
	 * @param b
	 *            true for absolute value
	 * @return double multiply value
	 */
	public double multiply(double[] x, boolean b) {
		double temp = 0.0;
		for (int i = 0; i < x.length; i++) {
			if (b) {
				x[i] = Math.abs(x[i]);
			}
			temp *= x[i];
		}
		return temp;
	}

	/**
	 * @param x1
	 * @return
	 */
	public double squares(double x1) {
		return x1 * x1;
	}

	/**
	 * @param x1
	 * @return
	 */
	public double absolute(double x1) {
		return Math.abs(x1);
	}

	/** 
	 * internal function for benchmark 12 
	 * */
	public double y(double x) {
		return 1 + ((x + 1) / 4);
	}

	/**
	 * internal function for benchmark 12 and 13
	 * */
	public double u(double x, double a, double k, int m) {
		double temp = 0.0;
		if (x > a) {
			temp = k * Math.pow((x - a), m);
		} else if (x < -a) {
			temp = k * Math.pow((-x - a), m);
		} else {
			temp = 0;
		}
		return temp;
	}
}
