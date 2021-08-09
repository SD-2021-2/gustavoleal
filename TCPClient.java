import java.io.*; 
import java.net.*; 

class TCPClient { 

    public static void main(String argv[]) throws Exception 
	{ 
	    
		String text;
	    Socket myClient = new Socket("127.0.0.1", 6789); 
	    	
	    BufferedReader inputSTD = new BufferedReader(new InputStreamReader(System.in)); 
	    DataOutputStream outputServer = new DataOutputStream(myClient.getOutputStream()); 
	    BufferedReader inputServer = new BufferedReader(new InputStreamReader(myClient.getInputStream())); 
	    
	    text = inputSTD.readLine();
	    outputServer.writeBytes(text + '\n'); 
	    
	    System.out.println("enviado");

	    text = inputServer.readLine();
	    System.out.println("Retorno: " + text); 
	    
	    myClient.close(); 
	} 
}
