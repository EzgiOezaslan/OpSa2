package Creators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Business.Freizeitbad;

public class WriterCsvProduct extends WriterProduct{
		
	
	
	private BufferedWriter aus;

	public WriterCsvProduct() throws IOException{
		 
			aus= new BufferedWriter(new FileWriter("Freizeitbad.csv"));
		}

	public void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException {		
		aus.write(((Freizeitbad) freizeitbad).gibFreizeitbadZurueck(';'));
		aus.write("\n");

	}


	public void schliesseDatei() throws IOException {
	    aus.close();
	}
}