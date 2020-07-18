from time import localtime

weekdays = ['月曜日','火曜日','水曜日','木曜日','金曜日','土曜日','日曜日']

t = localtime()
today = '%d-%d-%d' %(t.tm_year, t.tm_mon, t.tm_mday)
week = weekdays[t.tm_wday]

print('[%s] today is [%s]' %(today, week))