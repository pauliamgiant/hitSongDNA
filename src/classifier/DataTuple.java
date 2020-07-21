package classifier;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataTuple {

    private Map<String, SongAttribute> attributes;



//    public DataTuple(String name,
//                     Enum intro,
//                     Enum songwriters,
//                     Enum starColab,
//                     Enum hitSongwriter,
//                     Enum Hit_targetClass) {
//
//        attributes = new LinkedHashMap<>();
//        this.name = name;
//        attributes.put("INTRO_LEN", new SongAttribute("INTRO_LEN", intro));
//        attributes.put("No_Songwriters", new SongAttribute("No_Songwriters", songwriters));
//        attributes.put("ColabWithStar", new SongAttribute("ColabWithStar", starColab));
//        attributes.put("HitSongwriter", new SongAttribute("HitSongwriter", hitSongwriter));
//        attributes.put("Hit_targetClass", new SongAttribute("Hit_targetClass", Hit_targetClass));
//    }

    public DataTuple(Boolean knownTarget,String[] values ){
        this(values);
        attributes.put("CHART_POS", new SongAttribute("CHART_POS", values[29]));
    }

    public DataTuple(String[] values){

        attributes = new LinkedHashMap<>();
        attributes.put("INTRO_LEN", new SongAttribute("INTRO_LEN", values[0]));
        attributes.put("TEMPO", new SongAttribute("TEMPO", values[1]));
        attributes.put("GENRE", new SongAttribute("GENRE", values[2]));
        attributes.put("LEAD_SING", new SongAttribute("LEAD_SING", values[3]));
        attributes.put("KEY_VS", new SongAttribute("KEY_VS", values[4]));
        attributes.put("VS_STARTS_ON_I", new SongAttribute("VS_STARTS_ON_I", values[5]));
        attributes.put("IONIAN_VS_KEY", new SongAttribute("IONIAN_VS_KEY", values[6]));
        attributes.put("VS_DISTINCT_CHRD_COUNT", new SongAttribute("VS_DISTINCT_CHRD_COUNT", values[7]));
        attributes.put("VS_CH_SAME_CHRDS", new SongAttribute("VS_CH_SAME_CHRDS", values[8]));
        attributes.put("VS_KEY_CHNGS", new SongAttribute("VS_KEY_CHNGS", values[9]));
        attributes.put("CH_STARTS_ON_I", new SongAttribute("CH_STARTS_ON_I", values[10]));
        attributes.put("CH_DISTINCT_CHRD_COUNT", new SongAttribute("CH_DISTINCT_CHRD_COUNT", values[11]));
        attributes.put("SONG_TOTAL_CHORD_COUNT", new SongAttribute("SONG_TOTAL_CHORD_COUNT", values[12]));
        attributes.put("VS_TL_START_NOTE", new SongAttribute("VS_TL_START_NOTE", values[13]));
        attributes.put("VS_TL_DISTINCT_NOTES", new SongAttribute("VS_TL_DISTINCT_NOTES", values[14]));
        attributes.put("VS_TL_TYPE", new SongAttribute("VS_TL_TYPE", values[15]));
        attributes.put("CH_TL_START_NOTE", new SongAttribute("CH_TL_START_NOTE", values[16]));
        attributes.put("CH_TL_DISTINCT_NOTES", new SongAttribute("CH_TL_DISTINCT_NOTES", values[17]));
        attributes.put("CH_TL_TYPE", new SongAttribute("CH_TL_TYPE", values[18]));
        attributes.put("DRUM_PAT", new SongAttribute("DRUM_PAT", values[19]));
        attributes.put("LINE_REP", new SongAttribute("LINE_REP", values[20]));
        attributes.put("LYR_GRADE_LVL", new SongAttribute("LYR_GRADE_LVL", values[21]));
        attributes.put("TOTAL_WORDS", new SongAttribute("TOTAL_WORDS", values[22]));
        attributes.put("TITLE_REPEATS", new SongAttribute("TITLE_REPEATS", values[23]));
        attributes.put("DISTINCT_HITWORDS", new SongAttribute("DISTINCT_HITWORDS", values[24]));
        attributes.put("HITWORDS_TOTAL", new SongAttribute("HITWORDS_TOTAL", values[25]));
        attributes.put("RHYMECOUNT", new SongAttribute("RHYMECOUNT", values[26]));
        attributes.put("LYR_ARCHETYPE", new SongAttribute("LYR_ARCHETYPE", values[27]));
        attributes.put("HIT_WRITER", new SongAttribute("HIT_WRITER", values[28]));

    }

    public DataTuple(String INTRO_LEN,
                     String TEMPO,
                     String GENRE,
                     String LEAD_SING,
                     String CHART_POS) {

        attributes = new LinkedHashMap<>();
        attributes.put("INTRO_LEN", new SongAttribute("INTRO_LEN", INTRO_LEN));
        attributes.put("TEMPO", new SongAttribute("TEMPO", TEMPO));
        attributes.put("GENRE", new SongAttribute("GENRE", GENRE));
        attributes.put("LEAD_SING", new SongAttribute("LEAD_SING", LEAD_SING));
        attributes.put("CHART_POS", new SongAttribute("CHART_POS", CHART_POS));
    }

    public DataTuple(String INTRO_LEN,
                     String TEMPO,
                     String GENRE,
                     String LEAD_SING) {

        attributes = new LinkedHashMap<>();
        attributes.put("INTRO_LEN", new SongAttribute("INTRO_LEN", INTRO_LEN));
        attributes.put("TEMPO", new SongAttribute("TEMPO", TEMPO));
        attributes.put("GENRE", new SongAttribute("GENRE", GENRE));
        attributes.put("LEAD_SING", new SongAttribute("LEAD_SING", LEAD_SING));
    }


    public String printTuple() {

        String attributeValues = "";
        for (SongAttribute a : attributes.values()
        ) {
            attributeValues += a.getName() + "=" + a.getValue() + ", ";
        }
        return attributeValues;

    }



    public SongAttribute getTargetClass() {
        return attributes.get("CHART_POS");
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
