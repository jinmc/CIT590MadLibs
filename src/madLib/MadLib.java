/**Jinmo chong's code
 */
package madLib;

import java.util.*;

import javax.swing.*;

import java.io.*;

public class MadLib {

	static ArrayList<String> text = new ArrayList<String>();
	ArrayList<String> words = new ArrayList<String>();
	String word;
	Scanner in;

	public void readFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Please choose a Mad libs file");
		int result = chooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			chooser.setCurrentDirectory(null);
			System.out.println("Selected file: " + file.getAbsolutePath());
//			File file = new File("story.txt"); 	// this is for when jfilechooser doesn't work
			if (file.exists()) {
				if (file != null) {
					try {
						String filename = file.getCanonicalPath();
						FileReader fr = new FileReader(filename);
						BufferedReader br = new BufferedReader(fr);
						String line = br.readLine();
						while (line != null) {
							text.add(line);
							line = br.readLine();
						}
						br.close();
					} catch (FileNotFoundException e) {
						System.out.println("FileNotFoundException has occured");
					} catch (IOException e) {
						System.out.println("IOException has occured");
						;
					} catch (Exception e) {
						System.out.println("Exception has occured");
						;
					}
				}
			}
		}
	}
	
	
	public void ask() {

		in = new Scanner(System.in);
		if (check()) {
			System.out.print("please enter an " + word + " : ");
		} else {
			System.out.print("please enter a " + word + " : ");
		}
		String input = in.nextLine();
		while (input.length() == 0) {
			if (check()) {
				System.out.print("please enter an " + word + " : ");
			} else {
				System.out.print("please enter a " + word + " : ");
			}
			input = in.nextLine();
		}
		word = input;

	}

	public boolean check() {
		String vowels = "aeiouAEIOU";
		if (vowels.contains(word.substring(0, 1))) {
			return true;
		} else {
			return false;
		}
	}
	
	public void play() {
		int n = text.size();
		for (int i = 0; i < n; i++) {
			while (text.get(i).contains("[")) {
				int start = text.get(i).indexOf("[");
				int end = text.get(i).indexOf("]");
				word = text.get(i).substring(start + 1, end);
				ask();
				text.set(i, text.get(i).substring(0, start) + word + text.get(i).substring(end + 1, text.get(i).length()));
			}
		}
		in.close();
	}

	public static void main(String[] args) {
		MadLib ml = new MadLib();
		ml.readFile();
		ml.play();
		for (int i = 0; i < text.size(); i++) {
			System.out.println(text.get(i));
		}
	}
}
