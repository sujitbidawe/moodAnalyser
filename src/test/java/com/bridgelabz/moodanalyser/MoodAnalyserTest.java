package com.bridgelabz.moodanalyser;

import com.bridgelabz.moodanalyser.factory.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserTest {
    @Test
    public void givenMessage_whenSad_shouldReturnSad() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad mood");
        Class<?> cls = moodAnalyser.getClass();
        Method methodObject = cls.getDeclaredMethod("analyseMood");
        String mood = (String) methodObject.invoke(moodAnalyser);
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenMessage_whenHappy_shouldReturnHappy() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in happy mood");
        Class<?> cls = moodAnalyser.getClass();
        Method methodObject = cls.getDeclaredMethod("analyseMood");
        String mood = (String) methodObject.invoke(moodAnalyser);
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenMessage_whenAny_shouldReturnHappy() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any mood");
        Class<?> cls = moodAnalyser.getClass();
        Method methodObject = cls.getDeclaredMethod("analyseMood");
        String mood = (String) methodObject.invoke(moodAnalyser);
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenMessage_whenNull_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            String mood = moodAnalyser.analyseMood();
        }catch (MoodAnalysisException moodAnalysisException) {
            Assert.assertEquals("Invalid message", moodAnalysisException.getMessage());

        }
    }

    @Test
    public void givenEmptyMessage_whenAnalyseMood_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException moodAnalysisException) {
            Assert.assertEquals("Empty message", moodAnalysisException.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyser_whenProper_shouldReturnObject() {
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.getMoodAnalyserObject();
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        Assert.assertEquals(moodAnalyser, moodAnalyserObject);
    }

    @Test
    public void givenMoodAnalyser_whenImproper_shouldThrowClassNotFoundException() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getMoodAnalyserObject("CroodAnalyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.CLASSNOTFOUND,e.type);
        }
    }

    @Test
    public void givenMoodAnalyser_whenInvalidConstructor_shouldThrowNoSuchMethodException() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getMoodAnalyserObject("com.bridgelabz." +
                    "moodanalyser.MoodAnalyser", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.INVALIDCONSTRUCTOR,e.type);
        }
    }

    @Test
    public void givenWrongMethodName_shouldThrowException(){
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any mood");
        Class<?> cls = moodAnalyser.getClass();
        Method methodObject = null;
        try {
            methodObject = cls.getDeclaredMethod("returnMood");
        } catch (NoSuchMethodException e) {
            try {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NOSUCHMETHOD, "No Such Method");
            } catch (MoodAnalysisException ex) {
                Assert.assertEquals(MoodAnalysisException.ExceptionType.NOSUCHMETHOD, ex.type);
            }
        }
    }

    @Test
    public void givenFieldName_shouldChangeMoodToHappy() throws NoSuchFieldException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("sad");
        Class<?> cls = moodAnalyser.getClass();
        Field field = cls.getDeclaredField("message");
        field.set(moodAnalyser, "Happy");
        Method methodObject = cls.getDeclaredMethod("analyseMood");
        String mood = (String) methodObject.invoke(moodAnalyser);
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenImproperFieldName_shouldThrowException() throws IllegalAccessException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("sad");
        Class<?> cls = moodAnalyser.getClass();
        Field field = null;
        try {
            field = cls.getDeclaredField("mood");
            field.set(moodAnalyser, "happy");
        } catch (NoSuchFieldException e) {
            try {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NOSUCHFIELD,
                        "No Such Field");
            } catch (MoodAnalysisException ex) {
                Assert.assertEquals(MoodAnalysisException.ExceptionType.NOSUCHFIELD, ex.type);
            }
        }
    }

}

