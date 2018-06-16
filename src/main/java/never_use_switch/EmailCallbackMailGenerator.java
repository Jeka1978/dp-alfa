package never_use_switch;

import lombok.SneakyThrows;

/**
 * @author Evgeny Borisov
 */
@MailCode(2)
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        //60 lines of code
        return "<html> don't call us we call you</html>";
    }
}
