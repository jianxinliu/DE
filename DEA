package DEAForgithub;

import java.util.TreeMap;

import DEAForgithub.function.Function;

/**
 * 2017.1.6 rewrite
 * 
 * @author jianxin liu
 *
 */
public class DE extends Function {

	/** benchmark function */
	private static Function func;

	/** generation number to process */
	private static int G;

	/** current generation */
	private static int g;

	/** common things */
	private static Common common = new Common();

	/**
	 * if current best individual is better, this variable will be update to
	 * current best individual
	 */
	private static double[] bestIndividual;

	/** this fit value will been compare every generation,hold the best one */
	private static double bestFitValue;

	private DE(int gen, Function function) {
		G = gen;
		func = function;
	}

	/**
	 * Compute the value of the benchmark function as fit value.
	 * 
	 * @param arr
	 *            the candidate solution vector
	 * @return fit value
	 */
	private static double fitness(double[] arr) {
		return func.compute(arr);
	}

	/**
	 * util method. <code>TreeMap</code> sort the key by ascending order
	 * default,so the first key is the minimum,or say best
	 * 
	 * @param fitness
	 */
	private static double BestFitness(TreeMap<Double, Integer> fitness) {
		return fitness.firstKey();
	}

	/**
	 * util method. find individual with best fit
	 * 
	 * @param bestFit
	 * @param s
	 *            <Double,Integer> map key is fit value,value is the individual
	 *            position in the group
	 * @param arr
	 *            group
	 * @return
	 */
	private static double[] find_individual_with_fit(double bestFit, TreeMap<Double, Integer> s, double[][] arr) {
		return arr[s.get(bestFit)];
	}

	/**
	 * pass in a random two-dimension array.get best fit value as the initial
	 * value get best individual
	 * 
	 * @param original
	 * 
	 */
	private static void original(double[][] original) {
		TreeMap<Double, Integer> map = new TreeMap<Double, Integer>();
		for (int i = 0; i < original.length; i++) {
			map.put(fitness(original[i]), i);
		}
		bestFitValue = BestFitness(map);
		bestIndividual = find_individual_with_fit(bestFitValue, map, original);
	}

	/**
	 * step 1 variation operation
	 */
	private static double[][] variation(double[][] x) {
		double[][] v = new double[common.getNP()][func.getDimension()];
		for (int i = 0; i < v.length; i++) {
			int[] INum = Random.create(3, 1, common.getNP() + 1);
			for (int j = 0; j < v[i].length; j++) {
				v[i][j] = x[INum[0]][j] + common.getZOOM() * (x[INum[1]][j] - x[INum[2]][j]);
			}
		}
		return v;
	}

	/**
	 * step 2 hybird operation
	 */
	private static double[][] hybird(double[][] v, double[][] x) {
		double[][] u = new double[common.getNP()][func.getDimension()];
		for (int i = 0; i < u.length; i++) {
			int Ri = (int) (1 + (Math.random() * (func.getDimension() - 1)));
			for (int j = 0; j < u[i].length; j++) {
				u[i][j] = Math.random() < common.getCROSSOVER() || j == Ri ? v[i][j] : x[i][j];
			}
		}
		return u;
	}

	/**
	 * step 3 select operation
	 */
	private static double[][] choice(double[][] u, double[][] x) {
		double[][] x_ = new double[common.getNP()][func.getDimension()];
		for (int i = 0; i < x_.length; i++) {
			x_[i] = fitness(u[i]) <= fitness(x[i]) ? u[i] : x[i];
		}
		return x_;
	}

	/**
	 * transition between old generation and new one,obtain the best individual.
	 * compare with BestFitValue,better one will be assign to BestIndividual
	 */
	private static double[][] transition(double[][] x, double[][] x_) {
		double currentBestFit;
		double[] currentBestIndividual = new double[func.getDimension()];
		TreeMap<Double, Integer> mapx = new TreeMap<Double, Integer>();
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				x[i][j] = x_[i][j];
			}
			mapx.put(fitness(x[i]), i);
		}
		currentBestFit = BestFitness(mapx);
		currentBestIndividual = find_individual_with_fit(currentBestFit, mapx, x_);
		if (currentBestFit < bestFitValue) {
			bestFitValue = currentBestFit;
			bestIndividual = currentBestIndividual;
		}
		return x;
	}

	/**
	 * create original group by random number
	 * 
	 * @param i
	 *            the first dimension index
	 * @param j
	 *            the second dimension index
	 * @param min
	 * @param max
	 * @return the array
	 */
	private static double[][] createOriginal(int dem, double min, double max) {
		double[][] result = new double[common.getNP()][dem];
		for (int k = 0; k < result.length; k++) {
			for (int k2 = 0; k2 < result[k].length; k2++) {
				result[k][k2] = min + Math.random() * (max - min);
			}
		}
		return result;
	}

	/**
	 * print the result
	 */
	public static void ResultPrint() {
		System.out.print("BestFitValue:" + bestFitValue + " ");
		for (int i = 0; i < bestIndividual.length; i++) {
			System.out.print(i + 1 + ": " + bestIndividual[i] + "    ");
		}
	}

	/**
	 * @return get Result as an array
	 */
	public static double[] getResult() {
		double[] temp = new double[bestIndividual.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = bestIndividual[i];
		}
		return temp;
	}

	/**
	 * pass in the array and it's properties to process
	 * 
	 * @param sources
	 * @param gen
	 * @param f
	 * @param cr
	 * @param function
	 */
	public static void start(int gen, Function function) {
		double[][] x = createOriginal(function.getDimension(), function.getMin(), function.getMax());
		start(x, gen, function);
	}

	/**
	 * some preparatory work for start
	 * 
	 * @param sources
	 *            sources group to process
	 * @param gen
	 *            how many generations will be process
	 * @param function
	 *            one benchmark function
	 */
	private static void start(double[][] sources, int gen, Function function) {
		new DE(gen, function);
		double[][] v, u, x_, x = sources;
		original(x);
		for (g = 0; g < G; g++) {
			System.out.println((g + 1) + ":  ");
			v = variation(x);
			u = hybird(v, x);
			x_ = choice(u, x);
			x = transition(x, x_);
		}
	}
}
