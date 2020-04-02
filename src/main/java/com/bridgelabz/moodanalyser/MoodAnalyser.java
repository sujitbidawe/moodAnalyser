package com.bridgelabz.moodanalyser;

public class MoodAnalyser {

    //public MoodAnalyser(String)

    public String analyseMood(String message) {
        if (message.contains("sad"))
            return "SAD";
        return "HAPPY";
    }
}
