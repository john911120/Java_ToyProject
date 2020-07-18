import os

newfolder = input('새로 생성할 디렉토리 이름을 입력하세요')
try:
    os.mkdir(newfolder)
    print('[%s] 디렉토리를 생성하였습니다.'%newfolder)
except Exception as e:
    print(e)