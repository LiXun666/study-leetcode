package sington;

import sun.security.jca.GetInstance;

/**
 * @Author lxjj
 * @Date 2021-08-04 10:35
 * @Description
 */
//饿汉式
class SingtonDemo {
    private static SingtonDemo singtonDemo = new SingtonDemo();
    private SingtonDemo() {
    }
    
    public static SingtonDemo getInstance(){
        return singtonDemo;
    }
}
//懒汉式
class Singleton{
    private static Singleton singleton;

    private Singleton(){};
    public synchronized static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
//懒汉式(双重校验锁实现 )
class SingtonDemo2 {
    private volatile static SingtonDemo2 singtonDemo2;
    private SingtonDemo2() {
    }
    public static SingtonDemo2 getInstance(){
        if (singtonDemo2 == null){
           synchronized (SingtonDemo2.class){
               if (singtonDemo2 == null){
                   singtonDemo2 = new SingtonDemo2();
               }
           }
        }
        return singtonDemo2;
    }
}
