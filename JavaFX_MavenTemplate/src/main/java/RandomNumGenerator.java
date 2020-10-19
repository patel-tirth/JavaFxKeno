
	
	import java.util.HashSet;
	import java.util.Random;

	public class RandomNumGenerator {
		
//		public RandomNumGenerator()
//		{
//			
//		}
		 HashSet<Integer> randomNumbers = new HashSet<Integer>();
		
		public HashSet<Integer> randNumGenerator()
		 {
//			 j =1 ;   // grid starts from 1
			 Random rand = new Random();
			 
			 while(randomNumbers.size() < 20)
			 {
				 while (randomNumbers.add(rand.nextInt(80)+ 1) != true);
			 }
			 return randomNumbers;
		 }

	}


