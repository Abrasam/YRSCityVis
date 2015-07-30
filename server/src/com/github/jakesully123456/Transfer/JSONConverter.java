package com.github.jakesully123456.Transfer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class JSONConverter {
	public static String parseArray(int[][] array) {
		Gson gson = new Gson();
		List<String> parent = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			String child = gson.toJson(array[i]);
			parent.add(child);
		}
		System.out.println(gson.toJson(parent));
		return gson.toJson(parent);
	}
	
	//Thanks open data for this function.
	@SuppressWarnings("rawtypes")
	public static String toString(Object object) {
		if(object instanceof String) return (String) "\""+object+"\"";
		if(object instanceof Integer) return Integer.toString((Integer)object);
		if(object instanceof Float) return Float.toString((Float)object);
		if(object instanceof Boolean) return ((Boolean)object)?"TRUE":"FALSE";

		if(object instanceof Map<?,?>) {
			String jmap = "{";
			for(Object key : ((Map)object).keySet()) {
				jmap = jmap + toString(key);
				jmap = jmap + ":";
				jmap = jmap + toString(((Map)object).get(key));
				jmap = jmap + ",";
			}
			jmap = jmap.substring(0, jmap.length()-1);
			jmap = jmap + "}";
			return jmap;
		}

		if(object.getClass().isArray()) {
			String array = "[";
			for(Object obj : toObjectArray(object)) {
				array = array + toString(obj);
				array = array + ",";
			}
			array = array.substring(0,array.length()-1);
			array = array + "]";
			return array;
		}

		if(object instanceof Iterable<?>) {
			String array = "[";
			for(Object obj : ((Iterable)object)) {
				array = array + toString(obj);
				array = array + ",";
			}
			array = array.substring(0,array.length()-1);
			array = array + "]";
			return array;
		}
		return object.toString();
	}
	
	public static Object[] toObjectArray(Object array) {
	    int length = Array.getLength(array);
	    Object[] ret = new Object[length];
	    for(int i = 0; i < length; i++)
	        ret[i] = Array.get(array, i);
	    return ret;
	}
}
