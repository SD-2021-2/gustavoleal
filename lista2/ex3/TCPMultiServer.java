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

                int n1,n2,n3;

                n1 = Integer.parseInt(inputClient.next());
                n2 = Integer.parseInt(inputClient.next());
                n3 = Integer.parseInt(inputClient.next());

                if((n1+n2>=14) || (n1+n2>=6 && (n1+n2+2*n3>=20))){
                    outputClient.writeBytes("Aprovado\n"); 
                }else
                {
                    outputClient.writeBytes("Reprovado\n"); 
                }
        	}catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}