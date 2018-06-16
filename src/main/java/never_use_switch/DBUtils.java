package never_use_switch;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class DBUtils {

    private static Random random = new Random();

    public static MailInfo getMailInfo() {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setMailCode(random.nextInt(3)+1);
        return mailInfo;
    }
}
