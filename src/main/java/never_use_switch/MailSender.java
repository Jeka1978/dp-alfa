package never_use_switch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Evgeny Borisov
 */
public class MailSender {
    private final static Logger LOG = LoggerFactory.getLogger(MailSender.class);


    public void sendMail() {


        MailInfo mailInfo = DBUtils.getMailInfo();
        String html = MailType.findByMailCode(mailInfo.getMailCode()).getMailGenerator().generateHtml();
        send(html);
    }

    private void send(String html) {
        System.out.println("sending... "+html);
    }
}
















