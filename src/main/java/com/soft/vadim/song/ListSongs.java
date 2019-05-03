package com.soft.vadim.song;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListSongs {

    @SerializedName("songs")
    @Expose
    private List<Song> songs = null;
    @SerializedName("vkUserId")
    @Expose
    private int vkUserId;
    @SerializedName("pagesCount")
    @Expose
    private int pagesCount;

    /**
     * No args constructor for use in serialization
     *
     */
    public ListSongs() {
    }


    public ListSongs(List<Song> songs, int vkUserId, int pagesCount) {
        super();
        this.songs = songs;
        this.vkUserId = vkUserId;
        this.pagesCount = pagesCount;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public ListSongs withSongs(List<Song> songs) {
        this.songs = songs;
        return this;
    }

    public int getVkUserId() {
        return vkUserId;
    }

    public void setVkUserId(int vkUserId) {
        this.vkUserId = vkUserId;
    }

    public ListSongs withVkUserId(int vkUserId) {
        this.vkUserId = vkUserId;
        return this;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public ListSongs withPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
        return this;
    }

}