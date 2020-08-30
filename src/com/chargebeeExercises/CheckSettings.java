package com.chargebeeExercises;

import java.util.Date;

import com.chargebeeExercises.settings.AbstractSettings;
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
		Settings<AbstractSettings> system = new MacSettings();
		Settings<AbstractSettings> system1 = new WindowSettings();
		for (int i = 0; i < 100; i++) {
			system.putLong("Conf" + i, i);
		}

		for (int i = 1; i < 100; i++) {
			if (i > 0 && i < 30) {
				String aDate = "0" + i + "/07/2020";
				system1.putDate("Conf" + i, new Date(aDate));
			} else {
				system1.putLong("Conf" + i, i);
			}
		}
		
//		
//		
//		system1.println();
//		system1.andCriteria().IN("Conf4", "2020-07-05", "2020-07-08").println();
//		system.put("Conf1", "2");
//		system.putLong("Conf2", 2);
//		system.putInt("Conf3", 2);
//		system.putDate("Conf4", new Date("08/07/2020"));
//		system.getDate("Conf4", new Date("09/07/2020"));
//
//		system.andCriteria().BETWEEN("Conf4", "2020-08-05", "2020-08-08").println();
//		system.andCriteria().BETWEEN("Conf2", "1", "5").println();
//		system.andCriteria().NEQ("Conf4", "2020-08-07").println();

//		system.println();

//		System.out.println(system.getDate("Conf5", new Date("09/07/2020")));
	}
}
