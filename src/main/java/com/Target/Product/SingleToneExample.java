package com.Target.Product;

public class SingleToneExample {
	
	private static SingleToneExample instance;
	
	
	private SingleToneExample() {
		
	}
	
	// single check
	public synchronized SingleToneExample getInstance() {
		if(instance == null) {
			instance = new SingleToneExample();
		}
		
		return instance;
	}
	
	
	public  SingleToneExample getInstance() {
		if(instance == null) {
			;
		}
		
		return instance;
	}
	
}



// Trace Id and Pan Id
///Find the repeated more then 3 time 


Select trace_Id, Pan_id, count(*) as Number_Of_Details
from Metadata
Group by trace_ID, Pan_id
Having count(*) > 3;

