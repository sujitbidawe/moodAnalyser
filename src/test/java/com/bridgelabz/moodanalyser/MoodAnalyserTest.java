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
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.getMoodAnalyserObject();
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        Assert.assertTrue(moodAnalyser.equals(moodAnalyserObject));
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
}

