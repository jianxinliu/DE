package DEAForgithub.function;

public class F8 extends Function {

	public F8() {
	}

	public F8(int dimension, double min, double max) {
		super(dimension, min, max);
	}

	@Override
	public double compute(double[] x) {
		double temp = 0.0;
		for (int i = 0; i < x.length; i++) {
			temp += (-x[i]) * Math.sin(Math.sqrt(Math.abs(x[i])));
		}
		return temp;
	}
}
