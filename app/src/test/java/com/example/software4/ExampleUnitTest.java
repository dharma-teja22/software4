package com.example.software4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void chk1(){
        register rg=new register();
        boolean output;
        output=rg.check1(4);
        assertEquals(true,output);

    }
    @Test
    public void chk2(){
        register rg1=new register();
        boolean output;
        output=rg1.check2(16);
        assertEquals(true,output);

    }
    /*@Test
    public void chk3(){
        register rg2=new register();
        boolean output;
        output=rg2.check3(9);
        assertEquals(true,output);

    }*/
    @Test
    public void chk4(){
        register rg3=new register();
        boolean output;
        output=rg3.check4(8);
        assertEquals(true,output);

    }
    @Test
    public void chk5(){
        register rg4=new register();
        boolean output;
        output=rg4.check5(11);
        assertEquals(true,output);

    }

   /* @Test
    public void chk6(){
        cart cr=new cart();
        boolean output;
        output=cr.chkfine("21-02-2020","19-02-2020");
        assertEquals(true,output);
    }*/
    @Test
    public void chk7(){
        cart cr1=new cart();
        int output;
        output=cr1.findAmount("07-03-2020","21-02-2020");
        assertEquals(30,output);
    }

    @Test
    public void chk8(){
        addbooks ab=new addbooks();
        boolean output;
        output=ab.ch1(5);
        assertEquals(true,output);
    }
   /* @Test
    public void chk9(){
        addbooks ab1=new addbooks();
        boolean output;
        output=ab1.ch2(9);
        assertEquals(true,output);
    }*/
}