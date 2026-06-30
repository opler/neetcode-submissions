from collections import defaultdict
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s)!=len(t)):
            return False
        n=len(s)
        dict_1=dict()
        dict_2=dict()
        for i in range(n):
            dict_1[s[i]]=dict_1.get(s[i],0)+1
            dict_2[t[i]]=dict_2.get(t[i],0)+1
        return(dict_1==dict_2)    


                       