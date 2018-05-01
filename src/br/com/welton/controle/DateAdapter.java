package br.com.welton.controle;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
    private final SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    @Override
    public String marshal(Date v) throws Exception {
        synchronized (formato) {
            return formato.format(v);
        }
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        synchronized (formato) {
            return formato.parse(v);
        }
    }
}