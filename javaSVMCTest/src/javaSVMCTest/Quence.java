package javaSVMCTest;

import java.util.Scanner;

public class Quence {
	public static void main(String[] args) {
		int m, n;
		int count=0;
		
		int[] dxq = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dyq = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dxk = { -2, -2, -1, 1, 2, 2, 1, -1 };
		int[] dyk = { -1, 1, 2, 2, 1, -1, -2, -2 };
		Scanner sc = new Scanner(System.in);
		while (true) {
			m = sc.nextInt();
			n = sc.nextInt();
			if (m == 0 && n == 0) {
				break;
			}
			int[][] broad = new int[1001][1001];
			int q, k, p;
			int[][] nq = new int[2][1000];
			int[][] nk = new int[2][1000];
			q = sc.nextInt();
			for (int i = 0; i < q; i++) {
				nq[0][i] = sc.nextInt();
				nk[1][i] = sc.nextInt();
				broad[nq[0][i]][nq[1][i]] = 1;
			}
			k = sc.nextInt();
			for (int i = 0; i < k; i++) {
				nq[0][i] = sc.nextInt();
				nk[1][i] = sc.nextInt();
				broad[nq[0][i]][nq[1][i]] = 2;
			}
			p = sc.nextInt();
			for (int i = 0; i < p; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				broad[x][y] = 3;
			}
//		quan hau
			for (int i = 0; i < q; i++) {
				for (int j = 0; j < 8; j++) {
					for (int l = 1;; l++) {
						int x = nq[0][i] + dxq[j] * l;
						int y = nq[1][i] + dyq[j] * l;
						if (x <=0 || x >n|| y <= 0 || y >=m) {
							break;
						}
						if (broad[x][y] == 1 || broad[x][y] == 2 || broad[x][y] == 3) {
							break;
						}
						broad[x][y] = -1;
						count++;

					}
				}
			}
//		quan ma
			for (int i = 0; i < q; i++) {
				for (int j = 0; j < 8; j++) {
					int x = nq[0][i] + dxk[j];
					int y = nq[1][i] + dyk[j];
					if (x <=0 || x > n|| y <= 0 || y >=m) {
						break;
					}
					if (broad[x][y] == 1 || broad[x][y] == 2 || broad[x][y] == 3) {
						break;
					}
					broad[x][y] = -1;
					count++;

				}
			}
			
			System.out.println(m*n-count-q-k-p);
		}
		
	}
}
