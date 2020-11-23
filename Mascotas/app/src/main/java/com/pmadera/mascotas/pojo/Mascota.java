package com.pmadera.mascotas.pojo;

import java.util.Date;

public class Mascota {
    private String id;
    private String media_url;

    public Mascota(String id, String media_url) {
        this.id = id;
        this.media_url = media_url;
    }

    public Mascota() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }
}
