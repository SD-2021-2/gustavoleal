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
	        	String text;
                Double saldo,credito;
	            Scanner inputClient = new Scanner(conectSocket.getInputStream());
				DataOutputStream  outputClient = new DataOutputStream(conectSocket.getOutputStream()); 

				saldo = Double.parseDouble(inputClient.next());
                if(saldo <= 200)
                    credito = 0.0;
                else if(saldo <= 400)
                    credito = saldo*0.2;
                else if(saldo <= 600)
                    credito = saldo*0.3;
                else
                    credito = saldo*0.4;
				outputClient.writeBytes("Seu Credito e : "+ credito + '\n'); 
        	}catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}