package filters;

import solution.Solution;

public class MainTBMR {
		
	static int tbmrValues [] = {0};

	static String dataSets [] = {"Ara2013-RPi", "Ara2012", "Ara2013-Canon"};

	static double distances [] = {100,250,250};
	
	static int areaFilter = 50;
	
	public static void main ( String args[] ) throws Exception {
		
		System.err.println( "Runing (TBMR)" );
		
		String root = System.getProperty( "user.dir" );
		
		String dataSetsInputPath = root + "/experiments/Plant_detection_localization/";
		
		for( int delta : tbmrValues ) {		
			
			for( int base = 0 ; base < dataSets.length ; base++ ) {
								
				new Solution( Solution.TBMR, "/results/TBMR/" ).run( root, dataSetsInputPath, dataSets[base] + "/", delta, 100, distances[base], areaFilter );
			
			}
			
		}		
		
	}
	
}
