package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.MessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.whu.ashman.service.Impl.Chat;

@RestController
public class ChatRobotController {

    @Autowired
    Chat chat = null;

    @GetMapping("/chattingRobot/{message}")
    public MessageResult getRespond(@PathVariable("message") String message){
        MessageResult messageResult = null;
        try{
        String respond = chat.getRespond(message);
        messageResult = new MessageResult(303,respond);}
        catch(Exception e)
        {
            messageResult = new MessageResult(304,"服务器异常");
        }
        return messageResult;
    }
}
