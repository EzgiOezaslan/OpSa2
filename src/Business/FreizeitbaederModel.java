package Business;


import java.io.*;

import Creators.ConcreteTxtCreator;
import Creators.WriterCreator;
import Creators.WriterCsvCreator;
import Creators.WriterProduct;
import Pattern.ConcreteObservable;

public class FreizeitbaederModel extends ConcreteObservable {
	
	private Freizeitbad freizeitbad;

	/*
	 public void schreibeFreizeitbaederInCsvDatei(FreizeitbaederView fbView)
	 throws IOException { BufferedWriter aus = new BufferedWriter(new
	 FileWriter("Freizeitbaeder.csv", true));
	 aus.write(fbView.getFreizeitbad().gibFreizeitbadZurueck(';')); aus.close(); }
	 */

	//Singleton
	private static FreizeitbaederModel freizeitbaederModel= null;
	private FreizeitbaederModel() {
		
	}
	public static FreizeitbaederModel getInstance() {
		if(freizeitbaederModel == null)
			freizeitbaederModel= new FreizeitbaederModel();
		
		return freizeitbaederModel;
	}
	
	
	
	public void schreibeFreizeitbaederInTxtDatei() throws IOException {

		WriterCreator writerCreator = new ConcreteTxtCreator();
		WriterProduct writerProduct = writerCreator.factoryMethod(null);
		
		writerProduct.fuegeInDateiHinzu(this.freizeitbad);
		writerProduct.schliesseDatei();

	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException{
		WriterCreator writerCreator = new WriterCsvCreator();
		WriterProduct writerProduct = writerCreator.factoryMethod(null);
		writerProduct.fuegeInDateiHinzu(this.freizeitbad);
		writerProduct.schliesseDatei();

	}

	public Freizeitbad getFreizeitbad() {
		return this.freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
		this.notifyObservers();

	}

}

