package com.zzxx.exam.test;

import com.zzxx.exam.entity.EntityContext;

public class EntityContextTest {
    @org.junit.Test
    public void test01() {

        EntityContext context = new EntityContext();
        context.loadUsers("");

        System.out.println(context.getUsers());
    }
}
