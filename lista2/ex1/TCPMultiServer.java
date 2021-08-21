import java.io.*;
import java.net.*;
import java.util.Scanner;
// Server class
class TCPMultiServer {
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
        	}catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}