package com.api.appUtilities;

import java.io.IOException;
import java.util.Properties;

import com.api.applicationSettings.Settings;

public class Configurations {

	
	public static void setConfigurations() throws IOException {
		
		Properties properties = Settings.utility.getProperies(Settings.configFilePath);
		
		Settings.baseURL = properties.getProperty("baseURL");
	}
}
