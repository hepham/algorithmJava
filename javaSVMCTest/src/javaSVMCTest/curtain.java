package javaSVMCTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class curtain {
	public static String countCurtain(int n, int m, char[][] arr) {
		int[] result = new int[4];
		for (int i = 0; i < 4; i++) {
			result[i] = 0;
		}
		for (int i = 1; i < 5 * n + 1; i = i + 5) {
			for (int j = 2; j < 5 * m + 1; j = j + 5) {
				for (int k = 0; k < 4; k++) {
					if (Character.compare(arr[i + k][j], '*') != 0) {
						result[k] = result[k] + 1;
						break;
					}else if(k==3) {
						result[3]++;
					}
				}
			}
		}
		String s = "#";
		for (int i = 0; i < 4; i++) {
			s = s + i + " " + result[i] + " ";
		}
		return s;
	}

	public static void main(String[] args) {
		File testcase = new File("./src/javaSVMCTest/testcase.txt");
		int numberTest;
		int m = 0;
		int n = 0;
		int[] result = new int[4];
		char[][] arr = new char[501][501];
		int index = 0;
		Scanner scanner = null;
		try {
			scanner = new Scanner(testcase);
			numberTest = scanner.nextInt();
			scanner.nextLine();
			for (int i = 0; i < numberTest; i++) {
				String mn = scanner.nextLine();
				String[] split = mn.split(" ");
				n = Integer.parseInt(split[0]);
				m = Integer.parseInt(split[1]);
				for (int k = 0; k < 5 * n + 1; k++) {
					if (scanner.hasNextLine()) {
						String s = scanner.nextLine();
						for (int j = 0; j < s.length(); j++) {
							arr[k][j] = s.charAt(j);
						}

					}

				}

				System.out.println(curtain.countCurtain(n, m, arr));
			}

		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
