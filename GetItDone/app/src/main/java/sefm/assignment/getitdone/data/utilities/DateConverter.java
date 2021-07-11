package sefm.assignment.getitdone.data.utilities;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long dateLong){
        return dateLong == null ? null: new Date(dateLong);
    }

    @TypeConverter
    public static Long fromDate(Date date){
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static Date toDateFromString(String dateString){
        if(dateString == null)
            return null;

        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");

        Date stringDate = simpledateformat.parse(dateString, pos);
        return stringDate;
    }

    @TypeConverter
    public static String toStringFromDate(Date date){
        if(date == null)
            return null;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        String stringDate = dateFormat.format(date);

        return stringDate;
    }
}
