package me.vscode.ogpreviewer.Controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{

    @RequestMapping("/search")
    public String home(Model model){
        String description = "";
        String image_url   = "";
        try{
			String url = "https://www.daum.net";

			Document document = Jsoup.connect(url).get();

            Element meta_description = document.select("meta[property=og:description]").first();
            Element meta_image_url = document.select("meta[property=og:image]").first();
            
            description = meta_description.attr("content");
            image_url   = meta_image_url.attr("content");

		}catch(IOException e){
			e.printStackTrace();
        }
        
        model.addAttribute("description",description);
        model.addAttribute("image_url",image_url);

        return "home";
    }

}