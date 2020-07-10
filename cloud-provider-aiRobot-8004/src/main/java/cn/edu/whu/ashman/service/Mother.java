package cn.edu.whu.ashman.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.parser.AliceBotParser;
import bitoflife.chatterbean.util.Searcher;
import org.springframework.stereotype.Service;

@Service
public class Mother {
    private ByteArrayOutputStream gossip;


    public void setUp() {
        gossip = new ByteArrayOutputStream();
    }

    public String gossip() {
        return gossip.toString();
    }

    public AliceBot newInstance() throws Exception {
        Searcher searcher = new Searcher();
        AliceBotParser parser = new AliceBotParser();
        File textFile = new File("textFile.txt");
        System.out.println(textFile.getAbsolutePath());
        AliceBot bot = parser.parse(new FileInputStream("Bots/context.xml"),
                new FileInputStream("Bots/splitters.xml"),
                new FileInputStream("Bots/substitutions.xml"),
                searcher.search("Bots/mydomain", ".*\\.aiml"));

        Context context = bot.getContext();
        context.outputStream(gossip);
        //System.out.println("handler:"+bot.getGraphmaster().match(match)toString());
        return bot;
    }
}
