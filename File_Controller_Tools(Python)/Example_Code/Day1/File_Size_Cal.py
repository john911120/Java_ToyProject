from os.path import getsize

file1 = 'stockcode.txt'
file2 = 'Dn3CV3EUcAETK63.jpg'
file_Size1 = getsize(file1)
file_Size2 = getsize(file2)

print('File Name : %s\t, File Size : %d' %(file1, file_Size1))
print('File Name : %s\t, File Size : %d' %(file2, file_Size2))