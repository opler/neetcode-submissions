class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for ( char task : tasks ) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for ( int freq : map.values() ) {
            maxHeap.offer(freq);
        }
        int timer = 0;

        Deque<int[]> q = new ArrayDeque<>(); // [count, timer]

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            if (!q.isEmpty() && timer >= q.peek()[1]) {
                maxHeap.offer(q.poll()[0]);
            }
            if (!maxHeap.isEmpty()) {
                int freq = maxHeap.poll() - 1;
                if (freq > 0) {
                    q.offer(new int[] {freq, timer + n + 1});
                }
            }
            timer++;
        }
        return timer;
    }
}
