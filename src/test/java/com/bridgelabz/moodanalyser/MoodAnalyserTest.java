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
        try {
            MoodAnalyserFactory.getMoodAnalyserObject("com.bridgelabz.moodanalyser.MoodAnalyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Invalid class name", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyser_whenInvalidConstructor_shouldThrowNoSuchMethodException() {
        try {
            MoodAnalyserFactory.getMoodAnalyserObjectForMethodError("com.bridgelabz.moodanalyser.MoodAnalyser", "I am sad today");
        } catch (MoodAnalysisException e) {
            Assert.assertTrue(MoodAnalysisException.ExceptionType.INVALIDCONSTRUCTOR.equals(e.type));
        }
    }
}

