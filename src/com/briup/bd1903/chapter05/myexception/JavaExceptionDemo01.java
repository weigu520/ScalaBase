package com.briup.bd1903.chapter05.myexception;

/**
 * 描述:
 *
 * @author WeiGu
 * @create 2019-09-18 19:03
 */
public class JavaExceptionDemo01 {
    public static void main(String[] args) {
        try {
            // 可疑代码
            int i = 0;
            int b = 10;
            int c = b / i; // 执行代码时，会抛出ArithmeticException异常
        } catch (ArithmeticException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 最终要执行的代码
            System.out.println("java finally");
        }
        System.out.println("ok~~~继续执行...");
    }
}