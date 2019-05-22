package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2019/4/12.
 */

class DaoProxyHandler implements InvocationHandler{

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("select insert");
        return null;
    }
}

public class ProxyFactory {

    public <T>T newProxy(Class<T> targetCls){
        return (T) Proxy.newProxyInstance(targetCls.getClassLoader(),
                new Class[]{targetCls},
                new DaoProxyHandler());
    }
}
