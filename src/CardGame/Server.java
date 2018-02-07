package CardGame;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends Thread {
    
    
private static Integer port = 1337;

	private static Double versionNumber = 1.0;

	private static String welcomeMsg = "--- Welcome to Top Trumps Server V. " + versionNumber + " --- \n";

	private static boolean validPort(Integer x) {
		return x >= 1 && x <= 65535 ? true : false;
	}
        
        public static void main(String args[]) throws Exception {
        Server server = new Server();
        server.run();
        
        }
        
        private static int getPort() {

		Integer input;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Please select a port by entering an integer value between 1 and 65535 or\n");
			System.out.print("insert \"0\" in order to continue with the default setting (" + Server.port + "): ");
			input = sc.nextInt();

		} while (input != 0 && !Server.validPort(input));

		sc.close();

		return input == 0 ? Server.port : input;
	}

        
         public void run() {
             
            try {
               // getPort();
                
                String resClient_1 = "";
                String resClient_2 = "";
                String inputClient_1;
                String inputClient_2;
                
                // Print welcome msg
                System.out.println(Server.welcomeMsg);
                
                // Set port
                Server.port = Server.getPort();
                
                // Create new server socket & dump out a status msg
                ServerSocket welcomeSocket = new ServerSocket(Server.port);
                System.out.println("\nOk, we're up and running on port " + welcomeSocket.getLocalPort() + " ...");
                
                while (!welcomeSocket.isClosed()) {
                    
                    // Player one
                    Socket client_1 = welcomeSocket.accept();
                    if (client_1.isConnected()) {
                        System.out.println("\nPlayer one (" + (client_1.getLocalAddress().toString()).substring(1) + ":"
                                + client_1.getLocalPort() + ") has joined ... waiting for player two ...");
                    }
                    DataOutputStream outClient_1 = new DataOutputStream(client_1.getOutputStream());
                    BufferedReader inClient_1 = new BufferedReader(new InputStreamReader(client_1.getInputStream()));
                    
                    // Player two
                    Socket client_2 = welcomeSocket.accept();
                    if (client_2.isConnected()) {
                        System.out.println("Player two (" + (client_2.getLocalAddress().toString()).substring(1) + ":"
                                + client_1.getLocalPort() + ") has joined ... lets start ...");
                    }
                    DataOutputStream outClient_2 = new DataOutputStream(client_2.getOutputStream());
                    BufferedReader inClient_2 = new BufferedReader(new InputStreamReader(client_2.getInputStream()));
                    
                    // Get client inputs
                    inputClient_1 = inClient_1.readLine();
                    inputClient_2 = inClient_2.readLine();
                    
                    
                    if (inputClient_1.equals(inputClient_2)) {
                        resClient_1 = "Your In a Game";
                        resClient_2 = "Your In a Game";
                        System.out.println("P1 and P2 in a game");
                    }
                    
                    else if (inputClient_1.equals("UFC") && inputClient_2.equals("CAR")) {
                        resClient_1 = "Player 2 wants to play Car pack";
                        resClient_2 = "Player 1 wants to play UFC pack";
                        System.out.println("Players choosing pack");
                        
                        
                        // Send responses in uppercase and close sockets
                        outClient_1.writeBytes(resClient_1.toUpperCase());
                        outClient_2.writeBytes(resClient_2.toUpperCase());
                        client_1.close();
                        client_2.close();
                        
                        System.out.println("\nWaiting for new players ...\n");
                        
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
		
         }
}
