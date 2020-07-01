package lyricAnalysis;

import java.util.List;

public class SongTitleAnalysis {

    private int titleRepeats;
    private String songTitle;


    public SongTitleAnalysis(String songTitle){
        titleRepeats = 0;
        this.songTitle = songTitle;
    }

    public boolean titleInLyrics(List<String> lyrics) {
        for (int i = 0; i < lyrics.size(); i++) {
            if (lyrics.get(i).toLowerCase().equalsIgnoreCase(songTitle.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public int songTitleRepeats(List<String> lyrics) {
        int count = 0;

        for (int i = 0; i < lyrics.size(); i++) {
            int fromIndex = 0;
            int indexFound = 0;
            String checkMeForTitle = lyrics.get(i);
            indexFound = checkMeForTitle.indexOf(songTitle,fromIndex);
            while(indexFound!=0){
                count++;
                fromIndex++;
                indexFound = checkMeForTitle.indexOf(songTitle,fromIndex);
            }
            }

        return count;
    }



}


