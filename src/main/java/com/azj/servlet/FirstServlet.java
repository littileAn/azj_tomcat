package com.azj.servlet;

import com.azj.http.AzjRequest;
import com.azj.http.AzjResponse;
import com.azj.http.AzjServlet;

public class FirstServlet extends AzjServlet {
    public void doGet(AzjRequest request, AzjResponse response) throws Exception {
        doPost(request, response);
    }

    public void doPost(AzjRequest request, AzjResponse response) throws Exception {
        response.wirte("this is First Servlet");
    }
}
