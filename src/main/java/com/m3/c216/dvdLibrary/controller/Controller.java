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
                case 2:
                    removeDVD();
                    break;
                case 3:
                    userIO.print("EDIT DVD");
                    break;
                case 4:
                    searchDVD();
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
        return view.printMainMenuAndGetSelection();
    }

    private void addDVD(){
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD);
        view.displayAddDVDVerification();
    }

    private void removeDVD(){
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitle();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveDVDVerification(removedDVD);
    }

    private void searchDVD(){
        view.displaySearchDVDBanner();
        String title = view.getDVDTitle();
        DVD dvd = dao.getDVD(title);
        view.viewDVD(dvd);
    }

    private void editDVD(){
        boolean closeEditMenu = false;
        int editMenuSelection;

        while(!closeEditMenu){
            editMenuSelection = view.printEditMenuAndGetSelection();

            switch (editMenuSelection){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 0:
                    closeEditMenu = true;
                    break;
                default:
                    unknownCommand();
            }
        }
    }

    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }

    private void goodbyeMessage(){
        view.displayGoodByeMessage();
    }
}
