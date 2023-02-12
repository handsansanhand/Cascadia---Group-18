package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			Parent root = loader.load();
			 Scene scene = new Scene(root);
	        Scene2 scene2 = new Scene2();
			Button button1 = (Button) root.lookup("#rules");
			Button button2 = (Button) root.lookup("#button2");
			Button button3 = (Button) root.lookup("#button3");
			Button button4 = (Button) root.lookup("#button4");
		 URL RULES = new URL("https://www.alderac.com/wp-content/uploads/2021/08/Cascadia-Rules.pdf");
			button1.setOnAction(event -> {
			    TextArea textArea = new TextArea();
			    textArea.setText("Cascadia rulebook:\n1.ill later fill later fill later.\n2. ill later fill later fill later.\n3. ill later fill later fill later. \n"+RULES);
			    AnchorPane anchorPane = new AnchorPane();
			    anchorPane.getChildren().add(textArea);
			    Scene newScene = new Scene(anchorPane);
			    stage.setScene(newScene);
			    stage.show();
			});  
			button2.setOnAction(event -> {
				System.out.println("test");
				stage.setScene(Scene2.getScene());
		        stage.show();
			});
			button3.setOnAction(event -> {
				System.out.println("test");
				stage.setScene(scene3.getScene());
		        stage.show();
			});
			button4.setOnAction(event -> {
				System.out.println("test");
				stage.setScene(scene4.getScene());
		        stage.show();
				
			});



			stage.setScene(scene);
			stage.show();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
