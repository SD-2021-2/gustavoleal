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

			String sexo;
			double altura;

			sexo = inputClient.next();
			altura = Double.parseDouble(inputClient.next());
			double peso = 0;
			if(sexo.equals("feminino")){
				peso = altura*62.1 - 44.7;
			}
			if(sexo.equals("masculino")){
				peso = altura*72.7 - 58.0;
			}
			outputClient.writeBytes("O seu peso ideal e: " + Double.toString(peso) + '\n');

		} 
	} 
} 
