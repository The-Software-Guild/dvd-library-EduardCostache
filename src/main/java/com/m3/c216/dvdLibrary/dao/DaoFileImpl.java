package com.m3.c216.dvdLibrary.dao;

import com.m3.c216.dvdLibrary.dto.DVD;

import java.util.*;

public class DaoFileImpl implements Dao{

    private Map<String, DVD> dvdMap = new HashMap<>();

    @Override
    public DVD addDVD(DVD newDVD) {
        return dvdMap.put(newDVD.getTitle(), newDVD);
    }

    @Override
    public DVD removeDVD(String title) {
        return dvdMap.remove(title);
    }

    @Override
    public DVD getDVD(String title) {
        return dvdMap.get(title);
    }

    @Override
    public List<DVD> getAllDVDs() {
        List<DVD> dvdList = new ArrayList<>();

        for(String key : dvdMap.keySet()){
            dvdList.add(getDVD(key));
        }

        return dvdList;
    }
}
