package com.bridgelabz.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenSadMessage_shouldReturnSadMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenHappyMessage_shouldReturnHappyMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in any mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenNullMessage_shouldReturnHappyMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }
}

