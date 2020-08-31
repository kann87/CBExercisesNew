package com.chargebeeExercises;

import java.util.Date;

import com.chargebeeExercises.settings.Settings;
import com.chargebeeExercises.settings.system.MacSettings;
import com.chargebeeExercises.settings.system.WindowSettings;

public class CheckSettings {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Settings macSettings = new MacSettings();
		Settings windowSettings = new WindowSettings();
		
		for (int i = 0; i < 100; i++) {
			macSettings.putLong("Conf" + i, i);
		}

		for (int i = 1; i < 100; i++) {
			if (i > 0 && i < 30) {
				String aDate = "0" + i + "/07/2020";
				windowSettings.putDate("Conf" + i, new Date(aDate));
			} else {
				windowSettings.putLong("Conf" + i, i);
			}
		}

		macSettings
			.andCriteria() // returns true if all below conditions are valid
			.EQ("Conf2", "2") // EQUALS
			.NEQ("Conf10", "11") // NOT EQUALS
			.BETWEEN("Conf50", "49", "51") // BETWEEN
			.IN("Conf90", "89", "90", "91") // IN Clause
			.GTE("Conf60","61") // GREATER THAN OR EQUAL
			.LT("Conf60","59") // LESSER THAN
			.println();	// will execute() and print in console	
	}
}
