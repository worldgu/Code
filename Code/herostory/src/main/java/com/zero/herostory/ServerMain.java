package com.zero.herostory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@ClassName ServerMain
 *@Description TODO
 *@Author 张春海
 *@Date 2020/8/3 23:30 
 *@Version 1.0 */
public class ServerMain {

    static private final Logger LOGGER = LoggerFactory.getLogger(ServerMain.class);


    /**
     *  应用主函数
     * @param args
     */
    public static void main(String[] args){
        //  设置 log4j  属性文件
        PropertyConfigurator.configure(ServerMain.class.getClassLoader().getResourceAsStream("log4j.properties"));

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workGroup);
            b.channel(NioServerSocketChannel.class);  //  服务器信道的处理方式
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(
                       new HttpServerCodec(),    // Http服务器编解码器
                       new HttpObjectAggregator(65535),  //  内容长度限制
                       new WebSocketServerProtocolHandler("/websocket"),  //WebSocket 协议处理器，在这里处理握手、ping、pong等消息
                            new GameMsgHandler()   //  自定义的消息处理器
                    );
                }
            });

            b.option(ChannelOption.SO_BACKLOG,128);
            b.childOption(ChannelOption.SO_KEEPALIVE, true);

            // 绑定 12345 端口
            // 注意: 实际项目中会使用argArray 中的参数来指定端口号
            ChannelFuture f =  b.bind(12345).sync();

            if ( f.isSuccess() ) {
                LOGGER.info("游戏服务器启动成功");
            }

            // 等待服务器信道关闭
            // 也就是不要退出应用程序
            // 让应用程序可以一直提供服务
            f.channel().closeFuture().sync();
        } catch (Exception e) {

        } finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }
}
