package com.example.project_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;


//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}


public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0; // 数字按钮
    Button jia, jian, cheng, chu, dian, sum, clear, back, store, get;// +号
    EditText edit; // 显示文本
    //按钮音效
    private SoundPool soundPool;//音频通知声音播放器
    private int soundID_1,soundID_2,soundID_3;//音频资源ID


    private String ss = "";//设置一个String类型的变量
    private String ss1 = "1 + ";
    private String output = ""; //输出格式化
    private String current_ss = "";
    private int hasPoint = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //按钮音效
        initSound();

        // 获取页面上的控件
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        jia = findViewById(R.id.jia);
        jian = findViewById(R.id.jian);
        cheng = findViewById(R.id.cheng);
        chu = findViewById(R.id.chu);
        sum = findViewById(R.id.calculation);
        dian = findViewById(R.id.dian);
        clear = findViewById(R.id.clear);
        edit = findViewById(R.id.edit);
        back = findViewById(R.id.back);
        store = findViewById(R.id.store);
        get = findViewById(R.id.get);


        // 按钮的单击事件
        btn1.setOnClickListener(new Click());
        btn2.setOnClickListener(new Click());
        btn3.setOnClickListener(new Click());
        btn4.setOnClickListener(new Click());
        btn5.setOnClickListener(new Click());
        btn6.setOnClickListener(new Click());
        btn7.setOnClickListener(new Click());
        btn8.setOnClickListener(new Click());
        btn9.setOnClickListener(new Click());
        btn0.setOnClickListener(new Click());
        jia.setOnClickListener(new Click());
        jian.setOnClickListener(new Click());
        cheng.setOnClickListener(new Click());
        chu.setOnClickListener(new Click());
        sum.setOnClickListener(new Click());
        dian.setOnClickListener(new Click());
        clear.setOnClickListener(new Click());
        edit.setOnClickListener(new Click());
        back.setOnClickListener(new Click());
        store.setOnClickListener(new Click());
        get.setOnClickListener(new Click());
    }

    // 设置按钮点击后的监听
    class Click implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {                //switch循环获取点击按钮后的值
                case R.id.clear: {
                    ss = "";
                    edit.setText(ss);//在edittext里面显示字符串ss
                    playSound(soundID_3);
                    hasPoint = 0;
                }
                break;

                case R.id.btn0: {
                    ss += "0";
                    edit.setText(ss);
                    playSound(soundID_1);
                }
                break;
                case R.id.btn1: {
                    ss += "1"; // ss=ss+1
                    edit.setText(ss);
                    playSound(soundID_1);
                }
                break;
                case R.id.btn2: {
                    ss += "2";
                    edit.setText(ss);
                    playSound(soundID_1);
                }
                break;

                case R.id.btn3: {
                    ss += "3";
                    edit.setText(ss);
                    playSound(soundID_1);
                }
                break;
                case R.id.btn4: {
                    ss += "4";
                    edit.setText(ss);
                    playSound(soundID_1);
                }
                break;
                case R.id.btn5: {
                    ss += "5";
                    edit.setText(ss);
                    playSound(soundID_1);
                }
                break;

                case R.id.btn6: {
                    ss += "6";
                    edit.setText(ss);
                    playSound(soundID_1);
                }
                break;
                case R.id.btn7: {
                    ss += "7";
                    edit.setText(ss);
                    playSound(soundID_1);
                }
                break;
                case R.id.btn8: {
                    ss += "8";
                    edit.setText(ss);
                    playSound(soundID_1);
                }
                break;
                case R.id.btn9: {
                    ss += "9";
                    edit.setText(ss);
                    playSound(soundID_1);
                }
                break;
                case R.id.dian: {
                    if (ss.length() == 0 || hasPoint == 1 || ss.substring(ss.length() - 1).equals(" ")) {
                        break;
                    } else {
                        ss += ".";
                        edit.setText(ss);
                        hasPoint = 1;
                    }
                    playSound(soundID_1);
                }
                break;
                case R.id.jia: {
                    hasPoint = 0;
                    playSound(soundID_2);
                    if (ss.length() == 0) {
                        edit.setText("0 + ");
                        ss = "0 + ";
                        break;
                    }
                    if (ss.contains(" ")) {
                        if (ss.indexOf(" ") == ss.length() - 3)  //对应连续点符号的情况
                        {
//                            if(ss.contains("-"))  ss = ss.substring(0, ss.length() - 3)//修改一：加一个判断
                            break;
                        }
                        getResult();
                    }

                    ss += " + ";
                    edit.setText(ss);
                }
                break;
                case R.id.jian: {
                    hasPoint = 0;
                    playSound(soundID_2);
                    if (ss.length() == 0) {
                        edit.setText("0 - ");
                        ss = "0 - ";
                        break;
                    }
                    if (ss.contains(" ")) {
                        if (ss.indexOf(" ") == ss.length() - 3 )
                            break;
                        getResult();
                    }

                    ss += " - ";
                    edit.setText(ss);
                }
                break;
                case R.id.cheng: {
                    hasPoint = 0;
                    playSound(soundID_2);
                    if (ss.length() == 0) {
                        edit.setText("0 × ");
                        ss = "0 × ";
                        break;
                    }
                    if (ss.contains(" ")) {
                        if (ss.indexOf(" ") == ss.length() - 3)
                            break;
                        getResult();
                    }

                    ss += " × ";
                    edit.setText(ss);
                }
                break;
                case R.id.chu: {
                    hasPoint = 0;
                    playSound(soundID_2);
                    if (ss.length() == 0) {
                        edit.setText("0 / ");
                        ss = "0 / ";
                        break;
                    }
                    if (ss.contains(" ")) {
                        if (ss.indexOf(" ") == ss.length() - 3)
                            break;
                        getResult();
                    }

                    ss += " / ";
                    edit.setText(ss);
                }
                break;
                case R.id.calculation:
                    getResult();
                    if(ss.contains(".")) hasPoint = 1;  //判断是否有小数点，若有则不能再加小数点

                    break;
                case R.id.back: {
                    playSound(soundID_2);
                    if(ss.equals("")) break;
                    if (ss.contains(" ")){
                        if (ss.indexOf(" ") == ss.length() - 3) {
                            ss = ss.substring(0, ss.length() - 3);
                            edit.setText(ss);
                            break;
                        }
                    }
                    //判断是否是小数点，如果删去的是小数点，hasPoint=0
                    if (ss.contains(".")){
                        if (ss.indexOf(".") == ss.length() - 1) {
                            hasPoint = 0;
                        }
                    }
                    ss = ss.substring(0, ss.length() - 1);
                    edit.setText(ss);
                    break;
                }
                case R.id.store: {
                    playSound(soundID_2);
                    if(ss.contains(" ")){
                        current_ss = ss.substring(0,ss.indexOf(" "));  //保留运算符之前的数字
                    }
                    else {
                        current_ss = ss;
                    }
                    break;
                }

                case R.id.get: {
                    if(current_ss.contains(".")) hasPoint = 1;
                    playSound(soundID_2);
                    if (ss.contains(" ")){
                        if(ss.indexOf(" ") == ss.length() - 3)
                        ss += current_ss;
                        edit.setText(ss);
                    }
                    else {
                        ss = current_ss;
                        edit.setText(ss);
                    }
                    break;
                }
            }
        }
    }

    private void getResult() {
        double result = 0;
        if (ss == null || ss.equals("")) return;
        if (!ss.contains(" ")) return;
        String s1 = ss.substring(0, ss.indexOf(" "));
        String op = ss.substring(ss.indexOf(" ") + 1, ss.indexOf(" ") + 2);
        String s2 = ss.substring(ss.indexOf(" ") + 3);
        if (!s1.equals("") && !s2.equals("")) {
//            float d1 = Float.parseFloat(s1);
//            float d2 = Float.parseFloat(s2);
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            switch (op) {
                case "+":
                    result = d1 + d2;
                    break;
                case "-":
                    result = d1 - d2;
                    break;
                case "×":
                    result = d1 * d2;
                    break;
                case "/": {
                    if (d2 == 0) {
                        Toast.makeText(MainActivity.this, "不能除以零", Toast.LENGTH_SHORT).show();
                        break;

                    }
                    result = d1 / d2 * 1.0;
                }
                break;
            }
//            edit.setText(result + "");
//            ss = "" + result;
            int r = (int) result;
//            System.out.println((int)result);
            if (r == result) {  //输出整数
                edit.setText("" + r);
                ss = "" + r;
//                System.out.println("go1");
            } else {  //输出小数
                ss = "" + result; //将double类型的result转成string类型的数据存储在ss中

                //以下三行用于输出小数点后两位
                BigDecimal   b   =   new   BigDecimal(ss+"");
                double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
                output = "" + f1;

//                ss = ss.substring(0,ss.length()-1);  //不懂这一行有什么用
//                edit.setText(result+ "");
                edit.setText(output);
//                System.out.println("go2");

            }
        }
    }
    //按钮音效
    private void initSound() {
        soundPool = new SoundPool.Builder().build();//实例化音频通知播放器
        soundID_1 = soundPool.load(this, R.raw.number, 1);//设置资源ID
        soundID_2 = soundPool.load(this, R.raw.calculate, 1);//设置资源ID
        soundID_3 = soundPool.load(this, R.raw.tozero, 1);//设置资源ID
    }
    private void playSound(int id) {
        soundPool.play(
                id,
                1,      //左耳道音量【0~1】
                1,      //右耳道音量【0~1】
                0,         //播放优先级【0表示最低优先级】
                0,         //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1          //播放速度【1是正常，范围从0~2】
        );
    }



}
