from socket import *
serverName = '127.0.0.1'
serverPort = 6789
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((serverName,serverPort))
sentence = input('Escreva sua idade e tempo de serviço:') + '\n';
# print(sentence)

clientSocket.send(sentence.encode())

modifiedSentence = clientSocket.recv(1024)

clientSocket.close()
print (modifiedSentence.decode())
