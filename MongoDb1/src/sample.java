import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoCredential;
public class sample{
	public static void main(String[] args) {
	
		MongoClient mongo=new MongoClient("localhost",27017);
		MongoDatabase database=mongo.getDatabase("demo1");
		
		database.createCollection("NewStudent");
		System.out.println("collection created successfully");
		
	}
}
