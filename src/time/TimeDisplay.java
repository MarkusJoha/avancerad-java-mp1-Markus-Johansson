package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import display.Displayable;

public class TimeDisplay implements Displayable {
    private SimpleDateFormat timeFormat;
    private Date currentTime;

    public TimeDisplay() {
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        currentTime = new Date();
    }

    public String getCurrentValue() {
        return timeFormat.format(currentTime);
    }

    public boolean updateValue(String newTimeStr) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("HH:mm:ss");
            inputFormat.setLenient(false);
            Date newTime = inputFormat.parse(newTimeStr);
            currentTime = newTime;
            return true;
        } catch (ParseException e) {
            System.out.println("Ogiltig tid. Använd formatet HH:mm:ss.");
            return false;
        }
    }
}

