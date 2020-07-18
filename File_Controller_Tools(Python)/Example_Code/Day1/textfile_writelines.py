count = 1
data = []
print('파일에 내용을 저장하려면 내용을 입력하지 말고 enter를 누르시오')
while True:
    text = input('[%d] 파일에 저장할 내용을 입력하시오 : ' %count)
    if text == '':
        break
    data.append(text+'\n')
    count += 1

f = open('mydata.txt','w')
f.writelines(data)
f.close()