package DEAForgithub.function;

public class F11 extends Function {
	@Override
	public double compute(double[] x) {
		double temp = 0.0, y1 = 0.0, y2 = 1.0;
		for (int i = 0; i < x.length; i++) {
			y1 += x[i] * x[i];
			y2 *= Math.cos(x[i] / Math.sqrt(i + 1));
		}
		temp = (1 / 4000) * y1 - y2 + 1;
		return temp;
	}

	public F11() {
	}

	public F11(int dimension, double min, double max) {
		super(dimension, min, max);
	}
}
