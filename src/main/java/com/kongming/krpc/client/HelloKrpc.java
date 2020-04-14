package com.kongming.krpc.client;

import com.kongming.krpc.contract.IHelloWorld;

public class HelloKrpc {
    public static void main(String[] args) {

        KrpcClientProxy krpcClientProxy = new KrpcClientProxy();
        IHelloWorld iHelloWorld = krpcClientProxy.clientProxy(IHelloWorld.class,"localhost",8080);
        String rs = iHelloWorld.sayHello("1");
        System.out.println(rs);
    }
}
