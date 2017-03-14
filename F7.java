package DEAForgithub.function;

public class F7 extends Function {

	public F7() {
	}

	public F7(int dimension, double min, double max) {
		super(dimension, min, max);
	}

	@Override
	public double compute(double[] x) {
		double temp = 0.0;
		for (int i = 0; i < x.length; i++) {
			temp += (i + 1) * common.squares(x[i] * x[i]);
		}
		temp += Math.random();
		return temp;
	}
}
