import os
from os.path import exists

dir_name = input('새로 생성할 디렉토리를 입력하세요')
if not exists(dir_name):
    os.mkdir(dir_name)
    print('[%s]디렉토리를 생성하였다.' %dir_name)
else:
    print('[%s]는 이미 존재한다.' %dir_name)
