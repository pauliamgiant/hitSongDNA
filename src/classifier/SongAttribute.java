package classifier;

public class SongAttribute {

    private String name;
    private String value;

    public SongAttribute(String nameOfAttribute, String value){
//        if (validValue(nameOfAttribute, value)) {
//            this.name = nameOfAttribute;
//            this.value = value;
//        } else {
//            System.out.println("Not a valid Attribute value");;
//        }
                    this.name = nameOfAttribute;
            this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    private boolean validValue(String nameOfAttribute, String value) {
        return AttributeRegistry.getInstance().validAttributeValue(nameOfAttribute, value);
    }

}

