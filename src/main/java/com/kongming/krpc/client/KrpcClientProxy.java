package com.kongming.krpc.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class KrpcClientProxy {
    public <T> T clientProxy(final Class<T> interfaceClass,String host,int port){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass},
                new RemoteInvocationHandler(host,port));
    }
}
