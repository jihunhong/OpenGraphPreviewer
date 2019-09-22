package me.vscode.ogpreviewer.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String home(Model model) {

        return "home";
    }

    @RequestMapping("/search")
    public String Search(Model model, HttpServletRequest request) {
        String description = "";
        String image_url = "";
        String title = "";

        String url = request.getParameter("query");

        try {

            Document document = Jsoup.connect(url).get();

            Element meta_description = document.select("meta[property=og:description]").first();
            Element meta_image_url = document.select("meta[property=og:image]").first();
            Element meta_title = document.select("meta[property=og:title]").first();
            
            description = meta_description.attr("content");
            image_url   = meta_image_url.attr("content");
            title       = meta_title.attr("content");

		}catch(IOException e){
			e.printStackTrace();
        }
        
        model.addAttribute("description",description);
        model.addAttribute("image_url",image_url);
        model.addAttribute("title",title);
        model.addAttribute("url",url);

        return "search_result";
    }

    @RequestMapping("/search")
    public String Youtube(Model model, HttpServletRequest request) {
        String description = "";
        String image_url = "";
        String title = "";

        String url = request.getParameter("query");

        try {

            Document document = Jsoup.connect(url).get();

            Element meta_description = document.select("meta[property=og:description]").first();
            Element meta_image_url = document.select("meta[property=og:image]").first();
            Element meta_title = document.select("meta[property=og:title]").first();
            
            description = meta_description.attr("content");
            image_url   = meta_image_url.attr("content");
            title       = meta_title.attr("content");

		}catch(IOException e){
			e.printStackTrace();
        }
        
        model.addAttribute("description",description);
        model.addAttribute("image_url",image_url);
        model.addAttribute("title",title);
        model.addAttribute("url",url);

        return "search_result";
    }

    

}