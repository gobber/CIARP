package br.com.gobber.ciarp;

/*
 * 
 * 
 * 	'Ara2012' -> 250
 * 
 * 	'Ara2013-Canon' -> 250
 * 
 * 	'Ara2013-RPi' -> 100
 * 
 * 
 * */

public class MainMumfordShah {	
	
	static int energyValues [] = {5,10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100,105,110,115,120,
								  125,130,135,140,145,150,155,160,165,170,175,180,185,190,195,200,205,210,215,
								  220,225,230,235,240,245,250,255,260,265,270,275,280,285,290,295,300,305, 310, 315, 
    							  320, 325,330,335,340,345,350,355,360,365,370,375,380,385,390,395,400};
	
	static String dataSets [] = {"Ara2013-RPi", "Ara2012", "Ara2013-Canon"};
	
	static double distances [] = {100,250,250};
	
	public static void main ( String args[] ) throws Exception {
		
		String root = System.getProperty( "user.dir" );
		
		String dataSetsInputPath = root + "/experiments/Plant_detection_localization/";
		
		for( int e : energyValues ) {		
			
			for( int base = 0 ; base < dataSets.length ; base++ ) {
								
				new Solution( Solution.MUMFORD_SHAH, "MumfordShah" ).run( root, dataSetsInputPath, dataSets[base] + "/", e, distances[base] );
			
			}
		
		}		
		
	}
	
	/* main para chamar via terminal ( corrigir ) */
	
	public static void main2( String args[] ) throws Exception {
		
		if( args.length != 3 ) {
			
			System.out.println( "Número de parametros incorreto !" );
			
		} else {	
		
			String root = System.getProperty( "user.dir" );
		
			String dataSetsInputPath = root + "/experiments/Plant_detection_localization/";		
		
			/*String dataSet = "Ara2012/";
		
			int energy = 200;
		
			double distance = 250;*/
			
			String dataSet = args[ 0 ];
			
			int energy = Integer.valueOf( args[ 1 ] );
		
			double distance = Double.valueOf( args[ 2 ] );
			
			if( args[ 0 ].equals( "all" ) ){
		
				//new Main( Main.MUMFORD_SHAH, "MumfordShah" ).runAll( root, dataSetsInputPath, energy, distance );	
			
			} else {
				
				new Solution( Solution.MUMFORD_SHAH, "MumfordShah" ).run( root, dataSetsInputPath, dataSet + "/", energy, distance );
				
			}
		
		}
		
	}

}
