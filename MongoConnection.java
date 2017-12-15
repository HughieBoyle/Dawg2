/**
 * 
 */
package Healthcare2.health;

import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Projections.*;
/**
 * @author BoyleHugh(L00130487)
 *
 */
public class MongoConnection  
{
	/**
	 * @param args
	 */
	static double quote = 0;
	public static void main(String[] args) 
	{		
		MongoClient mC = new MongoClient("localhost", 27017);
		/*get and print the port number*/
		String cP = mC.getConnectPoint();
		System.out.println(cP);
		/*connect to the "test" database
		 */	MongoDatabase database = mC.getDatabase("test");
		/*list all the collections in the database*/
		for (String name : database.listCollectionNames())
		{
			System.out.println(name);
		}
		/*connect to the collection "DawgHealth"*/
		MongoCollection<Document> coll = database.getCollection("DawgHealth");
		/*print the collection*/
		MongoCursor<Document> cursor = coll.find().iterator();
		try {
		    while (cursor.hasNext()) 
		    {
		        System.out.println(cursor.next());
		    }
		}
		finally 
		{
		    cursor.close();
		}
		mC.close();
		getQuote();
	}
	public static void setQuote(Boolean occupationIn, Boolean conditionIn)
	{
		Boolean occupation = occupationIn;
		Boolean condition = conditionIn;
		/*update quote if occupation is selected*/
		if(occupation == true)
		{
			quote = quote + quote/10;
		}
		/*update quote if condition is selected*/
		if(condition == true)
		{
			quote = quote + quote/10;
		}
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("DawgHealth");
        
        /*filter the collection by name*/
        Bson filter = new Document("FName", "Hughie");
        /*set the new value*/
        Bson newQuote = new Document("Quote", 2.0);
        /*update the document*/
        Bson updateDocument = new Document("$set", newQuote);
        collection.updateOne(filter, updateDocument);
        mongoClient.close();
	}
	public static String getQuote() 
	{
		String sQ = null;
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("DawgHealth");
        
        /*filter by name and only show the field "Quote"*/
        FindIterable<Document> it = collection.find(eq("FName", "Hughie"))
        		.projection(fields(include("Quote"),excludeId()));
        ArrayList<Document> docs = new ArrayList<Document>();       
        it.into(docs);
        /*set value to String variable*/
       for (Document doc : docs) 
        {
        	sQ = doc.toString();
/*        	print for testing
            System.out.println(sQ);*/
        }     
        mongoClient.close();
        return sQ;
	}
}
