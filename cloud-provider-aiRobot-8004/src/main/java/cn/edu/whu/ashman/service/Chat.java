package cn.edu.whu.ashman.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bitoflife.chatterbean.AliceBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Chat {
    public static final String END = "bye";

    @Autowired
    public static Mother mother;
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

    public static String getRespone(String message) throws Exception {
        //Mother mother = new Mother();
        mother.setUp();
        AliceBot bot = mother.newInstance();
        //System.err.println("Alice>" + bot.respond("welcome"));
        //String input = Chat.input();
        //if (Chat.END.equalsIgnoreCase(input))
        //System.err.println("Alice>" + bot.respond(input));
        String input = message;

        return bot.respond(input);
    }

}

