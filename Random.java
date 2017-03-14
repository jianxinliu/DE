package DEAForgithub;

import java.util.Set;
import java.util.TreeSet;

public class Random {

	/**
	 * 在[min,max)范围内产生n个不同的随机数
	 * 思路：若是整数，则  n<=max-min,
	 * 两种思路：
	 * 1：将产生的数放入Set或者数组（自己判断是否重复），若重复则重新产生，直到满足
	 * 2：若产生的是整数，预先生成[min,max)的所有整数，随机生成[0,top)之间的下标值，将对应的元素值作为结果保存，将该元素所有后继前移一位，重复
	 * 注：[0,top)中，top为当前数组的实际元素个数，每产生一个数，top--.
	 */

	
	
	/**
	 * 思路二的实现
	 * @param num
	 * @param min
	 * @param max
	 * @return
	 * @throws outOfBoundsException 
	 */
	private static int[] Cre(int num,int min,int max) throws outOfBoundsException{
		if(!rangeCheck(num,min,max)) throw new outOfBoundsException("Out of bunds Exception!");
		int[] temp = new int[max-min];
		int[] result = new int[num];
		int top = temp.length-1;
		for (int i = 0; i < temp.length; i++) {
			temp[i] = min+i;
		}
		int number = 0;
		for (int i = 0; i < result.length; i++) {
			number = (int)(Math.random()*(top+1));//生成[0,top]的随机下标
			result[i] = temp[number];//将生成的数保存，再移动元素
			for (int j = number; j < top; j++) {//将number后的所有元素前移一位
				temp[j] = temp[j+1];
			}
			top--;
		}
		return result;
	}
	
	
	/**
	 * 主要用这个
	 * @param num
	 * @param min
	 * @param max
	 * @return
	 */
	public static int[] create(int num,int min,int max){
		int[] temp = new int[num];
		try {
			temp =  cr(num, min, max);
		} catch (outOfBoundsException e) {
			System.out.println("out of range");
		}
		return temp;
	}
	
	
	
	private static boolean rangeCheck(int num,double min,double max){
		return num<=(max-min);
	}
	/*public static double[] getRandom(double[] a){
		int num = 0;
        int head = 0;
        double[] queen = new double[a.length];
        int tail = queen.length;
        // the number of i
        int [] INum = new int[a.length];
        //随机产生不同的行数，将所有的行数编号依次放入数组（队列）
         for(int j = 0;j<a.length;j++){
            queen[j] = j;
        }
        //产生三个不同的随机数
        while(num < a.length){
            INum[num] = (int)((Math.random()*(tail-head))+head);	
            queen[head] = queen[num];
            head++;
            num++;
        }
        return queen;
	}*/

	/**
	 * 创建 num 个 范围在 [min,max)之间的不同的随机数,若想产生[1,100]之间的100个不同随机数，
	 * 这样调用此方法create(100,1,101)或者create(101,0,101)
	 * @param num 随机数的数量 不能超过 max-min
	 * @param min
	 * @param max
	 * @return
	 * @throws outOfBoundsException
	 */
	private static double[] crea(int num,double min,double max) throws outOfBoundsException{
		if(!rangeCheck(num,min,max)) throw new outOfBoundsException("Out of bunds Exception!");
		double[] temp = new double[num];
		Set<Double> s = new TreeSet<Double>();
		double number = 0;
		for (int i = 0; i < num;i++) {
			do{
				number = Math.random()*(max-min)+min;
			}while(!s.add(number));
			temp[i] = number;
		}
		return temp;
	}
	
	
	/**
	 * 创建 num 个 范围在 [min,max)之间的不同的随机整数,若想产生[1，100]之间的100个不同随机数，
	 * 这样调用此方法create(100,1,101)    或者create(101,0,101)
	 * @param num 随机数的数量 不能超过 max-min，否则抛超范围异常
	 * @param min
	 * @param max
	 * @return
	 * @throws outOfBoundsException
	 */
	private static int[] cr(int num,int min,int max) throws outOfBoundsException{
		if(!rangeCheck(num,min,max)) throw new outOfBoundsException("Out of bunds Exception!");
		int[] temp = new int[num];
		Set<Integer> s = new TreeSet<Integer>();
		int number = 0;
		//int[] counts = new int[num];
		for (int i = 0; i < num; i++) {
			//int count = 0;
			do{
				//count++;
				number = (int)(Math.random()*(max-min)+min);
				System.out.println(number);
			}while(!s.add(number));
			//counts[i] = count;
			//System.out.println(count+"---------------------------------------------------");
			temp[i] = number;
		}
		double sums = 0;
//		for (int i = 0; i < counts.length; i++) {
//			sums += counts[i];
//			System.out.print(counts[i]+" ");
//		}System.out.println();
//		System.out.println("means:"+sums/num);
		return temp;
	}
	
	
	public static void main(String[] args) {
		int[] s;
		try {
			s = Cre(10, 100, 110);
			for (int i = 0; i <  s.length; i++) {
				System.out.print(s[i]+" ");
			}System.out.println();
			
			
			int sum = 0;
			for (int i = 0; i < s.length; i++) {
				sum+=s[i];
			}
			System.out.println(sum);
		} catch (outOfBoundsException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * useless
	 * @param n
	 * @param min
	 * @param max
	 * @return
	 * @throws outOfBoundsException
	 */
	private static int[] another(int n,int min,int max) throws outOfBoundsException{
		if(!rangeCheck(n,min,max)) throw new outOfBoundsException("Out of bunds Exception!");
		int num = 0;
		int head = 0;
		int[] queen = new int[n];
		int tail = queen.length;
		// the number of i
		int[] INum = new int[n];
		// 随机产生不同的行数，将所有的行数编号依次放入数组（队列）
		for (int j = 0; j < tail; j++) {
			queen[j] = j;
		}
		// 产生三个不同的随机数
		while (num < n) {
			INum[num] = (int) ((Math.random() * (tail - head)) + head);
			queen[head] = queen[num];
			head++;
			num++;
		}
		return INum;
	}
}


class outOfBoundsException extends Exception{
	public outOfBoundsException(String msg){
		System.out.println(msg);
	}
}
