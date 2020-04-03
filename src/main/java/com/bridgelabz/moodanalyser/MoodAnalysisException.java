package com.bridgelabz.moodanalyser;

public class MoodAnalysisException extends Exception{
    public enum ExceptionType{
        EMPTY, NULL, CLASSNOTFOUND, INVALIDCONSTRUCTOR;
    }

    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message ){
        super(message);
        this.type = type;
    }
}
