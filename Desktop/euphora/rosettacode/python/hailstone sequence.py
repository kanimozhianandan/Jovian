'''
Generated hailstone sequence and provides the length of max hailstone sequence generated by a number < 100000
'''
def welcome():
    print __doc__
    n = input()
    return n
def hailstone(n):
    l = [n]
    while n != 1:
        if n%2 == 0:
            n = n/2
            l.append(n)
        else:
            n = (3 * n) + 1
            l.append(n)
    return l

n = welcome()
print "The hailstone sequence for %d  is %s"%(n, hailstone(n))
print
print "Max sequence %d found for %d" %(max((len(hailstone(i)), i) for i in range(1,100000)))
