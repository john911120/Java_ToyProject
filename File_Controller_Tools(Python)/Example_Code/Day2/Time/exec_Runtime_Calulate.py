from datetime import datetime

start = datetime.now()
print('1에서 1000000까지 더한다.')
ret = 0
for i in range(1000001):
    ret += i
print('1에서 1000000까지 더한 결과 : %d' %ret)
end = datetime.now()
elapsed = end - start
print('총 소요된 시간 : ', end='');print(elapsed)
elapsed_ms = int(elapsed.total_seconds()*1000)
print('총 소요된 시간 : %dms' %elapsed_ms)