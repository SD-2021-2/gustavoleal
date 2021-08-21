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
			PrintWriter outputClient = new PrintWriter(conectSocket.getOutputStream(),true); 

			int idade,tempo;
			String resp = "";

			idade = Integer.parseInt(inputClient.next());
			tempo = Integer.parseInt(inputClient.next());
			
			if(idade>=65 || tempo>=30 || (idade>=60 && tempo>=25))
			{
				resp = "Voce ja pode se aposentar :-)";
			}else
			{
				resp = "Voce nao pode se aposentar :-(";
			}
			outputClient.println(resp);

		} 
	} 
} 
