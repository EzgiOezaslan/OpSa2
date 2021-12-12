package Gui.Gui.Sportstaetten;


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

		public void update() {
			sportstaettenView.zeigeFreizeitbaederAn();
			
		}
		
		
		

}
