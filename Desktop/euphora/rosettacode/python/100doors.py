d = [False] * 100
for j in xrange(100):
    for i in xrange(j,100,j+1):
        d[i] = not d[i]
    print "%d pass completed" %(j)
print   "Open doors are: ", [k+1 for k in range(len(d)) if d[k]]
        
    
