import os, glob

folder = 'C:/Users/wtt54/PycharmProjects/Py_Extract/Day1'
file_list = os.listdir(folder)
print(file_list)

files = '*.txt'
file_list = glob.glob(files)
print(file_list)