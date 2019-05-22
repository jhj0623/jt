package com.demo;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2019/5/2.
 */
public class SelectSort02 {
    public static void main(String[] args) {
        int[]a =suiji();
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        for (int i=0;i<a.length;i++){
            int m=i;
            for (int j=i+1;j<a.length;j++){
                if (a[i]>a[j]){
                    m=j;
                }
            }
            int t=a[i];
            a[i]=a[m];
            a[m]=t;
        }
    }

    private static int[] suiji() {
        int n=new Random().nextInt(6)+5;
        int[]a=new int[n];
        for (int i=0;i<a.length;i++){
            a[i]=new Random().nextInt(1000);
        }
        return a;
    }
}
