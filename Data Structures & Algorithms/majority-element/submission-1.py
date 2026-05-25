class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        dict_cnt=dict()
        for i in nums:
            dict_cnt[i]=dict_cnt.get(i,0)+1
        for k,v in dict_cnt.items():
            if(v>=int(len(nums)/2)):
                return k
        