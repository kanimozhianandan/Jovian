import sys
def read_content(lines_per_case):
    def detect_type(line):
        ca = [int(s) if s.isdigit() else s for s in line.split()]
        if len(ca) > 1:
            return ca
        else:
            return ca[0]
    with open(sys.argv[1],"r") as f:
        content = f.readlines()    
    inputs = [detect_type(c.rsplit('\n')[0]) for c in content] #convert string or int by datatype
    n = int(inputs[0])
    del inputs[0]
    test_cases = []
    for test in range(0,n):
        if lines_per_case > 1:
            cases = [inputs[i] for i in range(test,test+lines_per_case)]
        else: cases = inputs[test]    
        test_cases.append(cases)
    return n, test_cases

#memoization technique
def get_memoize(d):
    if memoize.has_key(d):
        return memoize.get(d)        
    else:
        memoize[d] = (v* (get_memoize(d-1) + c*get_memoize(d-2))) % 1000000007
        return memoize[d]  
    
n, content = read_content(1)    
for line in range(n):
    memoize = {}
    memoize[0] = 1
    c, v, l = content[line][0], content[line][1], content[line][2]
    memoize[1] = v
    res = get_memoize(l)
    print "Case #{}: {}".format(line+1, res)    
        #bef = v if l-1 == 1 else get_memoize(l-1)
        #aft = v if l-2 == 1 else get_memoize(l-2)
        #print v*(bef + c*aft) 
    
    
