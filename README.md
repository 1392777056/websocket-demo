# 什么是WebSocket？
  WebSocket 是HTML5一种新的协议。它实现了浏览器与服务器全双工通信(full-duplex)。一开始的握手需要借助
  HTTP请求完成。 WebSocket是真正实现了全双工通信的服务器向客户端推的互联网技术。 它是一种在单个TCP连
  接上进行全双工通讯协议。Websocket通信协议与2011年倍IETF定为标准RFC 6455，Websocket API被W3C定为
  标准。
  
# 全双工和单工的区别？
  (1) 全双工（Full Duplex）是通讯传输的一个术语。通信允许数据在两个方向上同时传输，它在能力上相当
  于两个单工通信方式的结合。全双工指可以同时（瞬时）进行信号的双向传输（A→B且B→A）。指
  A→B的同时B→A，是瞬时同步的。
  (2) 单工、半双工（Half Duplex），所谓半双工就是指一个时间段内只有一个动作发生，举个简单例子，
  一条窄窄的马路，同时只能有一辆车通过，当目前有两辆车对开，这种情况下就只能一辆先过，等到头
  儿后另一辆再开，这个例子就形象的说明了半双工的原理。早期的对讲机、以及早期集线器等设备都是
  基于半双工的产品。随着技术的不断进步，半双工会逐渐退出历史舞台。
  
# http与websocket的区别
1.http
  http协议是短连接，因为请求之后，都会关闭连接，下次重新请求数据，需要再次打开链接。
2.websocket
  WebSocket协议是一种长链接，只需要通过一次请求来初始化链接，然后所有的请求和响应都是通过这个TCP链接
进行通讯。

# websocket的相关注解说明

@ServerEndpoint("/websocket/{uid}")
  申明这是一个websocket服务
  需要指定访问该服务的地址，在地址中可以指定参数，需要通过{}进行占位
@OnOpen
  用法：public void onOpen(Session session, @PathParam("uid") String uid) throws
IOException{}
  该方法将在建立连接后执行，会传入session对象，就是客户端与服务端建立的长连接通道
  通过@PathParam获取url申明中的参数
@OnClose
  用法：public void onClose() {}
  该方法是在连接关闭后执行
@OnMessage
  用法：public void onMessage(String message, Session session) throws IOException {}
  该方法用于接收客户端发来的消息
  message：发来的消息数据
  session：会话对象（也是通道）
  发送消息到客户端
  用法：session.getBasicRemote().sendText("你好");
  通过session进行发送。
