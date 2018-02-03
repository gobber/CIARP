package filters;

import solution.Solution;

/*
 * 
 * 
 * 	'Ara2012' -> 250
 * 
 * 	'Ara2013-Canon' -> 250
 * 
 * 	'Ara2013-RPi' -> 100
 * 
 * 	'Energy' -> 190
 * 
 * 
 * */

public class MainMumfordShah {	
	
	static int energyValues [] = {190};
	
	static String dataSets [] = {"Ara2013-RPi", "Ara2012", "Ara2013-Canon"};
	
	static double distances [] = {100,250,250};
	
	public static void main ( String args[] ) throws Exception {
		
		System.err.println( "Runing (Mumford-Shah)" );
		
		String root = System.getProperty( "user.dir" );
		
		String dataSetsInputPath = root + "/experiments/Plant_detection_localization/";
		
		for( int e : energyValues ) {		
			
			for( int base = 0 ; base < dataSets.length ; base++ ) {
								
				new Solution( Solution.MUMFORD_SHAH, "/results/MumfordShah2/" ).run( root, dataSetsInputPath, dataSets[base] + "/", e, distances[base] );
			
			}
		
		}		
		
	}

}
