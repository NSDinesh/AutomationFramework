package com.nsd.environmentData;

import java.util.HashMap;
import java.util.Map;

public final class EnvironmentDataManager {
	
	private EnvironmentDataManager() {
		
	}
	
	private static ThreadLocal<Map<EnvironmentData, String>> map = InheritableThreadLocal.withInitial(HashMap::new);

	/**
     * @param key   - Key of the data entry
     * @param value - value of the Data entry
     */
    public static void put(EnvironmentData key, String value) {
        if (key != null && value != null)  {
            map.get().put(key, value);
        }
    }

    /**
     * @param key - Key of the data entry to remove
     * @return The value of the entry removed. Null if no entry.
     */
    public static String remove(EnvironmentData key) {
        if (key != null) {
            return map.get().remove(key);
        }
        return "";
    }

    /**
     * @param key - Key of the data entry whose value is needed
     * @return The value corresponding to the key. null if there is no value stored
     */
    public static String get(EnvironmentData key) {
        if (key != null) {
            return map.get().get(key);
        }
        return "";
    }

}
