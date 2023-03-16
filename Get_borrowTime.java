package com.example.ohumbrella;

public class Get_borrowTime {
    private String borrowTime="";

    public String getTime(){
        return borrowTime;
    }

    public void setTime(String borrowtime){
        this.borrowTime = borrowtime;
    }
    private static Get_borrowTime instance = null;

    public static synchronized Get_borrowTime getInstance(){
        if(instance ==null){
            instance = new Get_borrowTime();
        }
        return instance;
    }

}
