package com.m3.c216.dvdLibrary.ui;

import com.m3.c216.dvdLibrary.dto.DVD;

public class View {
    private UserIO userIO;

    public View(UserIO userIO){
        this.userIO = userIO;
    }

    public int printMenuAndGetSelection(){
        //TODO: Add more buttons
        //TODO: Change exit button and readInt()
        userIO.print("--- Main Menu ---");
        userIO.print("\t1. Add DVD");
        userIO.print("\t2. Remove DVD");
        userIO.print("\t0. Exit");

        return userIO.readInt("Please select from the above choices.");
    }

    public DVD getNewDVDInfo(){
        String title = userIO.readString("Please enter DVD Title:");
        String releaseDate = userIO.readString("Please enter DVD Release Date:");
        String MPAARating = userIO.readString("Please enter DVD MPAA Rating:");
        String directorName = userIO.readString("Please enter the Director's name of DVD:");
        String studio = userIO.readString("Please enter DVD Studio:");

        return new DVD(title, releaseDate, MPAARating, directorName, studio);
    }

    public String getDVDTitle(){
        return userIO.readString("Please enter DVD Title:");
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

    public void displayRemoveDVDVerification(DVD dvdRecord){

        if(dvdRecord != null){
            userIO.print("~~~ DVD SUCCESSFULLY REMOVED ~~~");
        }else{
            userIO.print("*** NO SUCH DVD ***");
        }
        userIO.print("");
    }

    public void displayUnknownCommandBanner(){
        userIO.print("*** UNKNOWN COMMAND ***");
    }
    public void displayGoodByeMessage(){
        userIO.print("*** GOODBYE ***");
    }
}
