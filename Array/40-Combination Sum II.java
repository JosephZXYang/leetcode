/**

Key points:

    1. Backtracking
    2. Duplicates are handled by the condition canditates[i] == candidates[i-1]
        (this is a bit tricky)
Difficulty: Medium

*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        combinationSum2Helper(candidates, target, 0, path, result);
        
        return result;
        
    }
    
    void combinationSum2Helper(int[] candidates, int target, int index, List<Integer> path, List<List<Integer>> result) {
        
        if (target == 0) {
            result.add(path);
            return;
        }
        
        
        for (int i = index; i < candidates.length && candidates[i] <= target; i++ ) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            List<Integer> copy = new ArrayList<>();
            copy.addAll(path);
            copy.add(candidates[i]);
            combinationSum2Helper(candidates, target - candidates[i], i+1, copy, result);
        }
    }
}