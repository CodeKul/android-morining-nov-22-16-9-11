package com.codekul.gird;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //A1:K366
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCalendarView(Integer.parseInt(((EditText)findViewById(R.id.edtYear)).getText().toString()),Integer.parseInt(((EditText)findViewById(R.id.edtMonth)).getText().toString()));
            }
        });
    }

    private void createCalendarView(int year, int month) {

        final int [][]calendar  = createCalendarMatrix(year,month);

        GridLayout layoutRoot = (GridLayout) findViewById(R.id.calendarLayout);
        layoutRoot.removeAllViews();

        for (int row = 0; row < calendar.length; row++) {
            for (int col = 0; col < calendar[row].length; col++) {
                if(col == 0) addCalendarCell(getDayNameFromRow(row),layoutRoot);
                addCalendarCell(""+calendar[row][col],layoutRoot);
            }
        }
    }

    private void addCalendarCell(String text, GridLayout layoutRoot){
        TextView textCell = new TextView(this);

        GridLayout.LayoutParams lParams =
                new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED, 1f),
                        GridLayout.spec(GridLayout.UNDEFINED, 1f));

        lParams.width = 0;
        textCell.setLayoutParams(lParams);
        textCell.setGravity(Gravity.CENTER);
        textCell.setText(text);
        layoutRoot.addView(textCell);
    }

    private int [][] createCalendarMatrix(int year, int month) {

        int lastDay = getLastDayNum(year, month);
        int firstDay = getFirstDayNum(year, month);

        Log.i("@codekul","Year - "+year);
        Log.i("@codekul","Month - "+month);
        Log.i("@codekul","First Day - "+firstDay);
        Log.i("@codekul","Last Day - "+lastDay);
        Log.i("@codekul","First Day Text - "+getFirstDay(year,month));

        int[][] calendar = new int[7][5];

        int dayCounter = 1;

        for (int row = firstDay - 1, col = 0; col < 5; ) {
            if (row >= 7 && col <= 5) {
                col++;
                row = 0;
            } else {
                calendar[row][col] = dayCounter > lastDay ? 0 : dayCounter++;
                row++;
            }
        }

        Log.i("@codekul","Difference - "+ (lastDay - dayCounter));
        if((lastDay - dayCounter) == 0 || (lastDay - dayCounter) == 1) {
            Log.i("@codekul","Difference - "+ (lastDay - dayCounter));
            for(int i = 0 ; i <= (lastDay - dayCounter)+1; i++) {
                calendar[i][0] = dayCounter++;
            }
        }

        printCalendar(calendar);

        return calendar;
    }

    private void printCalendar(int[][] calendar) {
        for (int r = 0; r < calendar.length; r++) {
            for (int c = 0; c < calendar[r].length; c++)
                System.out.print(calendar[r][c] + " ");
            System.out.println();
        }
    }

    private int getLastDayNum(int year, int month) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);

        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        return day;
    }

    private int getFirstDayNum(int year, int month) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int day = calendar.get(Calendar.DAY_OF_WEEK);
        return day;
    }

    private String getFirstDay(int year, int month) {
        String weekDay = "";

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int day = calendar.get(Calendar.DAY_OF_WEEK);

        if (Calendar.MONDAY == day) {
            weekDay = "MON";
        } else if (Calendar.TUESDAY == day) {
            weekDay = "TUE";
        } else if (Calendar.WEDNESDAY == day) {
            weekDay = "WED";
        } else if (Calendar.THURSDAY == day) {
            weekDay = "THU";
        } else if (Calendar.FRIDAY == day) {
            weekDay = "FRI";
        } else if (Calendar.SATURDAY == day) {
            weekDay = "SAT";
        } else if (Calendar.SUNDAY == day) {
            weekDay = "SUN";
        }
        return weekDay;
    }

    private String getDayNameFromRow(int row){
        String day = "";

        if(row == 0) day = "SUN";
        if(row == 1) day = "MON";
        if(row == 2) day = "TUE";
        if(row == 3) day = "WED";
        if(row == 4) day = "THU";
        if(row == 5) day = "FRI";
        if(row == 6) day = "SAT";

        return day;

    }
}
