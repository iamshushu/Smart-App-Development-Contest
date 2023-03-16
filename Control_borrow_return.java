package com.example.ohumbrella;

public class Control_borrow_return {
    private boolean Borrow1 = true;
    private boolean Return1 = false;

    public boolean getBorrow1(){
        return Borrow1;
    }
    public boolean getReturn1() { return Return1; }
    public void setBorrow1(boolean borrow1){
        this.Borrow1 = borrow1;
    }
    public void setReturn1(boolean return1){
        this.Borrow1 = return1;
    }


    private static Control_borrow_return instance = null;

    public static synchronized Control_borrow_return getInstance(){
        if(instance ==null){
            instance = new Control_borrow_return();
        }
        return instance;
    }
}
