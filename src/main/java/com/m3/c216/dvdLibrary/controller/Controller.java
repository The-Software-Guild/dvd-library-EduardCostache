package com.m3.c216.dvdLibrary.controller;

import com.m3.c216.dvdLibrary.dao.Dao;
import com.m3.c216.dvdLibrary.dto.DVD;
import com.m3.c216.dvdLibrary.ui.UserIO;
import com.m3.c216.dvdLibrary.ui.UserIOConsoleImpl;
import com.m3.c216.dvdLibrary.ui.View;

public class Controller {
    private UserIO userIO = new UserIOConsoleImpl();
    private Dao dao;
    private View view;

    public Controller(Dao dao, View view){
        this.dao = dao;
        this.view = view;
    }

    public void run(){
        boolean closeMenu = false;
        int menuSelection;

        while(!closeMenu){
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    addDVD();
                    break;
                case 0:
                    closeMenu = true;
                    break;
                default:
                    unknownCommand();
            }
        }
        goodbyeMessage();
    }

    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    private void addDVD(){
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD);
    }

    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }

    private void goodbyeMessage(){
        view.displayGoodByeMessage();
    }
}
