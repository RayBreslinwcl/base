package bulk;

public interface pg_bulk_interface {
    /**
     * 接口：批量复制指定表到本地文件
     * @param filepath
     * @param tablename
     */
    void  copyTableToFile(String filepath,String tablename);

    /**
     * 接口：批量导入本地文件到指定表
     * @param filepath
     * @param tablename
     */
    void  copyFileToTable(String filepath,String tablename);
}
