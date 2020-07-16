package cn.edu.whu.ashman.service.Impl;import java.io.File;import java.io.FileInputStream;import java.io.ByteArrayOutputStream;import java.io.InputStream;import bitoflife.chatterbean.AliceBot;import bitoflife.chatterbean.Context;import bitoflife.chatterbean.parser.AliceBotParser;import bitoflife.chatterbean.util.Searcher;import cn.edu.whu.ashman.service.IMother;import org.springframework.core.io.ClassPathResource;import org.springframework.stereotype.Component;import org.springframework.stereotype.Service;/** * @Author Liu WeiFan * @create 2020年7月11日 20：56 */@Servicepublic class Mother implements IMother {    private ByteArrayOutputStream gossip;    public void setUp() {        gossip = new ByteArrayOutputStream();    }    public String gossip() {        return gossip.toString();    }    public InputStream getFile(String name) throws Exception {        ClassPathResource resource = new ClassPathResource("static/" + name);        File sourceFile = resource.getFile();        return resource.getInputStream();    }    public AliceBot newInstance() throws Exception {        //Searcher searcher = new Searcher();        AliceBotParser parser = new AliceBotParser();        //File textFile = new File("textFile.txt");        //System.out.println(textFile.getAbsolutePath());        ClassPathResource resource1 = new ClassPathResource("static/Bots/context.xml");        ClassPathResource resource2 = new ClassPathResource("static/Bots/splitters.xml");        ClassPathResource resource3 = new ClassPathResource("static/Bots/substitutions.xml");        ClassPathResource resource4 = new ClassPathResource("static/Bots/mydomain/idiom.aiml");        AliceBot bot = parser.parse(resource1.getInputStream(),                resource2.getInputStream(),                resource3.getInputStream(),                resource4.getInputStream());        Context context = bot.getContext();        context.outputStream(gossip);        //System.out.println("handler:"+bot.getGraphmaster().match(match)toString());        return bot;    }}