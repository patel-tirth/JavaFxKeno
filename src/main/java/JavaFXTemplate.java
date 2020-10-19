import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.sun.javafx.event.EventHandlerManager;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXTemplate extends Application {
	
//	private Button b1;
//	private Button b2;
//	private Button b3;
//	private Button changeBack;
	
//	private Menu gameMenu;
	private MenuBar gameMenu;
	private GridPane grid;
	private Button playGame;
	private static final int COLS=10, ROWS=8;
//	private Title text;
//	private ButtonMenu menubutton1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Keno Lottery System");
		
		Pane root=new Pane();
		root.setPrefSize(800,600);
	
		gameMenu= new MenuBar();
	
		Menu tab = new Menu("Menu"); // tab menu.. on click list the options
		
		tab.setGraphic(new ImageView("file:icon.png"));
	
		MenuItem opt1 = new MenuItem("Rules of the game");
		MenuItem opt2 = new MenuItem("Odds of winning");
		MenuItem opt3 = new MenuItem("Exit the game");
		
		
		tab.getItems().addAll(opt1,opt2,opt3);
		
		gameMenu.getMenus().addAll(tab);   // "Menu tab to the gameMenu bar"
		
		opt1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
//		    	DropShadow drop=new DropShadow();
//				drop.setOffsetX(40.0);
//				drop.setOffsetY(38.0);
//		    	
//		    	Rectangle rules = new Rectangle(500,500);
//		    	rules.setX(140);
//		    	rules.setY(60);
//		    	rules.setOpacity(0.7);
//				rules.setFill(Color.BLACK);
//				rules.setEffect(new GaussianBlur(1.5));	
//				rules.setEffect(drop);
//				
//				StackPane stack = new StackPane();
//				
//				Text ruleText = new Text("Rules:\n" +
//		                "1. Pick either 1, 4, 8, or 10 numbers from the bet\n "+
//						" card which has numbers ranging from 1 to 80. (or auto pick numbers)\n"+
//		                "2. Select number of drawings (min 1, max 4).\n" +
//		                "3. Each drawing consists 20 random numbers without duplicates.\n" +
//		                "4. You can fill out a new bet card, spots to play and drawings \n"+
//		                " after the current selected amount of drawings\n" +
//		                " have been completed.");
//				ruleText.setFill(Color.WHITE);
//				ruleText.setTextAlignment(TextAlignment.CENTER);
//				
//				stack.setMargin(rules, new Insets(50,50,50,50));
//				stack.getChildren().add(rules);
//				stack.getChildren().add(ruleText);
//				
////				tab.getItems().addAll(opt1,opt2,opt3);
////				gameMenu.getMenus().addAll(tab);
//				
//		        root.getChildren().addAll(stack);
		    	
		    	final Stage dialogBox = new Stage();
		        dialogBox.initModality(Modality.APPLICATION_MODAL);
		        dialogBox.initOwner(primaryStage);
		        VBox dialogVbox = new VBox(20);
		        Text text=new Text("Rules:\n" +
		                "1. Pick either 1, 4, 8, or 10 numbers from the bet\n "+
						" card which has numbers ranging from 1 to 80. (or auto pick numbers)\n"+
		                "2. Select number of drawings (min 1, max 4).\n" +
		                "3. Each drawing consists 20 random numbers without duplicates.\n" +
		                "4. You can fill out a new bet card, spots to play and drawings \n"+
		                " after the current selected amount of drawings\n" +
		                " have been completed.");
		        text.setFill(Color.BLUE);
//		        dialogBox.
		        
		        dialogVbox.getChildren().add(text);
		        
		        Scene dialogScene = new Scene(dialogVbox, 500, 500);
		        dialogBox.setScene(dialogScene);
		        dialogBox.show();
		        

		    }
		});
		
		opt2.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
