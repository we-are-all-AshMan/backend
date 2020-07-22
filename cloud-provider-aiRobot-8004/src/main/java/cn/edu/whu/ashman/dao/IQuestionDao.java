package cn.edu.whu.ashman.dao;

import cn.edu.whu.ashman.entities.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author LiuWeiFan
 * @create 2020/7/15 15:19
 */

@Repository
@Mapper
public interface IQuestionDao {
    /**
     * 获取所有问题
     * @return
     */
    @Select("select question form questions")
    List<Question> selectAllQuestions();

    @Select("select question from questions where question = #{question}")
    String selectQuestion(String question);

    /**
     * 插入问题
     * @param question
     */
    @Insert("insert questions(question, askTimes, answer) values(#{question},#{askTime},#{answer})")
    void insertQuestion(Question question);

    /**
     * 更新问题，及重复次数
     */
    @Update("update question set askTime = 0")
    void updateSetAskTimeIsZero();

    @Update("update questions set answer=#{answer}")
    void updateAnswer(Question question);

    /**
     * 删除问题
     * @param question
     */
    @Delete("delete question where qustion = #{question}")
    void deleteQuestion(Question question);

    @Update("update questions set askTime = askTime+1 where question=#{question}")
    void updateSetAskTimePlusOne(String question);
}
