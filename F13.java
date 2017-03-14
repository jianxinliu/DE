package DEAForgithub.function;

public class F13 extends Function {

	public F13() {
	}

	public F13(int dimension, double min, double max) {
		super(dimension, min, max);
	}

	@Override
	public double compute(double[] x) {
		double temp = 0.0, y1 = 0.0, y2 = 0.0, y3 = 0.0, y4 = 0.0;
		y1 = common.squares(Math.sin(3 * Math.PI * x[0]));
		for (int i = 0; i < x.length - 1; i++) {

			y2 += common.squares(x[i] - 1) * (1 + common.squares(Math.sin(3 * Math.PI * x[i + 1])));

			y4 += common.u(x[i], 5, 100, 4);
		}
		y3 = (x[x.length - 1] - 1) * (1 + common.squares(Math.sin(2 * Math.PI * x[x.length - 1])));
		temp = 0.1 * (y1 + y2 + y3) + y4 + common.u(x[x.length - 1], 5, 100, 4);
		return temp;
	}
}
