package Server;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class clientFile {
	File file;
	String lastUser;
	String dateEdited;
	String text;
	
	public clientFile(File _file) {
		file = _file;
		getData();
	}
	
	private void setUser() {
		
	}

	public String getName() {
		return file.getName();
	}
	
	public String getText() {
		return text;
	}
	
	public String getDate() {
		return dateEdited;
	}
	
	public String getUser() {
		return lastUser;
	}
	
	public String toString() {
		return text + "/:/" + lastUser + "/:/" + dateEdited;
		
	}
	
	public String getData() {
		String data = null;
		String lineSeparator = System.getProperty("line.separator");
		StringBuilder fileContents = new StringBuilder((int)file.length());
		try {
			Scanner scan = new Scanner(file);
			   try {
			        while(scan.hasNextLine()) {
			            fileContents.append(scan.nextLine() + lineSeparator);
			        }
			        StringTokenizer st = new StringTokenizer(fileContents.toString(),"/:/");
			        text = st.nextToken();
			        lastUser = st.nextToken();
			        dateEdited = st.nextToken();
//			        return fileContents.toString();
			    } finally {
			        scan.close();
			    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}

}
