package Common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * Created by Juliana on 19/11/2016.
 */
public class Commons {

    public String removeMask(String cpf) {
        String str = cpf;
        while (str.indexOf("-") != -1) {
            if (str.indexOf("-") != 0) {
                str = str.substring(0, str.indexOf("-")) +
                        str.substring(str.indexOf("-") + 1);
            }
            else {
                str = str.substring(str.indexOf("-") + 1);
            }
        }
        while (str.indexOf(".") != -1) {
            if (str.indexOf(".") != 0) {
                str = str.substring(0, str.indexOf(".")) +
                        str.substring(str.indexOf(".") + 1);
            }
            else {
                str = str.substring(str.indexOf(".") + 1);
            }
        }
        return str;
    }

    public static Date formataData(String data) throws Exception {
        if (data == null || data.equals(""))
            return null;
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.sql.Date)formatter.parse(data);
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
}
