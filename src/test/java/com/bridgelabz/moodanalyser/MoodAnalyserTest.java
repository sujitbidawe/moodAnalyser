package com.bridgelabz.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenSadMessage_shouldReturnSadMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("i am in sad");
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenHappyMessage_shouldReturnHappyMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("i am in any mood");
        Assert.assertEquals("HAPPY", mood);
    }
}

