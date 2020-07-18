from os import rename

target_file = 'Dn3CV3EUcAETK63.jpg'
newname = input('[%s]에 대한 새로운 이름을 입력하세요'%target_file)
rename(target_file, newname)
print('[%s] -> [%s]으로 파일 이름이 변경되었습니다.'%(target_file, newname))