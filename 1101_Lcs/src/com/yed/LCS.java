package com.yed;

/**
 * 动态规划法
 * @author yedong
 *
 */
public class LCS {
	
	
	/**
	 * 求两个字符串的最大子序列（可以不连续），不同于最大子字符串（要求连续）
	 * @param A
	 * @param B
	 * @return
	 */
	public int findLCS(String A, String B) {
		int lcs = 0;
		int col = A.length();
		int row = B.length();
		char[] rows = A.toCharArray();// 二维矩阵行
		char[] cols = B.toCharArray();// 二维矩阵列
		int[][] ab = new int[row][col];

		// 第一行赋值
		for (int i = 0; i < col; i++) {
			if (cols[0] == rows[i]) {
				ab[0][i] = 1;
				for (int j = i + 1; j < col; j++) {
					ab[0][j] = 1;
				}
				break;
			}
		}
		// 第一列赋值
		for (int i = 0; i < row; i++) {
			if (rows[0] == cols[i]) {
				ab[i][0] = 1;
				for (int j = i + 1; j < row; j++) {
					ab[j][0] = 1;
				}
				break;
			}
		}

		// 赋值除第一行和第一列的其他区域
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (cols[i] == rows[j]) {
					ab[i][j] = ab[i - 1][j - 1] + 1;
				} else {
					ab[i][j] = Math.max(ab[i - 1][j], ab[i][j - 1]);
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(ab[i][j] + " ");
			}
			System.out.println("");
		}

		return lcs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCS lcs = new LCS();
		lcs.findLCS("random", "androidm");
	}

}
