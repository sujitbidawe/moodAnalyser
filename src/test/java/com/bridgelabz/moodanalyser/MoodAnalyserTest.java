package com.bridgelabz.moodanalyser;

import com.bridgelabz.moodanalyser.factory.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {
    @Test
    public void givenSadMessage_shouldReturnSadMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenHappyMessage_shouldReturnHappyMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in happy mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenNullMessage_whenAnalyseMood_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException moodAnalysisException) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NULL, moodAnalysisException.type);
            Assert.assertEquals("Invalid message", moodAnalysisException.getMessage());
        }
    }

    @Test
    public void givenEmptyMessage_whenAnalyseMood_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException moodAnalysisException) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.EMPTY, moodAnalysisException.type);
        }
    }

    @Test
    public void givenMoodAnalyser_whenProper_shouldReturnObject() {
        MoodAnalyser moodAnalyserObject = null;
        try {
            moodAnalyserObject = MoodAnalyserFactory.getMoodAnalyserObject("com.bridgelabz.moodanalyser.MoodAnalyser");
            MoodAnalyser moodAnalyser = new MoodAnalyser();
            Assert.assertTrue(moodAnalyser.equals(moodAnalyserObject));
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyser_whenImproper_shouldThrowClassNotFoundException() {
        MoodAnalyser moodAnalyserObject = null;
        try {
            moodAnalyserObject = MoodAnalyserFactory.getMoodAnalyserObject("com.bridgelabz.moodanalyser.MoodAnalyser");
            MoodAnalyser moodAnalyser = new MoodAnalyser();

        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Invalid class name", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyser_whenInvalidConstructor_shouldThrowNoSuchMethodException() {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser").getConstructor(String.class, Integer.class);
            Object reflectionObject = constructor.newInstance("I am in Sad mood", 1);
            MoodAnalyser moodAnalyser = (MoodAnalyser) reflectionObject;
            MoodAnalyser realMoodObject = new MoodAnalyser("I am in sad mood");
            boolean result = realMoodObject.equals(moodAnalyser);

        } catch (NoSuchMethodException e) {
            try {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASSNOTFOUND, "Invalid constructor");
            } catch (MoodAnalysisException moodAnalyserException) {
                Assert.assertEquals("Invalid constructor", moodAnalyserException.getMessage());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}

