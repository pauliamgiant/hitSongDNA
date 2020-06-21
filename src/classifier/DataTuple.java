package classifier;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataTuple {

    private Map<String, SongAttribute> attributes;
    private String name;


    public DataTuple(String name,
                     Enum outlook,
                     Enum temp,
                     Enum humidity,
                     Enum windy,
                     Enum Hit_targetClass) {

        attributes = new LinkedHashMap<>();
        this.name = name;
        attributes.put("Outlook", new SongAttribute("Outlook", outlook));
        attributes.put("Temp", new SongAttribute("Temp", temp));
        attributes.put("Humidity", new SongAttribute("Humidity", humidity));
        attributes.put("Windy", new SongAttribute("Windy", windy));
        attributes.put("Hit_targetClass", new SongAttribute("Hit_targetClass", Hit_targetClass));
    }

    public DataTuple(String name,
                     Enum outlook,
                     Enum temp,
                     Enum humidity,
                     Enum windy) {

        attributes = new LinkedHashMap<>();
        this.name = name;
        attributes.put("Outlook", new SongAttribute("Outlook", outlook));
        attributes.put("Temp", new SongAttribute("Temp", temp));
        attributes.put("Humidity", new SongAttribute("Humidity", humidity));
        attributes.put("Windy", new SongAttribute("Windy", windy));
    }


    public String printTuple() {

        String attributeValues = "";
        for (SongAttribute a : attributes.values()
        ) {
            attributeValues += a.getName() + "=" + a.getValue() + ", ";
        }
        return attributeValues;

    }

    public String getName() {
        return name;
    }

    public SongAttribute getTargetClass() {
        return attributes.get("Hit_targetClass");
    }

    public SongAttribute getAttribute(String typeOfAttribute) {
        return attributes.get(typeOfAttribute);
    }

    public List getAllAttributes() {
        ArrayList<SongAttribute> listOfAllAttr= new ArrayList<>();
        for (SongAttribute sa : attributes.values()){
            listOfAllAttr.add(sa);
        }
        return listOfAllAttr;
    }

    public int numberOfAttributes(){
        return attributes.size();
    }


}
