package com.m3.c216.dvdLibrary.dao;

import com.m3.c216.dvdLibrary.dto.DVD;

import java.util.HashMap;
import java.util.Map;

public class DaoFileImpl implements Dao{

    private Map<String, DVD> DVDMap = new HashMap<>();

    @Override
    public DVD addDVD(DVD newDVD) {
        return null;
    }
}
