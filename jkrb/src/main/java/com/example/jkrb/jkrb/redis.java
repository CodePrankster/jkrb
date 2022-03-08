package com.example.jkrb.jkrb;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.HashMap;

@RestController
public class redis {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>(9);
        hashMap.put(null,null);
        System.out.println(hashMap);
    }
    @GetMapping("/list")
    public void list() throws Exception {
        Jedis jedis = new Jedis("127.0.0.1" , 6379 , 1000); // redis 的连接
        MyUser user = new MyUser(20,"张辉");

        jedis.set("userzzzzzzzzzzzzzzzz".getBytes(), serialize(user));

        byte[] byt=jedis.get("userzzzzzzzzzzzzzzzz".getBytes());

        MyUser obj= (MyUser) unserizlize(byt);

        System.out.println(obj.toString());


    }
    //序列化
    public static byte [] serialize(Object obj) throws Exception {
        ByteArrayOutputStream bai = null;
        ObjectOutputStream obi = null;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            return bai.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(obi!=null){
                obi.close();
            }
            if(bai!=null){
                bai.close();
            }
        }
        return null;
    }

    //反序列化
    public static Object unserizlize(byte[] byt) throws Exception {
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        try {
            bis=new ByteArrayInputStream(byt);
            oii=new ObjectInputStream(bis);
            return oii.readObject();
        } catch (Exception e) {

            e.printStackTrace();
        }finally {
            if(oii!=null){
                oii.close();
            }
            if(bis!=null){
                bis.close();
            }
        }
        return null;
    }
}
