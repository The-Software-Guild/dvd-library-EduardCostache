package com.m3.c216.dvdLibrary.dao;

import com.m3.c216.dvdLibrary.dto.DVD;

import java.util.HashMap;
import java.util.Map;

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
}
