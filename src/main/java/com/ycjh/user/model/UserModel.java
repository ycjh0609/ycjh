package com.ycjh.user.model;


public class UserModel {

    private String user_id;
    private String user_pwd;
    //need login
    private String secured_user_id;
    private String secured_user_pwd;

    private String user_name;
    private String user_email;
    private String user_phonenum;
    private String user_profile;
    private String user_type;
    private String reg_date;
    private String udt_date;
    private String team_id;



    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_phonenum() {
        return user_phonenum;
    }

    public void setUser_phonenum(String user_phonenum) {
        this.user_phonenum = user_phonenum;
    }

    public String getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(String user_profile) {
        this.user_profile = user_profile;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getUdt_date() {
        return udt_date;
    }

    public void setUdt_date(String udt_date) {
        this.udt_date = udt_date;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getSecured_user_pwd() {
        return secured_user_pwd;
    }

    public void setSecured_user_pwd(String secured_user_pwd) {
        this.secured_user_pwd = secured_user_pwd;
    }

    public String getSecured_user_id() {
        return secured_user_id;
    }

    public void setSecured_user_id(String secured_user_id) {
        this.secured_user_id = secured_user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
