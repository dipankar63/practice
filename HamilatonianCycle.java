package days30coding;

public class HamilatonianCycle {
	static boolean isSafe(int[][] graph, int v, int path[], int pos) {
		if (graph[path[pos - 1]][v] == 0)
			return false;
		for (int i = 0; i < pos; i++) {
			if (path[i] == v)
				return false;
		}

		return true;

	}

	static boolean isHamilatonian(int[][] adjMatrix, int pos, int[] hamiltannionCycle) {

		/* base case: If all vertices are included in Hamiltonian Cycle */
		if (pos == adjMatrix.length-1) {

			if (adjMatrix[hamiltannionCycle[pos - 1]][0] == 1)
				return true;
			else
				return false;

		}

		// Try different vertices as a next candidate in Hamiltonian Cycle.
		// We don't try for 0 as we included 0 as starting point in in
		// hamCycle()
		for (int v = 1; v < adjMatrix.length; v++) {
			if (isSafe(adjMatrix, v, hamiltannionCycle, pos)) {
				hamiltannionCycle[pos] = v;
				// recur ro reconstruct the path
				if (isHamilatonian(adjMatrix, pos + 1, hamiltannionCycle) == true)
					return true;
				hamiltannionCycle[pos] = -1;

			}
		}

		return false;

	}

	public static void main(String args[]) {

		int[][] graph1 = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 }, };
		int[] hamilatonianCycle = new int[graph1.length];
		
		for(int i = 0; i<hamilatonianCycle.length ;i++){
			hamilatonianCycle[i] = -1;
		}
		hamilatonianCycle[0] = 0;
		
		System.out.println("Is Hamilatonian: "+isHamilatonian(graph1, 1, hamilatonianCycle));
		
		System.out.println("Hamiltanion Cycle: ");
		for(int i : hamilatonianCycle){
			System.out.print(i+" " );
		}
		System.out.println("------------------");

	}
}
