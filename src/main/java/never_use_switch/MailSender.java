package never_use_switch;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class MailSender {
    private final static Logger LOG = LoggerFactory.getLogger(MailSender.class);

    private Map<Integer, MailGenerator> map = new HashMap<>();

    @SneakyThrows
    public MailSender() {
        Reflections scanner = new Reflections("never_use_switch");
        Set<Class<? extends MailGenerator>> classes = scanner.getSubTypesOf(MailGenerator.class);
        for (Class<? extends MailGenerator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                MailGenerator mailGenerator = aClass.newInstance();
                MailCode annotation = aClass.getAnnotation(MailCode.class);
                if (annotation == null) {
                    throw new IllegalStateException("mail generator class " + aClass + " should be marked with " + MailCode.class.getName());
                }
                int mailCode = annotation.value();
                if (map.containsKey(mailCode)) {
                    throw new RuntimeException(mailCode + " already in use");
                }
                map.put(mailCode, mailGenerator);

            }
        }
    }

    public void sendMail() {


        MailInfo mailInfo = DBUtils.getMailInfo();
        int mailCode = mailInfo.getMailCode();
        MailGenerator mailGenerator = map.getOrDefault(mailCode, () -> {
            throw new UnsupportedOperationException(mailCode + " not supported yet");
        });
        String html = mailGenerator.generateHtml();
        send(html);

    }

    private void send(String html) {
        System.out.println("sending... " + html);
    }
}
















