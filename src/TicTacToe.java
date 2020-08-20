/*
 * 
 * 
 * 
 * Hadas Libman
 * May 2020
 * 
 * 
 */
import java.util.Scanner;

public class TicTacToe {
	static String[] board = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
	static String player1;
	static String computer;
	static String turn;
	static boolean win = true;
		
	public static void board() {
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
	}
	
	public static String XorO() {
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to be X or O?");	
		boolean choiceMade = true;
		while(choiceMade) {
			player1 = input.next();
			switch(player1) {
			case "X":
				player1 = "X";
				computer = "O";
				System.out.println("You are X");
				choiceMade = false;
				break;
			case "x":
				player1 = "X";
				computer = "O";
				System.out.println("You are X");
				choiceMade = false;
				break;
			case "O":
				player1 = "O";
				computer = "X";
				System.out.println("You are O");
				choiceMade = false;
				break;
			case "o":
				player1 = "O";
				computer = "X";
				System.out.println("You are O");
				choiceMade = false;
				break;
			default:
				System.out.println("Please enter valid input X or O");
				break;		
			}
		}
		return player1;
	}
	
	public static String firstTurn() {
		int random = (int)Math.round(Math.random());	
		if(random == 0) {
			turn = player1;
			System.out.println("You will go first");
		}
		if(random == 1) {
			turn = computer;
			System.out.println("Computer will go first");
		}
			return turn;
	}
	
	public static void play() {
		Scanner input = new Scanner(System.in);	
		boolean play = true;
		while (play) {
			int decision; 
			if (turn == player1) {
				System.out.println("Enter a slot number");
				board();
				boolean test1 = true;
				while(test1) {
					decision = input.nextInt();
					if (decision < 0 || decision > 9) {
						System.out.println("Please enter a valid choice");
					}
					if (board[decision-1] != " ") {
						System.out.println("Taken slot, please try again");
					}
					else {
						board[decision-1] = player1;
						board();
						test1 = false;
						turn = computer;
						checkWin();
						checkTie();
						if (win == true) {
							turn = computer;
						}
						else {
							play = false;
						}			
					}
				}		
			}
			else if (turn == computer) {
				System.out.println("Computer's turn");	
				boolean test = true;
				while(test) {
					decision = (int)(Math.random()*9);
					if (board[decision] != " ") {
						continue; 
					}
					if(board[decision] == " ") {
						board[decision] = computer;
						board();
						test = false;					
						turn = player1;
						checkWin();
						checkTie();
						if (win == true) {
							turn = player1;
						}
						else {
							play = false;
						}	
					}				
				}			
			}
		}		
	}
	
	public static void checkWin() {
		if(win == true) {
			if (board[0] == "X" && board[1] == "X" && board[2] == "X") {
				System.out.println( "X is winner");
				win = false;
			}
			if (board[3] == "X" && board[4] == "X" && board[5] == "X") {
				System.out.println( "X is winner");
				win = false;
			}
			if (board[6] == "X" && board[7] == "X" && board[8] == "X") {
				System.out.println( "X is winner");
				win = false;
			}
			if (board[0] == "X" && board[3] == "X" && board[6] == "X") {
				System.out.println( "X is winner");
				win = false;
			}
			if (board[1] == "X" && board[4] == "X" && board[7] == "X") {
				System.out.println( "X is winner");
				win = false;
			}
			if (board[2] == "X" && board[5] == "X" && board[8] == "X") {
				System.out.println( "X is winner");
				win = false;
			}
			if (board[0] == "X" && board[4] == "X" && board[8] == "X") {
				System.out.println( "X is winner");
				win = false;
			}
			if (board[2] == "X" && board[4] == "X" && board[6] == "X") {
				System.out.println( "X is winner");
				win = false;
			}
			if (board[0] == "O" && board[1] == "O" && board[2] == "O") {
				System.out.println( "O is winner");
				win = false;
			}
			if (board[3] == "O" && board[4] == "O" && board[5] == "O") {
				System.out.println( "O is winner");
				win = false;
			}
			if (board[6] == "O" && board[7] == "O" && board[8] == "O") {
				System.out.println( "O is winner");
				win = false;
			}
			if (board[0] == "O" && board[3] == "O" && board[6] == "O") {
				System.out.println( "O is winner");
				win = false;
			}
			if (board[1] == "O" && board[4] == "O" && board[7] == "O") {
				System.out.println( "O is winner");
				win = false;
			}
			if (board[2] == "O" && board[5] == "O" && board[8] == "O") {
				System.out.println( "O is winner");
				win = false;
			}
			if (board[0] == "O" && board[4] == "O" && board[8] == "O") {
				System.out.println( "O is winner");
				win = false;
			}
			if (board[2] == "O" && board[4] == "O" && board[6] == "O") {
				System.out.println( "O is winner");
				win = false;
			}
		}			
	}
	
	public static void checkTie() {
		if (win == true) {
			boolean tie = true;
			for(int i = 0; i < 9; i++) {
				if (board[i]== " ") {
					tie = false;
					break;
				}	
			}
			if(tie) {
				System.out.print("There is a Tie");
				win = false;
			}
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to TicTacToe");
		XorO();
		firstTurn(); 
		play();
		
	}

}
