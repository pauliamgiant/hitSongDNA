package classifier;

import classifier.Attributes.*;

import java.util.HashMap;
import java.util.Map;

public class DataTuple {

    private Map<String, Enum> attributes;
    private String name;


    public DataTuple(String name,Enum attr1, Enum attr2, Enum attr3, Enum attr4, Enum attr5) {
        attributes = new HashMap<String, Enum> ();
        this.name = name;
        attributes.put("Outlook",Outlook.sunny);
        attributes.put("Temp", Temp.hot);
        attributes.put("Humidity", Humidity.high);
        attributes.put("Windy", Windy.no);
        attributes.put("Play", Play_targetClass.no);
    }

    public void setAttributes() {

        this.attributes = attributes;
    }
}
