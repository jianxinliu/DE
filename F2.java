package DEAForgithub.function;

public class F2 extends Function {

	public F2() {

	}

	public F2(int dimension, double min, double max) {
		super(dimension, min, max);
	}

	@Override
	public double compute(double[] x) {
		return common.sum(x, true) + common.multiply(x, true);
	}
}
