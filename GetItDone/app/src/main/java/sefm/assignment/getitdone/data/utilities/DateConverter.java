package sefm.assignment.getitdone.data.utilities;

import androidx.room.TypeConverter;

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
    public static Date toDate(String dateString){
        if(dateString == null)
            return null;

        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");

        Date stringDate = simpledateformat.parse(dateString, pos);
        return stringDate;
    }
}
