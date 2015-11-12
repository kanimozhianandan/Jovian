'''
Generate a random number of opening and closing barckets and determine if they are balanced
'''
import random
def welcome():
    print __doc__
    bracke = genbrackets()
    #print "Brackets generated as : ", bracke
    return bracke
def genbrackets():
    brackets = ['[',']'] * random.randint(1,10)
    random.shuffle(brackets)
    return ''.join(brackets)
def are_balanced(txt):
    print txt
    ok = True
    if txt.startswith(']'):
        print "Startswith closign bracket"
        ok = False
    else:
        ll = [e for e in txt]
        for i in range(len(txt)):
                if ll.count('[') == ll.count(']') and (ll[0] != ']'):
                    ltemp = txt[i+1:]
                    if ('[' in txt[:i]) and (']' in ltemp):
                        k =  txt.find('[')
                        del ll[k]
                        lt = txt.find(']') 
                        del ll[lt]
                else:
                    ok = not ok
                    break
    return ok

txt=welcome()
txt = '[[]]'
print are_balanced(txt)


