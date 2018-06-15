package never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class MailSender {



    public void sendMail() {
        MailInfo mailInfo = DBUtils.getMailInfo();
        switch (mailInfo.getMailCode()) {
            case 1:
                // 60 lines of code which will generate and send welcome mail
                System.out.println("Welcome mail was sent");
                break;
            case 2:
                // 90 lines of code
                System.out.println("mail: don't call us, we call you was sent");
                break;
        }
    }
}
