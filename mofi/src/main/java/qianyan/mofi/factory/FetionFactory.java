package qianyan.mofi.factory;

import net.solosky.litefetion.LiteFetion;

public class FetionFactory {
	
	private static LiteFetion client;
	
	public static synchronized LiteFetion getInstance(){
		if(client==null){
			client = new LiteFetion();
		}
		
		return client;
	}
	
	
}
