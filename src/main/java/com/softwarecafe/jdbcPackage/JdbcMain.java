package com.softwarecafe.jdbcPackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.stream.Stream;

public class JdbcMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("contextjdbcconfig.xml");
        UserdataDao dao = (UserdataDao) context.getBean("edao");
        //int status = dao.saveUserdata(new Userdata(104,"arun","123456"));
        //System.out.println(status);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JDBCConfig.class);
        ctx.refresh();
        UserdataDao dao1 = (UserdataDao) ctx.getBean("edao");

        UserdataDao dao2 = (UserdataDao) ctx.getBean("upntdao");

       // int st = dao1.updateUserdata(new Userdata(104,"abhishek","verma"));
//        Userdata d = new Userdata();
//         d.setId(104);
//        Boolean st = dao1.deleteUserdata(d);
//        System.out.println(st);
//        List<Userdata> list = dao.getAllUserData();
//        Stream<Userdata> userdataStream = list.stream();
//       // userdataStream.forEach(e-> System.out.println("id ="+e.getId()+",user="+e.getUsername()+",password="+e.getPassword()));
//        userdataStream.forEach(e-> System.out.println(e));

        List<Userdata> list = dao1.getAllUserRawMapper();
        Stream<Userdata> userdataStream = list.stream();
        userdataStream.forEach(System.out::println);

        //dao2.saveUserdataAnother(new Userdata(104,"abhinav","bindra"));


    }
}
