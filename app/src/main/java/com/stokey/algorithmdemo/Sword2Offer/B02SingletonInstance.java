package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/5/21.
 */

public class B02SingletonInstance {
}


/**
 * 饿汉单例模式
 */
class Singleton_EHAN {

    private Singleton_EHAN() {
    }

    private static final Singleton_EHAN mInstance = new Singleton_EHAN();

    public static Singleton_EHAN getInstance() {
        return mInstance;
    }
}

/**
 * 懒汉线程安全单例模式
 */
class Singleton_LANHAN {
    private Singleton_LANHAN() {
    }

    private static Singleton_LANHAN mInstance;

    public synchronized static Singleton_LANHAN getInstance() {
        if (mInstance == null) {
            mInstance = new Singleton_LANHAN();
        }
        return mInstance;
    }
}

/**
 * 双重检验锁模式
 */
class Singleton_DoubleCheck {
    private Singleton_DoubleCheck() {
    }

    private static volatile Singleton_DoubleCheck mInstance;

    public static Singleton_DoubleCheck getInstance() {
        if (mInstance == null) {
            synchronized (Singleton_DoubleCheck.class) {
                if (mInstance == null) {
                    mInstance = new Singleton_DoubleCheck();
                }
            }
        }
        return mInstance;
    }
}

/**
 * 静态内部类单例模式
 */
class Singleton_StaticInnerClass {
    private Singleton_StaticInnerClass() {
    }

    private static class SingletonHolder {
        private static final Singleton_StaticInnerClass mInstance = new Singleton_StaticInnerClass();
    }

    public static Singleton_StaticInnerClass getInstance() {
        return SingletonHolder.mInstance;
    }
}

/**
 * 枚举形式单例模式（）
 */
enum Singleton {
    INSTANCE;

    public static Singleton getInstance() {
        return INSTANCE;
    }
}

//早期用类实现枚举
class MyEnum {
    public static MyEnum NumberZero;
    public static MyEnum NumberOne;
    public static MyEnum NumberTwo;
    public static MyEnum NumberThree;

    static {
        NumberZero = new MyEnum(0);
        NumberOne = new MyEnum(1);
        NumberTwo = new MyEnum(2);
        NumberThree = new MyEnum(3);
    }

    private final int value;

    private MyEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

// Java5 枚举
enum MyEnum2 {
    NumberZero(0),
    NumberOne(1),
    NumberTwo(2),
    NumberThree(3);

    private final int value;

    MyEnum2(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
