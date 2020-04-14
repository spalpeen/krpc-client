package com.kongming.krpc.client;

import com.kongming.krpc.contract.KrpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        KrpcRequest krpcRequest = new KrpcRequest();
        krpcRequest.setClassName(method.getDeclaringClass().getName());
        krpcRequest.setMethodName(method.getName());
        krpcRequest.setParams(args);
        krpcRequest.setTypes(method.getParameterTypes());

        KrpcNetTransport krpcNetTransport = new KrpcNetTransport(host,port);
        return krpcNetTransport.send(krpcRequest);
    }
}
