package org.lanqiao.algo.elementary._01xor.exam;

/**
 * 找出数组中不重复的三个数，其余数皆为成对出现 输入 123 44 55 66 输出123
 * 
 * @author zhengwei lastmodified 2017年3月11日
 *
 */
public class TheThreeSingleNum {

	/**
	 * 找到bit上为1的最后一位的下标
	 * 
	 * @param n
	 * @return
	 */
	public static int getLastBitIndexOf1(int n) {
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) != 0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 将bit位最后一个1保留，其余变为 1 
	 * 1001 
	 * ^ 
	 * 0001 
	 * ---- 
	 * 1000 
	 * & 
	 * 1001 
	 * ------ 
	 * 0001
	 * 
	 * @param n
	 * @return
	 */
	public static int saveLast1(int n) {
		int index = getLastBitIndexOf1(n);
		return 1 << index;
	}

	public static int[] findTheThreeSingleNum(int[] arr) {
		int x = 0;
		int y = 0;
		// 连续异或得到x=a^b^c
		for (int i = 0; i < arr.length; i++) {
			x ^= arr[i];
		}
		// 得到 f(x^a)^f(x^b)^f(x^c)
		for (int i = 0; i < arr.length; i++) {
			y ^= saveLast1(x ^ arr[i]);
		}
		// 得到位置M
		int M = getLastBitIndexOf1(y);
		int a=0,b=0,c = 0;
		int xorOfAB = 0;
		for (int i = 0; i < arr.length; i++) {
			// 满足与x异或后M位为1的所有元素一起异或就能得出其中一个特殊值
			if (((x ^ arr[i]) & (1 << M)) == 0) {
				c ^= arr[i];
			}else{ // 剩余的元素按找出数组中不重复的2个元素来处理，先计算出a^b
				xorOfAB ^= arr[i];
			}
		}
		// 求a^b倒数第一个为1的位
		int N = getLastBitIndexOf1(xorOfAB);
		// 再来一次区分
		for (int i = 0; i < arr.length; i++) {
			// 满足与x异或后M位为1的所有元素一起异或就能得出其中一个特殊值
			if (((x ^ arr[i]) & (1 << M)) == 0) {

			} else { // 剩余的元素按找出数组中不重复的2个元素来处理，先计算出a^b
				if ((arr[i] & (1 << N)) == 0) {
					a ^= arr[i];
				} else {
					b ^= arr[i];
				}
			}
		}
		int result[] = new int[3];
		result[0] = a;
		result[1] = b;
		result[2] = c;
		return result;
	}
}
