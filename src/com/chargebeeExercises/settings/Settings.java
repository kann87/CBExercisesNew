package com.chargebeeExercises.settings;

import java.util.Date;

import com.chargebeeExercises.criteria.CriteriaBuilder;

public abstract class Settings<T> {
    public abstract void putLong(String key, long value);
    public abstract long getLong(String key, long defaultVal);
    public abstract void putInt(String key, int value);
    public abstract int getInt(String key, int defaultVal);
    public abstract void putDouble(String key, double value);
    public abstract double getDouble(String key, double defaultVal);
    public abstract void putBoolean(String key, boolean value);
    public abstract boolean getBoolean(String key, boolean defaultVal);
    public abstract void putDate(String key, Date value);
    public abstract Date getDate(String key, Date defaultVal);
    public abstract void put(String key, String value);
    public abstract String get(String key, String defaultVal);
    
    public abstract void remove(String key);
    public abstract void printLog();
    
    public abstract CriteriaBuilder andCriteria();
    public abstract CriteriaBuilder orCriteria();
    
    //Printing the Data
    public abstract void println();
    public abstract int size();
}
