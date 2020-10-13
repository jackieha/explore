package com.gsf.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;

/**
 * @author shuaifeng.gao
 * @since 2019-10-09 10:09
 **/
public class Main {

    public static void main(String[] args) {
        ByteBuddyAgent.install();
        Foo foo = new Foo();
        Class s = new ByteBuddy()
                .redefine(Bar.class)
                .name(Foo.class.getName())
                .make()
                .load(Foo.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent())
                .getLoaded();

        System.out.println(foo.m());
        System.out.println(s.getName());
        System.out.println(Foo.class.getName());
        System.out.println(Bar.class.getName());

    }

}

class Foo {
    String m() { return "foo"; }
}

class Bar {
    String m() { return "bar"; }
}