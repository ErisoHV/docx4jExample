package docx4jExample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.io3.Save;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.ContentInfoUtil;

public class GenerateDocuments {

	private final static String FORMAT = ".docx";
	private final static String MIME_TYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
	
	static Logger log = Logger.getLogger(GenerateDocuments.class.getName());
	
	public static String getMimeType (File file){
        ContentInfo info;
		try {
			info = (new ContentInfoUtil()).findMatch(file);
			if (info != null)
				return info.getMimeType();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return null;
    }
	
	public static boolean generateDocument(File template, HashMap<String, String> replace, 
			String outputDocument){
		if (template != null && replace != null && replace.size()>0 
			 && outputDocument != null && !outputDocument.isEmpty()){
			if (template.exists()){
				if (!outputDocument.endsWith(FORMAT)){
					log.warn("The output document must be .docx");
					return false;
				}			
				//1. Check file extension with simplemagic
				String mimeType = getMimeType(template);
				if (mimeType != null && mimeType.equals(MIME_TYPE)){
					WordprocessingMLPackage wordMLPackage;
						try {
							//2. Load template
							wordMLPackage = WordprocessingMLPackage.load(template);
							MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
							
							//3. Replace placeholders
							VariablePrepare.prepare(wordMLPackage);
							documentPart.variableReplace(replace);
							
							//4. output docx
							OutputStream output = new FileOutputStream(outputDocument);
							Save saver = new Save(wordMLPackage);
							if (saver.save(output)){
								log.info("Document " + outputDocument + " ok");
								return true;
							}
						} catch (Docx4JException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else{
						log.error("Invalid document mime type");
					}
			}
		}
		return false;
	}

}
