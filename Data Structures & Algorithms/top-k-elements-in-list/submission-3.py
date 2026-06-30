from collections import defaultdict
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        d=defaultdict(int)
        for i in nums:
            d[i]=d[i]+1
        sorted_dict = dict(sorted(d.items(), key=lambda x: x[1],reverse=True))
        return list(sorted_dict.keys())[:k]    

                       
        