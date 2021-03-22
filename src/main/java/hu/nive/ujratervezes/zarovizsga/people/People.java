package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {


    public int getNumberOfMales(String path) {
        int count = 0;
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] arr = line.split(",");
                if(arr[4].equalsIgnoreCase("male")){
                    count++;
                }

            }

        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
        return count;
    }


}

