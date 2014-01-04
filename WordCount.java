import java.io.*;
class WordCount{
	public static void main(String[] args) {
	MyFile myFile = new MyFile();
	Count count = new Count();

    String input = myFile.readTextFile(args[0]);
    int noOfLines = count.lineCount(input);

    System.out.println(noOfLines +" "+ args[0]);
	}
}
class MyFile {
  public String readTextFile(String fileName) {
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
    catch (IOException e) {
		throw new RuntimeException("IO Error occured");
    } 
    return returnValue;
  }
}
class Count{
	public int lineCount(String text) {
		int count = 0;
		String[] line = text.split("\n");
		return line.length;
	}
}