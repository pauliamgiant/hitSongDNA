package lyricAnalysis;




public class LyricalComplexityAnalysis {


    private static int getGrade(){
        return 0;
    }

    /**
     *
     * @author https://gist.github.com/Drainet/89cfbd78dcb96bdd39108cb4469e3c0b
     * @param sentence
     * @return
     *
     */

// Coleman–Liau index

    private static double calculateCLIValue(String sentence) {
        int letterCount = 0;
        int spaceCount = 0;
        int sentenceCount = 0;
        int length = sentence.length();
        for (int i = 0; i < length; i++) {
            char c = sentence.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                letterCount++;
            } else if (c == ' ') {
                spaceCount++;
            } else if (c == '.') {
                if (i != length - 1 && sentence.charAt(i + 1) == ' ') {
                    sentenceCount++;
                }
            }

        }
        int wordCount = spaceCount + 1;

        double l = (double) letterCount / (double) wordCount * 100;
        double s = (double) sentenceCount / (double) wordCount * 100;

        return 0.0588 * l - 0.296 * s - 15.8;
    }
}


 //Flesch-Kincaid ( 0.39 * ( float words.Length) / (float sentences.Length ) ) + ( 11.8 * (float syllableCount ) / ( float words.Length) ) - 15.59