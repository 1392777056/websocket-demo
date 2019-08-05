package cn.dezhe.demo;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * 这一个简单的连接 webSocket 的演示类
 *
 * @Author dezhe
 * @Date 2019/8/5 18:08
 */
//此注解代表这是一个websocket的服务
@ServerEndpoint("/mytest/{id}")
public class WebSocketControllerDemo {

    /**
     * 开启websocket连接
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("id") String id) throws IOException {
        System.out.println("开始建立连接"+session);
        session.getBasicRemote().sendText(id+"登录系统");
    }

    /**
     * 关闭webSocket连接
     * @param session
     */
    @OnClose
    public void onClose(Session session){
        System.out.println("关闭连接"+session);
    }

    @OnMessage
    public void onMessage(String message,Session session) throws IOException {
        System.out.println("收到客户端发来的消息"+message);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //响应回去
        session.getBasicRemote().sendText("消息收到！");
    }

}
