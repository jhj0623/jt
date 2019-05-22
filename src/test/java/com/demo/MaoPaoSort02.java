package com.demo;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2019/5/3.
 */
public class MaoPaoSort02 {

    public static void main(String[] args) {
        int[]a =suiji();
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        for (int i=0;i<a.length;i++){
            for(int j=a.length-1;j<i;j--){
                if (a[j]<a[j-1]){
                    int t=a[j];
                    a[j]=a[j-1];
                    a[j-1]=t;

                }
            }
        }
    }

    private static int[] suiji() {
        int n=new Random().nextInt(8)+8;
        int[]a=new int[n];
        for (int i=0;i<a.length;i++){
            a[i]=new Random().nextInt(1000);
        }
        return a;
    }

}

