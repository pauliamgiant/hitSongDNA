package classifier;

import java.util.Map;
import java.util.Set;

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
    private Map<String, Set> attributesAndValues;

    private AttributeRegistry() {
    }

    public static AttributeRegistry getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AttributeRegistry();
        }

        return INSTANCE;
    }

    public void updateAttributeDataFromARFF(Map<String, Set> mapOfAttributes) {
        attributesAndValues = mapOfAttributes;
    }

    public boolean validAttributeValue(String attributeName, String value) {
        if(attributesAndValues.get(attributeName).contains(value)==false){
            System.out.println(value + " is an INVALID value for "+attributeName);
            return false;
        }
        return true;
    }

    public void printAttributesAndVals() {
        System.out.println(attributesAndValues);
    }
}
