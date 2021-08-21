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

                String sexo;
                double altura;

                sexo = inputClient.next();
                altura = Double.parseDouble(inputClient.next());
                double peso = 0;
                if(sexo.equals("feminino")){
                    peso = altura*62.1 - 44.7;
                }
                if(sexo.equals("masculino")){
                    peso = altura*72.7 - 58.0;
                }
                outputClient.writeBytes("O seu peso ideal e: " + Double.toString(peso) + '\n');
        	}catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}