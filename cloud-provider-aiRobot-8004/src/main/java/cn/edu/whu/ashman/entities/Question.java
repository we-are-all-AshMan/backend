package cn.edu.whu.ashman.entities;

import java.util.Date;

/**
 * @Author LiuWeiFan
 * @create 2020/7/15 15:26
 */
public class Question implements Comparable<Question> {
    private int id;
    private String question;
    private String answer;
    private int askTimes;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAskTimes() {
        return askTimes;
    }

    public void setAskTimes(int askTimes) {
        this.askTimes = askTimes;
    }

    public Question(String question, int askTimes) {
        this.question = question;
        this.askTimes = askTimes;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", askTimes=" + askTimes +
                '}';
    }

    @Override
    public int compareTo(Question question) {
        return this.askTimes - question.getAskTimes();
    }
}
