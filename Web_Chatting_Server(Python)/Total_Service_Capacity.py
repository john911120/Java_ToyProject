KB = 1024
total_service = 0

with open('access_log','r') as f:
    logs = f.readlines()
    for log in logs:
        log = log.split()
        servicebyte = log[9]
        if servicebyte.isdigit():
            total_service += int(servicebyte)

total_service /= KB
print('total Service Capacity : %dKB'%total_service)