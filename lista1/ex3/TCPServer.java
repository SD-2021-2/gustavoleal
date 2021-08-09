import java.io.*; 
import java.net.*; 
import java.util.Scanner;

class TCPServer { 

	public static void main(String argv[]) throws Exception 
	{ 

		String text;
		ServerSocket myServer = new ServerSocket(6789); 
		while(true) { 

			Socket conectSocket = myServer.accept(); 

			Scanner inputClient = new Scanner(conectSocket.getInputStream());
			DataOutputStream  outputClient = new DataOutputStream(conectSocket.getOutputStream()); 

			int n1,n2,n3;

			n1 = Integer.parseInt(inputClient.next());
			n2 = Integer.parseInt(inputClient.next());
			n3 = Integer.parseInt(inputClient.next());

			if((n1+n2>=14) || (n1+n2>=6 && (n1+n2+2*n3>=20))){
				outputClient.writeBytes("Aprovado\n"); 
			}else
			{
				outputClient.writeBytes("reprovado\n"); 
			}

		} 
	} 
} 
