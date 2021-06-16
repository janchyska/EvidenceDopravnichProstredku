/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekce;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.internal.runners.TestClass;

/**
 *
 * @author janch
 */
public class LinSeznamTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void vlozPrvni() {
//        System.out.println("Vloz Prvni");
//        LinSeznam seznam = new LinSeznam();
//        int cislo = 8;
//        seznam.vlozPrvni(cislo);
//        int expresult = 1;
//        int result = seznam.size();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void dejPrvni() throws KolekceException {
//        System.out.println("Dej prvni");
//        LinSeznam seznam = new LinSeznam();
//        int cislo = 8;
//        seznam.vlozPrvni(cislo);
//        int cislo2 = 5;
//        seznam.vlozNaKonec(cislo2);
//        seznam.vlozNaKonec(10);
//        int expresult = 8;
//        Object result = seznam.dejPrvni();
//        assertEquals(expresult, result);
//    }
//
//    @Test
//    public void nastavPrvni2() throws KolekceException {
//        System.out.println("Nastav prvni");
//        LinSeznam seznam = new LinSeznam();
//        int cislo = 8;
//        seznam.vlozPrvni(cislo);
//        seznam.nastavPrvni();
//        int cislo2 = 5;
//        seznam.vlozNaKonec(cislo2);
//        seznam.vlozNaKonec(10);
//        int expresult = 8;
//        seznam.nastavPrvni();
//        Object result = seznam.dejAktualni();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void dejPosledni2() throws KolekceException {
//        System.out.println("Dej posledni");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(8);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(5);
//        seznam.nastavPosledni();
//        seznam.vlozZaAktualni(10);
//        int expresult = 10;
//        seznam.nastavPosledni();
//        Object result = seznam.dejPosledni();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void dejAktualni2() throws KolekceException {
//        System.out.println("Dej aktualni");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(8);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(5);
//        seznam.nastavPosledni();
//        seznam.vlozZaAktualni(10);
//        int expresult = 10;
//        seznam.nastavPosledni();
//        seznam.dejPosledni();
//        Object result = seznam.dejAktualni();
//        assertEquals(expresult, result);
//    }
//
//    @Test
//    public void dejPrvni2() throws KolekceException {
//        System.out.println("Dej prvni");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(8);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(5);
//        seznam.nastavPosledni();
//        seznam.vlozZaAktualni(10);
//        int expresult = 8;
//        seznam.nastavPosledni();
//        Object result = seznam.dejPrvni();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void dejAktualni3() throws KolekceException {
//        System.out.println("Dej aktualni");
//        LinSeznam seznam = new LinSeznam();
//        int cislo = 8;
//        seznam.vlozPrvni(cislo);
//        int cislo2 = 5;
//        seznam.vlozNaKonec(cislo2);
//        seznam.vlozNaKonec(10);
//        int expresult = 5;
//        seznam.nastavPrvni();
//        seznam.dalsi();
//        Object result = seznam.dejAktualni();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void vlozPrvni2() throws KolekceException {
//        System.out.println("Vloz Prvni");
//        LinSeznam seznam = new LinSeznam();
//        int cislo = 8;
//        seznam.vlozPrvni(cislo);
//        seznam.vlozNaKonec(5);
//        seznam.vlozPrvni("ahoj");
//        String expresult = "ahoj";
//        Object result = seznam.dejPrvni();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void zrus2() throws KolekceException {
//        System.out.println("Zrusit");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(8);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(5);
//        seznam.nastavPosledni();
//        seznam.vlozZaAktualni(10);
//        int expresult = 0;
//        seznam.zrus();
//        Object result = seznam.size();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void zrus3() throws KolekceException {
//        System.out.println("Zrusit");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(8);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(5);
//        seznam.nastavPosledni();
//        seznam.vlozZaAktualni(10);
//        int expresult = 0;
//        seznam.zrus();
//        Object result = seznam.size();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void zrusJePrazdny() throws KolekceException {
//        System.out.println("Zrusit");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(8);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(5);
//        seznam.nastavPosledni();
//        seznam.vlozZaAktualni(10);
//        boolean expresult = true;
//        seznam.zrus();
//        Object result = seznam.jePrazdny();
//        assertEquals(expresult, result);
//    }
//
//    @Test
//    public void dalsi1() throws KolekceException {
//        System.out.println("Dalsi");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(8);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(25);
//        seznam.dalsi();
//        int expresult = 25;
//        Object result = seznam.dejAktualni();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void dalsi2() throws KolekceException {
//        System.out.println("Dalsi");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(8);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(25);
//        seznam.dalsi();
//        seznam.zrus();
//        boolean expresult = false;
//        Object result = seznam.dalsi();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void dalsi3() throws KolekceException {
//        try {
//            System.out.println("Dalsi");
//            LinSeznam seznam = new LinSeznam();
//            seznam.vlozPrvni(8);
//            seznam.nastavPrvni();
//            seznam.vlozNaKonec(25);
//            seznam.dalsi();
//            seznam.dalsi();
//        } catch (KolekceException ex) {
//
//        }
//
//    }
////
//    @Test
//    public void dalsi4() throws KolekceException {
//        try {
//            System.out.println("Dalsi");
//            LinSeznam seznam = new LinSeznam();
//            seznam.vlozPrvni(8);
//            seznam.nastavPrvni();
//            seznam.vlozNaKonec(25);
//            seznam.dalsi();
//            seznam.dalsi();
//        } catch (KolekceException ex) {
//
//        }
//
//    }
////
//    @Test
//    public void vlozZaAktualni1() throws KolekceException {
//        System.out.println("Vloz za aktualni");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(8);
//        seznam.nastavPrvni();
//        seznam.vlozZaAktualni(95);
//        int expresult = 95;
//        seznam.dalsi();
//        Object result = seznam.dejAktualni();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void vlozZaAktualni2() throws KolekceException {
//        System.out.println("Vloz za aktualni");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(8);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(196);
//        seznam.dalsi();
//        seznam.vlozZaAktualni(95);
//        int expresult = 3;
//        Object result = seznam.size();
//
//        assertEquals(expresult, result);
//    }
////
////
//    @Test
//    public void vlozZaAktualni3() throws KolekceException {
//        System.out.println("Vloz za aktualni");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(8);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(196);
//        seznam.vlozZaAktualni(95);
//        seznam.vlozNaKonec(52);
//        int expresult = 8;
//        Object result = seznam.dejAktualni();
//        assertEquals(expresult, result);
//    }
//////
////
//    @Test
//    public void vlozNaKonec2() throws KolekceException {
//        System.out.println("Vloz na konec");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(8);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(196);
//        seznam.vlozZaAktualni(95);
//        int expresult = 196;
//        Object result = seznam.dejPosledni();
//        assertEquals(expresult, result);
//    }
////
    @Test
    public void odeberAktualniPosledni1() throws KolekceException {
        System.out.println("Odeber aktualni posledni");
        LinSeznam seznam = new LinSeznam();
        seznam.vlozPrvni(5);
        seznam.vlozNaKonec(8);
        seznam.vlozNaKonec(7);
        seznam.nastavPosledni();
        int expresult = 7;
        seznam.odeberAktualni();
        Object result = seznam.dejPosledni();
        assertEquals(expresult, result);
    }
////
//    @Test
//    public void odeberAktualniPosledni2() throws KolekceException {
//        System.out.println("Odeber aktualni posledni");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(5);
//        seznam.vlozNaKonec(8);
//        seznam.vlozNaKonec(7);
//        seznam.nastavPosledni();
//        int expresult = 2;
//        seznam.odeberAktualni();
//        Object result = seznam.size();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void dejPrvni3() throws KolekceException {
//        System.out.println("Dej prvni");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(5);
//        seznam.vlozNaKonec(8);
//        seznam.vlozNaKonec(7);
//        seznam.nastavPrvni();
//        seznam.dalsi();
//        int expresult = 5;
//        seznam.odeberAktualni();
//        Object result = seznam.dejPrvni();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void dejAktualni4() throws KolekceException {
//        System.out.println("Dej aktualni");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(5);
//        seznam.vlozNaKonec(8);
//        seznam.vlozNaKonec(7);
//        seznam.nastavPrvni();
//        seznam.dalsi();
//        int expresult = 8;
//        Object result = seznam.dejAktualni();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void odeberAktualni() throws KolekceException {
//        System.out.println("Odeber aktualni posledni");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(5);
//        seznam.vlozNaKonec(8);
//        seznam.vlozNaKonec(7);
//        seznam.nastavPrvni();
//        seznam.dalsi();
//        int expresult = 8;
//        Object result = seznam.odeberAktualni();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void size() throws KolekceException {
//        System.out.println("Velikost");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(5);
//        seznam.vlozNaKonec(8);
//        seznam.vlozNaKonec(7);
//        seznam.nastavPrvni();
//        seznam.dalsi();
//        int expresult = 2;
//        seznam.odeberAktualni();
//        Object result = seznam.size();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void sizePoOdeberAktualni() throws KolekceException {
//        System.out.println("Odeber aktualni posledni a velikost");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(1);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(3);
//        seznam.vlozZaAktualni(2);
//        seznam.dalsi();
//        int expresult = 2;
//        seznam.odeberAktualni();
//        Object result = seznam.size();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void odeberZaAktualnim1() throws KolekceException {
//        System.out.println("Odeber za aktualnim");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(1);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(3);
//        seznam.vlozZaAktualni(2);
//        seznam.dalsi();
//        seznam.odeberZaAktualnim();
//        int expresult = 2;
//        Object result = seznam.size();
//        assertEquals(expresult, result);
//    }
////
//    @Test
//    public void dejAktualni5() throws KolekceException {
//        System.out.println("Dej Aktualni");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(10);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(30);
//        seznam.vlozZaAktualni(20);
//        int expresult = 10;
//        Object result = seznam.dejAktualni();
//        assertEquals(expresult, result);
//    }
//////    
////
//    @Test
//    public void dejAktualni6() throws KolekceException {
//        System.out.println("Dej Aktualni");
//        LinSeznam seznam = new LinSeznam();
//        seznam.vlozPrvni(10);
//        seznam.nastavPrvni();
//        seznam.vlozNaKonec(30);
//        seznam.dalsi();
//        seznam.vlozNaKonec(40);
//        seznam.vlozZaAktualni(55);
//        seznam.vlozNaKonec(88);
//        int expresult = 6;
//        System.out.println(seznam.dejPrvni());
//        System.out.println(seznam.dejPosledni());
//        System.out.println(seznam.dejAktualni());
//        System.out.println(seznam.dejZaAktualnim());
//        System.out.println(seznam.size());
//        seznam.nastavPosledni();
//        seznam.vlozZaAktualni(189);
//        System.out.println(seznam.dejAktualni());
//        System.out.println(seznam.dejPosledni());
//        Object result = seznam.size();
//        assertEquals(expresult, result);
//    }
//    @Test
//    public void dejAktualni7() throws KolekceException {
//        System.out.println("Dej Aktualni");
//        LinSeznam<Integer> seznam = new LinSeznam<>();
//        seznam.vlozPrvni(10);
//        seznam.vlozNaKonec(30);
//        seznam.vlozNaKonec(40);
//        seznam.nastavPosledni();
//        seznam.vlozZaAktualni(8);
//        seznam.vlozNaKonec(7);
//        int expresult = 7;
//        Object result = seznam.dejPosledni();
//        assertEquals(expresult, result);
//    }
//    @Test
//    public void testSize02() {
//        LinSeznam<Integer> instance = new LinSeznam<>();
//        instance.vlozNaKonec(2);
//        assertEquals(1, instance.size());
//    }
//    @Test(expected = NullPointerException.class)
//    public void testVlozPrvni10() throws KolekceException {
//        LinSeznam<Integer> instance = new LinSeznam<>();
//        instance.vlozPrvni(null);
//        fail();
//    }
////    
//    @Test
//    public void testDalsi01() throws KolekceException {
//        LinSeznam<Integer> instance = new LinSeznam<>();
//        instance.vlozPrvni(1);
//        instance.vlozPrvni(2);
//        instance.vlozPrvni(3);
//        instance.nastavPrvni();
//        instance.dalsi();
//        Integer result = instance.dejAktualni();
//        assertEquals(new Integer(2), result);
//    }

