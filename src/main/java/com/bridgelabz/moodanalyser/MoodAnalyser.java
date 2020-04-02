package com.bridgelabz.moodanalyser;

public class MoodAnalyser {
    String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() {
        try {
            if (this.message.contains("sad"))
                return "SAD";
            return "HAPPY";
        }catch (NullPointerException NullPointerException){
            return "HAPPY";
        }
    }
}
