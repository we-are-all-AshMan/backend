package cn.edu.whu.ashman.service.Impl;

import bitoflife.chatterbean.AliceBot;
import cn.edu.whu.ashman.service.IChat;
import cn.edu.whu.ashman.service.Impl.Mother;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Chat implements IChat {
    public static final String END = "bye";

    @Autowired
    Mother mother = null;
    /**
     * public static String input()
     * {
     * BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     * String input = "";
     * try
     * {
     * input = in.readLine();
     * } catch (IOException e) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * }
     * return input;
     * }
     */

    public String getRespond(String message) throws Exception {
        //Mother mother = new Mother();
        mother.setUp();
        AliceBot bot = mother.newInstance();
        //System.err.println("Alice>" + bot.respond("welcome"));
        //String input = Chat.input();
        //if (Chat.END.equalsIgnoreCase(input))
        //System.err.println("Alice>" + bot.respond(input));

        return bot.respond(message);
    }

}
