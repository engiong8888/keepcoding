package cn.keep.coding.yuerlog;

import cn.keep.coding.utils.WebRequestUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @ClassName CollectOne
 * @Description www.yugonghf.com
 * @mail
 * @Author cheng
 * @Date 2020/10/23 14:25
 * @Version 1.0
 */
public class CollectOne {

    /**
     * yecs
     * 0-1岁
     * https://www.yugonghf.com/yuer/ysxs/
     */
    public void cai(String url){
        try {
            StringBuilder result = new StringBuilder();
            String source = WebRequestUtil.caiHttpsRequest(url);
            Document document = Jsoup.parse(source);
            Elements elements = document.select("main.site-main");

            Elements elements2 = elements.select("figure.thumbnail");

            System.out.println("a标签个数=" + elements2.size());
            String content = "";
            for (int i = 1; i < elements2.size(); i++) {
                System.out.println(elements2.get(i).select("a").attr("href"));
                content += elements2.get(i).attr("href");
            }
        }catch(Exception e){
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        CollectOne c = new CollectOne();
//        String url = "https://www.yugonghf.com/yuer/ysxs/"; //0-1岁
//        c.cai(url);

        String url2 = "https://www.yugonghf.com/yuer/2sui/"; //1-2岁
        c.cai(url2);

        String url3 = "https://www.yugonghf.com/yuer/3sui/"; //2-3岁
        c.cai(url3);

        String url6 = "https://www.yugonghf.com/yuer/6sui/"; //3-6岁
        c.cai(url6);
    }
}