    @Test
    public void testDalsi02() throws KolekceException {
        LinSeznam<Integer> instance = new LinSeznam<>();
        instance.vlozPrvni(1);
        instance.vlozPrvni(2);
        instance.nastavPrvni();
        System.out.println(instance.dejPrvni());
        System.out.println(instance.dejAktualni());
        System.out.println(instance.dejPosledni());
        instance.dalsi();
        Integer result = instance.dejAktualni();
        assertEquals(new Integer(1), result);
    }
//    

    @Test
    public void testOdeberZaAktualnim() throws KolekceException {

        LinSeznam<Integer> instance = new LinSeznam<>();
        instance.vlozPrvni(1);//1
        instance.nastavPrvni();
        instance.vlozNaKonec(5);//1,5
        instance.vlozNaKonec(48);//1,5,48
        instance.vlozNaKonec(45);//1,5,48,45
        instance.vlozNaKonec(897);//1,5,48,45,897
        instance.odeberZaAktualnim();//(-5)--- 1,48,45,897
        instance.dalsi();
        instance.dalsi();
        System.out.println(instance.dejPrvni());//1
        System.out.println(instance.dejAktualni());//45
        System.out.println(instance.dejPosledni());//897
        Integer expResult = 4;
        Integer result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testOdeberAktualni02() throws KolekceException {

        LinSeznam<Integer> instance = new LinSeznam<>();
        instance.vlozNaKonec(5);
        instance.vlozNaKonec(87);
        instance.nastavPrvni();
        Integer expresult = 5;
        Integer result = instance.odeberAktualni();
        assertEquals(expresult, result);
    }

    @Test(expected = KolekceException.class)
    public void testDalsi03() throws KolekceException {

        LinSeznam<Integer> instance = new LinSeznam<>();
        instance.dalsi();
        fail();
    }

    @Test(expected = KolekceException.class)
    public void testDalsi04() throws KolekceException {

        LinSeznam<Integer> instance = new LinSeznam<>();
        instance.vlozPrvni(5);
        instance.dalsi();
        fail();
    }

    @Test(expected = NullPointerException.class)
    public void testVlozZaAktualni10() throws KolekceException {
        LinSeznam<Integer> instance = new LinSeznam<>();
        instance.vlozZaAktualni(null);
        fail();
    }

}
