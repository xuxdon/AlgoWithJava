package com.xuxdon.algo.sort;

public class Test {
    public static void main(String[] args) {
        byte b1=1,b2=2,b3,b6;
        final byte b4=4,b5=6;
        b6 = b4 + b5;    // 编译期就已经为 b6 = 10;

        // b3 = b1 + b2;  // Java 中的 byte，short，char 进行运算时都会提升为 int 类型，这里会发生类型不匹配问题
        b3 = (byte) (b1 + b2);
    }
}
