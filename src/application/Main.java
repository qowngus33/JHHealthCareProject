package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.*;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("개인 건강 관리 앱 ");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

