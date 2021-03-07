package com.azj.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.io.OutputStream;

public class AzjResponse {

    private ChannelHandlerContext ctx;
    private HttpRequest req;

    public AzjResponse(ChannelHandlerContext ctx, HttpRequest req) {
        this.ctx = ctx;
        this.req = req;
    }

    public void wirte(String str) throws Exception {

        if(str == null || str.length() == 0){
            return;
        }
        try {
            //设置http及请求头信息
            FullHttpResponse response = new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK,
                    Unpooled.wrappedBuffer(str.getBytes("UTF-8"))
            );
            response.headers().set("Content-Type", "text/html");
            ctx.write(response);
        }catch (Exception e){

        }finally {
            ctx.flush();
            ctx.close();
        }

    }
}
