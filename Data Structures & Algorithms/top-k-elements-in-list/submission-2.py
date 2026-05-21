from collections import defaultdict
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        ret=defaultdict(int)
        for i in nums:
            ret[i]=ret.get(i,0)+1
        final_dict=dict(sorted(ret.items(),key=lambda x: x[1],reverse=True)[:k])
        return list(final_dict.keys())
                       
        