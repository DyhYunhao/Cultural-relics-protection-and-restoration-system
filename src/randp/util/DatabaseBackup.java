package randp.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by dyh on 2018/5/22.
 */
public class DatabaseBackup {
    public void backup() {
        try {
            StringBuffer command = new StringBuffer();
            String username = "root";// 用户名
            String password = "19960115";// 用户密码
            String exportDatabaseName = "randp";// 需要导出的数据库名
            String host = "localhost";// 从哪个主机导出数据库，如果没有指定这个值，则默认取localhost
            String port = "3306";// 使用的端口号
            String exportPath = "D:/mysql-5.7.21-winx64/mysqlbackup/" + "backup.sql";// 导出路径
            command.append("cmd.exe /cmysqldump -u").append(username)
                    .append(" -p")
                    .append(password)
                    .append(" -h").append(host).append(" -P").append(port)
                    .append(" ").append(exportDatabaseName).append(" -r ")
                    .append(exportPath);
            Runtime.getRuntime().exec(command.toString());
            System.out.println("备份成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restore() {
        Runtime runtime = Runtime.getRuntime();
        try {
            String username = "root";// 用户名
            String password = "19960115";// 用户密码
            String exportDatabaseName = "randp";// 需要导出的数据库名
            String host = "localhost";// 从哪个主机导出数据库，如果没有指定这个值，则默认取localhost
            String port = "3306";// 使用的端口号
            String Url = "D:/mysql-5.7.21-winx64/mysqlbackup/backup.sql";
            String loginCommand = new StringBuffer().append("mysql -u")
                    .append(username).append(" -p").append(password).append(" -h")
                    .append(host).append(" -P").append(port).toString();
            String switchCommand = new StringBuffer("use ").append(exportDatabaseName).toString();
            String importCommand = new StringBuffer("source ").append(Url).toString();
            String[] commands = new String[] { loginCommand, switchCommand, importCommand };
            Process process = runtime.exec(commands[0]);
            OutputStream os = process.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(os);
            writer.write(commands[1] + "\r\n" + commands[2]);
            writer.flush();
            writer.close();
            os.close();
            System.out.println("数据库还原成功！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("数据库还原异常！");
            e.printStackTrace();
        }
    }
}
