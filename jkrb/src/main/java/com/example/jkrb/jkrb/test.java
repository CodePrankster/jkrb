package com.example.jkrb.jkrb;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class test {
    //3.添加定时任务
//    @Scheduled(cron = "0 0 8 * * ?")
    @Scheduled(cron = "0 */1 * * * ?")
    public  void SaticScheduleTask ()
    {
        ArrayList<String> tokenList = new ArrayList<>();
        tokenList.add("970a0ea4-db06-455b-a5bc-d65d416ed7ac");//张辉
        tokenList.add("0136a83a-be15-49bd-bd9a-2ae96ac92c61");//科威
        tokenList.add("984f51ec-1eaa-40b6-9394-b90d061ef166");//浩男
        tokenList.add("50158c92-10bc-4a27-b89d-8269cbaf1de8");//成翔
        tokenList.add("9dd94fce-e900-41f6-9919-a7d3e46d6401");//龙
        tokenList.add("fbf81e64-be29-4b4d-bc16-228ece8991fd");//建宁
        tokenList.add("6b3df651-66ed-4b0c-8ac0-109c6c7f0e3a");//国栋
        tokenList.add("254cf875-712a-42f7-891b-6de259e146de");//董伟
        tokenList.add("8383a9b5-c65e-4333-8870-0f280bcab328");//康威
        tokenList.add("0cf3366b-6950-490f-9748-698098d12400");//凯兴
        tokenList.add("0e1032ca-e02e-418d-8271-13630a4ec63c");//孙露露
        tokenList.add("c49f9677-22c6-4aba-b506-e32c2188abcd");//狮广田
        tokenList.add("b5b2d245-d71d-4ab3-ba2a-015c9008f3b4");//慧庆
        tokenList.add("40f0764c-a933-4198-b888-6e950a50d13c");//吴强
        tokenList.add("21dbe876-9130-4b93-abf9-474b767b412b");//风
        tokenList.add("5767ecb1-b7ae-45c8-b8e8-0f4072e3a855");//纪磊
        tokenList.add("239a6e9a-ffef-4379-bb05-3a7127eef913");//彤宇
        tokenList.add("4bb76ef9-cf8b-4b6e-9545-1aa0fc5bae25");//世奇








        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setConnection("keep-alive");
        headers.setContentLength(146);
        headers.add(HttpHeaders.HOST,"https://xg.nyist.vip");
        headers.add("Accept","*/*");
        headers.add("authority","xg.nyist.vip");
        headers.add("scheme","https");
        headers.add("path","/v1/trace/Student/dailyreportadd");
        headers.add("appid","1");
        headers.add("Referer","https://servicewechat.com/wx5d22ba28f10a2e09/51/page-frame.html");
        headers.add("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36 MicroMessenger/7.0.9.501 NetType/WIFI MiniProgramEnv/Windows WindowsWechat");
        //第一个token 占位
        headers.add("token","0");
        params params = new params();
        params.setPcc("410000,411300,41130");
        params.setGps("33.0036,112.5396");
        params.setLocation("1");
        params.setStatus("0");
        params.setTemp("0");
        params.setContact("0");

        for (int i = 0; i < tokenList.size(); i++) {
            headers.remove("token");
            headers.add("token",tokenList.get(i));
            HttpEntity<String> httpEntity = new HttpEntity<String>(JSONObject.toJSON(params).toString(), headers);
            ResponseEntity<ResultVO> response = restTemplate.exchange("https://xg.nyist.vip/v1/trace/Student/dailyreportadd", HttpMethod.POST, httpEntity, ResultVO.class);
            System.out.println(response.getBody());
        }

    }
}
