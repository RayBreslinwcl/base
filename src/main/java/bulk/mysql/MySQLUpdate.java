package bulk.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 *  合肥工业大学 管理学院 qianyang 1563178220@qq.com
 */
public class MySQLUpdate {
    static Connection con = MySQLConnections.getConnection();
    static PreparedStatement stmt = null;
    public static int executeInsert() throws SQLException {
        int i = 0;
        //设置批量处理的数量
        int batchSize = 5000;
        stmt = con.prepareStatement("insert into mysqltest (id,name) "
                + "values (?,?)");
        // 关闭事务自动提交 ,这一行必须加上
        con.setAutoCommit(false);
        for (int j = 0; j < 50005; j++){
            ++i;
            stmt.setInt(1, j);
            stmt.setString(2, "name");
            stmt.addBatch();
            if ( i % batchSize == 0 ) {
                stmt.executeBatch();
                con.commit();
            }
        }
        if ( i % batchSize != 0 ) {
            stmt.executeBatch();
            con.commit();
        }
        return i;
    }

    public static  void executeInsert2() throws SQLException {
        // 关闭事务自动提交 ,这一行必须加上
        con.setAutoCommit(false);
        stmt = con.prepareStatement("insert into mysqltest1 (id,name) "
                + "values (?,?)");
        for (int j = 0; j < 50002; j++){
            stmt.setInt(1, j);
            stmt.setString(2, "name");
            stmt.addBatch();
        }
        stmt.executeBatch();
        con.commit();
        stmt.close();
        con.close();
    }

}
