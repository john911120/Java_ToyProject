import socket

HOST = ''
PORT = 9009

def runServer():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:
        sock.bind((HOST, PORT))
        sock.listen(1)
        print('Wating for Client Connection')
        conn, addr = sock.accept()
        with conn:
            print('[%s] is Connected!' %addr[0])
            while True:
                data = conn.recv(1024)
                if not data:
                    break
                print('Messeage Receiving [%s]' %data.decode())
                conn.sendall(data)

runServer()