package Config;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Config {
    
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/baiq4";
    private String usr = "root";
    private String pass = "";
    
    private static Config config;
    private Connection conn;
    
    private Config() {
        try{
            Class.forName(driver).newInstance();
            this.conn = DriverManager.getConnection(url, usr, pass);
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    public synchronized static Config getInstance(){
        if(config == null){
            config = new Config();
        }
        return config;
    }
    
    public JasperPrint getJasperPrint(File file, Map map) {
        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(file.getPath(), map, this.conn);
        } catch (Exception e) {
            e.getMessage();
        }
        
        return jp;
    }
    
    /*
    private static Config config = Config.getInstance();
    
    /Instructor/ JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametro, conec);
    /Sergio/ JasperPrint jp = config.getJasperPrint(jasper, parametro);
    */
    
    public Connection getConexion() {
        return this.conn;
    }
    
}