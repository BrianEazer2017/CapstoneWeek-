import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		}
	public static void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a word or a sentence but no numbers or special characters(punctuation is fine and appreciated but no parentheses and no consecutive punctuation marks haha lol):");
		if (sc.hasNextDouble()) {
			System.out.println("Oops. No numbers.");
			input();
		}
		String s = sc.nextLine();
		if (validate(s)) {
			String[] arr = s.split(" ");
			for (int i = 0; i < arr.length; i++) {
			makePigLatin(arr[i]);
			}
			System.out.println("");
			askToContinue();
		} else {
			System.out.println("No special characters, please");
			input();
		}
	}
	public static boolean validate(String s) {
		boolean answer = true;
		for (int i = 0; i < s.length(); i++) {
			if ("[@#$%^&*\":{}|<>]".indexOf(s.charAt(i)) >= 0) {
				answer = false;
			}
		}
		return answer;
	}
	public static void makePigLatin(String s) {
		String answer = "";
		for (int i = 0; i < s.length(); i++) {
			if ("aeiouAEIOU".indexOf(s.charAt(0)) != -1) {
				answer = s + "way";
				break;
			}
			if ("aeiouAEIOU".indexOf(s.charAt(i)) != -1) {
				if (s.substring(0,1).equals(s.substring(0,1).toUpperCase())) {
					answer = s.substring(i, i+1).toUpperCase() + s.substring(i+1) + s.substring(0, i).toLowerCase() + "ay";
				}
				else {
				answer = s.substring(i) + s.substring(0, i) + "ay";
				}
				break;
			}
			else {
				answer = s;
			}
		}
		
		//this for loop is to check punctuation and put it in it's proper spot
		for (int i = 0; i < answer.length(); i++) {
			if (".,?!".indexOf(answer.charAt(i)) >= 0) {
				String finalAnswer = answer.substring(0, i) + answer.substring(i+1, answer.length()) + answer.substring(i, i+1);
				System.out.print(finalAnswer + " ");
				return;
			}
		}
		System.out.print(answer + " ");
	}
	private static void askToContinue() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String answer = "y";
		System.out.println("Would you like to continue? y/n");
		if (sc.hasNext()) {
			answer = sc.nextLine();
		}
		else {
			System.out.println("Try that again....");
		}
		if (answer.equals("y")) {
			System.out.println("OK here we go again!");
			input();
		}
		else if (answer.equals("n")) {
			System.out.println("It was fun while it lasted");
		}
		else {
			System.out.println("Uh...What was that again?");
			askToContinue();
		}
	}
}
