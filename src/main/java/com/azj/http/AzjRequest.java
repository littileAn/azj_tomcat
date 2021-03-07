package com.azj.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

public class AzjRequest {
    private ChannelHandlerContext ctx;
    private HttpRequest req;

    public AzjRequest(ChannelHandlerContext ctx, HttpRequest req) {
        this.ctx = ctx;
        this.req = req;
    }

    public String getMethod() {
        return req.method().name();
    }

    public String getUrl() {
        return req.uri();
    }

    public Map<String, List<String>> getParameters(){
        QueryStringDecoder decoder = new QueryStringDecoder(req.uri());
        return decoder.parameters();
    }

    public String getParameter(String name){
        List<String> params = getParameters().get(name);
        return params == null ? null : params.get(0);
    }
}
