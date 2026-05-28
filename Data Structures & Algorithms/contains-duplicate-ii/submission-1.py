class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        dic=dict()
        for i in range(0,len(nums)):
            if nums[i] in dic and abs(dic[nums[i]] - i)<=k:
                return True
            else:
                dic[nums[i]]=i      
        return False        