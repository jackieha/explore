package com.gsf.jvm.oom;

/**
 * VM Args: -Xss128k
 *
 * @author shuaifeng.gao
 * @since 2020-05-04 15:09
 **/
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++ ;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF j = new JavaVMStackSOF();
        try{
            j.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:" + j.stackLength);
            throw  e;
        }
    }
}
