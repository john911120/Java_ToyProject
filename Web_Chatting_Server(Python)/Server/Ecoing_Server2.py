import socketserver

HOST = ''
PORT = 9009


class MyTcpHandler(socketserver.BaseRequestHandler):
    # 이 클래스는 서버 하나당 단 한번 초기화가 된다.
    # handle() 메소드에 클라이너트 연결 처리를 위한 로직 구현
    def handle(self):
        print('[%s] Connected'%self.client_address[0])

        try:
            while True:
                self.data = self.request.recv(1024)
                if self.data.decode() == '/quit':
                    print('[%s] 사용자에 의해 중단됨 ' %self.client_address[0])
                    return

                print('[%s]'%self.data.decode())
                self.request.sendall(self.data)
        except Exception as e:
            print(e)

def runServer():
    print('+++ Start the Eco Server+++')
    print('+++ If you Want to Stop the Server Press the Ctrl+C +++')

    try:
        server = socketserver.TCPServer((HOST, PORT), MyTcpHandler)
        server.serve_forever()
    except KeyboardInterrupt:
        print('--- EcoServer is Closed ---')

runServer()
