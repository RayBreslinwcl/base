package bulk;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class pg_bulk implements pg_bulk_interface{

    public static Connection getConnection(){
        Connection connection=null;
        Statement statement =null;

        String url="jdbc:postgresql://192.168.205.10:5432/postgres";
        String user="postgres";
        String password = "123456";
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void copyFromFile(Connection connection, String filePath, String tableName)
            throws SQLException, IOException {

        FileInputStream fileInputStream = null;

        try {
            CopyManager copyManager = new CopyManager((BaseConnection)connection);
            fileInputStream = new FileInputStream(filePath);
            copyManager.copyIn("COPY " + tableName + " FROM STDIN", fileInputStream);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void copyToFile(Connection connection, String filePath, String tableOrQuery)
            throws SQLException, IOException {

        FileOutputStream fileOutputStream = null;

        try {
            CopyManager copyManager = new CopyManager((BaseConnection)connection);
            fileOutputStream = new FileOutputStream(filePath);
            copyManager.copyOut("COPY " + tableOrQuery + " TO STDOUT", fileOutputStream);
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        /**
         * 获取连接
         */
        Connection conn=getConnection();
        String Filepath="d:/data.txt";
        String tablename="tv_series";

            // 将表tv_series中的数据导出到本地文件d:/data.txt
//             copyToFile(conn, "d:/data.txt", "tv_series");
        new pg_bulk().copyFileToTable(Filepath,tablename);
            // 将本地d:/data.txt文件中的数据导入到tv_series表中
//            copyFromFile(conn, "d:/data.txt", "tv_series_in");
        new pg_bulk().copyTableToFile(Filepath,tablename);


    }


    /**
     * 批量复制指定表到本地文件
     * @param filepath 本地文件路径
     * @param tablename 表名
     */
    public void copyTableToFile(String filepath, String tablename) {
        /**
         * 获取连接
         */
        Connection conn=getConnection();
        try {
            copyToFile(conn, filepath, tablename);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量导入本地文件到指定表
     * @param filepath 本地文件路径
     * @param tablename 表名
     */
    public void copyFileToTable(String filepath, String tablename) {
        /**
         * 获取连接
         */
        Connection conn=getConnection();
        try {
            copyFromFile(conn, filepath, tablename);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
