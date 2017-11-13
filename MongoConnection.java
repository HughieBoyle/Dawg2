/**
 * 
 */
package insuranceProject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @author BoyleHugh(L00130487)
 *
 */
public class MongoConnection 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		MongoClient mC = new MongoClient("localhost", 27017);
		String cP = mC.getConnectPoint();
		System.out.println(cP);
		MongoDatabase database = mC.getDatabase("test1");
		for (String name : database.listCollectionNames()) {
		    System.out.println(name);
		}
		mC.close();

	}

}
