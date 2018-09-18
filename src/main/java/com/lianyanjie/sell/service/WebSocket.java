package com.lianyanjie.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: lyj
 * @since: 2018/9/18
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    private Session session;

    // 储存session
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();

    /**
     * 打开连接
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("【websocket消息】有新的连接，总数:{}", webSocketSet.size());
    }

    /**
     * 关闭连接
     */
    @OnClose
    public void OnClose() {
        webSocketSet.remove(this);
        log.info("【websocket消息】连接断开，总数:{}", webSocketSet.size());
    }

    /**
     * 收到消息
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        webSocketSet.remove(this);
        log.info("【websocket消息】收到客户端发来的消息:{}", message);
    }

    /**
     * 发送消息
     */
    public void sendMessage(String message) {
        for (WebSocket webSocket : webSocketSet) {
            log.info("【websocket消息】广播消息, message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();    // 异常只打印不抛出（抛出会回滚）
            }
        }
    }
}
