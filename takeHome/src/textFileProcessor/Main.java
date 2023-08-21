package textFileProcessor;

public class Main {

	public static void main(String[] args) throws InvalidUndoOperationException{
		TextFileProcessor p = new TextFileProcessor("myText.txt", "command.txt");
		p.execute();
	}

}
