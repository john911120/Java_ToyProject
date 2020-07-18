num = input('press the any Number')

if num.isdigit():
    num = num[::-1]
    ret = ''
    for i, c in enumerate(num):
        i += 1
        if i != len(num) and i%3 == 0:
            ret += (c + ',')
        else:
            ret += c
        ret = ret[::-1]
        print(ret)
    else:
        print('inputed Number [%s] : is not Number' %num)