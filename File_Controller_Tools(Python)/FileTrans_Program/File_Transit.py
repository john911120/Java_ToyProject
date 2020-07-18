import socketserver
from os.path import exists

HOST = ''
PORT = 9009

class MyTcpHandler(socketserver.BaseRequestHandler):
    def handle(self):
        data_transferred = 0
        print('[%s] Connected'%self.client_address[0])
        filename = self.request.recv(1024)
        filename = filename.decode()

        if not exists(filename):
            return

        print('File[%s] Trans Start!'%filename)
        with open(filename, 'rb') as f:
            try:
                data = f.read(1024)
                while data:
                    data_transferred += self.request.send(data)
                    data = f.read(1024)
            except Exception as e:
                print(e)

        print('Trans Complete[%s], Data Size[%d]'%(filename, data_transferred))

def runServer():
    print('+++ Start the File Transit Server+++')
    print('+++ If you Want to Stop the Server Press the Ctrl+C +++')

    try:
        server = socketserver.TCPServer((HOST, PORT), MyTcpHandler)
        server.serve_forever()
    except KeyboardInterrupt:
        print('--- File Transit Server is Closed ---')

runServer()
