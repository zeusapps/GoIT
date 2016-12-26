package com.example.eugen.test.models;

public class TestItem {

    public static final String QUESTIN_EXTRA = "question";
    public static final String CORRECT_ANSWER_EXTRA = "correct_answer";
    public static final String WRONG_ANSWER_1_EXTRA = "wrong_answer_1";
    public static final String WRONG_ANSWER_2_EXTRA = "wrong_answer_2";
    public static final String WRONG_ANSWER_3_EXTRA = "wrong_answer_3";

    private String _question;
    private String _correctAnswer;
    private String _wrongAnswer1;
    private String _wrongAnswer2;

    public TestItem(String question, String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
        _question = question;
        _correctAnswer = correctAnswer;
        _wrongAnswer1 = wrongAnswer1;
        _wrongAnswer2 = wrongAnswer2;
        _wrongAnswer3 = wrongAnswer3;
    }

    private String _wrongAnswer3;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestItem item = (TestItem) o;

        if (_question != null ? !_question.equals(item._question) : item._question != null)
            return false;
        if (_correctAnswer != null ? !_correctAnswer.equals(item._correctAnswer) : item._correctAnswer != null)
            return false;
        if (_wrongAnswer1 != null ? !_wrongAnswer1.equals(item._wrongAnswer1) : item._wrongAnswer1 != null)
            return false;
        if (_wrongAnswer2 != null ? !_wrongAnswer2.equals(item._wrongAnswer2) : item._wrongAnswer2 != null)
            return false;
        return _wrongAnswer3 != null ? _wrongAnswer3.equals(item._wrongAnswer3) : item._wrongAnswer3 == null;

    }

    @Override
    public int hashCode() {
        int result = _question != null ? _question.hashCode() : 0;
        result = 31 * result + (_correctAnswer != null ? _correctAnswer.hashCode() : 0);
        result = 31 * result + (_wrongAnswer1 != null ? _wrongAnswer1.hashCode() : 0);
        result = 31 * result + (_wrongAnswer2 != null ? _wrongAnswer2.hashCode() : 0);
        result = 31 * result + (_wrongAnswer3 != null ? _wrongAnswer3.hashCode() : 0);
        return result;
    }
}
