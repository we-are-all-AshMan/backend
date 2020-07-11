package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.MessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.whu.ashman.service.Impl.Chat;

/**
 * @Author Liu WeiFan
 * @create 2020年7月11日 20：56
 */
@RestController
public class ChatRobotController {

    @Autowired
    Chat chat = null;

    @GetMapping("/chattingRobot/{message}")
    public MessageResult getRespond(@PathVariable("message") String message) {
        MessageResult messageResult = null;
        try {
            String respond = chat.getRespond(message);
            messageResult = new MessageResult(303, respond);
        } catch (Exception e) {
            messageResult = new MessageResult(304, "服务器异常");
        }
        return messageResult;
    }

    @GetMapping("/chattingRobot/predict/{message}")
    public MessageResult getPredictQuestion(@PathVariable("message") String message) {
        MessageResult messageResult = null;
        try {
            messageResult = new MessageResult(305, chat.getSimilarQuestion(message));
        } catch (Exception e) {
            messageResult = new MessageResult(304, "服务器异常");
        }
        return messageResult;
    }
}
