import ast
def generatenames(n):
    '''
    Generate differnt names for each row
    '''
    def recurselook(i):
        j = i - 1
        if i == 1:
            k = 0
            return  ((str(i) + '+') * (n - (i * (i - k)))).rstrip('+')
        return recurselook(j) 
        
        
    def getlist(turn):
        big = 1
        str3 = ''
        if big == 1:
            str3 = str3 + ((str(big) + '+') * (turn/big)).rstrip('+')
            big += 1
        while big < turn and big > 1:
            print "Turn is : " +str(big)
            filler = big - 1
            while filler != big and filler >0:
                print "Filler: " + str(filler)
                str1 = str(big) + "+"
                #print str1
                str2 = str(filler) + "+"
                #print str2
                #str3 = str1 * (big-filler) + str2 * (n - (big * (big - filler)))
                str3 = str3 + recurselook(turn, big)
                #print str3
                filler -= 1
                #l.append(str3.rstrip('+'))
            big += 1

            if big == turn:
                str3 = str(big)
       
        return str3.rstrip('+')
    
    def getl(turn):
        str3 = recurselook(turn)
        return str3.rstrip('+')
    
    nlist = [getl(turn) for turn in range(1,n+1) ]   
    return nlist

for i in range(3, 5):
    print generatenames(i)
    
    
