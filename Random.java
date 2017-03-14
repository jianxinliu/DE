package DEAForgithub;

import java.util.Set;
import java.util.TreeSet;

public class Random {

	/**
	 * ��[min,max)��Χ�ڲ���n����ͬ�������
	 * ˼·��������������  n<=max-min,
	 * ����˼·��
	 * 1����������������Set�������飨�Լ��ж��Ƿ��ظ��������ظ������²�����ֱ������
	 * 2������������������Ԥ������[min,max)�������������������[0,top)֮����±�ֵ������Ӧ��Ԫ��ֵ��Ϊ������棬����Ԫ�����к��ǰ��һλ���ظ�
	 * ע��[0,top)�У�topΪ��ǰ�����ʵ��Ԫ�ظ�����ÿ����һ������top--.
	 */

	
	
	/**
	 * ˼·����ʵ��
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
			number = (int)(Math.random()*(top+1));//����[0,top]������±�
			result[i] = temp[number];//�����ɵ������棬���ƶ�Ԫ��
			for (int j = number; j < top; j++) {//��number�������Ԫ��ǰ��һλ
				temp[j] = temp[j+1];
			}
			top--;
		}
		return result;
	}
	
	
	/**
	 * ��Ҫ�����
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
        //���������ͬ�������������е�����������η������飨���У�
         for(int j = 0;j<a.length;j++){
            queen[j] = j;
        }
        //����������ͬ�������
        while(num < a.length){
            INum[num] = (int)((Math.random()*(tail-head))+head);	
            queen[head] = queen[num];
            head++;
            num++;
        }
        return queen;
	}*/

	/**
	 * ���� num �� ��Χ�� [min,max)֮��Ĳ�ͬ�������,�������[1,100]֮���100����ͬ�������
	 * �������ô˷���create(100,1,101)����create(101,0,101)
	 * @param num ����������� ���ܳ��� max-min
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
	 * ���� num �� ��Χ�� [min,max)֮��Ĳ�ͬ���������,�������[1��100]֮���100����ͬ�������
	 * �������ô˷���create(100,1,101)    ����create(101,0,101)
	 * @param num ����������� ���ܳ��� max-min�������׳���Χ�쳣
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
		// ���������ͬ�������������е�����������η������飨���У�
		for (int j = 0; j < tail; j++) {
			queen[j] = j;
		}
		// ����������ͬ�������
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
