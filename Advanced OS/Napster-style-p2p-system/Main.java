import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * @author Vaishnavi Manjunath
 */

public class GroupOneMain {
	public static void main(String args[]) throws Exception{

		System.out.println("Welcome to Napster Style Peer to Peer File Sharing System :");
		System.out.println("Please enter your Choice ::");
		System.out.println("1. To run the Server");
		System.out.println("2. To run the Peer");
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int choice = Integer.parseInt(br.readLine());
		
		if(choice == 1){		
			GroupOneServer s = new GroupOneServer();
		}
		else if(choice == 2){
			GroupOneClient c = new GroupOneClient();
		}
		else{
			System.out.println("Your choice is incorrect");
		}
	}
}
