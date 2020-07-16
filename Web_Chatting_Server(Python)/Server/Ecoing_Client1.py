import socket

HOST = 'localhost'
PORT = 9009

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:
    sock.connect((HOST,PORT))
    msg = input('Input the Message : ')
    sock.sendall(msg.encode())
    data = sock.recv(1024)

print('From Receiving the Eco Server [%s] ' %data.decode())