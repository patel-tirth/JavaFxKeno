import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

public class PlayGame {
//	
//	BorderPane borderPane = new BorderPane();
	public int num =0 ;
	public int totalNum = 20;
	public int j;
	private MenuBar gameMenu2;
	int time= 0 ;
	public int count = 0;  // to keep track on total number of spots selected from bet grid (1,4,8,10)
	String spotNumber; // string to store the spot selected
//	ArrayList<Integer> NumberList= new ArrayList<Integer>(); 
	HashMap<Integer, Boolean> NumberMap = new HashMap<Integer, Boolean>();
	HashMap<Integer, Boolean> gridValue = new HashMap<Integer, Boolean>();

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
			 fillOutSpots(grid,numberOfSpots, gamePane);
			 
		});
		
		
		 gamePane.getChildren().addAll(vbox);
		
	
	 }
	 
	 // Function to generate a set of 20 random numbers
	 public void generateRandNum(GridPane grid, HashMap<Integer, Boolean> NumberMap,Pane gamePane)
	 {
		 System.out.println(NumberMap.keySet());
		 
		 
		j =1 ;   // grid starts from 1
		 Random rand = new Random();
		 HashMap<Integer,Boolean> randomNumbers = new HashMap<Integer,Boolean>();
		 for(int i =0 ; i <totalNum; ++i)
		 {
			 num = rand.nextInt(80);
			 randomNumbers.put(num,true);
			 if (randomNumbers.size() <= 20) {
	                if (randomNumbers.size() == 20) {
	                    totalNum = 10;
	                }
	                totalNum++;
	                randomNumbers.put(num,true);
	            }
		 }
		 
		 grid.getChildren().forEach(node -> { 
			 
			 PauseTransition pause = new PauseTransition(Duration.millis(200+(time*300)));
			 if(gridValue.containsKey(j)== true && randomNumbers.containsKey(j))
			 {
				 pause.play();
				 pause.setOnFinished(e->node.setStyle("-fx-background-color: red;"));
			 } 
			 if(NumberMap.containsKey(j)== true && randomNumbers.containsKey(j) )
			 {
				 pause.play();
				 pause.setOnFinished(e->node.setStyle("-fx-background-color: green;"));
			 }
			 time++;
			 j++;
			 
		 });
 
	 }
	 
	 // function to fill the bet card
	 public void fillOutSpots(GridPane grid, int spotNumber,Pane gamePane)
	 { 
		
		  System.out.println(spotNumber); 
		  
		  	 
			  grid.getChildren().forEach(node -> {   // for each node in the grid pane,
				                                     // let user click any random number based on spots selected
				  node.setOnMouseClicked(e->{
					  if(count == spotNumber && ((ToggleButton)e.getSource()).isSelected() == false)
					  {
						  node.setStyle(null);    // allow user to select any numbers
						  String text = ((ToggleButton)e.getSource()).getText();
						  int betNum =Integer.parseInt(text);
						  NumberMap.remove(betNum);

					  }
					  else if(count >=spotNumber) {
						
						  return;
					  }
					  
					  if(((ToggleButton)e.getSource()).isSelected() == false)
					  {
						  String text = ((ToggleButton)e.getSource()).getText();
						  int betNum =Integer.parseInt(text);  
						  node.setStyle(null);
						 NumberMap.remove(betNum);

						  count--;
					  }
					  else {
					 node.setStyle("-fx-background-color: #3489eb;");
					  String text = ((ToggleButton)e.getSource()).getText();
					  int betNum =Integer.parseInt(text);  
					  NumberMap.put(betNum,true);    // add the selected bet number to array NumberList

					  count++;
					  }

				  });
				  
			  });
			  
//			  HBox drawBox = new HBox(draw);
//			  
//			  
			  Button draw = new Button("Draw");
				 gamePane.getChildren().add(draw);
//			  drawBox.setAlignment(Pos.CENTER_RIGHT);
			  
//			  BorderPane root = new BorderPane();
//			    root.setPadding(new Insets(20)); // space between elements and window border
//			    root.setBottom(drawBox);
//			    gamePane.getChildren().addAll(draw);
			  draw.setOnAction(e->{
////				  grid.setDisable(true);
//				  draw.setStyle("-fx-cursor: hand;");
				  generateRandNum(grid,NumberMap,gamePane);
				  
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
					gridValue.put(count,true);
					ToggleButton b1 = new ToggleButton(Integer.toString(count));
					
					grid.add(b1, row, column);
					 
				}	
			}
			
		 
	 }
	 

}
