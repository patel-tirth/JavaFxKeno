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
import javafx.scene.text.Text;
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
		
	 
	
		MenuItem opt1 = new MenuItem("Rules of the game");
		MenuItem opt2 = new MenuItem("Odds of winning");
		MenuItem opt3 = new MenuItem("Exit the game");
		
		
		tab.getItems().addAll(opt1,opt2,opt3);
		
		gameMenu.getMenus().addAll(tab);   // "Menu tab to the gameMenu bar"
		
		
		
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
//		
		
		root.getChildren().addAll( img, gameMenu,playGame);
		

		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	
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
