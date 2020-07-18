text = input("input your sentence")

ret = ''
for i in range(len(text)):
    if i != len(text) -1:
        ret += text[i + 1]
    else:
        ret += text[0]

print(ret)