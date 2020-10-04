package quinzical;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class SelectCategory {
	

	
	public static void displayQuestion(String categoryName) {
		
		Menu playbackMenu = new Menu("Playback Speed");
		ToggleGroup playbackSpeed = new ToggleGroup();
		
		RadioMenuItem halfSpeed = new RadioMenuItem("x0.50");
		RadioMenuItem slowSpeed = new RadioMenuItem("x0.75");
		RadioMenuItem normalSpeed = new RadioMenuItem("x1.00");
		RadioMenuItem quickSpeed = new RadioMenuItem("x1.50");
		RadioMenuItem fastSpeed = new RadioMenuItem("x1.75");
		RadioMenuItem doubleSpeed = new RadioMenuItem("x2.00");
		
		halfSpeed.setToggleGroup(playbackSpeed);
		slowSpeed.setToggleGroup(playbackSpeed);
		normalSpeed.setToggleGroup(playbackSpeed);
		quickSpeed.setToggleGroup(playbackSpeed);
		fastSpeed.setToggleGroup(playbackSpeed);
		doubleSpeed.setToggleGroup(playbackSpeed);
		
		playbackMenu.getItems().addAll(halfSpeed, slowSpeed, normalSpeed, quickSpeed, fastSpeed, doubleSpeed);
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(categoryName);
		window.setMinWidth(400);
		
		Label label = new Label();
		label.setText("hewwo uwu");

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(playbackMenu);
		
		Button closeButton = new Button("close the window");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(menuBar);
		
		layout.getChildren().addAll(label, closeButton);
		
		
		//need to position individual nodes in VBox
		//setting up a new repository due to network changes



		
		Scene scene = new Scene(layout, 400, 400);
		window.setScene(scene);
		window.showAndWait();
		
	}

}
