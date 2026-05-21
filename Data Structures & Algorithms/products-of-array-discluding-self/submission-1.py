from functools import reduce
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        ret=[0]*len(nums)
        zero_cnt=0
        prod=1
        for i in nums:
            if i:
                prod=prod*i
                
            else:
                zero_cnt=zero_cnt+1   
        if zero_cnt>1:
            return  [0]*len(nums)
        for i,c in enumerate(nums):
            if zero_cnt:
                if c :
                    ret[i]=0
                else:
                    ret[i]=prod
            else:
                ret[i]=prod//c
        return ret                                

        