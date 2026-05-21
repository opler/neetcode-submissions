class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict1={}
        for i,n in enumerate(nums):
            diff=target-nums[i]
            if((diff in dict1) and (dict1[diff]!=i)):
                
                return [min(i,dict1[diff]),max(i,dict1[diff])]
            else:
                dict1[n]=i 
        return [-1.-1]                  
        