from time import localtime

t = localtime()
start_day = '%d-01-01' %t.tm_year
elapsed_day = t.tm_yday

print('Today is [%s] after [%d] day'%(start_day, elapsed_day))