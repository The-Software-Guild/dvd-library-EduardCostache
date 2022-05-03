package com.m3.c216.dvdLibrary;

import com.m3.c216.dvdLibrary.controller.Controller;
import com.m3.c216.dvdLibrary.dao.Dao;
import com.m3.c216.dvdLibrary.dao.DaoFileImpl;
import com.m3.c216.dvdLibrary.ui.UserIO;
import com.m3.c216.dvdLibrary.ui.UserIOConsoleImpl;
import com.m3.c216.dvdLibrary.ui.View;

public class App {
    public static void main(String[] args) {
        UserIO userIO = new UserIOConsoleImpl();
        Dao dao = new DaoFileImpl();
        View view = new View(userIO);

        Controller controller = new Controller(dao, view);

        controller.run();
    }
}
