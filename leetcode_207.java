// 207. Course Schedule

// detect cycle in directed grph using kahn's algorithm
// tc - O(V + E)
// sc - O(V) - inDegree + q

class Solution {
    public boolean topoSortBFS(Map<Integer, List<Integer>> adjList, int[] inDegree, int numCourses){
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                count++;
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            
            for(int v : adjList.getOrDefault(u, new ArrayList<>())){
                inDegree[v]--;
                
                if(inDegree[v] == 0){
                    count++;
                    q.add(v);
                }
            }
        }

        return count == numCourses;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int[] p : prerequisites) {
            int u = p[1];
            int v = p[0];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);
            inDegree[v]++;
        }

        return topoSortBFS(adjList, inDegree, numCourses);

    }
}
