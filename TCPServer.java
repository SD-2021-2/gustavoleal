import java.io.*; 
import java.net.*; 

class TCPServer { 

	public static void main(String argv[]) throws Exception 
	{ 

		String text;
		ServerSocket myServer = new ServerSocket(6789); 
		while(true) { 

			Socket conectSocket = myServer.accept(); 

			BufferedReader inputClient = new BufferedReader(new InputStreamReader(conectSocket.getInputStream()));
			DataOutputStream  outputClient = new DataOutputStream(conectSocket.getOutputStream()); 

			text = inputClient.readLine(); 
			System.out.println("Mensagem = " + text);
			
			text = "recebido!!";
			outputClient.writeBytes(text + '\n'); 
		} 
	} 
} 
