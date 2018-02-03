package filters;


import solution.Solution;

public class MainMSER {

	static int deltaValues [] = {11};
	
	static String dataSets [] = {"Ara2013-RPi", "Ara2012", "Ara2013-Canon"};

	static double distances [] = {100,250,250};
	
	public static void main ( String args[] ) throws Exception {
		
		System.err.println( "Runing (MSER)" );
		
		String root = System.getProperty( "user.dir" );
		
		String dataSetsInputPath = root + "/experiments/Plant_detection_localization/";
		
		for( int delta : deltaValues ) {		
			
			for( int base = 0 ; base < dataSets.length ; base++ ) {
								
				new Solution( Solution.MSER, "/results/MSER/" ).run( root, dataSetsInputPath, dataSets[base] + "/", delta, distances[base] );
			
			}
		
		}		
		
	}

}
