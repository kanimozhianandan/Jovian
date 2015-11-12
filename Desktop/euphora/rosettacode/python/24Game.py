'''
Manipulate the given 4 digits using +, - , *, / and ( ) to evaluate to 24.
Cheerios!!!
'''
import random, re, ast, sys

def answercheck(ans, digits):
    allowed = ''.join(digits) + '()+*-/\t'
    try:
        ast.parse(ans)
        ok = all(each in allowed for each in ans ) and all(digits.count(d) == ans.count(d) for d in set(digits))
    except:
        print "Invalid"
        sys.exit(0)
   
    return ok
def welcome():
    print __doc__
    digits = generatedigits()
    return digits
    
def generatedigits():
    print "Digits are :"
    digits = [str(random.randint(1,9)) for _ in range(4)]
    print digits
    return digits

digits = welcome()
ans = input()
if ans == "!":
    digits = generatedigits()
    print digits
ok = answercheck(ans, digits)
if ok:
    if eval(ans) == 24:
        print "Correct!"
        print eval(ans)
