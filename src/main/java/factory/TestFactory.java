package factory;

import factory02.ApplicationContext;
import javafx.scene.chart.PieChart;

import java.util.Date;

/**
 * Created by Administrator on 2019/4/17.
 */

class DateUtils{
    public static Date getInstance(){
        return new Date();
    }
}

public class TestFactory {
    public static void main(String[] args) {
        //直接创建对象
        Date date = new Date();
        //通过静态工厂创建
        Date instance = DateUtils.getInstance();
        //通过动态工厂创建(根据配置信息与反射创建对象)
        ApplicationContext context=new ApplicationContext("beans.xml");
        Date date1= (Date) context.getBean("date1");
        context.close();

    }

}
