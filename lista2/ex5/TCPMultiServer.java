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

                int idade;
                String categoria = "";

                idade = Integer.parseInt(inputClient.next());
                if(idade>=5 && idade<=10)
                {
                    categoria = "infatil";
                    if(idade>=8)
                        categoria = categoria + " B";
                    else
                        categoria = categoria + " A";
                }else if(idade>=11 && idade<=17)
                {
                    categoria = "juvenil";
                    if(idade>=14)
                        categoria = categoria + " B";
                    else
                        categoria = categoria + " A";
                }else if(idade>=18)
                {
                    categoria = "adulto";
                }
                outputClient.writeBytes("A sua Categoria e: " + categoria + '\n');
        	}catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}