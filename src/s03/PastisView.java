package s03;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PastisView extends Application{
	
	private PastisModel model;
	private PastisController controller;

	private VBox root = new VBox(50);
	private HBox textALenght = new HBox();
	private HBox optionBox = new HBox();
	private Spinner<Integer> lenghtSpinner = new Spinner<Integer>();
	private TextField pass = new TextField();


	@Override
	public void init(){
		model.pasProperty.bind(pass.textProperty());
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new PastisController();
		model = controller.init();
		
		SpinnerValueFactory<Integer> lenghtFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,25,12,1);
		lenghtFactory.setWrapAround(true);
		lenghtSpinner.setValueFactory(lenghtFactory);
		lenghtSpinner.setPrefWidth(80);
		
		Label complexity = new Label("Please select the options");
		
		textALenght.getChildren().addAll(pass,lenghtSpinner);
		textALenght.setSpacing(10);
		
		VBox check1 = new VBox();
		CheckBox maj = new CheckBox("majuscules");
		maj.setTooltip(new Tooltip("si cette case est cochée le modepasse peut contenir des Majuscule"));
		
		CheckBox min = new CheckBox("minuscules");
		min.setTooltip(new Tooltip("si cette case est cochée le modepasse peut contenir des minuscule"));
		
		CheckBox num = new CheckBox("chiffres");
		num.setTooltip(new Tooltip("si cette case est cochée le modepasse peut contenir des numéro"));
		
		check1.getChildren().addAll(maj,min,num);
		check1.setSpacing(5);
		
		VBox check2 = new VBox();
		CheckBox spe = new CheckBox("caractères spéciaux");
		num.setTooltip(new Tooltip("si cette case est cochée le modepasse peut contenir des caractères spéciaux"));

		CheckBox pro = new CheckBox("prononçable");
		num.setTooltip(new Tooltip("si cette case est cochée le modepasse doit être prononçable"));

		CheckBox amb = new CheckBox("ambigus");
		num.setTooltip(new Tooltip("si cette case est cochée le modepasse doit exlure les carctère ambigus"));

		check2.getChildren().addAll(spe,pro,amb);	
		check2.setSpacing(5);

		
		optionBox.getChildren().addAll(check1,check2);
		optionBox.setAlignment(Pos.CENTER);
		
		Button clip = new Button("Copy to Clipboard");
		
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(textALenght,complexity,optionBox,clip);
		root.setPadding(new Insets(90,80,90,80));
//sdsad
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}
	

}
