package Creators;

import java.io.IOException;

import Business.Freizeitbad;

public abstract class WriterProduct {
	
	public abstract void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException;
	
	
	public abstract void schliesseDatei() throws IOException;

	
}
