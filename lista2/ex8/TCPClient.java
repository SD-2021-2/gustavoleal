import java.io.*; 
import java.net.*; 
import java.util.Scanner;
class TCPClient { 

    public static void main(String argv[]) throws Exception 
	{ 
	    
		String saldo;
	    Socket myClient = new Socket("127.0.0.1", 6789); 
	    	
	    Scanner entrada = new Scanner(System.in);
	    DataOutputStream outputServer = new DataOutputStream(myClient.getOutputStream()); 
	    Scanner inputServer = new Scanner(myClient.getInputStream()); 
	    
	    System.out.println("Escreva o seu saldo medio");
	    saldo = entrada.next();
	    outputServer.writeBytes(saldo + '\n');

	    System.out.println(inputServer.nextLine()); 
	    myClient.close(); 
	} 
}
	
