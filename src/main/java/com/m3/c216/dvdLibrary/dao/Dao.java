package com.m3.c216.dvdLibrary.dao;

import com.m3.c216.dvdLibrary.dto.DVD;

import java.util.List;

public interface Dao {
    DVD addDVD(DVD newDVD) throws DaoException;

    DVD removeDVD(String title) throws DaoException;

    DVD getDVD(String title) throws DaoException;

    List<DVD> getAllDVDs() throws DaoException;
}
