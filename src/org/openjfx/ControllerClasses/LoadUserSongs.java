package org.openjfx.ControllerClasses;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadUserSongs {

    public static List<String> loadClassifiedSongs(){
        ArrayList<String> userSongData = new ArrayList<>();
        String filePath = System.getProperty("user.home");
        String filename = "HitSongDNA_user_class_song_data.hsd";
        filePath += File.separator + "Documents" + File.separator + filename;

// Read the content from file

        return getSongs(userSongData, filePath);


    }

    public static List<String> loadSongs() {
        ArrayList<String> userSongData = new ArrayList<>();
        String filePath = System.getProperty("user.home");
        String filename = "HitSongDNA_user_song_data.hsd";
        filePath += File.separator + "Documents" + File.separator + filename;

// Read the content from file

        return getSongs(userSongData, filePath);

    }

    private static List<String> getSongs(ArrayList<String> userSongData, String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();
            String compoundLine = "";
            while (line != null) {


                compoundLine += line + "\n";
                line = bufferedReader.readLine();
                while (line != null && line.equals("")) {
                    System.out.println("blank line skipped");
                    line = bufferedReader.readLine();
                }
                if (line != null && line.charAt(0) == '@') {
                    userSongData.add(compoundLine);
                    compoundLine = "";
                }

            }
            userSongData.add(compoundLine);


            return userSongData;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
