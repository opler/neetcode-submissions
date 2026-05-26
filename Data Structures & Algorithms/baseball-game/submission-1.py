class Solution:
    def calPoints(self, operations: List[str]) -> int:
        output=[]
        
        for i in operations:
            if i not in ["+","C","D"]:
                output.append(int(i))
                
            elif(i=="+"):
                output.append(output[len(output)-1]+output[len(output)-2])
            elif(i=="C"):
                output.pop()
            elif(i=='D'):
                output.append(output[len(output)-1]*2)
        return sum(output)        