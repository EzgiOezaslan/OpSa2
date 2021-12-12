package Creators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Business.Freizeitbad;

public class ConcreteTxtProduct extends WriterProduct{

    private BufferedWriter aus;

    public ConcreteTxtProduct() {
    	
        try {
            aus = new BufferedWriter(new FileWriter("Freizeitbad.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException {
      
        aus.write( "Daten des Freizeitbades\n");
        aus.write("Name des Freitzeitbads:" + "\t\t\t\t" + ((Freizeitbad) freizeitbad).getName() + "\n");
        aus.write("Oeffnungszeit des Freizeitbads:" + "\t\t" + ((Freizeitbad) freizeitbad).getGeoeffnetVon() + " - " + ((Freizeitbad) freizeitbad).getGeoeffnetBis() + "\n");
        aus.write("Beckenlaenge des Freizeitbads:" + "\t\t" + ((Freizeitbad) freizeitbad).getBeckenlaenge() + "\n");
        aus.write("Wassertemperatur des Freizeitbads:" + "\t" + ((Freizeitbad) freizeitbad).getTemperatur() + "\n");
        
       
        aus.write("\n");
    }

	public void schliesseDatei() throws IOException{
		aus.close();
	}
	

}