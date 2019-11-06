package com.briup.bd1903.chapter05.exercise;

/**
 * 描述:
 *
 * @author WeiGu
 * @create 2019-09-18 20:10
 */
public class e {
    public static void main(String[] args) {
        for(int i =1;i<=9;i++){
            for(int j=1;j<i;j++){
                System.out.printf("%d * %d = %d\t",j,i,i*j);
            }
            System.out.println();
        }
    }
}