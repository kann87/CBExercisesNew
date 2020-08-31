package com.chargebeeExercises.settings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import com.chargebeeExercises.criteria.CriteriaBuilder;
import com.chargebeeExercises.enums.LogicalCondition;
import com.chargebeeExercises.enums.SettingsDevice;
import com.chargebeeExercises.enums.SettingsType;

public abstract class AbstractSettings extends Settings {
	private final Map<String, String> dataMap;
	private final Map<Long, String> auditMap;
	private final SettingsDevice deviceName; // MacOs, Windows, Linux...
	private final SettingsType deviceType; // Virtual, Local...
	private SimpleDateFormat systemDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final int MAX_SIZE = 100; // Entry Limit

	public AbstractSettings(SettingsDevice deviceName, SettingsType deviceType) {
		// TODO Auto-generated constructor stub
		this.dataMap = new ConcurrentHashMap<>();
		this.auditMap = new TreeMap<>();
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		System.out.println("INITIATED the data storages -->" + dataMap + "-->" + auditMap);
		System.out.println("INITIATED For the System Configurations -->" + deviceName + "," + deviceType);
		System.out.println(this.hashCode());
		System.out.println("---INITIALISATION DONE---");
	}

	public AbstractSettings addDateFormat(String pattern) {
		this.systemDateFormat = new SimpleDateFormat(pattern);
		return this;
	}

	@Override
	public void putLong(String key, long value) {
		put(key, Long.toString(value));
	}

	@Override
	public long getLong(String key, long defaultVal) {

		try {
			String value = get(key, null);
			if (value != null)
				return Long.parseLong(value);
		} catch (NumberFormatException e) {
			// No Action required as returning the default value
		}
		return defaultVal;
	}

	@Override
	public void putInt(String key, int value) {
		put(key, Integer.toString(value));
	}

	@Override
	public int getInt(String key, int defaultVal) {

		try {
			String value = get(key, null);
			if (value != null)
				return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			// No Action required as returning the default value
		}
		return defaultVal;
	}

	@Override
	public void put(String key, String value) {
		if(this.size() > MAX_SIZE) {
			throw new RuntimeException("Size Exceeded");
		}
		
		try {
			dataMap.put(key, value);
			Thread.sleep(1); // added temp to avoid the data overwrites
			auditMap.put(System.currentTimeMillis(), key + "," + value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String get(String key, String defaultVal) {

		if (key == null) {
			throw new NullPointerException("Invalid key");
		}

		try {
			return dataMap.getOrDefault(key, defaultVal);
		} catch (Exception e) {
			// No action required
		}
		return defaultVal;
	}

	@Override
	public void printLog() {

		auditMap.forEach((k, v) -> System.out.println("Action time ->" + k + " Data->" + v));
	}

	@Override
	public void putDouble(String key, double value) {

		put(key, Double.toString(value));
	}

	@Override
	public double getDouble(String key, double defaultVal) {

		try {
			String value = get(key, null);
			if (value != null)
				return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			// No Action required as returning the default value
		}
		return defaultVal;
	}

	@Override
	public void putDate(String key, Date value) {
		put(key, systemDateFormat.format(value));
	}

	@Override
	public Date getDate(String key, Date defaultVal) {
		try {
			String value = get(key, null);
			if (value != null) {
				return systemDateFormat.parse(value);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
		}
		return defaultVal;
	}

	@Override
	public void putBoolean(String key, boolean value) {
		put(key, Boolean.toString(value));
	}

	@Override
	public boolean getBoolean(String key, boolean defaultVal) {
		try {
			String value = get(key, null);
			if (value != null)
				return Boolean.parseBoolean(value);
		} catch (NumberFormatException e) {
			// No Action required as returning the default value
		}
		return defaultVal;
	}

	@Override
	public void remove(String key) {

		if (dataMap.containsKey(key)) {
			dataMap.remove(key);
		}
	}

	@Override
	public CriteriaBuilder andCriteria() {
		if(size()==0) {
			throw new RuntimeException("Empty map");
		}
		return new CriteriaBuilder(LogicalCondition.AND, dataMap);
	}

	@Override
	public CriteriaBuilder orCriteria() {
		if(size()==0) {
			throw new RuntimeException("Empty map");
		}
		return new CriteriaBuilder(LogicalCondition.OR, this.dataMap);
	}

	@Override
	public void println() {
		System.out.println(dataMap.toString());
		System.out.println(dataMap.size());
	}

	@Override
	public int size() {
		return dataMap.size();
	}
}
