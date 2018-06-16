package never_use_switch;

import lombok.SneakyThrows;
import lombok_examples.Person;

import java.time.LocalDate;

/**
 * @author Evgeny Borisov
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {


        MailSender mailSender = new MailSender();
        while (true) {
            try {
                mailSender.sendMail();
            } catch (Exception e) {
                System.out.println(e);
            }
            Thread.sleep(1000);
        }
    }
}
