package utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class MeanToCsv {
	
private final String SEPARATOR = ",";
	
	private PrintWriter output;
	
	private static MeanToCsv instance;
	
	public static MeanToCsv createInstance( File file ) {
		
		return instance = new MeanToCsv( file );
		
	}
	
	public MeanToCsv getInstance() {	
		
		return instance;
		
	}
	
	private MeanToCsv ( File file ) {
		
		try {
			
			output = new PrintWriter( new FileOutputStream( file ) );
			
		} catch ( FileNotFoundException e ) {
						
			e.printStackTrace();
			
		}	
		
	}
	
	public void write( String testId, String mean ) {
			
		StringBuffer data = new StringBuffer();		
			
		data.append( testId + SEPARATOR + mean );
		
		output.println( data );
		
	}
	
	public void destroy() {
		
		output.close();
		
	}

}
