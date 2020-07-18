from os import remove

target_file = 'Dn3CV3EUcAETK63_Copy.jpg'
k = input('[%s] 파일을 삭제 하겠습니까?(y/n)'%target_file)
if k == 'y':
    remove(target_file)
    print('[%s]를 삭제했습니다.'%target_file)

