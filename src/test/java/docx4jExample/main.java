package docx4jExample;

import java.io.File;
import java.util.HashMap;

public class main {

	public static void main(final String[] args) {
		
		//Try with test/test.txt
		File template= new File("test/TestTemplate.docx");
		String var = "MyName";
		String outputDocument = "test/OutputTest.docx";
		
		HashMap<String, String> parameters = new HashMap<String,String>();
		parameters.put("Name", var);
		parameters.put("Name.upper", var.toUpperCase());
		
		GenerateDocuments.generateDocument(template, parameters, outputDocument);

	}

}
