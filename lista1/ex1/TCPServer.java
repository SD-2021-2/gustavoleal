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

			String nome,cargo;
			double salario;

			nome = inputClient.next();
			cargo = inputClient.next();
			salario = Double.parseDouble(inputClient.next());

			if(cargo.equals("operador")){
				salario = salario + salario*0.2;
			}
			if(cargo.equals("programador")){
				salario = salario + salario*0.18;
			}

			outputClient.writeBytes(Double.toString(salario) + '\n'); 
		} 
	} 
} 
