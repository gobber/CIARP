package utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;


public class ExtractMeans {		
	
	private static final String COMMA_DELIMITER = ",";	
	
	private MeanToCsv meanToCsv;
		
	public static void main( String args [] ) throws FileNotFoundException {
				
		new ExtractMeans().init();
		
	}	
	
	public void init() throws FileNotFoundException {
		
		String root = System.getProperty( "user.dir" );
		
		String csvPath = root + "/evaluation/Plant_detection_localization (ciarp)/";
		
		File csvDir = new File( csvPath );
		
		meanToCsv = MeanToCsv.createInstance( new File( System.getProperty( "user.dir" ) + "/means/means.csv" ) );
		
		for( File f : csvDir.listFiles() ) {
			
			if( f.getName().endsWith( "_all_results.csv" ) ) {				
				
				run( f );
				
			}
			
		}		
		
		meanToCsv.getInstance().destroy();
		
		System.out.println("Extracted!");
		
	}
	
	private void run( File f ) throws FileNotFoundException {
		
		Scanner csvReader = new Scanner( new FileReader( f ) ); 
		
		csvReader.useDelimiter( COMMA_DELIMITER );
		
		csvReader.useLocale( Locale.US );			
		
		while( csvReader.hasNext() ) {				
			
			String line = csvReader.nextLine(); 
			
			if( line.startsWith("mean") ) {		
				
				String list [] = line.split(",");	
				
				String temp = f.toString().substring( f.toString().lastIndexOf("/") + 8 ).replaceAll("\\D+","");
				
				meanToCsv.getInstance().write( temp.substring(1), list[ 1 ] );
				
			}
			
		}		
		
		csvReader.close();
		
	}

}
