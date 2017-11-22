/**
 * 
 */
package insuranceProject;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import static com.mongodb.client.model.Filters.*;
/**
 * @author BoyleHugh(L00130487)
 *
 */
public class MongoConnection 
{

	/**
	 * @param args
	 */
	double quote = 0;
	public static void main(String[] args) 
	{
		MongoClient mC = new MongoClient("localhost", 27017);

		String cP = mC.getConnectPoint();
		System.out.println(cP);
		MongoDatabase database = mC.getDatabase("test1");
		for (String name : database.listCollectionNames())
		{
			System.out.println(name);
		}
		MongoCollection<Document> coll = database.getCollection("collection1");
		
		DeleteResult deleteResult = coll.deleteMany(gte("FName", "Hughie"));
		System.out.println(deleteResult.getDeletedCount());
		
		MongoCursor<Document> cursor = coll.find().iterator();
		try {
		    while (cursor.hasNext()) 
		    {
		        System.out.println(cursor.next().toJson());
		    }
		} finally 
		{
		    cursor.close();
		}

		mC.close();
	}
	
}