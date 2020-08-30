package com.chargebeeExercises.settings.system;

import com.chargebeeExercises.enums.SettingsDevice;
import com.chargebeeExercises.enums.SettingsType;

public class MacSettings extends SystemSettings {
	public MacSettings() {
		super(SettingsDevice.MACOS, SettingsType.LOCAL);
		super.addDateFormat("dd/MM/yyyy"); //dd/MM/yyyy
		// TODO Auto-generated constructor stub
	}	
}
