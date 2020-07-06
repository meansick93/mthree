/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.testing.dao.implementations;

import com.sg.testing.dao.implementations.buggy.BadMonsterDaoA;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoB;
import com.sg.testing.model.Monster;
import static com.sg.testing.model.MonsterType.YETI;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author minsikkim
 */
public class AGoodMonsterDaoTest {

    BadMonsterDaoB instance = new BadMonsterDaoB();

    public AGoodMonsterDaoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        int id = 0;
        Monster m = new Monster("name", YETI, 2, "Apple");
       
        Monster n = new Monster("anotherName", YETI, 5, "Banana");
        
        instance = new BadMonsterDaoB();

        instance.addMonster(id, m);
        id++;
        instance.addMonster(id, n);
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addMonster method, of class AGoodMonsterDao.
     */
    @Test
    public void testAddMonster() {
        System.out.println("addMonster");
        int id = 0;
        Monster m = new Monster("name", YETI, 2, "Apple");

        Monster expResult = new Monster("name", YETI, 2, "Apple");
        Monster result = instance.addMonster(id, m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMonster method, of class AGoodMonsterDao.
     */
    @Test
    public void testGetMonster() {
        System.out.println("getMonster");
        int id = 0;
        Monster expResult = new Monster("name", YETI, 2, "Apple");
        Monster result = instance.getMonster(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAllMonsters method, of class AGoodMonsterDao.
     */
    @Test
    public void testGetAllMonsters() {
        System.out.println("getAllMonsters");
        List<Monster> expResult = new ArrayList<Monster>(List.of(new Monster("name", YETI, 2, "Apple"),new Monster("anotherName", YETI, 5, "Banana")));
        List<Monster> result = instance.getAllMonsters();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateMonster method, of class AGoodMonsterDao.
     */
    @Test
    public void testUpdateMonster() {
        System.out.println("updateMonster");
        int id = 0;
        Monster m = new Monster("differentdifferentName", YETI, 4, "Banana");
        Monster expResult = new Monster("differentdifferentName", YETI, 4, "Banana");
        instance.updateMonster(id, m);
        Monster result = instance.getMonster(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeMonster method, of class AGoodMonsterDao.
     */
    @Test
    public void testRemoveMonster() {
        System.out.println("removeMonster");
        int id = 0;
        Monster expResult = new Monster("name", YETI, 2, "Apple");
        Monster result = instance.removeMonster(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
