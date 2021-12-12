package Gui.Gui.Sportstaetten;

	import java.io.IOException;

import Business.FreizeitbaederModel;
import Pattern.Observer;
import javafx.stage.Stage;

	public class SportstaettenControl implements Observer{
		
		private FreizeitbaederModel freizeitbaederModel;
		private SportstaettenView sportstaettenView;

		public SportstaettenControl(Stage primaryStage) {
			this.freizeitbaederModel = FreizeitbaederModel.getInstance();
			this.sportstaettenView = new SportstaettenView( this, freizeitbaederModel, primaryStage);
		
			freizeitbaederModel.addObserver(this);
			
		}
/*
		void schreibeFreizeitbaederInDatei(String typ) {
			try {
				if ("csv".contentEquals(typ)) {
					this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
					this.sportstaettenView.zeigeInformationsfensterAn("Freizeitbäder wurden gespeichert!");

				} else if ("txt".equals(typ)) {
					this.freizeitbaederModel.schreibeFreizeitbaederInTxtDatei();
					this.sportstaettenView.zeigeInformationsfensterAn("Freizeitbäder wurden gespeichert!");
				
				}

			} catch (IOException exc) {
				sportstaettenView.zeigeFehlermeldungsfensterAn("IOException beim Speicher",typ);
			} catch (Exception exc) {
				sportstaettenView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern",typ);
			}
		}
*/

		public void update() {
			sportstaettenView.zeigeFreizeitbaederAn();
			
		}
		
		
		

}
