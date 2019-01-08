package me.vscode.ogpreviewer;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

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

}

