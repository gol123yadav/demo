import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class StudentMain {
public static void main(String[] args) {
	int choice;
	Scanner s=new Scanner(System.in);
	MongoClient mongo=new MongoClient("localhost",27017);
	
	MongoDatabase database=mongo.getDatabase("school");
	
	MongoCollection<Document> collection=database.getCollection("SchoolStudent");
	
	do { 
		
		System.out.println("Enter choice:  1:Register,2:List All,3:Search,4:Max Marks,5:Min Marks,6:Exit");
		choice=s.nextInt();
		switch (choice) {
		case 1:
		{
			
		
	System.out.println("enter name");
	String name=s.next();
	
	System.out.println("enter rollno");
	int rollno=s.nextInt();
	
	System.out.println("enter marks");
	float marks=s.nextFloat();
	
	Student obj=new Student(name, rollno, marks);
	
	Document d=new Document();
	d.append("name",obj.getName()).append("rollno", obj.getRollno()).append("marks", obj.getMarks());
	collection.insertOne(d);
	System.out.println("document added");
	break;
		}
	
		case 2:{
			
			FindIterable<Document> show=collection.find();
			Iterator<Document> it=show.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
				break;
				
			}	
		}
		
		case 3:{
			
			Document d1=new Document();
			d1.append("marks",77);
			
			FindIterable<Document> search=collection.find(d1);
			Iterator<Document> it=search.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
				break;
				
			}
			
		}
		
		case 4:{
			
			Document d1=new Document();
			d1.append("marks",-1);
			
			FindIterable<Document> Max=collection.find().sort(d1).limit(1);
			Iterator<Document> it=Max.iterator();
			while(it.hasNext()) {
				
				System.out.println(it.next());
				
				break;	
			}
		}
		
		case 5:{
			
			Document d1=new Document();
			d1.append("marks",1);
			
			FindIterable<Document> min=collection.find().sort(d1).limit(1);
			Iterator<Document> it=min.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
				break;
				
			}
		}
		
		case 6:System.exit(0);
		
		default:{
			
			System.out.println("invalid choice.......please enter a right choice");
		}
	}
		
	
}while(choice!=6);
	
}
}
