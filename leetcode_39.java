// 39. Combination Sum
// optimal approach - using backtracking
// tc - O(N∗Target∗NumberOfCombinations)
// sc - O(n) - temp to store the items

class Solution {
    private List<List<Integer>> ans;

    private void solve(int[] candidates, int target, int idx, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || idx == candidates.length) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            temp.add(candidates[i]);
            solve(candidates, target - candidates[i], i, temp);
            temp.remove(temp.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        ans = new ArrayList<>();

        solve(candidates, target, 0, temp);

        return ans;
    }
}
