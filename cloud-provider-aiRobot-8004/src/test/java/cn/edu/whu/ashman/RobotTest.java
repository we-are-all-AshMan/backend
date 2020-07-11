package cn.edu.whu.ashman;


import cn.edu.whu.ashman.service.Impl.Chat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RobotTest {

    @Autowired
    Chat chat = null;


    @Test
    public void testRespond() throws Exception {
        /**
         Mother mother = new Mother();
         //mother.setUp();
         AliceBot bot = mother.newInstance();
         System.err.println("Alice>" + bot.respond("welcome"));
         String input = RobotTest.input();
         while (true) {
         if (Chat.END.equalsIgnoreCase(input)) break;
         System.err.println("Alice>" + bot.respond(input));
         }

         //return bot.respond(input);*/

        System.err.println(chat.getRespond("你是谁"));

    }
}


