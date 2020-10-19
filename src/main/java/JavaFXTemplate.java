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
		
		tab.setGraphic(new ImageView("file:icon.png"));
	
		MenuItem opt1 = new MenuItem("Rules of the game");
		MenuItem opt2 = new MenuItem("Odds of winning");
		MenuItem opt3 = new MenuItem("Exit the game");
		
		
		tab.getItems().addAll(opt1,opt2,opt3);
		
		gameMenu.getMenus().addAll(tab);   // "Menu tab to the gameMenu bar"
		
		opt1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {

		    	
		    	final Stage dialogBox = new Stage();
		        dialogBox.initModality(Modality.APPLICATION_MODAL);
		        dialogBox.initOwner(primaryStage);
		        VBox dialogVbox = new VBox(20);
		        Text text=new Text("Rules:\n" +
		        		"1. Fill in a KENO play slip with the number of spots\n "+
						" you want to play per game. \n"+
		                " Choose 1, 4, 8 or 10 spots.\n"+
		                "2. Select number of drawings (min 1, max 4).\n" +
		                "3. Each drawing out of selected number of drawings \n"+ 
		                "consists 20 random numbers without duplicates.\n" +
		                "4. It is possible for you to select a new bet card, \n"+
		                " spots to play and drawings"+
		                " after your current drawings have been completed.");
		        text.setFill(Color.BLUE);

		        
		        dialogVbox.getChildren().add(text);
		        
		        Scene dialogScene = new Scene(dialogVbox, 500, 500);
		        dialogBox.setScene(dialogScene);
		        dialogBox.show();
		        

		    }
		});
		
		opt2.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {

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
	
}