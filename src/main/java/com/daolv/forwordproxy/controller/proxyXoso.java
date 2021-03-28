package com.daolv.forwordproxy.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController("/")
public class proxyXoso {

    @GetMapping()
    public String home(){
        return "ok";

    }


    @GetMapping("getketqua")
    public ResponseEntity<?> getXoSoPhp(@RequestParam ("type") String type) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://www.kqxs.vn/realtime.php?type="+type)
                .method("GET", null)
                .addHeader("Connection", "keep-alive")
                .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"")
                .addHeader("Accept", "text/html, */*; q=0.01")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Sec-Fetch-Dest", "empty")
                .addHeader("Referer", "https://www.kqxs.vn/xo-so-truc-tuyen")
                .addHeader("Accept-Language", "vi,en;q=0.9,vi-VN;q=0.8,en-US;q=0.7")
                .addHeader("Cookie", "isGoogleRedirect=true; PHPSESSID=l99rljco9s6d30m3ofbisc9fbp; __utmc=243497887; __utmz=243497887.1616839393.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utma=243497887.403849119.1616676942.1616839393.1616921445.3; __utmt=1; __utmb=243497887.20.10.1616921445")
                .build();
        Response response = client.newCall(request).execute();
        String res = response.body().string();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type",response.headers().get("Content-Type"));
        headers.add("Date",response.headers().get("Date"));
        ResponseEntity responseEntity = new ResponseEntity<>(res,headers, HttpStatus.OK);
        return responseEntity;
    }

}
