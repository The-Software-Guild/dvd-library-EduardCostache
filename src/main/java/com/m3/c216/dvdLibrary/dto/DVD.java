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
        userRating = "None";
    }

    public DVD(String title, String releaseDate, String MPPAARating, String directorName, String studio, String userRating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.MPPAARating = MPPAARating;
        this.directorName = directorName;
        this.studio = studio;
        this.userRating = userRating;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMPPAARating(String MPPAARating) {
        this.MPPAARating = MPPAARating;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
