package com.m3.c216.dvdLibrary.ui;

import com.m3.c216.dvdLibrary.dto.DVD;

import java.util.List;

public class View {
    private UserIO userIO;

    public View(UserIO userIO){
        this.userIO = userIO;
    }

    public int printMainMenuAndGetSelection(){
        //TODO: Add more buttons
        //TODO: Change exit button and readInt()
        userIO.print("--- Main Menu ---");
        userIO.print("\t1. Add DVD");
        userIO.print("\t2. Remove DVD");
        userIO.print("\t3. Edit DVD");
        userIO.print("\t4. Search for DVD");
        userIO.print("\t5. View all DVDs");
        userIO.print("\t0. Exit");

        return userIO.readInt("Please select from the above choices.");
    }

    public int printEditMenuAndGetSelection(){
        userIO.print("\t--- Edit Menu ---");
        userIO.print("\t\t1. Title");
        userIO.print("\t\t2. Release Date");
        userIO.print("\t\t3. MPAA Rating");
        userIO.print("\t\t4. Director's name");
        userIO.print("\t\t5. Studio");
        userIO.print("\t\t6. User Rating");
        userIO.print("\t\t0. Exit");

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
            userIO.print("~~~ SEARCH RESULT ~~~");
            userIO.print("Title: "+dvd.getTitle());
            userIO.print("Release Date: "+dvd.getReleaseDate());
            userIO.print("MPAA Rating: "+dvd.getMPPAARating());
            userIO.print("Director : "+dvd.getDirectorName());
            userIO.print("Studio: "+dvd.getStudio());
            userIO.print("User Rating: "+dvd.getUserRating());
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
        userIO.print("");
        userIO.print("=== Adding new DVD ===");
        userIO.print("");
    }

    public void displayAddDVDVerification(){
        userIO.print("~~~ DVD SUCCESSFULLY ADDED ~~~");
    }

    public void displayRemoveDVDBanner(){
        userIO.print("");
        userIO.print("=== Removing a DVD ===");
        userIO.print("");
    }

    public void displayEditingDVDBanner(){
        userIO.print("");
        userIO.print("=== Editing a DVD ===");
        userIO.print("");
    }

    public void displayViewingAllDVDs(){
        userIO.print("");
        userIO.print("=== Viewing all DVDs ===");
        userIO.print("");
    }

    public void displayNoDVDsInCollection(){
        userIO.print("*** NO DVDs IN COLLECTION ***");
    }

    public void displaySearchDVDBanner(){
        userIO.print("");
        userIO.print("=== Searching for DVD ===");
        userIO.print("");
    }

    public void displayRemoveDVDVerification(DVD dvdRecord){

        if(dvdRecord != null){
            userIO.print("~~~ DVD SUCCESSFULLY REMOVED ~~~");
        }else{
            displayNoSuchDVD();
        }
        userIO.print("");
    }

    public void displayEditPropertyVerification(String property){
        userIO.print("~~~ "+property+" SUCCESSFULLY CHANGED ~~~");
    }

    public void displayUnknownCommandBanner(){
        userIO.print("*** UNKNOWN COMMAND ***");
    }
    public void displayGoodByeMessage(){
        userIO.print("*** GOODBYE ***");
    }

    public void displayNoSuchDVD(){
        userIO.print("*** NO SUCH DVD ***");
    }

    public void displayErrorMessage(String errorMessage){
        userIO.print("*** ERROR ***");
        userIO.print(errorMessage);}
}
