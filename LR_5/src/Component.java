import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Component extends JComponent{
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        //region GraphicMedianTime
        Rectangle2D graph1 = new Rectangle2D.Double(0,0,950,950);

        //region CreateXY
        Line2D lineTime1 = new Line2D.Double(60,30,60,900);
        Line2D lineCount1 = new Line2D.Double(60,900,900, 900);
        //endregion
        //region CreateArrowOnXY
        Line2D arrowTime1left = new Line2D.Double(60,30,50,40);
        Line2D arrowTime1right = new Line2D.Double(60,30,70,40);
        Line2D arrowCount1left = new Line2D.Double(900,900,890,890);
        Line2D arrowCount1right = new Line2D.Double(900,900,890,910);
        //endregion
        Line2D [] times = new Line2D[20];
        for(int i = 0; i < 5; i++)
        {
            times[i] = new Line2D.Double(55,900-160*(i + 1),65,900-160*(i + 1));
        }
        Line2D [] points = new Line2D[5];
        for(int i = 0; i < 5; i++)
        {
            points[i] = new Line2D.Double(60+90*(2*i+1),895,60+90*(2*i+1),905);
        }
        //endregion
        //region MedianTimesPointsAddArray
        Ellipse2D ArrAddMedian10 = new Ellipse2D.Double(60+90-2,900-8,4,4);
        Ellipse2D ArrAddMedian100 = new Ellipse2D.Double(60+90*3-2,900-9.52,4,4);
        Ellipse2D ArrAddMedian1000 = new Ellipse2D.Double(60+90*5-2,900-1.84,4,4);
        Ellipse2D ArrAddMedian10000 = new Ellipse2D.Double(60+90*7-2,900-1.472,4,4);
        Ellipse2D ArrAddMedian100000 = new Ellipse2D.Double(60+90*9-2,900-0.88,4,4);

        Line2D ArrAddMed10to100 = new Line2D.Double(60+90,900-8,60+90*3,900-9.52);
        Line2D ArrAddMed100to1000 = new Line2D.Double(60+90*3,900-9.52,60+90*5,900-1.84);
        Line2D ArrAddMed1000to10000 = new Line2D.Double(60+90*5,900-1.84,60+90*7,900-1.472);
        Line2D ArrAddMed10000to100000 = new Line2D.Double(60+90*7,900-1.472,60+90*9,900-0.88);
        //endregion
        //region MedianTimesPointsAddLinked
        Ellipse2D LinkAddMedian10 = new Ellipse2D.Double(60+90-2,900-101.92,4,4);
        Ellipse2D LinkAddMedian100 = new Ellipse2D.Double(60+90*3-2,900-2.56,4,4);
        Ellipse2D LinkAddMedian1000 = new Ellipse2D.Double(60+90*5-2,900-2.23,4,4);
        Ellipse2D LinkAddMedian10000 = new Ellipse2D.Double(60+90*7-2,900-1.12,4,4);
        Ellipse2D LinkAddMedian100000 = new Ellipse2D.Double(60+90*9-2,900-0.88,4,4);

        Line2D LinkAddMed10to100 = new Line2D.Double(60+90,900-101.92,60+90*3,900-2.56);
        Line2D LinkAddMed100to1000 = new Line2D.Double(60+90*3,900-2.56,60+90*5,900-2.23);
        Line2D LinkAddMed1000to10000 = new Line2D.Double(60+90*5,900-2.23,60+90*7,900-1.12);
        Line2D LinkAddMed10000to100000 = new Line2D.Double(60+90*7,900-1.12,60+90*9,900-0.88);
        //endregion
        //region MedianTimesPointsRemoveArray
        Ellipse2D ArrRemMedian10 = new Ellipse2D.Double(60+90-2,900-75.2,4,4);
        Ellipse2D ArrRemMedian100 = new Ellipse2D.Double(60+90*3-2,900-47.68,4,4);
        Ellipse2D ArrRemMedian1000 = new Ellipse2D.Double(60+90*5-2,900-247.856,4,4);
        Ellipse2D ArrRemMedian10000 = new Ellipse2D.Double(60+90*7-2,900-230.05,4,4);
        Ellipse2D ArrRemMedian100000 = new Ellipse2D.Double(60+90*9-2,900-260,4,4);

        Line2D ArrRemMed10to100 = new Line2D.Double(60+90,900-75.2,60+90*3,900-47.68);
        Line2D ArrRemMed100to1000 = new Line2D.Double(60+90*3,900-47.68,60+90*5,900-247.856);
        Line2D ArrRemMed1000to10000 = new Line2D.Double(60+90*5,900-247.856,60+90*7,900-230.05);
        Line2D ArrRemMed10000to100000 = new Line2D.Double(60+90*7,900-230.05,60+90*9,900-260);
        //endregion
        //region MedianPointsRemoveLinked
        Ellipse2D LinkRemMedian10 = new Ellipse2D.Double(60+90-2,900-62.4,4,4);
        Ellipse2D LinkRemMedian100 = new Ellipse2D.Double(60+90*3-2,900-38.4,4,4);
        Ellipse2D LinkRemMedian1000 = new Ellipse2D.Double(60+90*5-2,900-274,4,4);
        Ellipse2D LinkRemMedian10000 = new Ellipse2D.Double(60+90*7-2,900-353.5,4,4);
        Ellipse2D LinkRemMedian100000 = new Ellipse2D.Double(60+90*9-2,900-846,4,4);

        Line2D LinkRemMed10to100 = new Line2D.Double(60+90,900-62.4,60+90*3,900-38.4);
        Line2D LinkRemMed100to1000 = new Line2D.Double(60+90*3,900-38.4,60+90*5,900-274);
        Line2D LinkRemMed1000to10000 = new Line2D.Double(60+90*5,900-274,60+90*7,900-353.5);
        Line2D LinkRemMed10000to100000 = new Line2D.Double(60+90*7,900-353.5,60+90*9,900-846);
        //endregion

        //region DrawArrowsCountTimeStrings
        g2.draw(graph1);
        g2.draw(lineTime1);
        g2.drawString("Time",10,10);
        g2.draw(lineCount1);
        g2.drawString("Count",910,920);
        g2.draw(arrowTime1left);
        g2.draw(arrowTime1right);
        g2.draw(arrowCount1left);
        g2.draw(arrowCount1right);
        //endregion
        //region DrawPointsForCount
        for(int i = 0; i < 5; i++)
        {
            g2.draw(points[i]);
        }
        g2.drawString("10",60+90-10,905+15);
        g2.drawString("100",60+90*3-10,905+15);
        g2.drawString("1000",60+90*5-10,905+15);
        g2.drawString("10000",60+90*7-10,905+15);
        g2.drawString("100000",60+90*9-10,905+15);
        //endregion
        //region DrawLineTimes
        for(int i = 0; i < 5; i++)
        {
            g2.draw(times[i]);
        }
        //endregion
        //region DrawStringTimew
        g2.drawString("10000",55-40,900-160);
        g2.drawString("20000",55-40,900-320);
        g2.drawString("30000",55-40,900-480);
        g2.drawString("40000",55-40,900-640);
        g2.drawString("50000",55-40,900-800);
        //endregion
        //region DrawArrayMedianAdd
        g2.setColor(Color.GREEN);
        g2.drawString("Array AddMedianTime",430,25);
        g2.draw(ArrAddMedian10);
        g2.draw(ArrAddMedian100);
        g2.draw(ArrAddMedian1000);
        g2.draw(ArrAddMedian10000);
        g2.draw(ArrAddMedian100000);
        g2.draw(ArrAddMed10to100);
        g2.draw(ArrAddMed100to1000);
        g2.draw(ArrAddMed1000to10000);
        g2.draw(ArrAddMed10000to100000);

        //endregion
        //region DrawLinkedMedianAdd
        g2.setColor(Color.RED);
        g2.drawString("Linked AddMedianTime",430,40);
        g2.draw(LinkAddMedian10);
        g2.draw(LinkAddMedian100);
        g2.draw(LinkAddMedian1000);
        g2.draw(LinkAddMedian10000);
        g2.draw(LinkAddMedian100000);
        g2.draw(LinkAddMed10to100);
        g2.draw(LinkAddMed100to1000);
        g2.draw(LinkAddMed1000to10000);
        g2.draw(LinkAddMed10000to100000);
        //endregion
        //region DrawArrayMedianRemove
        g2.setColor(Color.BLUE);
        g2.drawString("Array RemoveMedianTime",430,55);
        g2.draw(ArrRemMedian10);
        g2.draw(ArrRemMedian100);
        g2.draw(ArrRemMedian1000);
        g2.draw(ArrRemMedian10000);
        g2.draw(ArrRemMedian100000);
        g2.draw(ArrRemMed10to100);
        g2.draw(ArrRemMed100to1000);
        g2.draw(ArrRemMed1000to10000);
        g2.draw(ArrRemMed10000to100000);
        //endregion
        //region DrawLinkedMedianRemove
        g2.setColor(Color.BLACK);
        g2.drawString("Linked RemoveMedianTime",430,70);
        g2.draw(LinkRemMedian10);
        g2.draw(LinkRemMedian100);
        g2.draw(LinkRemMedian1000);
        g2.draw(LinkRemMedian10000);
        g2.draw(LinkRemMedian100000);
        g2.draw(LinkRemMed10to100);
        g2.draw(LinkRemMed100to1000);
        g2.draw(LinkRemMed1000to10000);
        g2.draw(LinkRemMed10000to100000);
        //endregion
        //endregion
        //region GraphicTotalTime
        //region Rectangle2
        Rectangle2D graph2 = new Rectangle2D.Double(950,0,950,950);
        Line2D lineTime2 = new Line2D.Double(60+950,30,60+950,900);
        Line2D lineCount2 = new Line2D.Double(60+950,900,900+950,900);
        //endregion
        //region Arrows2
        Line2D arrowTime2left = new Line2D.Double(60+950,30,50+950,40);
        Line2D arrowTime2right = new Line2D.Double(60+950,30,70+950,40);
        Line2D arrowCount2left = new Line2D.Double(900+950,900,890+950,890);
        Line2D arrowCount2right = new Line2D.Double(900+950,900,890+950,910);
        //endregion
        //region PointsTimesAndCount
        Line2D [] times_m = new Line2D[6];
        for(int i = 0; i < 6; i++)
        {
            times_m[i] = new Line2D.Double(55+950,900-150*(i+1),65+950,900-150*(i+1));
        }
        Line2D [] points_m = new Line2D[5];
        for(int i = 0; i < 5; i++)
        {
            points_m[i] = new Line2D.Double(60+90*(2*i+1)+950,895,60+90*(2*i+1)+950,905);
        }
        //endregion
        //region AddTotalTimeArrayPoints
        Ellipse2D ArrAddTotal10 = new Ellipse2D.Double(60+90-2+950,900-7.5,4,4);
        Ellipse2D ArrAddTotal100 = new Ellipse2D.Double(60+90*3-2+950,900-89.25,4,4);
        Ellipse2D ArrAddTotal1000 = new Ellipse2D.Double(60+90*5-2+950,900-169.216,4,4);
        Ellipse2D ArrAddTotal10000 = new Ellipse2D.Double(60+90*7-2+950,900-288.6,4,4);
        Ellipse2D ArrAddTotal100000 = new Ellipse2D.Double(60+90*9-2+950,900-392,4,4);

        Line2D ArrAddTot10to100 = new Line2D.Double(60+90+950,900-7.5,60+90*3+950,900-89.25);
        Line2D ArrAddTot100to1000 = new Line2D.Double(60+90*3+950,900-89.25,60+90*5+950,900-169.216);
        Line2D ArrAddTot1000to10000 = new Line2D.Double(60+90*5+950,900-169.216,60+90*7+950,900-288.6);
        Line2D ArrAddTot10000to100000 = new Line2D.Double(60+90*7+950,900-288.6,60+90*9+950,900-392);
        //endregion
        //region AddTotalTimeLinkedPoints
        Ellipse2D LinkAddTotal10 = new Ellipse2D.Double(60+90-2+950,900-95.55,4,4);
        Ellipse2D LinkAddTotal100 = new Ellipse2D.Double(60+90*3-2+950,900-24,4,4);
        Ellipse2D LinkAddTotal1000 = new Ellipse2D.Double(60+90*5-2+950,900-173.3,4,4);
        Ellipse2D LinkAddTotal10000 = new Ellipse2D.Double(60+90*7-2+950,900-267.83,4,4);
        Ellipse2D LinkAddTotal100000 = new Ellipse2D.Double(60+90*9-2+950,900-393.1,4,4);

        Line2D LinkAddTotal10to100 = new Line2D.Double(60+90+950,900-95.55,60+90*3+950,900-24);
        Line2D LinkAddTotal100to1000 = new Line2D.Double(60+90*3+950,900-24,60+90*5+950,900-173.3);
        Line2D LinkAddTotal1000to10000 = new Line2D.Double(60+90*5+950,900-173.3,60+90*7+950,900-267.83);
        Line2D LinkAddTotal10000to100000 = new Line2D.Double(60+90*7+950,900-267.83,60+90*9+950,900-393.1);
        //endregion
        //region RemoveTotalTimeArrayPoints
        Ellipse2D ArrRemTotal10 = new Ellipse2D.Double(60+90-2+950,900-7.05,4,4);
        Ellipse2D ArrRemTotal100 = new Ellipse2D.Double(60+90*3-2+950,900-45,4,4);
        Ellipse2D ArrRemTotal1000 = new Ellipse2D.Double(60+90*5-2+950,900-325.83,4,4);
        Ellipse2D ArrRemTotal10000 = new Ellipse2D.Double(60+90*7-2+950,900-473.97,4,4);
        Ellipse2D ArrRemTotal100000 = new Ellipse2D.Double(60+90*9-2+950,900-627.06,4,4);

        Line2D ArrRemTotal10to100 = new Line2D.Double(60+90+950,900-7.05,60+90*3+950,900-45);
        Line2D ArrRemTotal100to1000 = new Line2D.Double(60+90*3+950,900-45,60+90*5+950,900-325.83);
        Line2D ArrRemTotal1000to10000 = new Line2D.Double(60+90*5+950,900-325.83,60+90*7+950,900-473.97);
        Line2D ArrRemTotal10000to100000 = new Line2D.Double(60+90*7+950,900-473.97,60+90*9+950,900-627.06);
        //endregion
        //region RemoveTotalTimeLinkedPoints
        Ellipse2D LinkRemTotal10 = new Ellipse2D.Double(60+90-2+950,900-5.85,4,4);
        Ellipse2D LinkRemTotal100 = new Ellipse2D.Double(60+90*3-2+950,900-36,4,4);
        Ellipse2D LinkRemTotal1000 = new Ellipse2D.Double(60+90*5-2+950,900-328.53,4,4);
        Ellipse2D LinkRemTotal10000 = new Ellipse2D.Double(60+90*7-2+950,900-486.83,4,4);
        Ellipse2D LinkRemTotal100000 = new Ellipse2D.Double(60+90*9-2+950,900-886.955,4,4);

        Line2D LinkRemTotal10to100 = new Line2D.Double(60+90+950,900-5.85,60+90*3+950,900-36);
        Line2D LinkRemTotal100to1000 = new Line2D.Double(60+90*3+950,900-36,60+90*5+950,900-328.53);
        Line2D LinkRemTotal1000to10000 = new Line2D.Double(60+90*5+950,900-328.53,60+90*7+950,900-486.83);
        Line2D LinkRemTotal10000to100000 = new Line2D.Double(60+90*7+950,900-486.83,60+90*9+950,900-886.955);
        //endregion

        //region DrawTimesAndCountsAndArrows
        g2.setColor(Color.BLACK);
        g2.draw(graph2);

        g2.draw(lineTime2);
        g2.drawString("Time",30+950,10);
        g2.draw(lineCount2);
        g2.drawString("Count",890+950,940);

        g2.draw(arrowTime2left);
        g2.draw(arrowTime2right);
        g2.draw(arrowCount2left);
        g2.draw(arrowCount2right);

        for(int i = 0; i < 6; i++)
        {
            g2.draw(times_m[i]);
        }

        for(int i = 0; i < 5; i++)
        {
            g2.draw(points_m[i]);
        }

        g2.drawString("10",60+90-10+950,905+15);
        g2.drawString("100",60+90*3-10+950,905+15);
        g2.drawString("1000",60+90*5-10+950,905+15);
        g2.drawString("10000",60+90*7-10+950,905+15);
        g2.drawString("100000",60+90*9-10+950,905+15);

        g2.drawString("0,1m",55-40+950,900-150);
        g2.drawString("1m",55-40+950,900-150*2);
        g2.drawString("10m",55-40+950,900-150*3);
        g2.drawString("100m",55-40+950,900-150*4);
        g2.drawString("1000m",55-40+950,900-150*5);
        g2.drawString("10000m",55-40+950,900-145*6);
        //endregion
        //region DrawArrayAddTotal
        g2.setColor(Color.GREEN);
        g2.drawString("Array AddAllTime",430+630,25);
        g2.draw(ArrAddTotal10);
        g2.draw(ArrAddTotal100);
        g2.draw(ArrAddTotal1000);
        g2.draw(ArrAddTotal10000);
        g2.draw(ArrAddTotal100000);
        g2.draw(ArrAddTot10to100);
        g2.draw(ArrAddTot100to1000);
        g2.draw(ArrAddTot1000to10000);
        g2.draw(ArrAddTot10000to100000);
        //endregion
        //region DrawLinkedAddTotal
        g2.setColor(Color.RED);
        g2.drawString("Linked AddAllTime",430+630,40);
        g2.draw(LinkAddTotal10);
        g2.draw(LinkAddTotal100);
        g2.draw(LinkAddTotal1000);
        g2.draw(LinkAddTotal10000);
        g2.draw(LinkAddTotal100000);
        g2.draw(LinkAddTotal10to100);
        g2.draw(LinkAddTotal100to1000);
        g2.draw(LinkAddTotal1000to10000);
        g2.draw(LinkAddTotal10000to100000);
        //endregion
        //region DrawArrayRemoveTotal
        g2.setColor(Color.BLUE);
        g2.drawString("Array RemoveAllTime",430+630,55);
        g2.draw(ArrRemTotal10);
        g2.draw(ArrRemTotal100);
        g2.draw(ArrRemTotal1000);
        g2.draw(ArrRemTotal10000);
        g2.draw(ArrRemTotal100000);
        g2.draw(ArrRemTotal10to100);
        g2.draw(ArrRemTotal100to1000);
        g2.draw(ArrRemTotal1000to10000);
        g2.draw(ArrRemTotal10000to100000);
        //endregion
        //region DrawLinkedRemoveTotal
        g2.setColor(Color.BLACK);
        g2.drawString("Linked RemoveAllTime",430+630,70);
        g2.draw(LinkRemTotal10);
        g2.draw(LinkRemTotal100);
        g2.draw(LinkRemTotal1000);
        g2.draw(LinkRemTotal10000);
        g2.draw(LinkRemTotal100000);
        g2.draw(LinkRemTotal10to100);
        g2.draw(LinkRemTotal100to1000);
        g2.draw(LinkRemTotal1000to10000);
        g2.draw(LinkRemTotal10000to100000);
        //endregion
        //endregion
    }
}
