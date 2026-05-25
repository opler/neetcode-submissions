class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if(strs is None):
            return ""
        elif(len(strs)==1):
           return strs[0]
        max_e = max(strs, key=len)
        max_length=len(max_e)

        for i in strs:
            if (max_e in i[0:max_length]):
                pass
            else:
                while(max_e not in i[0:max_length]):
                    max_length=max_length-1
                    max_e=max_e[0:max_length]

        if(max_e is None):
            return ""  
        return max_e    
        