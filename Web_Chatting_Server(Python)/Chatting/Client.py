import socket
from threading import Thread

HOST = 'localhost' # 다른 컴퓨터에서 서버 IP로 수정하고 실행 하면 된다. 그렇게 하면 채팅을 할 수 있게 된다.
PORT =  9009

def rcvMsg(sock):
    while True:
        try:
            data = sock.recv(1024)
            if not data:
                break
            print(data.decode())
        except:
            pass

def runChat():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:
        sock.connect((HOST,PORT))
        t = Thread(target=rcvMsg, args=(sock,))
        t.daemon = True
        t.start()

        while True:
            msg = input()
            if msg == '/quit':
                sock.send(msg.encode())
                break

            sock.send(msg.encode())

runChat()