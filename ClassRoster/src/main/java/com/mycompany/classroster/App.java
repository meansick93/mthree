/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster;

import com.mycompany.controller.ClassRosterController;
import com.mycompany.dao.ClassRosterAuditDao;
import com.mycompany.dao.ClassRosterAuditDaoImpl;
import com.mycompany.dao.ClassRosterDao;
import com.mycompany.dao.ClassRosterDaoImpl;
import com.mycompany.service.ClassRosterServiceLayer;
import com.mycompany.service.ClassRosterServiceLayerImpl;
import com.mycompany.view.ClassRosterView;
import com.mycompany.view.UserIO;
import com.mycompany.view.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author minsikkim
 */
public class App {
    public static void main(String[] args) {
//        UserIO io = new UserIOConsoleImpl();
//        ClassRosterDao dao = new ClassRosterDaoImpl();
//        ClassRosterView view = new ClassRosterView(io);
//        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoImpl();
//        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(dao, auditDao);
//        ClassRosterController controller = new ClassRosterController(myService, view);

        ApplicationContext appContext
                = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        
        ClassRosterController controller = appContext.getBean("controller", ClassRosterController.class);
        controller.run();
    }
}
