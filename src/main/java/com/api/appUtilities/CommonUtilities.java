package com.api.appUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;

public class CommonUtilities {

	public  String replaceJsonValues(String filePath, HashMap<String, String> replaceValues) throws IOException {

		String jsonFilePath = getFilePath(filePath);
		String replace = convertJsonBodyToString(jsonFilePath);
		for (String keyname : replaceValues.keySet()) {
			replace = replace.replace(keyname, replaceValues.get(keyname));
		}
		return replace;
	}

	private  String getFilePath(String filePath) {
		String jsonData = filePath.toString();
		return jsonData;
	}

	private  String convertJsonBodyToString(String jsonFilePath) throws IOException {
		String jsonBody = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
		return jsonBody;
	}

	public Properties getProperies(String filePath) throws IOException {

		Properties prop = new Properties();
		FileInputStream inputStream = new FileInputStream(filePath);
		prop.load(inputStream);
		return prop;
	}
}
