package com.m3.c216.dvdLibrary.ui;

import com.m3.c216.dvdLibrary.dto.DVD;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class View {
    private final UserIO userIO;
    private final int MENU_PADDING = 24;
    private final int BANNER_PADDING = 30;

    public View(UserIO userIO){
        this.userIO = userIO;
    }

    public int printMainMenuAndGetSelection(){
        userIO.print("|"+StringUtils.center("Main Menu", MENU_PADDING, "-")+"|");
        userIO.print("|\t1. Add DVD           |");
        userIO.print("|\t2. Remove DVD        |");
        userIO.print("|\t3. Edit DVD          |");
        userIO.print("|\t4. Search for DVD    |");
        userIO.print("|\t5. View all DVDs     |");
        userIO.print("|\t0. Exit              |");
        userIO.print("|"+StringUtils.center("_", MENU_PADDING, "_")+"|");

        return userIO.readInt("Please select from the above choices.");
    }

    public int printEditMenuAndGetSelection(){
        userIO.print("|"+StringUtils.center("Edit Menu", MENU_PADDING, "-")+"|");
        userIO.print("|\t1. Title             |");
        userIO.print("|\t2. Release Date      |");
        userIO.print("|\t3. MPAA Rating       |");
        userIO.print("|\t4. Director's name   |");
        userIO.print("|\t5. Studio            |");
        userIO.print("|\t6. User Rating       |");
        userIO.print("|\t0. Exit              |");
        userIO.print("|"+StringUtils.center("_", MENU_PADDING, "_")+"|");

        return userIO.readInt("Please select which property you want to edit");
    }

    public DVD getNewDVDInfo(){
        String title = getDVDTitle(false);
        String releaseDate = userIO.readString("Please enter DVD Release Date:");
        String MPAARating = userIO.readString("Please enter DVD MPAA Rating:");
        String directorName = userIO.readString("Please enter the Director's name of DVD:");
        String studio = userIO.readString("Please enter DVD Studio:");

        return new DVD(title, releaseDate, MPAARating, directorName, studio);
    }

    public String getDVDTitle(boolean forEdit){
        if(forEdit)
        {
            return userIO.readString("Please enter the Title of the DVD you wish to Edit:");
        }
        else {
            return userIO.readString("Please enter DVD Title: ");
        }
    }

    public String getDVDEditInfo(String property){
        return userIO.readString("Enter a new "+property+": ");
    }

    public void viewDVD(DVD dvd){
        if(dvd != null){
            userIO.print("Title:        "+dvd.getTitle());
            userIO.print("Release Date: "+dvd.getReleaseDate());
            userIO.print("MPAA Rating:  "+dvd.getMPPAARating());
            userIO.print("Director:     "+dvd.getDirectorName());
            userIO.print("Studio:       "+dvd.getStudio());
            userIO.print("User Rating:  "+dvd.getUserRating());
            userIO.print("");
        }
        else{
            displayNoSuchDVD();
        }
    }

    public void viewAllDVD(List<DVD> dvdList){
        if(dvdList.isEmpty()){
            displayNoDVDsInCollection();
        }
        else{
            for(DVD dvd : dvdList){
                viewDVD(dvd);
            }
        }
    }

    public void displayAddDVDBanner(){
        userIO.print(StringUtils.center("Adding New DVD", BANNER_PADDING, "="));
        userIO.print(StringUtils.center("=", BANNER_PADDING, "="));
    }


    public void displayRemoveDVDBanner(){
        userIO.print(StringUtils.center("Removing DVD", BANNER_PADDING, "="));
        userIO.print(StringUtils.center("=", BANNER_PADDING, "="));
    }

    public void displayEditingDVDBanner(){
        userIO.print(StringUtils.center("Editing a DVD", BANNER_PADDING, "="));
        userIO.print(StringUtils.center("=", BANNER_PADDING, "="));
    }

    public void displayViewingAllDVDs(){
        userIO.print(StringUtils.center("Viewing All DVDs", BANNER_PADDING, "="));
        userIO.print(StringUtils.center("=", BANNER_PADDING, "="));
    }

    public void displaySearchResultBanner(){

        userIO.print(StringUtils.center("SEARCH RESULT", BANNER_PADDING, "~"));
        userIO.print(StringUtils.center("~", BANNER_PADDING, "~"));
    }

    public void displayNoDVDsInCollection(){
        userIO.print("*** NO DVDs IN COLLECTION ***");
    }

    public void displaySearchDVDBanner(){
        userIO.print(StringUtils.center("Searching For DVD", BANNER_PADDING, "="));
        userIO.print(StringUtils.center("=", BANNER_PADDING, "="));
    }

    public void displayAddDVDVerification(){
        userIO.print(StringUtils.center("~", BANNER_PADDING, "~"));
        userIO.print(StringUtils.center("DVD SUCCESSFULLY ADDED", BANNER_PADDING, "~"));
        userIO.print("");
    }
    public void displayRemoveDVDVerification(DVD dvdRecord){

        if(dvdRecord != null){
            userIO.print(StringUtils.center("~", BANNER_PADDING, "~"));
            userIO.print(StringUtils.center("DVD SUCCESSFULLY REMOVED", BANNER_PADDING, "~"));
            userIO.print("");
        }else{
            displayNoSuchDVD();
        }
        userIO.print("");
    }

    public void displayEditPropertyVerification(String property){
        userIO.print(StringUtils.center("~", BANNER_PADDING, "~"));
        userIO.print(StringUtils.center(property+ " SUCCESSFULLY CHANGED", BANNER_PADDING, "~"));
        userIO.print("");
    }

    public void displayEditMenuClose(){
        userIO.print(StringUtils.center("~", BANNER_PADDING, "~"));
        userIO.print(StringUtils.center("EXITING EDIT MENU", BANNER_PADDING, "~"));
        userIO.print("");
    }

    public void displayUnknownCommandBanner(){
        userIO.print("*** UNKNOWN COMMAND ***");
        userIO.print("");
    }
    public void displayGoodByeMessage(){
        userIO.print("*** GOODBYE ***");
    }

    public void displayNoSuchDVD(){
        userIO.print("*** NO SUCH DVD ***");
        userIO.print("");
    }

    public void displayErrorMessage(String errorMessage){
        userIO.print("*** ERROR ***");
        userIO.print(errorMessage);
        userIO.print("");}
}
