import java.util.*;

public class GameView {
	
	Scanner scan;

	Explorer explorer;

	public GameView() {
		scan = new Scanner(System.in);

		explorer = new Explorer();
	}
	public void run() {
		System.out.print("Welcome to the Explorer's Game! \n\n");
		System.out.print("Please enter your name: ");
			explorer.setName(scan.nextLine());
		System.out.println("\n");
		System.out.print("Please enter a username: ");
			explorer.setUsername(scan.next());
		System.out.println("\n\n");

		System.out.println("Hello " + explorer.getName());
		System.out.println("Welcome to the Explorer's Game. Where you are tasked with" + "\n"
							 + "collecting treasure and making it to the final room. The" + "\n"
							 + "explorer with the highest value of treasures wins the game." + "\n"
							 + "The game ends when all explorers make it to the final room.");

	}
}