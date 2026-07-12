class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        for (int num: nums) {
            List<List<Integer>> subsets = result.stream()
                .map(ArrayList::new)
                .peek((subset) -> subset.add(num))
                .collect(Collectors.toList());
            result.addAll(subsets);
        }
        return result;
    }
}
