package com.m3.c216.dvdLibrary.dao;

import com.m3.c216.dvdLibrary.dto.DVD;

import java.io.*;
import java.util.*;

public class DaoFileImpl implements Dao{
    private static final String DELIMITER = "::";
    private static final String PATH_TO_FILE = "src/main/java/com/m3/c216/dvdLibrary/data/dvds.txt";

    private Map<String, DVD> dvdMap = new HashMap<>();

    @Override
    public DVD addDVD(DVD newDVD) throws DaoException{
        loadFile();
        DVD previousDVD = dvdMap.put(newDVD.getTitle(), newDVD);
        writeFile();
        return previousDVD;
    }

    @Override
    public DVD removeDVD(String title) throws DaoException{
        loadFile();
        DVD removedDVD = dvdMap.remove(title);
        writeFile();
        return removedDVD;
    }

    @Override
    public DVD getDVD(String title) throws DaoException{
        loadFile();
        return dvdMap.get(title);
    }

    @Override
    public List<DVD> getAllDVDs() throws DaoException{
        loadFile();
        List<DVD> dvdList = new ArrayList<>();

        for(String key : dvdMap.keySet()){
            dvdList.add(getDVD(key));
        }

        return dvdList;
    }

    private String marshallDVD(DVD dvd){
        return dvd.getTitle() + DELIMITER +
                dvd.getReleaseDate() + DELIMITER +
                dvd.getMPPAARating() + DELIMITER +
                dvd.getDirectorName() + DELIMITER +
                dvd.getStudio() + DELIMITER +
                dvd.getUserRating();
    }

    private DVD unMarshallDVD(String line){
        String[] dvdProperties = line.split(DELIMITER);
        return new DVD(dvdProperties[0], dvdProperties[1], dvdProperties[2], dvdProperties[3], dvdProperties[4], dvdProperties[5]);
    }

    private void loadFile() throws DaoException{
        Scanner scanner;

        try{
            scanner = new Scanner(new BufferedReader(new FileReader(PATH_TO_FILE)));

        }catch (FileNotFoundException e){
            throw new DaoException("Could not load Roster data.", e);
        }

        String currentLine;
        DVD currentDVD;

        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentDVD = unMarshallDVD(currentLine);
            dvdMap.put(currentDVD.getTitle(), currentDVD);
        }

        scanner.close();
    }

    private void writeFile() throws DaoException{
        PrintWriter out;

        try{
            out = new PrintWriter(new FileWriter(PATH_TO_FILE));
        }catch (IOException e){
            throw new DaoException("Could not write to Roster.", e);
        }

        String dvdAsText;
        List<DVD> dvdList = this.getAllDVDs();

        for(DVD dvd : dvdList){
            dvdAsText = marshallDVD(dvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }
}
