package bsmall.cart;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

public class MyCartList {
	
	private Map<Integer,Integer> orderlists = null;
	
	public MyCartList() {
		orderlists = new HashMap<Integer,Integer>();
	}
	
	public void AddOrder(int bnum,int oqty) {
		if(orderlists.containsKey(bnum)==false) { 
			orderlists.put(bnum, oqty);
		}
		else {
			int oldoqty = orderlists.get(bnum);
			orderlists.put(bnum, oldoqty+oqty);
		}
	}
	
	public Map<Integer,Integer> getAllOrder(){
		return orderlists;
	}
	
}
