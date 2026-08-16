class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for(int num: nums) {
            List<List<Integer>> toAddList = new ArrayList<>();
            for(List<Integer> el: output) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(el);
                newList.add(num);
                toAddList.add(newList);
            }
            output.addAll(toAddList);
        }

        return output;
    }
}
