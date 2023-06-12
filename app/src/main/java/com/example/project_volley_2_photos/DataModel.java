package com.example.project_volley_2_photos;

//public class DataModel
//{


import android.net.Uri;
import android.graphics.Bitmap;

public class DataModel {
        private long albumId;
        private long id;
        private String title;
        private String url;
        private String thumbnailUrl;
    private android.net.Uri Uri;

    public DataModel(long albumID, long id, String title, String url, String thumbnailURL)
    {
        this.albumId = albumID;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailURL;
    }

    public long getAlbumId() {
            return albumId;
        }
        public void setAlbumId(Integer albumId) {
            this.albumId = albumId;
        }
        public long getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public String getThumbnailUrl() {
            return thumbnailUrl;
        }
        public void setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
        }

    public Uri thumbnailUrl() {
        return Uri;
    }
}


