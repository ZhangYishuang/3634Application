package com.example.shuhao20.finalapplication;

public class Quiz {
    private int quizId;
    private String desc;
    private String rightOption;
    private String[] wrongOptions;
    private int chapter;
    private String explanation;

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getQuizId() {
        return quizId;
    }
    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getRightOption() {
        return rightOption;
    }

    public void setRightOption(String rightOption) {
        this.rightOption = rightOption;
    }
    public String[] getWrongOptions() {
        return wrongOptions;
    }
    public void setWrongOptions(String[] wrongOptions) {
        this.wrongOptions = wrongOptions;
    }
    public int getChapter() {
        return chapter;
    }
    public void setChapter(int chapter) {
        this.chapter = chapter;
    }
}
