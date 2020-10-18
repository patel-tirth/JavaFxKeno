import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PlayGame {
//	
//	public public PlayGame()
//	{
//        
//
//	}
	String spotNumber; // string to store the spot selected
	// set the scene of the game play
	 public Scene getGameScene() 
	 
	 {
		Pane gamePane = new Pane();
		gamePane.setPrefSize(800,600);
		
	    
	
		GridPane grid= new GridPane();
		
		grid.setAlignment(Pos.CENTER);
		addGrid(grid);
		grid.setDisable(true);
		selectSpots(gamePane , grid); // pass a new grid to select a spot
	
		gamePane.getChildren().addAll(grid);
		return new Scene(gamePane);

	  }
	 
	 // function to select the number of spots to play and enable disable grid accordingly 
	 public void selectSpots(Pane gamePane, GridPane grid)
	 {
		
		Text text = new Text();
    text.setText("How many spots do you want to play?");
		 
    text.setStyle("-fx-font-size: 18;"+"-fx-border-size: 20;"+ 
			"-fx-border-color: purple;" + "-fx-padding: 15;");
    ToggleGroup group = new ToggleGroup();
    	
	    ToggleButton spot1 = new ToggleButton("1");
	    
	 
	    ToggleButton spot4 = new ToggleButton("4");
	   
	    ToggleButton spot8 = new ToggleButton("8");
	  
	    ToggleButton spot10 = new ToggleButton("10"); 
	    spot1.setToggleGroup(group);
	    spot4.setToggleGroup(group);
	    spot8.setToggleGroup(group);
	    spot10.setToggleGroup(group);
	    
	    Button proceed = new Button("Procceed");
	    HBox hbox = new HBox(spot1,spot4,spot8,spot10,proceed);
	    hbox.setAlignment(Pos.BASELINE_CENTER);
		VBox vbox = new VBox(text,hbox);
		 
		proceed.setOnAction(e -> {
			 Toggle selectedSpot = group.getSelectedToggle();
			 if(selectedSpot ==spot1 )
			 {
				 spotNumber = spot1.getText();
//				 System.out.println(spotNumber);
				 grid.setDisable(false);
			 }
			 else if (selectedSpot ==spot4 )
			 {
				 spotNumber = spot4.getText();
//				 System.out.println(spotNumber);
				 grid.setDisable(false);
			 }
			 else if (selectedSpot ==spot8 )
			 {
				 spotNumber = spot8.getText();
//				 System.out.println(spotNumber);
				 grid.setDisable(false);
			 }
			 else if (selectedSpot ==spot10)
			 {
				 spotNumber = spot10.getText();
//				 System.out.println(spotNumber);
				 grid.setDisable(false);
			 }
			 else
			 {
				 grid.setDisable(true);
			 }
			 fillOutSpots(grid,spotNumber);
		});
		
		
		 gamePane.getChildren().addAll(vbox);
		
		
	
	 }
	 
	 // function to fill the bet card
	 public void fillOutSpots(GridPane grid, String spotNumber)
	 { 
		// to be implemented
//		 int NumberOfSpots =Integer.parseInt(spotNumber); // convert the spotNumber to int
		  System.out.println(spotNumber);
//		 int i = 0;
//		 while(i 
//		 grid.get
	 }
	 
	 // function to make the grid 
	 public void addGrid(GridPane grid)
	 {
		 EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>() {
				
				public void handle(ActionEvent e) {
					Button b1 = (Button)e.getSource();
					b1.setDisable(true);
				}
			};
			grid.setLayoutX(300);
			grid.setLayoutY(200);
			grid.setHgap(10); 
			grid.setVgap(10);
			int count = 0;
			for(int row = 0; row<=7; row++) {
				for(int column = 1; column<=10; column++) {
					count++;
					Button b1 = new Button(Integer.toString(count));
//					b1.setOnAction(myHandler);
					grid.add(b1, row, column);
					 
				}	
			}
			
//
		 
	 }
	 

}
