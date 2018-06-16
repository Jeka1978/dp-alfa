package strategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

/**
 * @author Evgeny Borisov
 */
@NoArgsConstructor
@AllArgsConstructor
public class RadioAlarm implements Radio,Alarm{

    @Delegate
    private Radio radio = new RadioImpl();
    @Delegate(excludes = RadioAlarmExclusion.class)
    private Alarm alarm = new AlarmImpl();


    @Override
    public void c() {

    }
}



