import java.io.*; 
import java.net.*; 
import java.util.Scanner;
class User { 

    public static void main(String argv[]) throws Exception 
	{ 
	    
		String nome,salario;
	    Socket myClient = new Socket("127.0.0.1", 6789); 
	    	
	    Scanner entrada = new Scanner(System.in);
	    DataOutputStream outputServer = new DataOutputStream(myClient.getOutputStream()); 
	    Scanner inputServer = new Scanner(myClient.getInputStream()); 
	    
	    System.out.println("Escreva o seu nome");
	    nome = entrada.next();
	    outputServer.writeBytes(nome  + '\n');

	    System.out.println(inputServer.nextLine()); 
	    myClient.close(); 
	} 
}
