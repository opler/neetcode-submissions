from collections import defaultdict
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #set1=set(s)
        if(len(s)!=len(t)):
            return False
        else:
            dict1=defaultdict(int)
            dict2=defaultdict(int)
            for i in s:
                dict1[i]=dict1.get(i,0)+1
            for i in t:
                dict2[i]=dict2.get(i,0)+1
                
        return (dict1==dict2)                