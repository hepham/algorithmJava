package javaSVMCTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class spiralMatrix {
	public static List<Integer> spiralOrder(int[][] arr) {
		List<Integer> results = new ArrayList<>();
		int check = 0;
		int top = 0;
		int down = arr.length - 1;
		int left = 0;
		int right = arr[0].length - 1;
//		System.out.println("down:"+down);
//		System.out.println("right:"+right);
		while (top <= down && left <= right) {
			switch (check) {
//			left to right
			case 0:
				for (int i = left; i <= right; i++) {
					results.add(arr[top][i]);
				}
				top++;
				break;
//			top to dơwn
			case 1:
				for (int i = top; i <= down; i++) {
					results.add(arr[i][right]);
				}
				right--;
				break;
//			right to left
			case 2:
				for (int i = right; i >= left; i--) {
					results.add(arr[down][i]);
				}
				down--;
				break;
//			down to top
			case 3:
				for (int i = down; i >= top; i--) {
					results.add(arr[i][left]);
				}
				left++;
			}
			check = (check + 1) % 4;
		}
		return results;
	}

	public static void main(String[] agrs) {
		File testcase = new File("./src/javaSVMCTest/test.txt");
		Scanner scanner;

		scanner = new Scanner(System.in);
		String[] split = scanner.nextLine().split(" ");
		int m = Integer.parseInt(split[0]);
		int n = Integer.parseInt(split[1]);
		int[][] arr = new int[n][m];
		split = scanner.nextLine().split(" ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(split[i * arr.length + j]);
			}
		}

		List<Integer> result = spiralOrder(arr);
		System.out.println(result.toString());

	}
}
