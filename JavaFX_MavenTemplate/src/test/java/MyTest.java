import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


class MyTest {

//	static JavaFXTemplate t1 = new JavaFXTemplate();
	static RandomNumGenerator r1 = new RandomNumGenerator() ;
	
//	@BeforeAll
//	static void setup() {
//		t1 = new JavaFXTemplate();
//		g1 = new Pla   // instance g1 by calling  constructor
//		
//	}
	@Test
	void test1() {
		
		HashSet<Integer> randomNumbers = new HashSet<Integer>();
		randomNumbers = r1.randNumGenerator();
		assertEquals(20,randomNumbers.size(),"incorrect length for cash values array");
	}

}
