class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        if (visited.contains("0000")) return -1;

        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");
        visited.add("0000");

        int counter = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(target)) return counter;

                List<String> options = getOptions(curr);
                for (String next : options) {
                    if (!visited.contains(next)) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            counter++;
        }
        return -1;
    }

    private List<String> getOptions(String lock) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] arr = lock.toCharArray();
            arr[i] = (char) (newSeq(arr[i], 1) + '0');
            res.add(new String(arr));

            arr = lock.toCharArray();
            arr[i] = (char) (newSeq(arr[i], -1) + '0');

            res.add(new String(arr));
        }
        return res;
    }

    private int newSeq(char n, int inc) {
        int num = n - '0';
        return (num + inc + 10) % 10;
    }
}