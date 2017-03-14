package DEAForgithub.function;

public class F9 extends Function {
	public F9() {
	}

	public F9(int dimension, double min, double max) {
		super(dimension, min, max);
	}

	@Override
	public double compute(double[] x) {
		double temp = 0.0;
		for (int i = 0; i < x.length; i++) {
			temp += common.squares(x[i]) - 10 * Math.cos(2 * Math.PI * x[i]) + 10;
		}
		return temp;
	}
}
