package com.chargebeeExercises.criteria;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.chargebeeExercises.enums.LogicalCondition;

public class CriteriaBuilder {
	private final List<Boolean> critList;
	private final LogicalCondition lcond;
	private final Map<String, String> critDataMap;

	public CriteriaBuilder(LogicalCondition lcond, Map<String, String> critDataMap) {
		this.critList = new ArrayList<>();
		this.lcond = lcond;
		this.critDataMap = critDataMap;
		System.out.println("---CriteriaBuilder Objects---");
		System.out.println("Logical Condition --> " + lcond);
		System.out.println("Input Map --> " + critDataMap);
		System.out.println("---INITIALISATION DONE---");
	}

	public boolean isKeyExists(String key) {
		return critDataMap.containsKey(key);
	}

	public CriteriaBuilder EQ(String key, String compareValue) {
		if (isKeyExists(key)) {
			boolean result = critDataMap.get(key).compareTo(compareValue) == 0;
			this.critList.add(result);
		}
		return this;
	}

	public CriteriaBuilder NEQ(String key, String compareValue) {
		if (isKeyExists(key)) {
			boolean result = critDataMap.get(key).compareTo(compareValue) == 0;
			this.critList.add(!result);
		}
		return this;
	}

	public CriteriaBuilder GT(String key, String compareValue) {
		if (isKeyExists(key)) {
			boolean result = critDataMap.get(key).compareTo(compareValue) < 0;
			this.critList.add(result);
		}
		return this;
	}

	public CriteriaBuilder GTE(String key, String compareValue) {
		if (isKeyExists(key)) {
			boolean result = critDataMap.get(key).compareTo(compareValue) <= 0;
			this.critList.add(result);
		}
		return this;
	}

	public CriteriaBuilder LT(String key, String compareValue) {
		if (isKeyExists(key)) {
			boolean result = critDataMap.get(key).compareTo(compareValue) > 0;
			this.critList.add(result);
		}
		return this;
	}

	public CriteriaBuilder LTE(String key, String compareValue) {
		if (isKeyExists(key)) {
			boolean result = critDataMap.get(key).compareTo(compareValue) >= 0;
			this.critList.add(result);
		}
		return this;
	}

	public CriteriaBuilder IN(String key, Date... values) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		boolean result = false;
		try {
			Date check = sdf.parse(critDataMap.get(key));
			for (Date value : values) {
				result = value.compareTo(check) == 0;
			}
			this.critList.add(result);
		} catch (ParseException e) {
			// FIXME Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public CriteriaBuilder IN(String key, String... values) {
		if (isKeyExists(key)) {
			boolean result = false;
			for (String value : values) {
				result = critDataMap.get(key).compareTo(value) >= 0;
				if (result) {
					break;
				}
			}
			this.critList.add(result);
		}
		return this;
	}

	public CriteriaBuilder BETWEEN(String key, Date start, Date end) {
		if (isKeyExists(key)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date check = sdf.parse(critDataMap.get(key));
				boolean result = (start.before(check) && end.after(check));
				this.critList.add(result);
			} catch (ParseException e) {
				//
			}
		}
		return this;
	}

	public CriteriaBuilder BETWEEN(String key, String start, String end) {
		if (isKeyExists(key)) {
			boolean result = (critDataMap.get(key).compareTo(start) >= 0 && critDataMap.get(key).compareTo(end) < 0);
			this.critList.add(result);
		}
		return this;
	}

	public boolean execute() {
		boolean result = false;
		for (Boolean crit : critList) {
			result = crit;
			if ((lcond.equals(LogicalCondition.OR) && result) || (lcond.equals(LogicalCondition.AND) && !result)) {
				return result;
			}
		}
		return result;
	}

	public void println() {
		System.out.println("---CriteriaBuilder Objects---");
		System.out.println(lcond + " " + critList);
		System.out.println(this.execute());
	}
}
