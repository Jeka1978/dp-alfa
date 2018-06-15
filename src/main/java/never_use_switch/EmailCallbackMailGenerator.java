package never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        //60 lines of code
        return "<html> don't call us we call you</html>";
    }
}
