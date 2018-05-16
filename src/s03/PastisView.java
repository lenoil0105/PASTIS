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
		controller = new PastisController();
		model = controller.init();
		model.pasProperty.bind(pass.textProperty());
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {

		
		SpinnerValueFactory<Integer> lenghtFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,25,12,1);
		lenghtFactory.setWrapAround(true);
		lenghtSpinner.setValueFactory(lenghtFactory);
		lenghtSpinner.setPrefWidth(80);
		model.lenght.bind(lenghtSpinner.valueProperty());
		
		Button generate = new Button("Generate Password");
		generate.setOnMouseClicked(e-> pass.setText(controller.generate()));
		Label complexity = new Label("Please select the options");
		
		textALenght.getChildren().addAll(pass,lenghtSpinner);
		textALenght.setSpacing(10);
		
		VBox check1 = new VBox();
		CheckBox maj = new CheckBox("majuscules");
		maj.setTooltip(new Tooltip("si cette case est cochée le modepasse peut contenir des Majuscule"));
		model.Uc.bind(maj.selectedProperty());
		
		CheckBox min = new CheckBox("minuscules");
		min.setTooltip(new Tooltip("si cette case est cochée le modepasse peut contenir des minuscule"));
		model.Lc.bind(min.selectedProperty());
		
		CheckBox num = new CheckBox("chiffres");
		num.setTooltip(new Tooltip("si cette case est cochée le modepasse peut contenir des numéro"));
		model.digits.bind(num.selectedProperty());
		
		check1.getChildren().addAll(maj,min,num);
		check1.setSpacing(5);
		
		VBox check2 = new VBox();
		CheckBox spe = new CheckBox("caractères spéciaux");
		spe.setTooltip(new Tooltip("si cette case est cochée le modepasse peut contenir des caractères spéciaux"));
		model.sym.bind(spe.selectedProperty());

		CheckBox pro = new CheckBox("prononçable");
		pro.setTooltip(new Tooltip("si cette case est cochée le modepasse doit être prononçable"));

		CheckBox amb = new CheckBox("ambigus");
		amb.setTooltip(new Tooltip("si cette case est cochée le modepasse doit exlure les carctère ambigus"));
		model.unam.bind(amb.selectedProperty());

		check2.getChildren().addAll(spe,pro,amb);	
		check2.setSpacing(5);

		
		optionBox.getChildren().addAll(check1,check2);
		optionBox.setAlignment(Pos.CENTER);
		
		Button clip = new Button("Copy to Clipboard");
		
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(textALenght,generate,complexity,optionBox,clip);
		root.setPadding(new Insets(90,80,90,80));
//sdsad
		primaryStage.setScene(new Scene(root));
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	

}
