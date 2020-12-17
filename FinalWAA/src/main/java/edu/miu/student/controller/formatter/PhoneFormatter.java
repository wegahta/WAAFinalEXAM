package edu.miu.student.controller.formatter;

import edu.miu.student.domain.Phone;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PhoneFormatter implements Formatter<Phone> {
    @Override
    public Phone parse(String s, Locale locale) throws ParseException {
        String[] str= s.split("-");
        Phone phone=new Phone();
        phone.setPrexis(str[0]);
        phone.setMiddle(str[1]);
        phone.setSubFix(str[2]);
        return phone;
    }

    @Override
    public String print(Phone phone, Locale locale) {


        return phone.getPrexis()+"-"+ phone.getMiddle()+"-"+phone.getSubFix();
    }
}
