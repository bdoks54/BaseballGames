package com.infopub.j4android.baseballgames;



import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


import androidx.appcompat.app.AppCompatActivity;

public class BaseBallGameMainActivity extends AppCompatActivity implements View.OnClickListener{

    //--------위젯------
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnCancel;
    Button btnClear;
    Button btnHit;
    Button btnResult1;
    Button btnResult2;
    Button btnResult3;
    ListView lvResults;
    TextView tvTop;
    ArrayAdapter<String> baseResult;
    ArrayList<String> balllists;
    //--------야구------------
    Empire emp;//심판
    Hitter hit;//타자
    Pitcher pit;//투수
    //-----------------------
    int pressCount=0;
    int iterCount=0;
    int [] ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_ball_game_main);
        //---------Ready---------
        init();
        //--------Listener-------
        addListener();//-->onClick()을 이벤트에 따라 자동 호출
    }

    public void init(){
        btn0 = (Button)this.findViewById(R.id.btn0);
        btn1 = (Button)this.findViewById(R.id.btn1);
        btn2 = (Button)this.findViewById(R.id.btn2);
        btn3 = (Button)this.findViewById(R.id.btn3);
        btn4 = (Button)this.findViewById(R.id.btn4);
        btn5 = (Button)this.findViewById(R.id.btn5);
        btn6 = (Button)this.findViewById(R.id.btn6);
        btn7 = (Button)this.findViewById(R.id.btn7);
        btn8 = (Button)this.findViewById(R.id.btn8);
        btn9 = (Button)this.findViewById(R.id.btn9);
        btnCancel = (Button)this.findViewById(R.id.btnCancel);
        btnClear = (Button)this.findViewById(R.id.btnClear);
        btnHit = (Button)this.findViewById(R.id.btnHit);
        btnResult1 = (Button)this.findViewById(R.id.btnResult1);
        btnResult2 = (Button)this.findViewById(R.id.btnResult2);
        btnResult3 = (Button)this.findViewById(R.id.btnResult3);
        lvResults = (ListView)this.findViewById(R.id.lvResults);
        tvTop = (TextView)this.findViewById(R.id.tvTop);
        setting(true);
        settingButton(false);
        //-------------------
        hit=new Hitter(3);
        pit=new Pitcher(3);
        emp=new Empire(3);
        //-------------------- 아답터 =목록+한 아이템 뷰
        balllists=new ArrayList<String>() ;
        balllists.clear();
        baseResult=new ArrayAdapter<String>(this,
                android.R.layout.test_list_item,balllists);
        lvResults.setAdapter(baseResult);
    }
    //시작, 히팅 버튼을 보이거나 안보이게
    public void setting(boolean s){
        if(s){
            btnCancel.setVisibility(View.VISIBLE);//0
            btnHit.setVisibility(View.INVISIBLE);//4
            btnClear.setVisibility(View.INVISIBLE);//4
        }else{
            btnCancel.setVisibility(View.INVISIBLE);//4
            btnHit.setVisibility(View.VISIBLE);//0
            btnClear.setVisibility(View.VISIBLE);//0
        }
    }
    //번호버튼을 보이거나 안보이게
    public void settingButton(boolean s){
        if(s){
            btn0.setVisibility(View.VISIBLE);//0
            btn1.setVisibility(View.VISIBLE);//0
            btn2.setVisibility(View.VISIBLE);//0
            btn3.setVisibility(View.VISIBLE);//0
            btn4.setVisibility(View.VISIBLE);//0
            btn5.setVisibility(View.VISIBLE);//0
            btn6.setVisibility(View.VISIBLE);//0
            btn7.setVisibility(View.VISIBLE);//0
            btn8.setVisibility(View.VISIBLE);//0
            btn9.setVisibility(View.VISIBLE);//0
        }else{
            btn0.setVisibility(View.INVISIBLE);//4
            btn1.setVisibility(View.INVISIBLE);//4
            btn2.setVisibility(View.INVISIBLE);//4
            btn3.setVisibility(View.INVISIBLE);//4
            btn4.setVisibility(View.INVISIBLE);//4
            btn5.setVisibility(View.INVISIBLE);//4
            btn6.setVisibility(View.INVISIBLE);//4
            btn7.setVisibility(View.INVISIBLE);//4
            btn8.setVisibility(View.INVISIBLE);//4
            btn9.setVisibility(View.INVISIBLE);//4
        }
    }
    //투수가 공을 던지고 심판에게 입력
    public void startGame(){
        pit.make();//서로 다른 세수 만들기->투수 공던지기
        ball=new int[3];//타자용 공 준비
        emp.setPit(pit.getBall());//심판에 넣기
    }
    public void addListener(){
        btnCancel.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnHit.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }

    //이벤트가 발생한 장소와 이벤트 내용을 담아서 넘긴다.
    public void onClick(View v) {
        if(v==btnCancel){//시작을 누르면
            setting(false);
            settingButton(true);
            startGame();
            pressCount=0;//3개 버튼 누르기
            iterCount=0;//10번 안에 맞추기
            tvTop.setText("Base Ball Game!!");
            btnResult1.setText("");
            btnResult2.setText("");
            btnResult3.setText("");
            //----------------------------------
            //리스트를 제거하고 아답터를 이용하여 리스트뷰에 반영한다.
            balllists.clear();
            lvResults.setAdapter(baseResult);
        }else if(v==btnClear){
            settingButton(true);
            pressCount=0;//3개 버튼 누르기
            btnResult1.setText("");
            btnResult2.setText("");
            btnResult3.setText("");
        }else if(v==btn0){
            setNums(toNum(btn0.getText().toString()),btn0);
        }else if(v==btn1){
            setNums(toNum(btn1.getText().toString()),btn1);
        }else if(v==btn2){
            setNums(toNum(btn2.getText().toString()),btn2);
        }else if(v==btn3){
            setNums(toNum(btn3.getText().toString()),btn3);
        }else if(v==btn4){
            setNums(toNum(btn4.getText().toString()),btn4);
        }else if(v==btn5){
            setNums(toNum(btn5.getText().toString()),btn5);
        }else if(v==btn6){
            setNums(toNum(btn6.getText().toString()),btn6);
        }else if(v==btn7){
            setNums(toNum(btn7.getText().toString()),btn7);
        }else if(v==btn8){
            setNums(toNum(btn8.getText().toString()),btn8);
        }else if(v==btn9){
            setNums(toNum(btn9.getText().toString()),btn9);
        }else if(v==btnHit && pressCount==3){
            iterCount++;//히팅한 수--> 10번 이하에 맞추어야한다.
            hit.make(ball); //타자
            emp.setHit(hit.getBall());
            //-------------이곳 수정 요망
            balllists.add(showHit());
            lvResults.setAdapter(baseResult);
            //---------------
            if(iterCount<10){
                if(emp.strike()==3){
                    winGame();//win game
                }else{
                    contGame();//continue game
                }
            }else{
                lostGame();//lost game
            }
        }
    }
    private void showHint(){
        String str=String.format("%d Strike %d Ball!!",
                emp.strike(),emp.ball() );
        tvTop.setText(str);
    }//
    private String showHint2(){
        int[]mmm=pit.getBall();
        String st=String.format("[%d : %d : %d]",
                mmm[0],mmm[1],mmm[2] );
        return st;
    }
    private String showHit(){
        String str=String.format("%dS%dB",
                emp.strike(),emp.ball() );
        int[]mmm=hit.getBall();
        String st=String.format("%s:[%d:%d:%d]",
                str,mmm[0],mmm[1],mmm[2] );
        return st;
    }
    private void winGame(){
        tvTop.setText("축하합니다.("+iterCount+"회)");
        setting(true);
        settingButton(false);
        startGame();
        pressCount=0;//3개 버튼 누르기
        iterCount=0;//10번 안에 맞추기
    }
    private void lostGame(){
        tvTop.setText("Out! =>"+showHint2());
        setting(true);
        settingButton(false);
        startGame();
        pressCount=0;//3개 버튼 누르기
        iterCount=0;//10번 안에 맞추기
    }
    private void contGame(){
        showHint();
        pressCount=0;//3개 버튼 누르기
        //iterCount++;
        settingButton(true);
    }
    private int toNum(String msg){
        return Integer.parseInt(msg.trim());
    }
    private void setNums(int number, Button bu){
        if(pressCount>2){
            settingButton(false);
        }else{
            ball[pressCount]=number;
            if(pressCount==0){
                btnResult1.setText(ball[pressCount]+"");
                btnResult2.setText("");
                btnResult3.setText("");
            }else if(pressCount==1){
                btnResult2.setText(ball[pressCount]+"");
                btnResult3.setText("");
            }else if(pressCount==2){
                btnResult3.setText(ball[pressCount]+"");
            }
            bu.setVisibility(View.INVISIBLE);
            pressCount++;
        }
    }
}