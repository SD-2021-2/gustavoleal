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

			String nome,sexo;
			int idade;

			nome = inputClient.next();
			sexo = inputClient.next();
			idade = Integer.parseInt(inputClient.next());

			if((sexo.equals("feminino") && idade>=21) || (sexo.equals("masculino") && idade>=18)){
				outputClient.writeBytes(nome + " ja atingiu a maioridade\n"); 
			}else
			{
				outputClient.writeBytes(nome + " nao atingiu a maioridade\n"); 
			}

		} 
	} 
} 
