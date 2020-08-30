package com.chargebeeExercises.settings.system;

import com.chargebeeExercises.enums.SettingsDevice;
import com.chargebeeExercises.enums.SettingsType;
import com.chargebeeExercises.settings.AbstractSettings;

public class SystemSettings extends AbstractSettings {

	public SystemSettings(SettingsDevice deviceName, SettingsType deviceType) {
		super(deviceName, deviceType);
		// FIXME Auto-generated constructor stub
	}
	
	@Override
	public void println() {
		// To add custom prints
		System.out.println("OVerrided Print");
		super.println();
	}

}
