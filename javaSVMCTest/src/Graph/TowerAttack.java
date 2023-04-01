package Graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Tower {
	int number;
	int cannons;

	public Tower(int number, int cannons) {
		super();
		this.number = number;
		this.cannons = cannons;
	}

	@Override
	public String toString() {
		return "Tower [number=" + number + ", cannons=" + cannons + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCannons() {
		return cannons;
	}

	public void setCannons(int cannons) {
		this.cannons = cannons;
	}

}

public class TowerAttack {
	public static int n;
	static int findMaxVertex(boolean visited[], int weights[]) {
		int index = -1;
		int maxW = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (visited[i] == false && weights[i] > maxW) {
				maxW = weights[i];
				index = i;
			}
		}
		return index;
	}
	static void printMaximumSpanningTree(int graph[][], int parent[]) {
		// of a graph
		int MST = 0;
		for (int i = 1; i < n; i++) {
			if(parent[i]!=-1)
			// Update MST
			MST += graph[i][parent[i]];
		}

		System.out.println("Weight of the maximum Spanning-tree " + MST);
		System.out.println();
		System.out.println("Edges \tWeight");

		for (int i = 1; i < n; i++) {
			if(parent[i]!=-1)
			System.out.println(parent[i] + " - " + i + " \t" + graph[i][parent[i]]);
		}
	}
	static int maximumSpanningTree(int[][] graph,int start) {

		boolean[] visited = new boolean[n];
		int[] weights = new int[n];
		int[] parent = new int[n];

		for (int i = 0; i < n; i++) {
			visited[i] = false;
			weights[i] = Integer.MIN_VALUE;
		}
		boolean check=true;
		int MST = 0;
		while(check) {
			weights[start] = Integer.MAX_VALUE;
			parent[start] = -1;

			for (int i = 0; i < n - 1; i++) {

				int maxVertexIndex = findMaxVertex(visited, weights);
				if(maxVertexIndex!=-1) {
				visited[maxVertexIndex] = true;
				
				}
				for (int j = 0; j < n; j++) {
					if (maxVertexIndex!=-1&&graph[j][maxVertexIndex] != 0 && visited[j] == false) {
						if (graph[j][maxVertexIndex] > weights[j]) {
							weights[j] = graph[j][maxVertexIndex];
							parent[j] = maxVertexIndex;
						}
					}
				}
			}
			check=false;
			for(int i=0;i<n;i++) {
				if(!visited[i]) {
					check=true;
					start=i;
					break;
				}
			}
		}
		printMaximumSpanningTree(graph, parent);
		for (int i = 1; i < n; i++) {

			// Update MST
			if(parent[i]!=-1)
			MST += graph[i][parent[i]];
		}
		return MST;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			n = sc.nextInt();
			int[][] array = new int[n][n];
			Tower[] towerArray = new Tower[n];
			for (int k = 0; k < n; k++) {
				towerArray[k] = new Tower(sc.nextInt(), sc.nextInt());
				int linkedTower = sc.nextInt();
				for (int i = 0; i < linkedTower; i++) {
					int t = sc.nextInt();
					array[towerArray[k].getNumber()][t] = 1;
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (array[i][j] == 1) {
						array[i][j] = towerArray[i].getCannons() + towerArray[j].getCannons();
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(array[i][j] + " ");
				}
				System.out.println("");
			}
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					sum = sum + array[i][j];
				}
			}
			int val=maximumSpanningTree(array,0);
			System.out.println(sum-val);

		}
	}

}
