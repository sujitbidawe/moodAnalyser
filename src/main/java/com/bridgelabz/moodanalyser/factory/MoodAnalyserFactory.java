package com.bridgelabz.moodanalyser.factory;

import com.bridgelabz.moodanalyser.MoodAnalyser;
import com.bridgelabz.moodanalyser.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser getMoodAnalyserObject() {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser").getConstructor();
            Object reflectionObject = constructor.newInstance();
            return  (MoodAnalyser) reflectionObject;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor<?> getMoodAnalyserObject(String className, Class<?> ... param )
            throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASSNOTFOUND,"Class not found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.INVALIDCONSTRUCTOR,"METHOD not found");
        }
    }

    public static MoodAnalyser getMoodAnalyserObject(String className, String param)
            throws MoodAnalysisException {
        try {
            Constructor constructor = Class.forName(className).getConstructor(String.class);
            Object reflectionObject = constructor.newInstance(param);
            return  (MoodAnalyser) reflectionObject;
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.INVALIDCONSTRUCTOR,
                    "No such method");
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASSNOTFOUND,
                    "Invalid class name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
