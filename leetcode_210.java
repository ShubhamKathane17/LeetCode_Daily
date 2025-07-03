// 210. Course Schedule II

// using kahn's algo to find the topological order and checking if all the courses are covered in the topological order
// tc - O(V + E)
// sc - O(V + E)


class Solution {
    public int[] topoSortKahn(Map<Integer, List<Integer>> adjList, int numCourses, int[] inDegree) {
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[numCourses];
        int idx = 0;

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                ans[idx++] = i;
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adjList.getOrDefault(u, new ArrayList<>())) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    ans[idx++] = v;
                    q.add(v);
                }
            }
        }

        if (idx != numCourses) {
            return new int[] {};
        }
        return ans;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int[] p : prerequisites) {
            int u = p[1];
            int v = p[0];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);

            inDegree[v]++;
        }

        return topoSortKahn(adjList, numCourses, inDegree);
    }
}
