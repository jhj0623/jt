package factory02;

/**
 * Created by Administrator on 2019/4/17.
 */

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 构建applicationcontext对象
 */
public class ApplicationContext {
    //静态 类加载是构建,确保只有一个map
    private static Map<String,Object> beanMap=new HashMap<String, Object>();
    public ApplicationContext(String file){
        init(file);
    }
/**初始化对象,然后存储到map*/
    private void init(String file) {
        //1.读取文件(在类路径下读取文件)
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
        //2.解析文件
        SAXReader sr =new SAXReader();
        Document doc=null;
        try {
             doc = sr.read(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        Element root = doc.getRootElement();//拿到根元素
        //获取根元素下所有的bean元素
        List<Element> list = root.elements("bean");
        for (Element e : list) {
            //拿到id和class属性的值
            String idValue=e.attributeValue("id");
            String clsValue = e.attributeValue("class");
            Object obj=null;
            //3.创建对象
            try {
                //拿到对象?了解反射API
                obj = Class.forName(clsValue).newInstance();
            } catch (Exception e1) {
                e1.printStackTrace();
                throw new RuntimeException();
            }
            //4.存储对象
            beanMap.put(idValue,obj);
        }
    }
    /**从map中获取对象*/
    public Object getBean(String key){

        return beanMap.get(key);
    }
    /**释放资源*/
    public void close(){
        beanMap.clear();
        beanMap=null;
    }
}
