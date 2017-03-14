package DEAForgithub.function;

public class F6 extends Function {

	@Override
	public double compute(double[] x) {
		double temp = 0.0;
		for (int i = 0; i < x.length - 1; i++) {
			temp += common.squares(Math.floor(x[i] + 0.5));
		}
		return temp;
	}

	public F6() {
	}

	public F6(int dimension, double min, double max) {
		super(dimension, min, max);
	}
}
