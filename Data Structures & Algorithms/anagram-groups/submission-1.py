from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ret=defaultdict(list)
        for i in strs:
            k=''.join(sorted(i))
            ret[k].append(i)
        return list(ret.values())    

        