/**
 * The client class creates a connection to the server at default port 1337.
 * Waits for the user to input a single character with the keyboard. The
 * character has to be ’R’ (rock), ’P’ (paper) or ’S’ (scissors). Sends the
 * character to the server via the TCP protocol. Waits for a reply from the
 * Server. Prints the message received from the Server. Closes the connection.
 *
 * @author Mathias Schilling <https://github.com/pinkbigmacmedia>
 * @version 1.0
 * 
 */

package CardGame;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {

    private static Double versionNumber = 1.0;

    /**
     * A short welcome msg
     * 
     * @var string
     */
    private static String msgWelcome = "--- Welcome to Top Trumps "
	    + versionNumber + " --- \n";

    /**
     * The help context
     * 
     * @var string
     * 
     */
    private static String msgRules = "Pick A Category, Pick A Card, Higher Value wins";
    public static void main(String args[]) throws Exception {
        
        
        System.out.println("Enter Host IP");
        Scanner scan = new Scanner(System.in); 
        
        String host = scan.next();
        
        System.out.println("Port");
        Scanner scan2 = new Scanner(System.in); 
        
        int port = scan.nextInt();
        
	String input = "";
	String response;

	System.out.println(Client.msgWelcome);

	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
		System.in));
        
        
        Socket clientSocket = new Socket(host, port);
	DataOutputStream outToServer = new DataOutputStream(
		clientSocket.getOutputStream());
	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
		clientSocket.getInputStream()));
        

	do {

	    if (input.equals("-rules")) {
		System.out.println(Client.msgRules);
	    }

	    // Prompt user for select rock, paper or scissors ...
	    System.out
		    .println("Start the game by selecting which pack UFC pack, Car pack, Monster pack");
	    System.out.print("or type \"-rules\" in order to see the rules: ");
	    input = inFromUser.readLine();

	} while (!input.equals("UFC") && !input.equals("CAR") && !input.equals("Monster"));

	// Transmit input to the server and provide some feedback for the user
	outToServer.writeBytes(input + "\n");
	System.out
		.println("\nYour input ("
			+ input
			+ ") was successfully transmitted to the server. Now just be patient and wait for the result ...");

	// Catch respones
	response = inFromServer.readLine();

	// Display respones
	System.out.println("Response from server: " + response);

	// Close socket
	clientSocket.close();

    }
}
