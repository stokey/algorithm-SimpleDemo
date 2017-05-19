package com.stokey.algorithmdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.stokey.algorithmdemo.Algorithm.basic.GenerateData;
import com.stokey.algorithmdemo.Algorithm.util.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sort();
    }

    private void sort() {
        Integer[] input = GenerateData.gen(10, 10);
        Integer[] input2 = input.clone();
        Integer[] input3 = GenerateData.gen(15, 20);
        Integer[] input4 = input3.clone();

        Utils.sort("com.stokey.algorithmdemo.Algorithm.basic.sort.InsertSort", input);

        Utils.sort("com.stokey.algorithmdemo.Algorithm.basic.sort.SelectionSort", input2);

        Utils.sort("com.stokey.algorithmdemo.Algorithm.sort.BubbleSort", input3);
        Utils.sort("com.stokey.algorithmdemo.Algorithm.sort.ShellSort", input4);


        Integer[] input5 = GenerateData.gen(10, 20);
        Utils.printF("outMerge", input5);
        Utils.sort("com.stokey.algorithmdemo.Algorithm.sort.MergeSort", input5, true);
        Utils.sort("com.stokey.algorithmdemo.Algorithm.sort.QuickSort", input5, true);
    }
}
