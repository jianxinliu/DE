package DEAForgithub.function;

public class F4 extends Function {

	public F4() {
	}

	public F4(int dimension, double min, double max) {
		super(dimension, min, max);
	}

	@Override
	public double compute(double[] x) {
		double temp = 0.0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] > temp) {
				temp = x[i];
			}
		}
		return temp;
	}
}
