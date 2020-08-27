package classifier;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DataTuple {

    /**
     * Provides datatuple object by creating range of SongAttribute objects from array of values
     */

    private LinkedHashMap<String, SongAttribute> attributes;

    public DataTuple(String[] values) {

        attributes = new LinkedHashMap<String, SongAttribute>();
        attributes.put("INTRO_LEN", new SongAttribute("INTRO_LEN", values[0]));
        attributes.put("TEMPO", new SongAttribute("TEMPO", values[1]));
        attributes.put("GENRE", new SongAttribute("GENRE", values[2]));
        attributes.put("LEAD_SING", new SongAttribute("LEAD_SING", values[3]));
        attributes.put("KEY_VS", new SongAttribute("KEY_VS", values[4]));
        attributes.put("CHORDS_VS", new SongAttribute("CHORDS_VS", values[5]));
        attributes.put("VS_STARTS_ON_I", new SongAttribute("VS_STARTS_ON_I", values[6]));
        attributes.put("IONIAN_VS_KEY", new SongAttribute("IONIAN_VS_KEY", values[7]));
        attributes.put("IONIAN_VS_CHORDS", new SongAttribute("IONIAN_VS_CHORDS", values[8]));
        attributes.put("VS_DISTINCT_CHRD_COUNT", new SongAttribute("VS_DISTINCT_CHRD_COUNT", values[9]));
        attributes.put("VS_CH_SAME_CHRDS", new SongAttribute("VS_CH_SAME_CHRDS", values[10]));
        attributes.put("VS_KEY_CHNGS", new SongAttribute("VS_KEY_CHNGS", values[11]));
        attributes.put("CHORDS_CH", new SongAttribute("CHORDS_CH", values[12]));
        attributes.put("CH_STARTS_ON_I", new SongAttribute("CH_STARTS_ON_I", values[13]));
        attributes.put("IONIAN_CH_CHORDS", new SongAttribute("IONIAN_CH_CHORDS", values[14]));
        attributes.put("CH_DISTINCT_CHRD_COUNT", new SongAttribute("CH_DISTINCT_CHRD_COUNT", values[15]));
        attributes.put("SONG_TOTAL_CHORD_COUNT", new SongAttribute("SONG_TOTAL_CHORD_COUNT", values[16]));
        attributes.put("VS_TOPLINE", new SongAttribute("VS_TOPLINE", values[17]));
        attributes.put("VS_TL_START_NOTE", new SongAttribute("VS_TL_START_NOTE", values[18]));
        attributes.put("VS_TL_DISTINCT_NOTES", new SongAttribute("VS_TL_DISTINCT_NOTES", values[19]));
        attributes.put("VS_TL_TYPE", new SongAttribute("VS_TL_TYPE", values[20]));
        attributes.put("CH_TOPLINE", new SongAttribute("CH_TOPLINE", values[21]));
        attributes.put("CH_TL_START_NOTE", new SongAttribute("CH_TL_START_NOTE", values[22]));
        attributes.put("CH_TL_DISTINCT_NOTES", new SongAttribute("CH_TL_DISTINCT_NOTES", values[23]));
        attributes.put("CH_TL_TYPE", new SongAttribute("CH_TL_TYPE", values[24]));
        attributes.put("DRUM_PAT", new SongAttribute("DRUM_PAT", values[25]));
        attributes.put("LINE_REP", new SongAttribute("LINE_REP", values[26]));
        attributes.put("LYR_GRADE_LVL", new SongAttribute("LYR_GRADE_LVL", values[27]));
        attributes.put("TOTAL_WORDS", new SongAttribute("TOTAL_WORDS", values[28]));
        attributes.put("TITLE_REPEATS", new SongAttribute("TITLE_REPEATS", values[29]));
        attributes.put("DISTINCT_HITWORDS", new SongAttribute("DISTINCT_HITWORDS", values[30]));
        attributes.put("HITWORDS_TOTAL", new SongAttribute("HITWORDS_TOTAL", values[31]));
        attributes.put("RHYMECOUNT", new SongAttribute("RHYMECOUNT", values[32]));
        attributes.put("LYR_ARCHETYPE", new SongAttribute("LYR_ARCHETYPE", values[33]));
        attributes.put("HIT_WRITER", new SongAttribute("HIT_WRITER", values[34]));
    }

    public DataTuple(Boolean fix) {
        attributes = new LinkedHashMap<String, SongAttribute>();
        SongAttribute sa = new SongAttribute("Test", "Test");
    }

    public DataTuple(Boolean knownTarget, String[] values, Boolean fullAnalysisSet) {
        this(values);
        attributes.put("CHART_POS", new SongAttribute("CHART_POS", values[35]));
        attributes.put("SONG", new SongAttribute("SONG", values[36]));
        attributes.put("ARTIST", new SongAttribute("ARTIST", values[37]));
        attributes.put("KEY_CH", new SongAttribute("KEY_CH", values[38]));
        attributes.put("IONIAN_CH_KEY", new SongAttribute("IONIAN_CH_KEY", values[39]));
        attributes.put("CH_KEY_CHNGS", new SongAttribute("CH_KEY_CHNGS", values[40]));
        attributes.put("DISTINCT_WORDS", new SongAttribute("DISTINCT_WORDS", values[41]));
        attributes.put("TITLE_IN_LYRICS", new SongAttribute("TITLE_IN_LYRICS", values[42]));
        attributes.put("STAR_COLLAB", new SongAttribute("STAR_COLLAB", values[43]));

    }


    public DataTuple(Boolean knownTarget, String[] values) {
        this(values);
        attributes.put("CHART_POS", new SongAttribute("CHART_POS", values[35]));


    }


    public String printTuple() {
        String attributeValues = "";
        for (SongAttribute a : attributes.values()
        ) {
            attributeValues += a.getName() + "=" + a.getValue() + ", ";
        }
        return attributeValues;
    }

    /**
     *
     * @return The HIT or MISS classification Attribute
     */
    public SongAttribute getTargetClass() {
        if (attributes.get("CHART_POS") != null) {
            return attributes.get("CHART_POS");
        } else return null;
    }

    /**
     *
     * @param typeOfAttribute name of Attribute i.e. 'TEMPO'
     * @return Attribute selected by name
     */
    public SongAttribute getAttribute(String typeOfAttribute) {
        return attributes.get(typeOfAttribute);
    }

    /**
     *
     * @return List of Tuple attribute values only
     */
    public List getAllTupleAttributeValues() {
        ArrayList<SongAttribute> listOfAllAttr = new ArrayList<>();
        for (SongAttribute sa : attributes.values()) {
            listOfAllAttr.add(sa);
        }
        return listOfAllAttr;
    }

    public int numberOfAttributes() {
        return attributes.size();
    }

}
