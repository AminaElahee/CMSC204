import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	
	//private static MorseCodeTree<String> morseCode=new MorseCodeTree<String>;
	
	private static MorseCodeTree morseCode=new MorseCodeTree();
	
	public  MorseCodeConverter()
	{
		
	}
	
	public static String printTree()
	{
		ArrayList<String> list = morseCode.toArrayList();
		return String.join(" ", list);
	}
	
	
	public static String convertToEnglish(String code)
	{
		StringBuilder convert = new StringBuilder();
		
		String[] words = code.trim().split("/");

		for (int i = 0; i < words.length; i++) 
		{
			String[] chars = words[i].split(" ");
			
			for (String c : chars) 
			{
				convert.append(morseCode.fetch(c));
			}
			
			
			if (i < words.length - 1)
			{
				convert.append(" ");
			}
		}
		return convert.toString();
	}
	
	public static String convertToEnglish(File code) throws FileNotFoundException
	{
		Scanner s = new Scanner(code);
		
		StringBuilder morseCode = new StringBuilder();
		
		while (s.hasNextLine()) 
		{
			morseCode.append(s.nextLine());
		}
		
		
		s.close();

		return convertToEnglish(morseCode.toString());
	}
	

}
