import java.io.*; 
import java.net.*; 
import java.util.Scanner;
class TCPClient { 

    public static void main(String argv[]) throws Exception 
	{ 
	    
		String idade;
	    Socket myClient = new Socket("127.0.0.1", 6789); 
	    	
	    Scanner entrada = new Scanner(System.in);
	    DataOutputStream outputServer = new DataOutputStream(myClient.getOutputStream()); 
	    Scanner inputServer = new Scanner(myClient.getInputStream()); 
	    
	    System.out.println("Escreva a sua idade");
	    idade = entrada.next();
	    outputServer.writeBytes(idade + '\n');

	    System.out.println(inputServer.nextLine()); 
	    myClient.close(); 
	} 
}
	
