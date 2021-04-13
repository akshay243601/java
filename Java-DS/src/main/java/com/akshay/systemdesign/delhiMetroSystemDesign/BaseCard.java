package com.akshay.systemdesign.delhiMetroSystemDesign;

import java.util.HashMap;
import java.util.Map;

public class BaseCard {

	public static final float MIN_CARD_BALANCE = 5.5f;
	public static Map<Integer, Float> farePerDay = new HashMap<Integer, Float>();

	static {
		farePerDay.put(1, 7f);
		farePerDay.put(2, 7f);
		farePerDay.put(3, 7f);
		farePerDay.put(4, 7f);
		farePerDay.put(5, 7f);
		farePerDay.put(6, 5.5f);
		farePerDay.put(7, 5.5f);
	}

}
