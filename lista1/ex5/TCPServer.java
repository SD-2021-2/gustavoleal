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

			int idade;
			String categoria = "";

			idade = Integer.parseInt(inputClient.next());
			if(idade>=5 && idade<=10)
			{
				categoria = "infatil";
				if(idade>=8)
					categoria = categoria + " B";
				else
					categoria = categoria + " A";
			}else if(idade>=11 && idade<=17)
			{
				categoria = "juvenil";
				if(idade>=14)
					categoria = categoria + " B";
				else
					categoria = categoria + " A";
			}else if(idade>=18)
			{
				categoria = "adulto";
			}
			outputClient.writeBytes("A sua Categoria e: " + categoria + '\n');

		} 
	} 
} 
