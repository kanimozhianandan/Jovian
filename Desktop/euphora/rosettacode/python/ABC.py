import string
digits = string.ascii_letters
sampleblocks='BO XK DQ CP NA GT RE TG QD FS JW HU VI AN OB ER FS LY PC ZM'.split()
def make_word(word):
    bb = []
    can_make = False
    if any(letter not in digits for letter in set(word)):
        can_make = False      
    else:
        for letter in set(word):
            for b in sampleblocks:
                print b
                if (b not in bb) and (letter.upper() in b):
                    can_make = True
                    bb.append(b)
                    break
            if not can_make:
                break
            
    return can_make

word = raw_input("Enter string to check for:")
print make_word(word)

    
            
         
         
         
    