//		    	DropShadow drop=new DropShadow();
//				drop.setOffsetX(40.0);
//				drop.setOffsetY(38.0);
//		    	
//		    	Rectangle rules = new Rectangle(500,500);
//		    	rules.setX(140);
//		    	rules.setY(60);
//		    	rules.setOpacity(0.7);
//				rules.setFill(Color.BLACK);
//				rules.setEffect(new GaussianBlur(1.5));	
//				rules.setEffect(drop);
//				
//				opt1.setOnAction(null);
////				opt1.disableProperty().set(true);
//		        root.getChildren().add(rules);
////		        title.setDisable(true);
		    	
		    	final Stage dialogBox = new Stage();
		        dialogBox.initModality(Modality.APPLICATION_MODAL);
		        dialogBox.initOwner(primaryStage);
		        VBox dialogVbox = new VBox(20);
		        Text text=new Text("Odds of winning:\n\n" +
		                " 1 SPOT GAME\n" +
		                " Match     Prize\n" +
		                "     1           $2\n"+
		                "Overall Odds: 1 in 4.00\n");
		        Text text1=new Text(" 4 SPOT GAME\n" +
		                " Match     Prize\n" +
		                "     4          $75\n" +
		                "     3           $5\n" +
		                "     2           $1\n" +
		                "Overall Odds: 1 in 3.86\n");
		        Text text2=new Text(" 8 SPOT GAME\n" +
		                " Match     Prize\n" +
		                "     8      $10,000\n" +
		                "     7         $150\n" +
		                "     6          $50\n" +
		                "     5          $12\n" +
		                "     4           $1\n" +
		                "Overall Odds: 1 in 9.77\n");
		        Text text3=new Text(" 8 SPOT GAME\n" +
		                " Match     Prize\n" +
		                "    10     $100,000\n" +
		                "     9       $4,250\n" +
		                "     8         $450\n" +
		                "     7          $40\n" +
		                "     6          $15\n" +
		                "     5           $2\n" +
		                "     0           $5\n" +
		                "Overall Odds: 1 in 9.05\n");

		        
		        dialogVbox.getChildren().addAll(text,text1,text2,text3);
		        
		        Scene dialogScene = new Scene(dialogVbox, 400, 600);
		        dialogBox.setScene(dialogScene);
		        dialogBox.show();
		    }
		});
		
		opt3.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	System.exit(0);
		    }
		});
		
		playGame = new Button("Lets Play");
		playGame.setAlignment(Pos.CENTER);
		playGame.setLayoutX(100);
		playGame.setOnAction(e-> {
			PlayGame game = new PlayGame();
			primaryStage.setScene(game.getGameScene());
			primaryStage.show();
		});     
			
		// background image
		Image image = new Image("background.png");
		ImageView img= new ImageView(image);
		img.setFitHeight(800);
		img.setFitWidth(800);
		img.setFitHeight(800);
		img.setFitWidth(800);

		InnerShadow is = new InnerShadow();
		is.setOffsetX(4.0f);
		is.setOffsetY(4.0f);

		Text title = new Text();
		title.setEffect(is);
		title.setX(-170);
		title.setY(10);
		title.setText("KENO LOTTERY");
		title.setFill(Color.YELLOW);
		title.setFont(Font.font(null, FontWeight.BOLD, 80));

		title.setTranslateX(300);
		title.setTranslateY(300);
		
		
		
		

		
		root.getChildren().addAll( img, gameMenu,playGame, title);
		
		

		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
//	public void menuButton() {
//		DropShadow drop=new DropShadow();
//		drop.setOffsetX(40.0);
//		drop.setOffsetY(38.0);
//		
//		Rectangle rules=new Rectangle(600,500);
//		rules.setX(10);
//		rules.setY(50);
//		rules.setOpacity(0.4);
//		rules.setFill(Color.BLACK);
//		rules.setEffect(new GaussianBlur(1.5));	
//		rules.setEffect(drop);
//	}
	

//	private class ButtonMenu implements EventHandler<actionevent>{
//		public void menuButton(ActionEvent event) {
//			DropShadow drop=new DropShadow();
//			drop.setOffsetX(40.0);
//			drop.setOffsetY(38.0);
//			
//			Rectangle rules=new Rectangle(600,500);
//			rules.setX(10);
//			rules.setY(50);
//			rules.setOpacity(0.4);
//			rules.setFill(Color.BLACK);
//			rules.setEffect(new GaussianBlur(1.5));	
//			rules.setEffect(drop);
//		}
//	}
	
	
//	private static class ButtonMenu extends StackPane {
//		private Text buttonText;
//		
//		public ButtonMenu(String name) {
//			buttonText=new Text(name);
//			buttonText.setFont(buttonText.getFont().font(20));
//			buttonText.setFill(Color.WHITE);
//			Rectangle box=new Rectangle(270,50);
//			box.setOpacity(0.4);
//			box.setFill(Color.BLACK);
//			box.setEffect(new GaussianBlur(3.5));
//			setAlignment(Pos.CENTER);
//			getChildren().addAll(box,buttonText);
//			
//			setOnMouseEntered(event->{
//				buttonText.setFill(Color.BLACK);
//				box.setFill(Color.WHITE);
//				box.setStroke(Color.GREEN);
//			});
//			
//			setOnMouseExited(event->{
//				buttonText.setTranslateX(0);
//				buttonText.setFill(Color.WHITE);
//				box.setTranslateX(0);
//				box.setFill(Color.BLACK);
//				box.setStroke(Color.WHITE);
//				box.setStrokeWidth(0.0f);
//			});
//			
//			
//		}
//	}
//		
		
