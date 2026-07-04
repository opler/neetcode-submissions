class Solution:

    def encode(self, strs: List[str]) -> str:
        out_str=""
        for i in strs:
            out_str=out_str+str(len(i))+"#"+i
        return out_str

    def decode(self, s: str) -> List[str]:
        res=[]
        i=0
        j=0
        while(i<len(s)):
            l1=''
            while(s[j]!='#'):
                l1=l1+s[j]
                j=j+1
       
            n=int(l1)
            i=j+1
            res.append(s[i:i+n])
    
            i=i+n
    
            j=i
        return res    
