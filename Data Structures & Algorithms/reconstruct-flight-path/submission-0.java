class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adjList = new HashMap<>();

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(dest);
        }

        for (String key: adjList.keySet()) {
            Collections.sort(adjList.get(key));
        }

        List<String> output = new ArrayList<>();
        
        dfs(adjList, output, "JFK");
        Collections.reverse(output);
        
        if (output.size() != tickets.size() + 1) {
            return new ArrayList<>();
        }

        return output;
    }

    public void dfs(Map<String, List<String>> adjList, List<String> output, String src) {
        if (adjList.containsKey(src)) {
            List<String> dests = new ArrayList<>(adjList.get(src));
            while (!dests.isEmpty()) {
                String dest = dests.get(0);
                adjList.get(src).remove(0);
                dfs(adjList, output, dest);
                dests = new ArrayList<>(adjList.get(src));
            }
        }
        output.add(src);
    }
}
