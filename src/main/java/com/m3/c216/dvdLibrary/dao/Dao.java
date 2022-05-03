package com.m3.c216.dvdLibrary.dao;

import com.m3.c216.dvdLibrary.dto.DVD;

public interface Dao {
    DVD addDVD(DVD newDVD);

    DVD removeDVD(String title);


    DVD getDVD(String title);
}
