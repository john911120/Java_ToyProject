visit_ip = []

with open('access_log', 'r') as f:
    logs = f.readlines()
    for log in logs:
        log = log.split()
        ip = log[0]
        if ip not in visit_ip:
            visit_ip.append(ip)

print('Total Visitors : [%d]' %len(visit_ip))