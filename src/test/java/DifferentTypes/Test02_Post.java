package DifferentTypes;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test02_Post {

	
	@Test 
	void test_post() {
		
		Map<String, Object> hm1 = new HashMap<String, Object>();
		hm1.put("name", "Ragu");
		hm1.put("job", "teacher");
		System.out.println(hm1);
		JSONObject request = new JSONObject(hm1);
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		
		given().body(request.toJSONString()).when().post("https://reqres.in/api/users?page=2").then().statusCode(201);
	}
	
	
	@Test
	void james_forloop() {
		//HIie
		
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>(Arrays.asList(1, 2, 4)); 
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>(Arrays.asList(1, 3, 4)); 
		
		ArrayList<Integer> answerArray = new ArrayList();
		
		int i = 0;
		if(arrayList1.size() > arrayList2.size()) {
			while(i < arrayList1.size() - 1) {
				
				
				if(i < arrayList1.size() - 1) {
					answerArray.add(arrayList1.get(i));
				}

				if(i < arrayList2.size() - 1) {
					answerArray.add(arrayList2.get(i));
				}
				
				
				
				
			}
			
			
			
		} else {
				
			while(i < arrayList2.size() - 1) {	
				
			}
		
			
			
		}
		

		
		
		
	    
	    
		
	}
	
	//1,2,3,4,5,6,7,8,9,...
}
