package com.example.andrew.testsystem.Models;

/**
 * Created by Andrew on 18.12.2016.
 */

public class TestItem {

    public static final String TEST_ID = "test_id";
    public static final String IMAGE = "image";
    public static final String QUESTION = "question";
    public static final String CORRECT_ANSWER = "correct_answer";
    public static final String WRONG_ANSWER_1 = "wrong_answer_1";
    public static final String WRONG_ANSWER_2 = "wrong_answer_2";
    public static final String WRONG_ANSWER_3 = "wrong_answer_3";

    private long _testId;
    private String _image;
    private String _question;
    private String _correctAnswer;
    private String _wrongAnswer1;
    private String _wrongAnswer2;
    private String _wrongAnswer3;

    public TestItem(
            long testId,
            String image,
            String question,
            String correctAnswer,
            String wrongAnswer1,
            String wrongAnswer2,
            String wrongAnswer3) {
        this._testId = testId;
        this._image = image;
        this._question = question;
        this._correctAnswer = correctAnswer;
        this._wrongAnswer1 = wrongAnswer1;
        this._wrongAnswer2 = wrongAnswer2;
        this._wrongAnswer3 = wrongAnswer3;
    }

    public long getTestId() {
        return _testId;
    }

    public String getImage() {
        return _image;
    }

    public String getQuestion() {
        return _question;
    }

    public String getCorrectAnswer() {
        return _correctAnswer;
    }

    public String getWrongAnswer1() {
        return _wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return _wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return _wrongAnswer3;
    }
}
