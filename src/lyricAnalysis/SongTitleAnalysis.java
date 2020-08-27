package lyricAnalysis;

import java.util.List;

public class SongTitleAnalysis {

    /**
     * Counts number of Song Title repeats in the lyrics
     */
    private int titleRepeats;
    private String songTitle;


    public SongTitleAnalysis(String songTitle) {
        titleRepeats = 0;
        this.songTitle = songTitle;
    }

    public boolean titleInLyrics(List<String> lyrics) {
            if(songTitleRepeats(lyrics)>0){
                return true;
            }
            else return false;
    }

    public int songTitleRepeats(List<String> lyrics) {
        int count = 0;
        for (int i = 0; i < lyrics.size(); i++) {
            int fromIndex = 0;
            int indexFound = 0;
            String checkMeForTitle = lyrics.get(i).toLowerCase();
           //System.out.println(checkMeForTitle);
            indexFound = checkMeForTitle.indexOf(songTitle.toLowerCase(), fromIndex);
            //System.out.println(indexFound);
            while (indexFound != -1) {
                count++;
                fromIndex = indexFound+1;
                indexFound = checkMeForTitle.indexOf(songTitle.toLowerCase(), fromIndex);
            }
        }
        return count;
    }




}


