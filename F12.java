package DEAForgithub.function;

public class F12 extends Function {

	public F12() {
	}

	public F12(int dimension, double min, double max) {
		super(dimension, min, max);
	}

	@Override
	public double compute(double[] x) {
		double temp = 0.0, y1 = 0.0, y2 = 0.0, y3 = 0.0, y4 = 0.0;
		y1 = 10 * common.squares(Math.sin(Math.PI * common.y(x[0])));
		for (int i = 0; i < x.length - 1; i++) {

			y2 += common.squares(common.y(x[i]) - 1)
					* (1 + 10 * common.squares(Math.sin(Math.PI * common.y(x[i + 1]))));

			y4 += common.u(x[i], 10, 100, 4);
		}
		y3 = common.squares(common.y(x[x.length - 1]));
		temp = (Math.PI / x.length) * (y1 + y2 + y3) + y4 + common.u(x[x.length - 1], 10, 100, 4);
		return temp;
	}
}
