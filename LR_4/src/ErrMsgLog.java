import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class ErrMsgLog {
    private static ArrayList <Exception> ErrList;
    private static Logger log;
    //private static FileHandler errhnd;
    public ErrMsgLog() throws IOException {
        ErrList = new ArrayList();
//Читаем конфигурационный файл лога
        LogManager.getLogManager().readConfiguration(ErrMsgLog.class.getResourceAsStream("logging.properties"));
        log = Logger.getLogger(ErrMsgLog.class.getName());
//Закомментарили т.к. вынесли в конфигурационный файл лога
//errhnd = new FileHandler("src/logs/err_log.txt", true);
//errhnd.setFormatter( new SimpleFormatter());
//log.addHandler(errhnd);
    }
    //Добавляем ошибку в список ошибок
    public int addErr(Exception e) {
        ErrList.add(e);
        return ErrList.size();
    }
//Добавляем ошибку в список ошибок и в лог
public int addErrWithLog(Exception e) {
    ErrList.add(e);
//Код записи сообщения в лог
    log.log(Level.FINE, e.getMessage());
    return ErrList.size();
}
    //Получаем количество ошибок
    public int getErrCount() {
        return ErrList.size();
    }
    //Выводим информацию об ошибке
    public void showErrText(Exception e) {
        System.err.println(e.getMessage());
    }
    //Генерим (пробрасываем ошибку) с фиксацией в списке ошибок
    public Exception makeErr(Exception e) {
        addErr(e);
        return new Exception(e);
    }
}