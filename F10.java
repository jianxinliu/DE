package DEAForgithub.function;

public class F10 extends Function {
	@Override
	public double compute(double[] x) {
		double temp = 0.0, y1 = 0.0, y2 = 0.0;
		for (int i = 0; i < x.length; i++) {
			y1 += x[i] * x[i];
			y2 += Math.cos(2 * Math.PI * x[i]);

		}
		temp = -20 * Math.exp(-0.2 * Math.sqrt(y1 / x.length)) - Math.exp(y2 / x.length) + 20 + Math.exp(1);
		return temp;
	}

	public F10() {
	}

	public F10(int dimension, double min, double max) {
		super(dimension, min, max);
	}
}
