import socket

HOST = 'localhost'
PORT = 9009

def getFileFromServer(filename):
    data_transferred = 0

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:
      sock.connect((HOST, PORT))
      sock.sendall(filename.encode())

      data = sock.recv(1024)
      if not data:
         print('File[%s] : Is Not Exist or TransError is Accured' %filename)
         return

      with open('download/'+filename, 'wb') as f:
        try:
            while data:
               f.write(data)
               data_transferred += len(data)
               data = sock.recv(1024)
        except Exception as e:
               print(e)

    print('File[%s] : Transform Completed. Data:[%d]'%(filename,data_transferred))

filename = input('Want to your DownloadFile Input this line : ')
getFileFromServer(filename)
