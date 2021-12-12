package Business;


import java.io.*;
import java.util.Vector;
import Creators.ConcreteTxtCreator;
import Creators.WriterCreator;
import Creators.WriterCsvCreator;
import Creators.WriterProduct;
import Pattern.Observer;
import Pattern.Observable;

public class FreizeitbaederModel implements Observable {
	
	private Freizeitbad freizeitbad;
	private Vector <Observer> observers = new Vector <Observer>();

	/*
	 * public void schreibeFreizeitbaederInCsvDatei(FreizeitbaederView fbView)
	 * throws IOException { BufferedWriter aus = new BufferedWriter(new
	 * FileWriter("Freizeitbaeder.csv", true));
	 * aus.write(fbView.getFreizeitbad().gibFreizeitbadZurueck(';')); aus.close(); }
	 */
	

	//Singleton
	private static FreizeitbaederModel freizeitbaederModel;
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
	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.addElement(obs);
	}
	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.removeElement(obs);
	}
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer obs: observers) {
			obs.update();
		}
		
	}


}

