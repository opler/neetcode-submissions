class MedianFinder {

    // MaxHeap
    PriorityQueue<Integer> firstHalf = new PriorityQueue<>(Collections.reverseOrder());
    // MinHeap
    PriorityQueue<Integer> secondHalf = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        firstHalf.offer(num);
        if (firstHalf.size() - secondHalf.size() > 1 || !secondHalf.isEmpty() && firstHalf.peek() > secondHalf.peek()) {
            secondHalf.offer(firstHalf.poll());
        }
        if (secondHalf.size() - firstHalf.size() > 1) {
            firstHalf.offer(secondHalf.poll());
        }
    }
    
    public double findMedian() {
        if (firstHalf.size() == secondHalf.size()) {
            return (double) (firstHalf.peek() + secondHalf.peek())/2;
        }
        if (firstHalf.size() > secondHalf.size()) {
            return (double) firstHalf.peek();
        } else {
            return (double) secondHalf.peek();
        }
    }
}
