import java.io.*; 
import java.net.*; 
import java.util.Scanner;

class TCPClient { 

    public static void main(String argv[]) throws Exception 
	{ 
	    
		String n1,n2,n3;
	    Socket myClient = new Socket("127.0.0.1", 6789); 
	    	
	    Scanner entrada = new Scanner(System.in);
	    DataOutputStream outputServer = new DataOutputStream(myClient.getOutputStream()); 
	    Scanner inputServer = new Scanner(myClient.getInputStream()); 
	    
	    System.out.println("Escreva as 3 notas");
	    n1 = entrada.next();
	    n2 = entrada.next();
	    n3 = entrada.next();
	    
	    outputServer.writeBytes(n1 +' '+ n2 + ' ' + n3 + '\n');

	    System.out.println(inputServer.nextLine()); 
	    myClient.close(); 
	} 
}
	
