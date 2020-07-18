from os import rename

target_file = 'stockcode.txt'
newpath = input('[%s]를 이동시킬 디렉토리의 절대경로를 입력하시오 : ' %target_file)

if newpath[-1] == '/':
    newname = newpath + target_file
else:
    newname = newpath + '/' + target_file

try:
    rename(target_file, newname)
    print('[%s] -> [%s]으로 이동되었습니다.'%(target_file, newname))
except FileNotFoundError as e :
    print(e)