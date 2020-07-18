bufsize = 1024
f = open('Dn3CV3EUcAETK63.jpg','rb')
h = open('Dn3CV3EUcAETK63_Copy.jpg','wb')

data = f.read(bufsize)
while data:
    h.write(data)
    data = f.read(bufsize)

f.close()
h.close()