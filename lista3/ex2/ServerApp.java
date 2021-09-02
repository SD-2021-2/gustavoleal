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

                String nome,sexo;
                int idade;

                Socket myClient = new Socket("127.0.0.1", 6798); 
            
                DataOutputStream outputServer = new DataOutputStream(myClient.getOutputStream()); 
                Scanner inputServer = new Scanner(myClient.getInputStream()); 
        
                DataOutputStream  outputClient = new DataOutputStream(conectSocket.getOutputStream()); 
                Scanner inputClient = new Scanner(conectSocket.getInputStream());
                
                nome = inputClient.next();
                outputServer.writeBytes(nome  + '\n');

                sexo = inputServer.next();
                idade = Integer.parseInt(inputServer.next());


                if((sexo.equals("feminino") && idade>=21) || (sexo.equals("masculino") && idade>=18)){
                    outputClient.writeBytes(nome + " ja atingiu a maioridade\n"); 
                }else
                {
                    outputClient.writeBytes(nome + " nao atingiu a maioridade\n"); 
                } 
        	}catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
