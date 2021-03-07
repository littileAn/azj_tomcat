package com.azj.http;

public abstract  class AzjServlet {

    public void service(AzjRequest request, AzjResponse response) throws Exception {
        if("GET".equals(request.getMethod())){
            doGet(request,response);
        }else{
            doPost(request, response);
        }
    }

    public abstract void doGet(AzjRequest request, AzjResponse response) throws Exception;

    public abstract void doPost(AzjRequest request, AzjResponse response) throws Exception;



}
