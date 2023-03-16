package com.example.ohumbrella;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Rest_timeAct extends AppCompatActivity {

    //String borrowTime = (borrow_umb_1science.context_umb_1science).datestr;
    long IAvailableDate;
    long ILeaveDay;
    Integer mDay,mHour,mMin,mSec;
    TextView timer_text;
    String timer_sec;

    private TimerTask second;
    private final Handler handler = new Handler();

    //초기화
    int dYear = 2020;
    int dMonth = 0; //1월은 0부터
    int dDay = 0;
    int dHour = 0;
    int dMin = 0;
    int dSec = 00;

    public void setTimer(int Year, int Month, int Day, int Hour, int Min, int Sec){
        this.dYear = Year;
        this.dMonth = Month;
        this.dDay = Day-2; //따라서 여기를 반납시각 날짜 -2일 (2020,12,5,2,45,00) 넘어왔는데
        this.dHour = Hour;
        this.dMin = Min;
        this.dSec = Sec;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_time);
        timer_text = (TextView) findViewById(R.id.clock);

        String borrowTime = Get_borrowTime.getInstance().getTime();
        if (borrowTime.equals("")){
            setTimer(0,0,0,0,0,0);
        }
        else{
            String[] array = borrowTime.split("/");

            //아래 날짜를 바꿔주면 됨 (년,월,일,시,분,초) //반납시각
            setTimer(Integer.parseInt(array[0])+0,Integer.parseInt(array[1])+1,Integer.parseInt(array[2])+1,
                    Integer.parseInt(array[3])+0,Integer.parseInt(array[4])+0,Integer.parseInt(array[5])+0);  //빌린시각 + 24hours
        }


        testStart();
    }

    public void testStart() {

        Calendar gameDate = null;
        gameDate = Calendar.getInstance();
        gameDate.set(dYear,dMonth,dDay,dHour,dMin,dSec);
        //반납시각 추후 바꿔야함..
        IAvailableDate = gameDate.getTimeInMillis();

        second = new TimerTask() {

            @Override
            public void run() {

                Calendar gameDate2 = null;
                gameDate2 = Calendar.getInstance();
                ILeaveDay = IAvailableDate - gameDate2.getTimeInMillis(); //반납시각- 현재시각 -> 반납시간을 대여기준 시각 +24hours으로 변경해야함

                if(ILeaveDay > 0){
                    gameDate2.setTimeInMillis(ILeaveDay);
                    mDay = gameDate2.get(Calendar.DATE);
                    if(mDay > 1){
                        //며칠인지 표현 안하고 시간으로만 표시하기 위해 처리
                        mHour = ((mDay-1)*24)+(gameDate2.get(Calendar.HOUR_OF_DAY)-9);
                    }else{
                        mHour = gameDate2.get(Calendar.HOUR_OF_DAY)-9;
                    }
                    mMin = gameDate2.get(Calendar.MINUTE);
                    mSec = gameDate2.get(Calendar.SECOND);
                }
                else{
                    timer_sec = "종료";
                }


                Log.i("Test", "Timer start");

                if(mHour == null && mMin == null && mSec == null || mHour == 0 && mMin == 0 && mSec == 0){
                    timer_sec = "현재 대여하신 우산이 없습니다";
                }else{
                    timer_sec = "반납까지 남은시간\n"+mHour+" : "+mMin+" : "+mSec;
                }

                Update();
            }
        };
        Timer timer = new Timer();
        timer.schedule(second, 0, 1000);
    }

    protected void Update() {
        Runnable updater = new Runnable() {
            public void run() {
                timer_text.setText(timer_sec);
            }
        };
        handler.post(updater);
    }
}
