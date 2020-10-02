package com.share.design;

import java.util.Arrays;

/**
 * @author Lgq create on 2020/10/1
 */
public class SingletonClass {

    private static volatile SingletonClass singleton = null;



    public static SingletonClass getInstance() {

        if (singleton == null) {
            synchronized (SingletonClass.class) {
                if (singleton == null) {
                    singleton = new SingletonClass();
                }

            }
        }
        return singleton;
    }

    public static void main(String[] args) {

        int t = (int) 1e9;

        int nums[] = new int[]{1,2,3,9,5,6,7};

        int res = 0 ;
        for (int i = 1 ; i < nums.length ; i ++) {
            if(nums[res] > nums[i]){
                continue;
            }else{
                res = i ;
            }
        }

        System.out.println(res);
    }


}
