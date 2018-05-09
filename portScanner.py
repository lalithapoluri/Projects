import socket
import sys
host = sys.argv[1];
begin = int(sys.argv[2]);
end = int(sys.argv[3]); 

for port in range(begin,end+1):
	sock = socket.socket()
	result = sock.connect_ex((host,port))      
	if result == 0:
		print((str(port))+' is open') 
		sock.close()
	else:
		print((str(port))+' is closed') 
		sock.close()