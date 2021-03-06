package gov.mef.gfa.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MapperUtils {
	
	public static <T,E> T copyProperties(E from, Class<T> to) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SZ").create();			
		return gson.fromJson(gson.toJson(from), to);
	}

}
