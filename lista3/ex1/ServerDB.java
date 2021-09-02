import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
// Server class
class ServerDB {
    static Map<String,String> cargo = new HashMap<String,String>(){{
        put("jose", "operador");
        put("maria", "programador");
    }};
    static Map<String,Double> salario = new HashMap<String,Double>(){{
        put("jose", 1300.0);
        put("maria", 2000.0);
    }};

    public static void main(String[] args)throws Exception 
    {
        ServerSocket server = null;
  
        server = new ServerSocket(6798);
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

                String nome;

                nome = inputClient.next();

                outputClient.writeBytes(cargo.get(nome) +' '+ Double.toString(salario.get(nome)) + '\n');  
        	}catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}