//	private class Menu extends Parent{
//		private Text text;
//		
//		public Pane drawGrid() {
//			grid = new GridPane();
//			grid.setLayoutX(400);
//			grid.setLayoutY(100);
//
//			for(int rowIndex = 0; rowIndex < ROWS ; rowIndex++) {
//	            Node[] nodes = new Node[COLS];
//	            for(int colIndex = 0; colIndex < COLS ; colIndex++) {
//	                Button node= new Button(colIndex+1+"");
//	                nodes[colIndex]= node;
//	            }
//	            grid.addRow(rowIndex, nodes);
//	        }
//	        return grid;
//		}
//		
//		public Menu() {
//			VBox mainMenu = new VBox(20);
//			DropShadow drop=new DropShadow();
//			drop.setOffsetX(40.0);
//			drop.setOffsetY(38.0);
//			
//			Rectangle rules=new Rectangle(600,500);
//			rules.setX(10);
//			rules.setY(50);
//			rules.setOpacity(0.4);
//			rules.setFill(Color.BLACK);
//			rules.setEffect(new GaussianBlur(1.5));	
//			rules.setEffect(drop);

//			
//			VBox root = new VBox(50);
//	        root.setPadding(new Insets(60, 50,60,60));
//	        
//	        
//			
//			
//			text=new Text("Game Rules are shown over here");
//			text.setFont(text.getFont().font(20));
//			text.setFill(Color.WHITE);
//			
//			
//				
//			mainMenu.setTranslateX(100);
//			mainMenu.setTranslateY(200);
//			
//			final int offset=100;
//			rules.setTranslateX(offset);
//			
//			ButtonMenu buttonRules= new ButtonMenu("Rules of the game");
//			buttonRules.setOnMouseClicked(event->{
//				
//
//				getChildren().addAll(rules, text);
//				TranslateTransition toRules = new TranslateTransition(Duration.seconds(0.25), mainMenu);
//				toRules.setToX(mainMenu.getTranslateX() - offset);
//				
//				TranslateTransition toNewRules = new TranslateTransition(Duration.seconds(0.15), mainMenu);
//				toNewRules.setToX(rules.getTranslateX());
//				
//				toRules.play();
//				toNewRules.play();
//				
//				toRules.setOnFinished(evt->{
//					getChildren().remove(mainMenu);
//				});
//				
//				
//			});
//			
//			ButtonMenu buttonWins = new ButtonMenu("Odds of Winning");
//////			buttonWins.setOnMouseClicked(event->{
//////
//////				
//////			});
//				
//			ButtonMenu buttonExit = new ButtonMenu("Exit Game");
//			buttonWins.setOnMouseClicked(event->{
//				System.exit(0);
//			});
//			
//			ButtonMenu buttonPlay = new ButtonMenu("Play");
//			buttonPlay.setOnMouseClicked(event->{
//				
//				getChildren().addAll(root, drawGrid());
//				TranslateTransition toRules = new TranslateTransition(Duration.seconds(0.25), mainMenu);
//				toRules.setToX(mainMenu.getTranslateX() - offset);
//				
//				TranslateTransition toNewRules = new TranslateTransition(Duration.seconds(0.15), mainMenu);
//				toNewRules.setToX(root.getTranslateX());
//				
//				toRules.play();
//				toNewRules.play();
//				
//				toRules.setOnFinished(evt->{
//					getChildren().remove(mainMenu);
//				});
//				
//			});	
//			
//			mainMenu.getChildren().addAll(buttonRules, buttonWins, buttonExit, buttonPlay);
//			Rectangle allButtBack=new Rectangle(800,600);
//			allButtBack.setFill(Color.GREY);
//			allButtBack.setOpacity(0.4);
//			getChildren().addAll(allButtBack, mainMenu);
//		}
//	}



		
		
	

}
