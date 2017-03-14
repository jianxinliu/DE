package DEAForgithub.function;

public class F3 extends Function {

	public F3() {
	}

	public F3(int dimension, double min, double max) {
		super(dimension, min, max);
	}

	@Override
	public double compute(double[] x) {
		double temp = 0.0;
		for (int i = 0; i < x.length; i++) {
			double y = 0.0;
			for (int j = 0; j < i; j++) {
				y += x[j] * x[j];
			}
			temp += y;
		}
		return temp;
	}
}
