from time import localtime, strftime

logfile = 'test.log'
def writelog(logfile, log):
    time_stamp = strftime('%Y-%m-%d-%X\t', localtime())
    log = time_stamp + log + '\n'

    with open(logfile, 'a') as f:
        f.writelines(log)

writelog(logfile, 'First_Loging_Sentense')