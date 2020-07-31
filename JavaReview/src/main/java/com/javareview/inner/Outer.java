package com.javareview.inner;

public class Outer {

    class Inner implements Inter {
        @Override
        public void print() {
            System.out.println("print1");
        }

        @Override
        public void print1() {

        }
    }

    public void method() {
        new Inner().print();

        new Inter() {
            @Override
            public void print() {
                System.out.println("print2");
            }

            @Override
            public void print1() {

            }
        }.print();

    }
}
