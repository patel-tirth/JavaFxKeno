import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class PlayGame {
//	
//	BorderPane borderPane = new BorderPane();
//	
	private MenuBar gameMenu2;
	public int count = 0;  // to keep track on total number of spots selected from bet grid (1,4,8,10)
	String spotNumber; // string to store the spot selected
	ArrayList<Integer> NumberList= new ArrayList<Integer>(); 

	 public PlayGame() {
		// TODO Auto-generated constructor stub
	}

	public Scene getGameScene() 
	 
	 {
		Pane gamePane = new Pane();
		gamePane.setPrefSize(800,600);
		
		gameMenu2= new MenuBar();
		Menu tab = new Menu("Menu");
		MenuItem opt1 = new MenuItem("Rules of the game");
		MenuItem opt2 = new MenuItem("Odds of winning");
		MenuItem opt3 = new MenuItem("Exit the game");
		MenuItem opt4 = new MenuItem("New Look");
		tab.getItems().addAll(opt1,opt2,opt3,opt4);
	
		gameMenu2.getMenus().addAll(tab);
		
		opt4.setOnAction(e->{
			gamePane.setStyle("-fx-background-color: #a3816d;");
		});
		GridPane grid= new GridPane();
		grid.setStyle("-fx-cursor: hand;");
		
	   selectSpots(gamePane , grid); // pass a new grid to select a spot
		grid.setAlignment(Pos.CENTER);
		addGrid(grid);
		grid.setDisable(true);
		gamePane.getChildren().addAll(grid,gameMenu2);
		return new Scene(gamePane,700,700);

	  }
	 
	 // function to select the number of spots to play and enable disable grid accordingly 
	 public void selectSpots(Pane gamePane, GridPane grid)
	 {
		
		Text text = new Text();
    text.setText("How many spots do you want to play?");
		 
    text.setStyle("-fx-font-size: 18;"+"-fx-border-size: 20;"+ 
			"-fx-border-color: purple;" + "-fx-padding: 15;" + "-fx-alignment:center;");
    text.setTextAlignment(TextAlignment.CENTER);
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
		
		 vbox.setStyle("-fx-cursor: hand;");
		 vbox.setPrefWidth(700);
		proceed.setOnAction(e -> {
			 Toggle selectedSpot = group.getSelectedToggle();
			 if(selectedSpot ==spot1 )
			 {
				 spotNumber = spot1.getText();
				 spot1.setStyle("-fx-background-color: #34ebd5;");
				 grid.setDisable(false);
				 spot4.setDisable(true);
				 spot8.setDisable(true);
				 spot10.setDisable(true);
			 }
			 else if (selectedSpot ==spot4 )
			 {
				 spotNumber = spot4.getText();
				 spot4.setStyle("-fx-background-color: #34ebd5;");
				 grid.setDisable(false);
				 spot1.setDisable(true);
				 spot8.setDisable(true);
				 spot10.setDisable(true);
			 }
			 else if (selectedSpot ==spot8 )
			 {
				 spotNumber = spot8.getText();
				 spot8.setStyle("-fx-background-color: #34ebd5;");
				 grid.setDisable(false);
				 spot1.setDisable(true);
				 spot4.setDisable(true);
				 spot10.setDisable(true);
			 }
			 else if (selectedSpot ==spot10)  
			 {
				 spotNumber = spot10.getText();
				 spot10.setStyle("-fx-background-color: #34ebd5;");
				 grid.setDisable(false);
				 spot1.setDisable(true);
				 spot4.setDisable(true);
				 spot8.setDisable(true);
				 
			 }
			 else
			 {
				 grid.setDisable(true);
			 }
			 int numberOfSpots =Integer.parseInt(spotNumber);  
			 fillOutSpots(grid,numberOfSpots);
		});
		
		
		 gamePane.getChildren().addAll(vbox);
		
	
	 }
	 
	 // function to fill the bet card
	 public void fillOutSpots(GridPane grid, int spotNumber)
	 { 
		
		  System.out.println(spotNumber); 
		  	 
			  grid.getChildren().forEach(node -> {   // for each node in the grid pane,
				                                     // let user click any random number based on spots selected
				  node.setOnMouseClicked(e->{
					  if(count >=spotNumber)
						  return;
					  node.setStyle("-fx-background-color: #d442f5;");
					  node.setDisable(true);
					  String text = ((Button)e.getSource()).getText();
					  int betNum =Integer.parseInt(text);  
					  NumberList.add(betNum);    // add the selected bet number to array NumberList
					  count++;
				  });
				  
			  });
			  
	 }
	 
	 // function to make the grid 
	 public void addGrid(GridPane grid)
	 {

			grid.setLayoutX(300);
			grid.setLayoutY(200);
			grid.setHgap(10); 
			grid.setVgap(10);
			int count = 0;
			for(int row = 0; row<=7; row++) {
				for(int column = 1; column<=10; column++) {
					count++;
					Button b1 = new Button(Integer.toString(count));
					grid.add(b1, row, column);
					 
				}	
			}
			
		 
	 }
	 

}
