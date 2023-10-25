package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import display.Displayable;

public class DateDisplay implements Displayable {
    private SimpleDateFormat dateFormat;
    private Date currentDate;

    public DateDisplay() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        currentDate = new Date();
    }

    public String getCurrentValue() {
        return dateFormat.format(currentDate);
    }

    public boolean updateValue(String newDateStr) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            inputFormat.setLenient(false);
            Date newDate = inputFormat.parse(newDateStr);
            currentDate = newDate;
            return true;
        } catch (ParseException e) {
            System.out.println("Ogiltigt datum. Använd formatet yyyy-MM-dd.");
            return false;
        }
    }
}

