package com.chargebeeExercises.settings.system;

import com.chargebeeExercises.enums.SettingsDevice;
import com.chargebeeExercises.enums.SettingsType;

public class WindowSettings extends SystemSettings{
	public WindowSettings() {
		super(SettingsDevice.WINDOWS, SettingsType.LOCAL);
		super.addDateFormat("dd/MM/yyyy"); //dd/MM/yyyy
		// TODO Auto-generated constructor stub
	}	
}
