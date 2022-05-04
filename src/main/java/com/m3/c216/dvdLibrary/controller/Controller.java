package com.m3.c216.dvdLibrary.controller;

import com.m3.c216.dvdLibrary.dao.Dao;
import com.m3.c216.dvdLibrary.dao.DaoException;
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

        try{
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
                        editDVD();
                        break;
                    case 4:
                        searchDVD();
                        break;
                    case 5:
                        viewAllDVDs();
                        break;
                    case 0:
                        closeMenu = true;
                        break;
                    default:
                        unknownCommand();
                }
            }
            goodbyeMessage();
        }catch (DaoException e){
            view.displayErrorMessage(e.getMessage());
        }

    }

    private int getMenuSelection(){
        return view.printMainMenuAndGetSelection();
    }

    private void addDVD() throws DaoException{
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD);
        view.displayAddDVDVerification();
    }

    private void removeDVD() throws DaoException{
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitle(false);
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveDVDVerification(removedDVD);
    }

    private void searchDVD() throws DaoException{
        view.displaySearchDVDBanner();
        String title = view.getDVDTitle(false);
        DVD dvd = dao.getDVD(title);
        view.viewDVD(dvd);
    }

    private void editDVD() throws DaoException{
        view.displayEditingDVDBanner();
        boolean closeEditMenu = false;
        int editMenuSelection;

        DVD dvdToEdit = dao.getDVD(view.getDVDTitle(true));

        if(dvdToEdit != null){
            String newTitle = dvdToEdit.getTitle();
            String relDate = dvdToEdit.getReleaseDate();
            String mpaaRating = dvdToEdit.getMPPAARating();
            String dirName = dvdToEdit.getDirectorName();
            String studio = dvdToEdit.getStudio();
            String userRating = dvdToEdit.getUserRating();

            while(!closeEditMenu){
                editMenuSelection = view.printEditMenuAndGetSelection();

                switch (editMenuSelection){
                    case 1:
                        newTitle = view.getDVDEditInfo("Title");
                        view.displayEditPropertyVerification("TITLE");
                        dao.removeDVD(dvdToEdit.getTitle());
                        closeEditMenu = true;
                        break;
                    case 2:
                        relDate = view.getDVDEditInfo("Release Date");
                        view.displayEditPropertyVerification("RELEASE DATE");
                        break;
                    case 3:
                        mpaaRating = view.getDVDEditInfo("MPAA Rating");
                        view.displayEditPropertyVerification("MPAA RATING");
                        break;
                    case 4:
                        dirName = view.getDVDEditInfo("Director Name");
                        view.displayEditPropertyVerification("DIRECTOR NAME");
                        break;
                    case 5:
                        studio = view.getDVDEditInfo("Studio");
                        view.displayEditPropertyVerification("STUDIO");
                        break;
                    case 6:
                        userRating = view.getDVDEditInfo("User Rating");
                        view.displayEditPropertyVerification("USER RATING");
                        break;
                    case 0:
                        closeEditMenu = true;
                        break;
                    default:
                        unknownCommand();
                }
                dao.addDVD(new DVD(newTitle, relDate, mpaaRating, dirName, studio, userRating));
            }
        }
        else{
            view.displayNoSuchDVD();
        }
    }

    private void viewAllDVDs() throws DaoException {
        view.displayViewingAllDVDs();
        view.viewAllDVD(dao.getAllDVDs());
    }

    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }

    private void goodbyeMessage(){
        view.displayGoodByeMessage();
    }
}
