package classifier;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * VALUES PERMISSABLE
 *
 * @attribute INTRO_LEN {-inf-12,12-23,23-35,35-inf}
 * @attribute TEMPO {<80,80-95,95-110,111-120,121-130,>130}
 * @attribute GENRE {country,disco,edm,electro-indie,folk,folk-rock,indie-rock,pop,pop-rock,r&b,rock,soul}
 * @attribute LEAD_SING {male,female,f-duet,m-duet,mf-duet}
 * @attribute KEY_VS {AbMAJ,Am,AMAJ,Bbm,BbMAJ,Bm,BMAJ,C#m,Cm,CMAJ,DbMAJ,Dm,DMAJ,Ebm,EbMAJ,Em,EMAJ,F#m,F#MAJ,Fm,FMAJ,G#m,Gm,GMAJ}
 * @attribute VS_STARTS_ON_I {TRUE,FALSE}
 * @attribute IONIAN_VS_KEY {AbMAJ,AMAJ,BbMAJ,BMAJ,CMAJ,DbMAJ,DMAJ,EbMAJ,EMAJ,F#MAJ,FMAJ,GMAJ}
 * @attribute VS_DISTINCT_CHRD_COUNT {1,2,3,4,>4}
 * @attribute VS_CH_SAME_CHRDS {TRUE,FALSE}
 * @attribute VS_KEY_CHNGS {yes,no}
 * @attribute CH_STARTS_ON_I {TRUE,FALSE}
 * @attribute CH_DISTINCT_CHRD_COUNT {1,2,3,4,>4}
 * @attribute SONG_TOTAL_CHORD_COUNT {-inf-3,3-4,4-5,5-6,6-7,7-8,8-11,11-inf}
 * @attribute VS_TL_START_NOTE {1,2,3,4,5,6,7}
 * @attribute VS_TL_DISTINCT_NOTES {1,2,3,4}
 * @attribute VS_TL_TYPE {mixed-harm,thirds,fifths,sevenths,roots,pedal,triad-notes,four-note-chord,pedal-triad,pedal-four}
 * @attribute CH_TL_START_NOTE {1,2,3,4,5,6,7}
 * @attribute CH_TL_DISTINCT_NOTES {1,2,3,4}
 * @attribute CH_TL_TYPE {mixed-harm,thirds,fifths,sevenths,roots,pedal,triad-notes,four-note-chord,pedal-triad,pedal-four}
 * @attribute DRUM_PAT {rockbeat-var,dancebeat,moneybeat,latinbeat,hiphopbeat,slowjam,none,motownbeat,folkpercussion}
 * @attribute LINE_REP {-inf-7,7-14,14-21,21-28,28-35,35-41,41-51,51-inf}
 * @attribute LYR_GRADE_LVL {-inf--1.72,-1.72--0.85,-0.85-0.01,0.01-0.88,0.88-1.75,1.75-2.61,2.61-3.47,3.47-inf}
 * @attribute TOTAL_WORDS {-inf-187,187-212.5,212.5-249,249-286.5,286.5-328.5,328.5-372.5,372.5-405.5,405.5-inf}
 * @attribute TITLE_REPEATS {-inf-3,3-5,5-7,7-9,9-11,11-14,14-18,18-inf}
 * @attribute DISTINCT_HITWORDS {-inf-2,2-3,3-4,4-5,5-6,6-7,7-8,8-inf}
 * @attribute HITWORDS_TOTAL {-inf-2,2-5,5-7,7-9,9-10,10-11,11-13,13-17,17-20,20-22,22-26,26-37,37-49,49-inf}
 * @attribute RHYMECOUNT {-inf-8,8-11,11-13,13-16,16-19,19-23,23-31,31-inf}
 * @attribute LYR_ARCHETYPE {lover,vulnerable,innuendist,innocent,ruler,sage,hero,political,explorer,partier,tribute,joker}
 * @attribute HIT_WRITER {yes,no}
 * @attribute CHART_POS {HIT,miss}
 */



public class AttributeRegistry {


    private static AttributeRegistry INSTANCE;
    private Map<String,LinkedHashSet> attributesAndValues;

    private AttributeRegistry() {
        attributesAndValues = new LinkedHashMap<>();
    }

    public static AttributeRegistry getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AttributeRegistry();
        }

        return INSTANCE;
    }

    public Set<String> getSetOfAttributes(){
        return attributesAndValues.keySet();
    }

    public void updateAttributeDataFromARFF() throws FileNotFoundException {
        ImportARFFDataset iad = new ImportARFFDataset();
        attributesAndValues =  iad.getAttrAndVals();
    }

    public LinkedHashSet<String> getAttributeValuesSafe(String currentLine){
        LinkedHashSet<String> setOFAttrVals;
        String selectedSubString = currentLine.substring(currentLine.indexOf('{'), currentLine.indexOf('}'));
        String cleanString = selectedSubString.replaceAll("[{}'()+\\]^:\\\\]", "");
        String[] splitARFFValues = cleanString.split(",");
        setOFAttrVals = new LinkedHashSet<>(Arrays.asList(splitARFFValues));
       // System.out.println(setOFAttrVals);
        return setOFAttrVals;
    }

    public void updateAttributeDataSafely(){

       // System.out.println("easy does it");
        String lines[] = getHardCodeAttributeData().split("\\r?\\n");

        for (int i = 0; i < lines.length; i++) {
            String attrName;
            LinkedHashSet<String> setOfValues;
            String currentLine = lines[i];
            attrName = currentLine.substring(currentLine.indexOf(' ') + 1, currentLine.indexOf('{') - 1);
           // System.out.println(attrName);
            setOfValues = getAttributeValuesSafe(currentLine);
            attributesAndValues.put(attrName,setOfValues);
        }
    }

    public Map<String, LinkedHashSet> getAttributesAndValues(){
        return attributesAndValues;
    }

    public boolean validAttributeValue(String attributeName, String value) {
        if(attributesAndValues.get(attributeName).contains(value)==false){
            System.out.println(value + " is an INVALID value for "+attributeName);
            return false;
        }
        return true;
    }

    public boolean validAttributeName(String name){

        return attributesAndValues.keySet().contains(name);
    }
    public String printAttributesAndVals() {
        return attributesAndValues.toString();
    }

    public void flushRegistry(){
        attributesAndValues = new LinkedHashMap<>();

    }

    public List<String> getValues(String nameOfAttribute){
        List<String> l = null;
        try {
            l = new ArrayList<>(attributesAndValues.get(nameOfAttribute));
        } catch (NullPointerException exception) {
            System.out.println("Attribute name valid: "+  validAttributeName(nameOfAttribute));
            exception.printStackTrace();
        }
        return l;
    }

    public String getHardCodeAttributeData(){

        String data = "@attribute INTRO_LEN {'\\'(-inf-12]\\'','\\'(12-23]\\'','\\'(23-35]\\'','\\'(35-inf)\\''}\n" +
                "@attribute TEMPO {<80,80-95,95-110,111-120,121-130,>130}\n" +
                "@attribute GENRE {country,disco,edm,electro-indie,folk,folk-rock,indie-rock,pop,pop-rock,r&b,rock,soul}\n" +
                "@attribute LEAD_SING {male,female,f-duet,m-duet,mf-duet}\n" +
                "@attribute KEY_VS {AbMAJ,Am,AMAJ,Bbm,BbMAJ,Bm,BMAJ,C#m,Cm,CMAJ,DbMAJ,Dm,DMAJ,Ebm,EbMAJ,Em,EMAJ,F#m,F#MAJ,Fm,FMAJ,G#m,Gm,GMAJ}\n" +
                "@attribute CHORDS_VS {i-i-i-i,I-I-I-I,i-i-i-iv,i-i-III-III,I-I-IV-V,I-I-V-V,i-i-v-v,I-I-vi-IV,i-i-VI-VI,I-I-vi-vi,i-i-VI-VII,I-i-VII-VII,i-i-VII-VII,I-ii-I-ii,I-ii-iii-ii,i-III-i-III,I-iii-I-iii,i-III-ii-v,I-iii-IV-I,i-III-iv-i,i-III-iv-V,I-iii-IV-VI,i-III-VI-iv,i-III-VI-V,I-iii-vi-vi,i-III-VI-VII,I-IV-I-IV,i-iv-i-iv,i-iv-i-V,I-IV-IV-V,i-iv-V-iv,I-IV-V-V,i-IV-VI-i,I-IV-vi-IV,I-IV-vi-V,i-iv-VII-III,i-v-i-v,I-V-I-V,I-V-ii-vi,I-V-IV-I,I-V-IV-IV,i-v-iv-VI,I-V-vi-I,i-v-VI-III,I-V-vi-IV,I-V-vi-V,I-V-vi-vi,i-v-VI-VII,I-vi-I-vi,i-VI-III-III,I-vi-III-IV,i-VI-III-VII,I-vi-IV-I,i-VI-iv-VII,I-VI-v-v,i-VI-VII-i,i-VI-VII-v,i-VII-i-i,i-VII-i-VII,i-VII-III-v,i-VII-III-VII,i-VII-iv-i,i-VII-IV-VI,i-VII-v-VI,i-VII-VI-III,i-VII-VI-v,i-VII-VI-VII,ii-I-V-V,ii-ii-I-I,ii-ii-vi-V,ii-IV-I-V,ii-V-I-I,ii-V-I-IV,ii-V-I-vi,IV-I-vi-V,iv-v-i-i,IV-V-I-I,IV-V-I-IV,IV-V-I-vi,IV-V-vi-V,iv-VI-VII-i,iv-VII-i-VII,iv-VII-VII-i,NTP,V-I-I-V,v-i-VI-VI,V-ii-I-I,V-IV-V-IV,V-IV-V-V,V-V-I-I,V-V-IV-ii,V-vi-IV-V,VI-i-iv-VI,VI-i-VII-iv,vi-IV-I-I,vi-IV-IV-I,vi-V-I-I,VI-v-i-III,vi-V-IV-I,VI-VI-i-i,VI-VI-i-III,VI-VI-i-VII,VI-VII-i-III,VII-i-VI-VI,I-I-V-IV,i-III-VII-VI,IV-I-V-V,i-III-v-VII,i-III-VI-III,IV-IV-I-I,iii-IV-I-V,I-I-vi-VII,ii-III-v-VI,I-IV-V-IV,V-V-V-IV,IV-I-I-V,I-III-vi-V,i-VI-III-V,I-I-IV-IV}\n" +
                "@attribute VS_STARTS_ON_I {TRUE,FALSE}\n" +
                "@attribute IONIAN_VS_KEY {AbMAJ,AMAJ,BbMAJ,BMAJ,CMAJ,DbMAJ,DMAJ,EbMAJ,EMAJ,F#MAJ,FMAJ,GMAJ}\n" +
                "@attribute IONIAN_VS_CHORDS {IV-IV-vi-V,I-I-I-I,I-I-IV-V,I-I-V-IV,I-I-V-V,I-I-vi-IV,I-I-vi-vi,I-ii-I-ii,I-ii-iii-ii,I-iii-I-iii,I-iii-IV-I,I-iii-IV-VI,I-iii-vi-vi,I-IV-I-IV,I-IV-IV-V,I-IV-V-V,I-IV-vi-IV,I-IV-vi-V,I-V-I-V,I-V-ii-vi,I-V-IV-I,I-V-IV-IV,I-V-vi-I,I-V-vi-IV,I-V-vi-V,I-V-vi-vi,I-vi-I-vi,I-vi-III-IV,I-vi-IV-I,ii-I-V-V,ii-ii-I-I,ii-ii-vi-V,ii-iii-vi-vi,ii-IV-I-V,ii-IV-V-vi,ii-V-I-I,ii-V-I-IV,ii-V-I-vi,ii-V-V-vi,ii-V-vi-V,iii-vi-IV-IV,IV-I-vi-V,IV-iii-vi-I,IV-IV-vi-I,IV-IV-vi-vi,IV-V-I-I,IV-V-I-IV,IV-V-I-vi,IV-V-vi-I,IV-V-vi-V,IV-vi-ii-IV,IV-vi-V-ii,NTP,V-I-I-V,V-ii-I-I,V-IV-V-IV,V-IV-V-V,V-V-I-I,V-V-IV-ii,V-vi-IV-IV,V-vi-IV-V,vi-I-ii-III,vi-I-ii-vi,vi-I-IV-ii,vi-I-IV-III,vi-I-IV-V,vi-I-V-IV,vi-I-vi-I,vi-I-vii-iii,vi-ii-III-ii,vi-II-IV-vi,vi-ii-V-I,vi-ii-vi-ii,vi-ii-vi-III,vi-iii-ii-IV,vi-iii-IV-I,vi-iii-IV-V,vi-III-vi-III,vi-IV-I-I,vi-IV-I-V,vi-IV-ii-V,vi-IV-iii-iii,vi-IV-IV-I,vi-IV-V-iii,vi-IV-V-vi,vi-V-I-I,vi-V-I-iii,vi-V-I-V,vi-V-II-IV,vi-V-ii-vi,vi-V-iii-IV,vi-V-IV-I,vi-V-IV-iii,vi-V-IV-V,vi-V-vi-V,vi-V-vi-vi,vi-vi-I-I,vi-vi-III-III,vi-vi-IV-IV,vi-vi-IV-V,vi-vi-V-V,VI-vi-V-V,vi-vi-vi-ii,vi-vi-vi-vi,IV-I-V-V,vi-I-iii-V,vi-I-IV-I,IV-IV-I-I,iii-IV-I-V,I-I-vi-VII,vii-I-iii-IV,I-IV-V-IV,V-V-V-IV,IV-I-I-V,I-III-vi-V,vi-IV-I-iii,I-I-IV-IV}\n" +
                "@attribute VS_DISTINCT_CHRD_COUNT {1,2,3,4,>4}\n" +
                "@attribute VS_CH_SAME_CHRDS {TRUE,FALSE}\n" +
                "@attribute VS_KEY_CHNGS {yes,no}\n" +
                "@attribute CHORDS_CH {i-i-i-i,I-I-I-I,I-I-ii-ii,I-I-iii-iii,I-I-IV-IV,I-I-V-IV,I-I-V-V,I-I-vi-IV,i-i-VII-VII,I-ii-iii-ii,I-ii-IV-I,I-ii-IV-V,i-III-ii-v,i-III-iv-i,I-iii-IV-V,i-III-iv-V,i-III-iv-VI,I-III-VI-iv,i-III-VI-V,I-iii-vi-V,I-iii-vi-vi,i-III-VI-VII,i-iv-i-iv,I-IV-I-IV,i-iv-i-V,I-IV-I-V,I-IV-ii-I,I-IV-ii-V,I-IV-IV-V,I-IV-V-V,i-IV-VI-i,I-IV-vi-IV,I-IV-vi-V,i-iv-VII-III,i-v-i-v,I-V-ii-IV,I-V-IV-I,I-V-IV-IV,I-V-IV-V,i-v-iv-VI,I-V-vi-IV,I-V-vi-V,i-v-VI-VII,i-VI-III-III,i-VI-III-VII,I-vi-IV-V,i-VI-iv-VII,I-VI-v-v,i-VI-VII-i,i-VI-VII-v,i-VII-III-VII,i-VII-iv-i,i-VII-iv-VI,i-VII-iv-VII,i-VII-v-VI,i-VII-VI-III,i-VII-VI-VI,i-VII-VI-VII,ii-I-V-V,ii-ii-I-I,ii-ii-iii-I,ii-IV-I-V,ii-V-I-VI,ii-V-I-vi,ii-V-ii-V,IV-I-V-ii,IV-I-V-Vi,IV-I-V-vi,IV-i-VI-VII,IV-iii-vi-V,IV-iv-I-V,iv-iv-i-VII,IV-V-I-I,IV-V-I-IV,IV-V-I-vi,iv-v-II-ii,iv-v-III-iv,iv-V-iv-V,iv-v-VI-v,IV-vi-IV-V,iv-VI-VII-i,iv-VII-i-VII,NTP,v-i-VI-VI,V-ii-I-I,V-IV-I-IV,V-IV-I-V,V-IV-V-IV,V-IV-V-vi,V-IV-vi-I,V-V-IV-ii,VI-i-iv-VI,VI-i-VII-VII,VI-III-i-VII,VI-III-VII-i,vi-IV-I-I,vi-IV-IV-I,vi-V-I-I,VI-v-i-III,vi-V-IV-I,VI-VI-i-III,vi-vi-VI-VII,VI-VII-i-i,VI-VII-i-III,VI-VII-i-VI,VI-VII-v-i,VII-i-VI-VI,VII-i-VII-i,IV-I-V-V,i-III-v-VII,IV-IV-I-I,IV-I-ii-V,I-V-IV-vi,VI-VI-VII-i,IV-I-vi-I,IV-VII-i-i,iv-v-VI-VII,IV-I-IV-V}\n" +
                "@attribute CH_STARTS_ON_I {TRUE,FALSE}\n" +
                "@attribute IONIAN_CH_CHORDS {I-I-I-I,I-I-ii-ii,I-I-iii-iii,I-I-IV-IV,I-I-V-IV,I-I-V-V,I-I-vi-IV,I-ii-iii-ii,I-ii-IV-I,I-ii-IV-V,I-iii-IV-V,I-iii-vi-V,I-iii-vi-vi,I-IV-I-IV,I-IV-I-V,I-IV-ii-I,I-IV-ii-V,I-IV-IV-V,I-IV-V-V,I-IV-vi-IV,I-IV-vi-V,I-V-ii-IV,I-V-IV-I,I-V-IV-IV,I-V-IV-V,I-V-vi-IV,I-V-vi-V,I-vi-IV-V,ii-I-V-V,ii-ii-I-I,ii-ii-iii-I,ii-ii-vi-V,ii-iii-I-ii,ii-III-ii-III,ii-iii-IV-iii,ii-iii-VII-vii,ii-IV-I-V,ii-IV-V-vi,ii-V-I-VI,ii-V-I-vi,ii-V-ii-V,ii-V-vi-V,II-vi-IV-V,iii-vi-IV-IV,IV-I-V-ii,IV-I-V-vi,IV-I-V-Vi,IV-I-vi-V,IV-iii-vi-I,IV-iii-vi-V,IV-iv-I-V,IV-IV-vi-I,IV-V-I-I,IV-V-I-IV,IV-V-I-vi,IV-V-iii-vi,IV-V-vi-I,IV-V-vi-IV,IV-V-vi-vi,IV-vi-ii-IV,IV-vi-IV-V,IV-vi-V-V,NTP,V-ii-I-I,V-IV-I-IV,V-IV-I-V,V-IV-V-IV,V-IV-V-vi,V-IV-vi-I,V-V-IV-ii,V-vi-IV-VI,V-vi-V-vi,vi-I-ii-III,vi-I-ii-IV,vi-I-ii-vi,vi-I-IV-ii,vi-I-IV-III,vi-I-IV-V,vi-I-vii-iii,vi-II-IV-vi,vi-ii-V-I,vi-ii-vi-ii,vi-ii-vi-III,vi-iii-ii-IV,vi-iii-IV-V,vi-III-vi-III,vi-IV-I-I,vi-IV-I-V,vi-IV-ii-V,vi-IV-iii-iii,vi-IV-IV-I,vi-IV-V-iii,vi-IV-V-vi,vi-V-I-I,vi-V-I-V,vi-V-ii-IV,vi-V-ii-V,vi-V-ii-vi,vi-V-iii-IV,vi-V-IV-I,vi-V-IV-IV,vi-V-IV-V,vi-vi-V-V,vi-vi-vi-vi,vi-vi-VI-VII,IV-I-V-V,vi-I-iii-V,IV-IV-I-I,IV-I-ii-V,I-V-IV-vi,IV-IV-V-vi,IV-I-vi-I,IV-VII-i-i,ii-iii-IV-V,IV-I-IV-V}\n" +
                "@attribute CH_DISTINCT_CHRD_COUNT {1,2,3,4,>4}\n" +
                "@attribute SONG_TOTAL_CHORD_COUNT {'\\'(-inf-3]\\'','\\'(3-4]\\'','\\'(4-5]\\'','\\'(5-6]\\'','\\'(6-7]\\'','\\'(7-8]\\'','\\'(8-11]\\'','\\'(11-inf)\\''}\n" +
                "@attribute VS_TOPLINE {1-1-1-1,1-1-1-4,1-1-1-5,1-1-3-1,1-1-3-3,1-1-5-3,1-1-5-5,1-1-7-3,1-2-1-2,1-2-3-6,1-2-5-3,1-3-1-1,1-3-1-5,1-3-2-5,1-3-3-1,1-3-3-5,1-3-5-1,1-3-5-5,1-4-3-5,1-4-3-6,1-4-4-5,1-4-5-5,1-5-1-1,1-5-1-5,1-5-3-3,1-5-3-5,1-5-5-5,1-5-6-6,1-6-1-6,1-6-5-4,1-7-4-5,1-7-5-5,2-1-2-3,2-1-7-5,2-2-5-5,2-2-7-5,2-3-1-7,2-3-5-3,2-3-7-5,2-5-3-5,2-5-4-1,2-5-4-5,2-7-1-5,3-1-1-4,3-1-3-2,3-1-3-3,3-1-5-1,3-1-5-3,3-1-5-4,3-1-5-5,3-2-3-2,3-2-5-5,3-3-1-1,3-3-3-1,3-3-3-3,3-3-3-5,3-3-5-1,3-3-5-3,3-3-5-5,3-4-3-5,3-4-5-6,3-5-1-3,3-5-1-6,3-5-1-7,3-5-3-1,3-5-3-3,3-5-3-5,3-5-5-5,3-5-7-5,3-5-7-6,3-6-3-6,3-6-5-5,3-7-3-3,3-7-3-7,3-7-4-3,3-7-5-5,3-7-6-2,4-1-6-1,4-3-3-3,4-5-6-5,5-1-1-1,5-1-3-6,5-1-5-1,5-1-5-5,5-1-7-1,5-1-7-3,5-2-1-3,5-2-1-5,5-2-5-2,5-3-5-1,5-3-5-5,5-4-1-7,5-4-5-1,5-5-1-3,5-5-3-3,5-5-4-4,5-5-5-1,5-5-5-3,5-5-5-5,5-5-7-5,5-5-7-6,5-6-1-1,5-6-3-2,5-6-7-1,5-7-3-1,5-7-5-3,6-2-6-3,6-4-1-1,6-5-5-5,6-6-4-1,6-7-3-1,7-2-5-1,7-3-3-3,7-4-1-1,7-5-7-3,7-7-5-3,7-7-7-5,3-5-4-1,3-3-1-5,1-3-2-1,1-5-5-3,6-5-5-3,3-5-5-1,1-1-3-2,3-1-4-5,7-5-7-7,5-5-4-5,1-3-1-3,3-5-1-5,1-3-1-6,5-3-1-5,1-1-1-2,3-4-1-1,6-1-3-3}\n" +
                "@attribute VS_TL_START_NOTE {1,2,3,4,5,6,7}\n" +
                "@attribute VS_TL_DISTINCT_NOTES {1,2,3,4}\n" +
                "@attribute VS_TL_TYPE {mixed-harm,thirds,fifths,sevenths,roots,pedal,triad-notes,four-note-chord,pedal-triad,pedal-four}\n" +
                "@attribute CH_TOPLINE {1-1-1-1,1-1-1-3,1-1-3-1,1-1-3-5,1-1-4-5,1-1-5-5,1-1-6-1,1-1-6-5,1-2-3-1,1-3-1-1,1-3-1-3,1-3-1-5,1-3-3-1,1-3-3-4,1-3-3-5,1-3-5-1,1-3-5-3,1-3-5-5,1-4-1-1,1-4-3-5,1-4-7-5,1-5-1-5,1-5-2-1,1-5-3-5,1-5-5-1,1-5-5-5,1-5-7-1,1-5-7-5,1-6-1-1,1-6-3-3,1-7-5-5,2-1-3-5,2-3-5-3,2-4-5-5,2-5-2-5,2-6-5-3,2-7-3-3,2-7-5-5,2-7-7-7,3-1-1-7,3-1-2-3,3-1-5-3,3-1-7-4,3-1-7-5,3-2-3-7,3-2-6-4,3-3-1-5,3-3-1-6,3-3-3-3,3-3-3-5,3-3-5-5,3-4-1-1,3-4-1-3,3-4-1-6,3-4-5-1,3-5-1-1,3-5-1-4,3-5-1-5,3-5-2-1,3-5-3-5,3-5-5-1,3-5-5-5,3-5-7-1,3-7-3-7,3-7-4-3,3-7-5-5,4-5-1-1,4-5-7-3,4-5-7-5,4-6-1-1,4-6-2-3,4-6-5-5,5-1-1-5,5-1-5-3,5-1-5-5,5-1-6-6,5-1-7-3,5-2-3-6,5-2-5-5,5-2-7-2,5-3-3-1,5-3-3-5,5-3-3-7,5-3-5-1,5-3-5-5,5-4-1-1,5-4-3-4,5-4-5-1,5-4-5-5,5-5-1-1,5-5-1-5,5-5-2-5,5-5-3-1,5-5-3-3,5-5-3-5,5-5-5-5,5-5-5-6,5-5-6-1,5-5-7-7,5-6-1-3,5-6-3-1,5-6-3-2,5-6-3-5,5-7-2-4,5-7-3-6,5-7-5-4,5-7-7-2,6-2-1-3,6-5-3-4,6-5-5-5,6-6-5-6,7-3-3-5,7-3-3-6,7-3-5-5,7-4-5-1,7-5-1-1,7-5-1-5,7-5-5-1,7-5-5-3,7-7-4-1,7-7-5-1,7-7-5-3,7-7-5-5,5-1-6-4,3-5-7-7,3-1-3-5,5-1-3-1,6-5-3-3,7-1-4-1,5-5-4-5,2-5-3-3,5-1-3-3,5-7-5-5,5-1-1-1,3-1-5-5,5-7-2-3,5-5-5-3,5-7-1-5,4-2-6-5}\n" +
                "@attribute CH_TL_START_NOTE {1,2,3,4,5,6,7}\n" +
                "@attribute CH_TL_DISTINCT_NOTES {1,2,3,4}\n" +
                "@attribute CH_TL_TYPE {mixed-harm,thirds,fifths,sevenths,roots,pedal,triad-notes,four-note-chord,pedal-triad,pedal-four}\n" +
                "@attribute DRUM_PAT {rockbeat-var,dancebeat,moneybeat,latinbeat,hiphopbeat,slowjam,none,motownbeat,folkpercussion}\n" +
                "@attribute LINE_REP {'\\'(-inf-7]\\'','\\'(7-14]\\'','\\'(14-21]\\'','\\'(21-28]\\'','\\'(28-35]\\'','\\'(35-41]\\'','\\'(41-51)\\'','\\'(51-inf)\\''}\n" +
                "@attribute LYR_GRADE_LVL {'\\'(-inf--1.72]\\'','\\'(-1.72--0.85]\\'','\\'(-0.85-0.01]\\'','\\'(0.01-0.88]\\'','\\'(0.88-1.75]\\'','\\'(1.75-2.61]\\'','\\'(2.61-3.47]\\'','\\'(3.47-inf)\\''}\n" +
                "@attribute TOTAL_WORDS {'\\'(-inf-187]\\'','\\'(187-212.5]\\'','\\'(212.5-249]\\'','\\'(249-286.5]\\'','\\'(286.5-328.5]\\'','\\'(328.5-372.5]\\'','\\'(372.5-405.5]\\'','\\'(405.5-inf)\\''}\n" +
                "@attribute TITLE_REPEATS {'\\'(-inf-3]\\'','\\'(3-5]\\'','\\'(5-7]\\'','\\'(7-9]\\'','\\'(9-11]\\'','\\'(11-14]\\'','\\'(14-18]\\'','\\'(18-inf)\\''}\n" +
                "@attribute DISTINCT_HITWORDS {'\\'(-inf-2]\\'','\\'(2-3]\\'','\\'(3-4]\\'','\\'(4-5]\\'','\\'(5-6]\\'','\\'(6-7]\\'','\\'(7-8]\\'','\\'(8-inf)\\''}\n" +
                "@attribute HITWORDS_TOTAL {'\\'(-inf-2]\\'','\\'(2-5]\\'','\\'(5-7]\\'','\\'(7-9]\\'','\\'(9-10]\\'','\\'(10-11]\\'','\\'(11-13]\\'','\\'(13-17]\\'','\\'(17-20]\\'','\\'(20-22]\\'','\\'(22-26]\\'','\\'(26-37]\\'','\\'(37-49]\\'','\\'(49-inf)\\''}\n" +
                "@attribute RHYMECOUNT {'\\'(-inf-8]\\'','\\'(8-11]\\'','\\'(11-13]\\'','\\'(13-16]\\'','\\'(16-19]\\'','\\'(19-23]\\'','\\'(23-31]\\'','\\'(31-inf)\\''}\n" +
                "@attribute LYR_ARCHETYPE {lover,vulnerable,innuendist,innocent,ruler,sage,hero,political,explorer,partier,tribute,joker}\n" +
                "@attribute HIT_WRITER {yes,no}\n" +
                "@attribute CHART_POS {HIT,miss}";
        return data;
    }

}
