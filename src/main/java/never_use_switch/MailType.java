package never_use_switch;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author Evgeny Borisov
 */
@RequiredArgsConstructor
@Getter
public enum MailType {
    WELCOME(1, new WelcomeMailGenerator()),
    EMAIL_CALLBACK(2, new EmailCallbackMailGenerator());









    private final int mailCode;
    private final MailGenerator mailGenerator;


    public static MailType findByMailCode(int dbCode) throws RuntimeException {
        return Arrays.stream(values()).filter(mailType -> mailType.mailCode == dbCode)
                .findAny().orElseThrow(() -> new UnsupportedOperationException(dbCode + " not supportefd yet"));


    }

















}
