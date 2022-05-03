package com.m3.c216.dvdLibrary.dto;

public class DVD {
    private String title;
    private String releaseDate;
    private String MPPAARating;
    private String directorName;
    private String studio;
    private String userRating;

    public DVD(String title, String releaseDate, String MPPAARating, String directorName, String studio) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.MPPAARating = MPPAARating;
        this.directorName = directorName;
        this.studio = studio;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getMPPAARating() {
        return MPPAARating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getStudio() {
        return studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
}
