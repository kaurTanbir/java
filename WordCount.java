import java.io.*;
class WordCount{
	public static void main(String[] args) throws IOException {
	MyFile myFile = new MyFile();
	Count count = new Count();

    String input = myFile.readFile(args[0]);

    int noOfLines = count.lineCount(input);
    int noOfCharacter = count.charCount(input);
    int noOfWords = count.wordCount(input);

    System.out.println(noOfLines +" "+noOfWords+" "+noOfCharacter+" "+ args[0]);
	}
}

class MyFile {
  public String readFile(String fileName) throws IOException{
    String returnValue = "";
    FileReader file = null;
    String line = "";
    try {
		file = new FileReader(fileName);
		BufferedReader reader = new BufferedReader(file);
		while ((line = reader.readLine()) != null) {
			returnValue += line + "\n";
		}
    } 
    catch (FileNotFoundException e) {
		throw new RuntimeException("File not found");
    } 
    return returnValue;
  }
}

class Count{
	public int lineCount(String text) {
		int count = 0;
		String[] lines = text.split("\n");
		return lines.length;
	}
	
	public int wordCount(String text) {
		int count = 0;
		String[] words = text.split("\\s");
		return words.length;
	}

	public int charCount(String text) {
		int count = 0;
		String[] characters = text.split("");
		return characters.length;
	}
}