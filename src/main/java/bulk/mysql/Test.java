package bulk.mysql;

import java.sql.SQLException;
//import db.MySQLUpdate;
/*
 *  合肥工业大学 管理学院 qianyang 1563178220@qq.com
 */
public class Test {

    public static void main(String[] args) throws SQLException {
//      long begin1 = System.currentTimeMillis();
//      MySQLUpdate.executeInsert();
//      long end1 = System.currentTimeMillis();
//      System.out.println("程序运行时间为："+(end1-begin1));

        long begin2 = System.currentTimeMillis();
        MySQLUpdate.executeInsert2();
        long end2 = System.currentTimeMillis();
        System.out.println("程序运行时间为："+(end2-begin2));
    }

}
