import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

public class FileLinkedList
{
    public static void SaveToFile(String FileName, boolean Update, int count, LinkedList<Transport> transports) throws IOException
    {
        boolean Result = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(FileName, Update);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            writer.append("Start program: ").append(dtf.format(now)).append("\n");
            long sumtime = 0;
            for (int i = 0; i < count; i++)
            {
                Transport transport = new Transport("Mercedes", 70, i + 1);
                long start_time = System.nanoTime();
                transports.add(transport);
                long end_time = System.nanoTime() - start_time;
                sumtime += end_time;
                writer.append("add, ID = ").append(String.valueOf(i + 1)).append("  ").append(String.valueOf(end_time)).append(" ").append("nsec").append("\n");
            }
            writer.append("addTotalCount = ").append(String.valueOf(count)).append("\n");
            writer.append("addTotalTime = ").append(String.valueOf(sumtime)).append(" nsec").append("\n");
            writer.append("addMedianTime = ").append(String.valueOf(sumtime / count)).append(" nsec").append("\n");
            long sumtime_remove = 0;
            for (int i = 0; i < (count * 0.1); i++)
            {
                while(true)
                {
                    int ID = (int) (Math.random() * (count - i));
                    if (transports.get(ID) != null)
                    {
//                        Transport temp = transports.get(ID);
                        long start_time = System.nanoTime();
                        transports.remove(ID);
                        long end_time = System.nanoTime() - start_time;
                        sumtime_remove += end_time;
                        writer.append("remove, ID = ").append(String.valueOf(ID)).append("  ").append(String.valueOf(end_time)).append(" ").append("nsec").append("\n");
                        break;
                    }
                }
            }
            writer.append("removeTotalCount = ").append(String.valueOf(count/10)).append("\n");
            writer.append("removeTotalTime = ").append(String.valueOf(sumtime_remove)).append("\n");
            writer.append("removeMedianTime = ").append(String.valueOf(sumtime_remove/(count/10))).append("\n");
            LocalDateTime now1 = LocalDateTime.now();
            writer.append("Finish program: ").append(dtf.format(now1));
            Result = true;
        } catch (IOException exc) {
            System.err.println(exc.getMessage());
        } finally {
            assert writer != null;
            writer.close();
        }
    }
}
