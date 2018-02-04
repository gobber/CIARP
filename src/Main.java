import mmlib4j.utils.Utils;
import solution.Solution;


public class Main {	
	
	public static void main( String args [] ) throws Exception {
		
		// Parameters
				
		String distances []    = System.getProperty( "distances", "Ara2012:250,Ara2013-Canon:250,Ara2013-RPi:100" ).split(",");		
		String datasets []	   = System.getProperty( "datasets", "Ara2012,Ara2013-Canon,Ara2013-RPi" ).split(",");
		String saveImageResult = System.getProperty( "saveImageResult", "false" );
		String saveImageBounds = System.getProperty( "saveImageBounds", "false" );
		String debug 		   = System.getProperty( "debug", "true" );
		String inputPath 	   = System.getProperty( "inputPath", "/experiments/Plant_detection_localization/");
		String saveResultsPath = System.getProperty( "saveResultsPath", "/results/MumfordShah/" );
		
		String energyFilter[]  	  = System.getProperty( "energyFilterArray", "190" ).split(",");
		double rgbFilter 	   	  = Double.parseDouble( System.getProperty( "rgbFilter", "100" ) );
		int areaFilter            = Integer.parseInt( System.getProperty( "areaFilter", "50" ) );
		
		// Debug mode
		
		if( debug.equals( "false" ) ) {
			
			Utils.debug = false;
			
		}
		
		// Bases -> 0 = Ara2012, 1 = Ara2013-Canon, 2 = Ara2013-RPi 
		
		int dist [] = {-1,-1,-1};
		
		// Convert distances in int values
			
		for( int i = 0 ; i < distances.length ; i++ ) {								
				
			String base = distances[ i ];
				
			if( base.indexOf( "Ara2012" ) != -1 ) {					
					
				dist[ 0 ] = Integer.parseInt( base.substring( 8, base.length() ) );									
					
			} else if( base.indexOf( "Ara2013-Canon" ) != -1 ) {
					
				dist[ 1 ] = Integer.parseInt( base.substring( 14, base.length() ) );
					
			} else if( base.indexOf( "Ara2013-RPi" ) != -1  ) {
					
				dist[ 2 ] = Integer.parseInt( base.substring( 12, base.length() ) );
					
			}
			
		}
		
		// Compute for datasets selecteds
		
		System.err.println( "Running..." );
		
		String root = System.getProperty( "user.dir" );
		
		root = root.substring( 0, root.indexOf( "/CIARP" ) + 6 );
		
		String dataSetsInputPath = root + inputPath;
		
		for( String e : energyFilter ) {
		
			for( int base = 0 ; base < datasets.length ; base++ ) {
			
				int dSet = -1;			
			
				switch ( datasets[ base ] ) {
			
					case "Ara2012":
						dSet = ( dist[ 0 ] == -1 ? 250 : dist[ 0 ] );
						break;
				
					case "Ara2013-Canon":
						dSet = ( dist[ 1 ] == -1 ? 250 : dist[ 1 ] );
						break;
					
					case "Ara2013-RPi":
						dSet = ( dist[ 2 ] == -1 ? 100 : dist[ 2 ] );
						break;
					
				}
			
				if( dSet != -1 ) {
				
					Solution solution = new Solution( Solution.MUMFORD_SHAH, saveResultsPath );
				
					if( saveImageBounds.equals( "true" ) ) {
					
						solution.setSaveImageBounds( true );
					
					}
				
					if( saveImageResult.equals( "true" ) ) {
					
						solution.setSaveImageResult( true );
					
					}
				
					solution.run( root, dataSetsInputPath, datasets[ base ] + "/", Integer.parseInt( e ), rgbFilter, dSet, areaFilter );								
				
				}
			
			}
		
		}
		
		System.err.println( "Finished" );
		
	}

}
