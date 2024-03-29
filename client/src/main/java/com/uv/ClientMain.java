package com.uv;

import com.uv.client.NettyClient;
import com.uv.protocol.RpcRequest;
import io.netty.channel.Channel;
import java.util.UUID;

/**
 * <uv> [2018/10/13 19:51]
 */
public class ClientMain {

    public static void main(String[] args) throws Exception {
        NettyClient client = new NettyClient("127.0.0.1", 8080);
        //启动client服务
        client.start();
        Channel channel = client.getChannel();
        //channel对象可保存在map中，供其它地方发送消息
        RpcRequest request = new RpcRequest();
        request.setId(UUID.randomUUID().toString());
        request.setData("client.message");
        channel.writeAndFlush(request);
        //channel对象可保存在map中，供其它地方发送消息
        RpcRequest request2 = new RpcRequest();
        request2.setId(UUID.randomUUID().toString());
        request2.setData("client.message");
        channel.writeAndFlush(request2);
        System.out.println(123);
    }
}
