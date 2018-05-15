import com.zww.cloud.MessageApplication;
import com.zww.cloud.sender.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by RogueZww on 2018/4/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MessageApplication.class)
public class MessageApplicationTest {

    @Autowired
    private MessageSender messageSender;

    @Test
    public void testRabbitNoMessage() throws Exception {
        messageSender.send(null);
    }

    @Test
    public void testRabbitWithMessage() throws Exception {
        messageSender.send("Basic+note");
    }

}
