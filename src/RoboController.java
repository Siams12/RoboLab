import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
public class RoboController {
	public static void main(String[] args) {
		RoboController RoboController = new RoboController();
		RoboController.go();
	}
	
	public Scanner createScannerFile() { 
		File file = getGraphFileFromUser();
		  Scanner input = null;
		  try {
			  input = new Scanner(file);
		  }
		  catch(FileNotFoundException e) {
			  System.out.println("Could not read the file");
		  }
		  return input;
		}
	
	public File getGraphFileFromUser() {
    	JFileChooser chooser = new JFileChooser();
		 
	    int returnVal = chooser.showOpenDialog(null);
	    
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    
	      File file = chooser.getSelectedFile();
	      return file;
	    }
	    return null;
    }
	
	public RoboModel readGraphFromFile(Scanner input) {
		int numNodes = input.nextInt();
		input.nextLine();
		RoboModel Robot = new RoboModel(numNodes);
		for (int i = 0; i < numNodes; i++) {
			String NextLine = input.nextLine();
			Scanner Scanline = new Scanner(NextLine);
			while (Scanline.hasNextInt()) {
				int Connection = Scanline.nextInt();
				Robot.setConnections(i, Connection);
			}
		}
		return Robot;
	}
	
	public void go() {
	Scanner ScanGraph = createScannerFile();	
	RoboModel Robot = readGraphFromFile(ScanGraph);
		int Length = Robot.graphLength();
		String s = ".";
		for (int i = 0; i < Length; i++) {
			if(Robot.isSolvable(i) != null) {
				s = "s";
	        System.out.println("Cannot get to every node from " + i);		
	}
			
	}
		if (!s .equals("s")) {
			System.out.println("Good Job! Solvable!");
		}
	}
}
