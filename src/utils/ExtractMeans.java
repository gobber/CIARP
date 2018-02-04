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
		
		String inputPath    = System.getProperty( "inputPath", "/evaluation/Plant_detection_localization/");

		String outputPath   = System.getProperty( "outputPath", "/means/");
		
		String fileName 	= System.getProperty( "fileName", "means");
		
		new ExtractMeans().init( inputPath, outputPath, fileName );
		
	}	
	
	public void init( String inputPath, String outputPath, String fileName ) throws FileNotFoundException {
		
		String root = System.getProperty( "user.dir" );			
		
		root = root.substring( 0, root.indexOf( "/CIARP" ) + 6 );
		
		String csvPath = root + inputPath;
		
		File csvDir = new File( csvPath );
		
		meanToCsv = MeanToCsv.createInstance( new File( root + outputPath + fileName + ".csv" ) );
		
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
				
				String fileName = f.toString().substring( f.toString().lastIndexOf("/") );
				
				int index =  fileName.indexOf("(");
				
				if( index != -1 ) {
					
					fileName = fileName.substring( index );
					
				}
				
				meanToCsv.getInstance().write( fileName.replaceAll("\\D+",""), list[ 1 ] );
				
			}
			
		}		
		
		csvReader.close();
		
	}

}
