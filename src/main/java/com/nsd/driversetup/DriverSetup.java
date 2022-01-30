package com.nsd.driversetup;

import com.nsd.constants.ConfigConstants;
import com.nsd.constants.FrameworkConstants;
import com.nsd.driversetup.enums.DriverType;
import com.nsd.environmentData.EnvironmentData;
import com.nsd.environmentData.EnvironmentDataManager;
import com.nsd.utils.PropertiesUtils;

public final class DriverSetup {

	private DriverSetup() {

	}

	public static void setup() {
		if(EnvironmentDataManager.get(EnvironmentData.BROWSER) != null)
			DriverType.valueOf(EnvironmentDataManager.get(EnvironmentData.BROWSER).toUpperCase()).setDriverType();
		else
			DriverType.valueOf(PropertiesUtils.getPropValue(FrameworkConstants.CONFIG_FILE_PATH, ConfigConstants.EXECUTE_ON).
					toUpperCase()).setDriverType();
	}

}
