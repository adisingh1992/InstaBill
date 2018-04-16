package instabill;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.sql.Connection;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @author scorpion
 */

public class DBase {
    
    final private String dbName = "InstaBill";
    final private String dbUser = "root";
    final private String dbPass = "password";
    final private String dbUrl = "localhost";
    
    public Connection conn;

    public void dbInit() throws SQLException{
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName(dbName);
        dataSource.setUser(dbUser);
        dataSource.setPassword(dbPass);
        dataSource.setServerName(dbUrl);
        conn = dataSource.getConnection();
    }
    
    public Connection dbConnect() throws SQLException{
        dbInit();
        return conn;
    }
    
    public void dbClose() throws SQLException{
        conn.close();
    }
    
    public void dbBackup(String value) throws SQLException{
        try {
            /*NOTE: Getting path to the Jar file being executed*/
            CodeSource codeSource = DBase.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();

            /*NOTE: Here the backup folder is created for saving inside it*/
            String folderPath = jarDir + "/Backup";

            /*NOTE: Creating Folder if it does not exist*/
            File f1 = new File(folderPath);
            f1.mkdir();

            /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
            String savePath = "" + jarDir + "/Backup/" + "backup.sql";

            /*NOTE: Used to create a cmd command*/
            String mysqldump = value;
            if (!mysqldump.equals("")) {
                mysqldump += "/";
            }
            String executeCmd = mysqldump + "mysqldump -u " + dbUser + " -p" + dbPass + " --databases " + dbName + " -r " + savePath;

            /*NOTE: Executing the command here*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                showMessageDialog(null, "Database Backed-Up Successfully!");
            } else {
                showMessageDialog(null, "Backup Failure!");
            }
        } catch (URISyntaxException | IOException | InterruptedException ex) {
            showMessageDialog(null, "Backup Failure!");
        }
    }
    
    public void restoreDB(String value){
        try {
            String filePath = value;

            String[] executeCmd = new String[]{"mysql", "--user=" + dbUser, "--password=" + dbPass, "-e", "source " + filePath};
            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                showMessageDialog(null, "Database Successfully Restored!");
            } else {
                showMessageDialog(null, "Something Went Wrong, Please Try Again!");
            }
        } catch (IOException | InterruptedException | HeadlessException ex) {
        }
    }
}