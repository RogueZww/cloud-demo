import com.zww.cloud.StreamApplication;
import com.zww.cloud.receiver.sender.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by RogueZww on 2018/5/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StreamApplication.class)
@WebAppConfiguration
public class SenderTest {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void testTT(){
        sinkSender.output().send(MessageBuilder.withPayload("From payload").build());
    }


}
