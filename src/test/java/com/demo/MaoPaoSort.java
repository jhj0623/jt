package com.demo;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2019/5/2.
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[]a=suiji();
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static int[] suiji() {
        int n=8+new Random().nextInt(5);
        int []a=new int[n];
        for (int i=0;i<a.length;i++){
            a[i]=new Random().nextInt(1000);
        }
        return a;
    }

    private static void sort(int[] a) {
        boolean flag=false;//表示没有交换
        for (int i=0;i<a.length;i++){
            //j循环从a.length-1到>i位置
            //把较小值向前交换,吧最小是推到i位置
            for(int j=a.length-1;j>i;j--){
                if (a[j]<a[j-1]){
                    int t=a[j];
                    a[j]=a[j-1];
                    a[j-1]=t;
                    flag=true;
                }
            }
            if (!flag){
                break;
            }
        }
    }
}
