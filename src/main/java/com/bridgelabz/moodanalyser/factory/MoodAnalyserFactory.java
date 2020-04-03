package com.bridgelabz.moodanalyser.factory;

import com.bridgelabz.moodanalyser.MoodAnalyser;
import com.bridgelabz.moodanalyser.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser getMoodAnalyserObject(String className) throws MoodAnalysisException {
        try {
            Constructor constructor = Class.forName(className ).getConstructor();
            Object refectionObject = constructor.newInstance();
            return (MoodAnalyser) refectionObject;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASSNOTFOUND, "Invalid class name");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyser getMoodAnalyserObject(String className, String message) throws MoodAnalysisException {
        try {
            Constructor constructor = Class.forName(className).getConstructor(String.class);
            Object reflectionObject = constructor.newInstance(message);
            return (MoodAnalyser) reflectionObject;
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASSNOTFOUND, "Invalid class name");
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
