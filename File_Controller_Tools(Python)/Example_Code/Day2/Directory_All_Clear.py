import shutil
import os

target_folder = 'C:/Users/wtt54/OneDrive/바탕 화면/document/Time'
print('[%s] 하위 모든 디렉토리 및 파일들을 삭제한다.' %target_folder)
for file in os.listdir(target_folder):
    print(file)
k = input('[%s]를 삭제할거야? (y/n)' %target_folder)
if k == 'y':
    try:
        shutil.rmtree(target_folder)
        print('[%s]의 모든 하위 디렉토리와 파일들을 삭제했다.' %target_folder)
    except Exception as e:
        print(e)