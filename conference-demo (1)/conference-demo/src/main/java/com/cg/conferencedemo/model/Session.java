package com.cg.conferencedemo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="session")
public class Session {
    @Id
    private Long session_id;
    private String session_name;
    private  String getSession_description;
    private Integer session_length;



    public Session() {
    }



    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getGetSession_description() {
        return getSession_description;
    }

    public void setGetSession_description(String getSession_description) {
        this.getSession_description = getSession_description;
    }

    public Integer getSession_length() {
        return session_length;
    }

    public void setSession_length(Integer session_length) {
        this.session_length = session_length;
    }

    public Session(Long session_id, String session_name, String getSession_description, Integer session_length) {
        this.session_id = session_id;
        this.session_name = session_name;
        this.getSession_description = getSession_description;
        this.session_length = session_length;
    }

    @Override
    public String toString() {
        return "Session{" +
                "session_id=" + session_id +
                ", session_name='" + session_name + '\'' +
                ", getSession_description='" + getSession_description + '\'' +
                ", session_length=" + session_length +
                '}';
    }
}
