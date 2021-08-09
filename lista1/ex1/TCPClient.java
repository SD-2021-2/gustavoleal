import java.io.*; 
import java.net.*; 
import java.util.Scanner;
class TCPClient { 

    public static void main(String argv[]) throws Exception 
	{ 
	    
		String nome,cargo,salario;
	    Socket myClient = new Socket("127.0.0.1", 6789); 
	    	
	    Scanner entrada = new Scanner(System.in);
	    DataOutputStream outputServer = new DataOutputStream(myClient.getOutputStream()); 
	    Scanner inputServer = new Scanner(myClient.getInputStream()); 
	    
	    System.out.println("Escreva o nome cargo e salario separados por espaco");
	    nome = entrada.next();
	    cargo = entrada.next();
	    salario = entrada.next();
	    outputServer.writeBytes(nome +' '+ cargo + ' ' + salario + '\n');

	    salario = inputServer.next();
	    System.out.println(nome + ' ' + salario); 
	    myClient.close(); 
	} 
}
