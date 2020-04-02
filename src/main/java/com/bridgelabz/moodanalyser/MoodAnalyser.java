package com.bridgelabz.moodanalyser;

public class MoodAnalyser {
    String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (this.message.contains("sad"))
                return "SAD";
            return "HAPPY";
        }catch (NullPointerException NullPointerException){
            throw new MoodAnalysisException("Invalid message");
        }
    }
}
