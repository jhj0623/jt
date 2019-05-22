package com.demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2019/5/2.
 */
public class SelectSort {
    public static void main(String[] args) {
        //随机生成一个乱序数组
        int[]a=suiji();
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        for (int i=0;i<a.length;i++){
            //假设i位置最小
            int m =i;
            //j循环从i+1,到末尾,找到更小值下标存到M
            for (int j =i+1;j<a.length;j++){
                //如果j位置值,比m位置小
                if(a[j]<a[m]){
                    m=j;
                }
            }
            //吧m位置的最小值,交换到I位置
            int t=a[i];
            a[i]=a[m];
            a[m]=t;
        }
    }

    private static int[] suiji() {
        int n = 5 + new Random().nextInt(6);
        int[] a = new int[n];
        for (int i=0;i<a.length;i++){
            a[i]=new Random().nextInt(100);
        }
        return a;
    }
}
