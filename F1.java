package DEAForgithub.function;

public class F1 extends Function {

	public F1() {
	}

	public F1(int dimension, double min, double max) {
		super(dimension, min, max);
	}

	@Override
	public double compute(double[] x) {
		double temp = 0.0;
		for (int i = 0; i < x.length; i++) {
			temp += common.squares(x[i]);
		}
		return temp;
	}
}
