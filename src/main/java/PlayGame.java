import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class PlayGame {

	public int num =0 ;
	public int totalNum = 20;
	public int j;
	int NumDraws = 1;
	private MenuBar gameMenu2;
	int secs= 0 ;
     int count = 0;  // to keep track on total number of spots selected from bet grid (1,4,8,10)
	String spotNumber; // string to store the spot selected
	String drawNumber; // to select the number  of draws

	HashMap<Integer, Boolean> NumberMap = new HashMap<Integer, Boolean>();
	HashMap<Integer, Boolean> gridValue = new HashMap<Integer, Boolean>();
	 HashSet<Integer> randomNumbers = new HashSet<Integer>();
	 HashSet<Integer> WinSet = new HashSet<Integer>();  // to store winning results
	 Button resultButton = new Button("Show Results!");
	 
	 int Money =0;
	 public PlayGame() {
		// TODO Auto-generated constructor stub
	}

	 public Scene newGameScene(Pane gamePane)
	 {
		return new Scene(gamePane,700,700);
		 
	 }
	public Scene getGameScene() 
	 
	 {
		Pane gamePane = new Pane();
		gamePane.setPrefSize(800,600);
		
		Button newGame = new Button("New Game");
		newGame.setLayoutX(450);
		
		resultButton.setLayoutX(300);
		
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
		gamePane.getChildren().addAll(grid,gameMenu2,newGame, resultButton);
//		newGame.setOnAction(e->{
//			Scene scene = newGameScene(gamePane);
//			return scene;
//		});
		return new Scene(gamePane,700,700);

	  }
	 
	 // function to select the number of spots to play and enable disable grid accordingly 
	 public void selectSpots(Pane gamePane, GridPane grid)
	 {
		
		Text text = new Text();
    text.setText("How many spots do you want to play?");
     
    Text text2 = new Text();
    text2.setText("How many draws do you want to play?");
    
    ToggleGroup group = new ToggleGroup();
    ToggleGroup group2 = new ToggleGroup();
    	
	    ToggleButton spot1 = new ToggleButton("1");
	    
	 
	    ToggleButton spot4 = new ToggleButton("4");
	   
	    ToggleButton spot8 = new ToggleButton("8");
	  
	    ToggleButton spot10 = new ToggleButton("10"); 
	    
	    // to select number of draws
	    ToggleButton draw1 = new ToggleButton("1");
	    ToggleButton draw2 = new ToggleButton("2");
	    ToggleButton draw3 = new ToggleButton("3");
	    ToggleButton draw4 = new ToggleButton("4");
	    
	    spot1.setToggleGroup(group);
	    spot4.setToggleGroup(group);
	    spot8.setToggleGroup(group);
	    spot10.setToggleGroup(group);
	    
	    draw1.setToggleGroup(group2);
	    draw2.setToggleGroup(group2);
	    draw3.setToggleGroup(group2);
	    draw4.setToggleGroup(group2);
	    
	    Button proceed = new Button("Procceed");
	    Button NumOfDraws = new Button (" Select Num of Draws");
	    HBox hbox = new HBox(spot1,spot4,spot8,spot10,proceed);
	    HBox hbox2 = new HBox(draw1,draw2,draw3,draw4,NumOfDraws);
	    hbox.setAlignment(Pos.BASELINE_CENTER);
	   
		VBox vbox = new VBox(text,hbox);
		VBox vbox2 = new VBox(text2,hbox2);
		 vbox2.setLayoutX(200);
		 vbox2.setLayoutY(90);
		 vbox.setStyle("-fx-cursor: hand;");
		 vbox2.setStyle("-fx-cursor: hand;");

		 vbox.setLayoutX(200);
		 vbox.setLayoutY(40);
		proceed.setOnAction(e -> {
			 Toggle selectedSpot = group.getSelectedToggle();
			 if(selectedSpot ==spot1 )
			 {
				 spotNumber = spot1.getText();
				 spot1.setStyle("-fx-background-color: #34ebd5;");
				 spot4.setDisable(true);
				 spot8.setDisable(true);
				 spot10.setDisable(true);
			 }
			 else if (selectedSpot ==spot4 )
			 {
				 spotNumber = spot4.getText();
				 spot4.setStyle("-fx-background-color: #34ebd5;"); 
				 spot1.setDisable(true);
				 spot8.setDisable(true);
				 spot10.setDisable(true);
			 }
			 else if (selectedSpot ==spot8 )
			 {
				 spotNumber = spot8.getText();
				 spot8.setStyle("-fx-background-color: #34ebd5;");

				 spot1.setDisable(true);
				 spot4.setDisable(true);
				 spot10.setDisable(true);
			 }
			 else if (selectedSpot ==spot10)  
			 {
				 spotNumber = spot10.getText();
				 spot10.setStyle("-fx-background-color: #34ebd5;");

				 spot1.setDisable(true);
				 spot4.setDisable(true);
				 spot8.setDisable(true);
				 
			 }
			 	 
		});
		
		NumOfDraws.setOnAction(e->{
			Toggle selectedDraw = group2.getSelectedToggle();
			if(selectedDraw == draw1)
			{
				drawNumber = draw1.getText();
				draw1.setStyle("-fx-background-color: #34ebd5;");
				grid.setDisable(false);
				draw2.setDisable(true);
				draw3.setDisable(true);
				draw4.setDisable(true);
			}
			if(selectedDraw == draw2)
			{
				drawNumber = draw2.getText();
				draw2.setStyle("-fx-background-color: #34ebd5;");
				grid.setDisable(false);
				draw1.setDisable(true);
				draw3.setDisable(true);
				draw4.setDisable(true);
			}
			if(selectedDraw == draw3)
			{
				drawNumber = draw3.getText();
				draw3.setStyle("-fx-background-color: #34ebd5;");
				grid.setDisable(false);
				draw1.setDisable(true);
				draw2.setDisable(true);
				draw4.setDisable(true);
			}
			if(selectedDraw == draw4)
			{
				drawNumber = draw4.getText();
				draw4.setStyle("-fx-background-color: #34ebd5;");
				grid.setDisable(false);
				draw1.setDisable(true);
				draw2.setDisable(true);
				draw3.setDisable(true);
			}
			
			int numberOfSpots =Integer.parseInt(spotNumber);  
			int numberOfDraws = Integer.parseInt(drawNumber);
			 fillOutSpots(grid,numberOfSpots, gamePane,numberOfDraws); // function call to fill the spots
		});
		
		 gamePane.getChildren().addAll(vbox,vbox2);
		
	
	 }
	 
	 // 
	 
	 public HashSet<Integer> randNumGenerator()
	 {
//		 j =1 ;   // grid starts from 1
		 Random rand = new Random();
		 
		 while(randomNumbers.size() <  20)
		 {
			 while (randomNumbers.add(rand.nextInt(80)) != true);
		 }
		 return randomNumbers;
		 
		 

	 }
	 
	 // Lottery results
	public void lotteryResults(HashSet<Integer> WinSet,int spotNumber)
	{
		Alert result = new Alert(AlertType.INFORMATION);
		result.setTitle("Lottery Results");
		if(spotNumber == 10)
		{
			if(WinSet.size() == 10)
				Money = 100000;
			else if (WinSet.size() == 9)
				Money = 4250;
			else if (WinSet.size() == 8)
				Money = 450;
			else if (WinSet.size() == 7)
				Money = 40;
			else if (WinSet.size() == 6)
				Money = 15;
			else if (WinSet.size() == 5)
				Money = 2;
			else
				Money = 5;
			
		}
		if(spotNumber == 8)
		{
			if(WinSet.size() == 8)
				Money = 10000;
			else if (WinSet.size() == 7)
				Money = 750;
			else if (WinSet.size() == 8)
				Money = 450;
			else if (WinSet.size() == 6)
				Money = 50;
			else if (WinSet.size() == 5)
				Money = 12;
			else if (WinSet.size() == 4)
				Money = 2;
			else
				Money = 0;
			
		}
		if(spotNumber == 4)
		{
			if(WinSet.size() == 4)
				Money = 75;
			else if (WinSet.size() == 3)
				Money = 5;
			else if (WinSet.size() == 2)
				Money = 1;
			else
				Money = 0;
			
		}
		if(spotNumber == 1)
		{
			if(WinSet.size() == 1)
				Money = 2;
			else
				Money = 0;
			
		}
		String text = "Price won for this round is $"+ Money;
		result.setContentText(text);
		result.show();
	}
	 
	 
	 // Function to
	 public void generateRandNum(GridPane grid, HashMap<Integer, Boolean> NumberMap,Pane gamePane, int NumDraws,Button draw,
			 int spotNumber)
	 {
		 
//		 System.out.println(NumberMap.keySet());
		 j = 1;
		 
		 HashSet<Integer> randomNumbers = randNumGenerator();
		 
		 grid.getChildren().forEach(node -> { 
			 PauseTransition pause = new PauseTransition(Duration.millis(500+(secs*100)));	
//			 if(NumDraws > 1 && randomNumbers.contains(j) && gridValue.containsKey(j) )
//				 {
////					 pause.play();
//					 node.setStyle(null);
////					 generateRandNum( grid,  NumberMap,gamePane,NumDraws,draw);
//					 
//				 }
			 
			
			 if(gridValue.containsKey(j)== true && randomNumbers.contains(j))
			 {
				 pause.play();
				 pause.setOnFinished(e->node.setStyle("-fx-background-color: red;"));
			 } 
			 if(NumberMap.containsKey(j)== true && randomNumbers.contains(j) )
			 {
				 WinSet.add(j);
				 pause.play();
				 pause.setOnFinished(e->node.setStyle("-fx-background-color: green;"));
				
			 }
//			
			 ++secs;
			 j++;   

		 });
		 resultButton.setOnAction(e->{
			 lotteryResults(WinSet,spotNumber);
		 });
		 
	 }
	 
	 // function to fill the bet card
	 public void fillOutSpots(GridPane grid, int spotNumber,Pane gamePane,int drawNumber)
	 { 
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
			  		  
			  Button RandomSelect = new Button("Select Random Spots");
			  Button draw = new Button("Draw");
			  
			  VBox drawBox = new VBox(RandomSelect,draw);
			  	drawBox.setLayoutX(100);
			  	drawBox.setLayoutY(300);
			  	drawBox.setStyle("-fx-cursor: hand;");
				 gamePane.getChildren().add(drawBox);
				 
				 RandomSelect.setOnAction(e->{
					 selectRandomSpots(grid,spotNumber);
				 });
			
			
			draw.setOnAction(e->{
				if(NumDraws == drawNumber)
					draw.setDisable(true);
				
			NumDraws++;
		 		
		   grid.setDisable(true);
		   draw.setText("Draw "+NumDraws);
		  generateRandNum(grid,NumberMap,gamePane,NumDraws,draw,spotNumber);
				  	
			  });
			
//		}
				 
		
	 }
	 
	 // function to let computer choose spots for the user
	 public void selectRandomSpots(GridPane grid , int numberOfSpots)
	 {
		 Random rand = new Random();
		 HashSet<Integer> randomNumbers = new HashSet<Integer>();
		  Random rand2 = new Random();
		 
		 while(randomNumbers.size() < numberOfSpots)
		 {
			 while (randomNumbers.add(rand2.nextInt(80)) != true);
		 }
		 
		 j = 1 ;
		 grid.getChildren().forEach(node -> {  
			 PauseTransition pause = new PauseTransition(Duration.millis(500+(secs*100)));
			 if(gridValue.containsKey(j) && randomNumbers.contains(j))
			 {
				 pause.play();
				 NumberMap.put(j,true);
				 pause.setOnFinished(e->node.setStyle("-fx-background-color: #3489eb;"));
			 } 
			 secs = secs + 1;
			 j++;
			
			
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
