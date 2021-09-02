import java.io.*; 
import java.net.*; 
import java.util.Scanner;
class ServerApp { 

    public static void main(String[] args)throws Exception 
    {
        ServerSocket server = null;
  
        server = new ServerSocket(6789);
        server.setReuseAddress(true);

        while (true) {

            Socket client = server.accept();

            NewClient conectSocket
                = new NewClient(client);

            new Thread(conectSocket).start();
        }
             
    }
  
    // ClientHandler class
    private static class NewClient implements Runnable {
        private final Socket conectSocket;
  
        // Constructor
        public NewClient(Socket socket)
        {
            this.conectSocket = socket;
        }
  
        public void run()
        {
        	try
        	{

                String nome,cargo;
	    		Double salario;

	    		Socket myClient = new Socket("127.0.0.1", 6798); 
	    	
			    DataOutputStream outputServer = new DataOutputStream(myClient.getOutputStream()); 
			    Scanner inputServer = new Scanner(myClient.getInputStream()); 
	    
                DataOutputStream  outputClient = new DataOutputStream(conectSocket.getOutputStream()); 
	        	Scanner inputClient = new Scanner(conectSocket.getInputStream());
			    
			    nome = inputClient.next();
			    outputServer.writeBytes(nome  + '\n');

                cargo = inputServer.next();
                salario = Double.parseDouble(inputServer.next());

                if(cargo.equals("operador")){
                    salario = salario + salario*0.2;
                }
                if(cargo.equals("programador")){
                    salario = salario + salario*0.18;
                }

                outputClient.writeBytes(Double.toString(salario) + '\n');  
        	}catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
