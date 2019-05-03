package com.soft.vadim.song;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Song {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("details")
    @Expose
    private Object details;
    @SerializedName("index")
    @Expose
    private int index;

    /**
     * No args constructor for use in serialization
     */
    public Song() {
    }


    public Song(String id, String url, String artist, String title, String duration, Object details, int index) {
        super();
        this.id = id;
        this.url = url;
        this.artist = artist;
        this.title = title;
        this.duration = duration;
        this.details = details;
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Song withId(String id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Song withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Song withArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Song withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Song withDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public Song withDetails(Object details) {
        this.details = details;
        return this;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Song withIndex(int index) {
        this.index = index;
        return this;
    }

    @Override
    public String toString() {
        return artist + " - " + title + "  " + duration;

    }
}