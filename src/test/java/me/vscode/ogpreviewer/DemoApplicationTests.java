package me.vscode.ogpreviewer;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void contextLoads() { 
	}

	@Test
 	public void Get_html(){
		try{
			String url = "https://www.daum.net";

			Document document = Jsoup.connect(url).get();

			Element element = document.select("html").first();

            System.out.println(element.toString());
 
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Test
	public void Pairing_tags(){
		try{
			String url = "https://www.daum.net";

			Document document = Jsoup.connect(url).get();
			
            Elements els = document.select("meta");

            Map<String, String> map = new HashMap<>();
			
			for(Element el : els){
                map.put(el.attr("property"), el.attr("content"));
                System.out.println(el.attr("property") + "  :  " + el.attr("content"));                
            }
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Test
	public void Crawl(){
		try{
			String url = "http://gall.dcinside.com/mgallery/board/view/?id=mnet_k&no=3103286&exception_mode=recommend&page=1";

			Document document = Jsoup.connect(url).get();
			
			Elements els = document.select(".usertxt ub-word");
			
			for(Element el : els){
                String s = el.text();               
            }
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}

