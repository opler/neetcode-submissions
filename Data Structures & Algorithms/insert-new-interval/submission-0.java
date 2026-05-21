class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean isAdded = false;

        for (int [] interval : intervals) {
            if (isAdded || newInterval[0] > interval[1]) {
                res.add(interval);
            } else if (newInterval[1] < interval[0]) {
                res.add(newInterval);
                res.add(interval);
                isAdded = true;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        if (!isAdded) {
            res.add(newInterval);
        }



        return res.toArray(new int[res.size()][]);
    }
}
