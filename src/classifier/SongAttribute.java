package classifier;

public class SongAttribute {

    private String name;
    private String value;

    public SongAttribute(String nameOfAttribute, String value){
        if(validValue(nameOfAttribute,value)){
        this.name = nameOfAttribute;
        this.value = value;}
        else{
           // throw new InvalidPropertiesFormatException();
        }
        }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    private boolean validValue(String nameOfAttribute,String value){

        return true;

    }

}

