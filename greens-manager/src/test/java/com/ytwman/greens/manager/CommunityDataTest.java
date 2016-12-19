package com.ytwman.greens.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

import java.io.IOException;

/**
 * Created by ytwman on 16/12/19.
 */
public class CommunityDataTest extends BaseTest {

    final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 抓取房产超市的社区数据
     */
    @Test
    public void testFccsCommunity() {
        int totalPage = 115;
        String urlTemplate = "http://xiaoqu.xf.fccs.com/sale/fr1_p%s.html";

        String lnglat = "http://second.xf.fccs.com/map/getLocationCommunity.do?m=1&q=%s";

        for (int i = 1; i <= totalPage; i++) {
            String url = String.format(urlTemplate, i);
            logger.info("请求页面：" + url);

            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select(".fy_list.xqfy_list ul li.item");
                for (Element element : elements) {

                    // 小区名称
                    Element ahref = element.select(".info0 .t a.w_l_3").get(0);
                    String name = ahref.text();
                    String idString = ahref.attr("href");

                    double lng = 0.0;
                    double lat = 0.0;

                    if (StringUtils.isNotEmpty(idString)) {
                        idString = idString.replaceAll("/", "").replaceAll(".html", "");
                        String html = Jsoup.connect(String.format(lnglat, idString)).get().body().html();
//                        logger.info(html);

                        if(StringUtils.isNotEmpty(html)){
                            JSONObject jsonObject = JSON.parseObject(html);
                            lng = jsonObject.getDouble("mapx");
                            lat = jsonObject.getDouble("mapy");
                        }
                     }

                    // 地址
                    ahref = element.select(".info0 .lp label").get(0);
                    String address = ahref.text();

                    logger.info(name + "---" + lat + "---" + lng + "---" + address);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
