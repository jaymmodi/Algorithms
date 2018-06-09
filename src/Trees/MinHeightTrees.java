package Trees;

import java.util.*;

public class MinHeightTrees {

    //topological sort, come back to this later
    public static void main(String[] args) {
        int edges[][] = {
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 4}
        };

        System.out.println(findMinHeightTrees(6, edges));
    }


    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        if (edges.length == 0) {
            minHeightTrees.add(0);
            return minHeightTrees;
        }
        List<List<Integer>> outList = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            outList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            outList.get(edge[0]).add(edge[1]);
            outList.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int sz = queue.size();
            minHeightTrees = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                int tmp = queue.poll();
                minHeightTrees.add(tmp);
                for (int neighbour : outList.get(tmp)) {
                    inDegree[neighbour]--;
                    if (inDegree[neighbour] == 1) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        return minHeightTrees;
    }
}
