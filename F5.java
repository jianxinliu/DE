package DEAForgithub.function;

public class F5 extends Function {

	public F5() {
	}

	public F5(int dimension, double min, double max) {
		super(dimension, min, max);
	}

	@Override
	public double compute(double[] x) {
		double temp = 0.0;
		for (int i = 0; i < x.length - 1; i++) {
			temp += common.squares(100 * (x[i + 1] - x[i] * x[i])) + common.squares(x[i] - 1);
		}
		return temp;
	}
}
