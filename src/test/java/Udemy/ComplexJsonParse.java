package Udemy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	
	@Test
	public static void JsonParse() {
		
		//Print number of courses
		JsonPath js = new JsonPath(payload.CoursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//Print Purchase Amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		//Print Title of the first course
		
		String titleOfFirstCourse = js.getString("courses[0].title");
		System.out.println(titleOfFirstCourse);
		
		//Print All course titles and their respective prices
		

		for (int i = 0; i < count; i++) {
			String courseTitles = js.get("courses[" + i + "].title");
			//System.out.println(courseTitles);
			if(courseTitles.equalsIgnoreCase("RPA")) {
				System.out.println();
			}
		
		
			

		}
		
		//Print number of copies sold by RPA Course
		for (int i = 0; i < count; i++) {
			 if(js.getString("courses[" + i + "].title").equalsIgnoreCase("RPA")){
				 System.out.println("If is hit");
				 int numberOfCopiesSoldByRPA = js.get("courses[" + i + "].copies");
				 System.out.println(numberOfCopiesSoldByRPA);

	 
			 }
		}
		
		//Verify if sum of all course prices matches with purchase amount
		
		int purchaseAmount = 910;
		int actualPurchaseAmount = 0;
		
		for(int i = 0; i < count; i++) {
			actualPurchaseAmount = actualPurchaseAmount + js.getInt("courses[" + i + "].price") * js.getInt("courses[" + i + "].copies");
			actualPurchaseAmount = actualPurchaseAmount + js.getInt("courses[" + i + "].copies");
		}
		
		if(purchaseAmount == actualPurchaseAmount) {
			System.out.println("PurchaseAmount is correct: " +purchaseAmount);
		}else {
			System.out.println("purchaseAmount is incorrect and should be: " + actualPurchaseAmount);
			
			System.out.println("This is a void program");
		}
	}
}
