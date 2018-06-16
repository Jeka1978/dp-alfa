package never_use_switch;

/**
 * @author Evgeny Borisov
 */
@MailCode(1)
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        //60 lines of code
        return "<html> welcome!!!</html>";
    }
}
