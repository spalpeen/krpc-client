package com.kongming.krpc.client;

import com.kongming.krpc.contract.KrpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class KrpcNetTransport {

    private String host;
    private int port;

    public KrpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object send(KrpcRequest krpcRequest) {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
            outputStream.writeObject(krpcRequest);
            outputStream.flush();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            return inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return null;
    }
}
