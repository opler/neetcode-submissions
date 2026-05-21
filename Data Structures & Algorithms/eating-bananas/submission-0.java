class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxNumber = 0;
        for (int pile : piles) {
            maxNumber = Math.max(maxNumber, pile);
        }

        int l = 0;
        int r = maxNumber;

        int minEatingSpeed = maxNumber;

        while (l <= r) {
            int m = (l+r)/2;
            
            int totalHours = 0;
            for (int pile: piles) {
                totalHours += Math.ceil((double) pile / m);
            }
            if (totalHours <= h) {
                minEatingSpeed = m;
                r = m - 1; 
            } else {
                l = m + 1;
            }
        }
        return minEatingSpeed;

    }
}
