package com.bridgelabz.moodanalyser;

public class MoodAnalyser {
    String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (this.message.length() < 1){
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EMPTY,"Empty message");
            }

            if (this.message.contains("sad")) {
                return "SAD";
            }

            if(this.message.contains("happy")) {
                return "HAPPY";
            }

        }catch (NullPointerException NullPointerException){
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NULL,"Invalid message");
        }
        return null;
    }
}
