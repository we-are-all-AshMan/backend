package cn.edu.whu.ashman.service.Impl;

import cn.edu.whu.ashman.dao.IQuestionDao;
import cn.edu.whu.ashman.entities.Question;
import cn.edu.whu.ashman.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * @Author LiuWeiFan
 * @create 2020/7/15 16:50
 */
@Service
public class QuestionService implements IQuestionService {
    @Autowired
    IQuestionDao questionDao = null;

    List<Question> questions = null;

    /**
     * Question数组转String数组
     *
     * @param questionList
     * @return
     */
    private List<String> QuestionsToString(List<Question> questionList) {
        List<String> result = new ArrayList<String>();
        for (Question q : questionList) {
            result.add(q.getQuestion());
        }
        return result;
    }

    /**
     * 获得热门的话题
     * @return public List<String> getHotQuestion(){
    questions = selectAllQuestions();
    Collections.sort(questions);
    List<String> result = new ArrayList<String>();
    if(questions.size() < 6){
    return QuestionsToString(questions);
    }else {
    return QuestionsToString(questions.subList(0,4));
    }
    }*/
    /**
     * 获得热门话题，演示用
     *
     * @return
     * @throws Exception
     */
    public List<String> getHotQuestion() throws Exception {
        File file = getFile("static/Bots/question.txt");
        System.out.println(file.getAbsolutePath());
        InputStream in = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        List<String> questionList = new ArrayList<String>();
        String line = null;
        for (int i = 0; i < 5;i++){
            line = br.readLine();
            questionList.add(line);
        }
        return questionList;
    }

    /**
     * 读取question.txt文件
     *
     * @param fileName
     * @return
     */
    private File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();

        // getResource()//方法会去classpath下找这个文件，获取到url resource, 得到这个资源后，调用url.getFile获取到 文件 的绝对路径

        URL url = classLoader.getResource(fileName);

        // url.getFile(); //得到这个文件的绝对路径

        System.out.println(url.getFile());
        File file = new File(url.getFile());
        return file;
    }

    /**
     * 管理端添加问题
     *
     * @param question
     * @throws Exception
     */
    public void insertQuestionForAdministrator(String question) throws Exception {
        if (questions.contains(question)) {
            throw new Exception("问题库已包含该问题");
        }
        char[] questionMessage = question.toCharArray();
        /**
         //向文本中添加问题
         File file = getFile("question.txt");
         System.out.println(file.getAbsolutePath());
         OutputStream out = new FileOutputStream(file);
         BufferedWriter br = new BufferedWriter(new OutputStreamWriter(out));
         br.newLine();
         for(char s:questionMessage) {
         br.append(s);
         }*/
        insertQuestion(new Question(question, 0));
    }

    /**
     * 管理端删除问题
     *
     * @return
     */
    public void deleteQuestionForAdministrator(String question) throws Exception {
        if (!questions.contains(question)) {
            throw new Exception("问题库无该问题");
        }
        /**
         File file = getFile("question.txt");
         System.out.println(file.getAbsolutePath());
         InputStream in = new FileInputStream(file);
         BufferedReader br = new BufferedReader(new InputStreamReader(in));
         br.newLine();
         for(char s:questionMessage) {
         br.append(s);*/
        deleteQuestion(new Question(question, 0));
    }

    public void updateAnswer(Question question) throws Exception {
        if (!questions.contains(question)) {
            throw new Exception("问题库无该问题");
        }
        questionDao.updateAnswer(question);
    }

    List<Question> selectAllQuestions() {
        return questionDao.selectAllQuestions();
    }

    public void insertQuestion(Question question) {
        questionDao.insertQuestion(question);
    }

    public void deleteQuestion(Question question) {
        questionDao.deleteQuestion(question);
    }

    public void updateQuestion(Question question) {
        questionDao.updateSetAskTimeIsZero();
    }

    public void updateQuestionPlusOne(String question) {
        questionDao.updateSetAskTimePlusOne(question);
    }
}
