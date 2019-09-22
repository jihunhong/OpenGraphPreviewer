## 🔬 입력한 페이지의 `OpenGraph TAG` 를 받아오는 Application


## 🌐 OpenGraph protocol

![enter image description here](http://2.bp.blogspot.com/-kzdcNpZkkK0/VBHOHfDjlkI/AAAAAAAAALs/Ud6T0JfaB4A/s1600/SharedLink.png)

>페이스북에서 최초로 정의한 메타 태그 규약입니다. 웹페이지의 정보를 찾을때 점점 더 복잡해서 정보를 얻기 어려워집니다.

>특정정보를 웹사이트에서 미리 간략하게 정리하여 정리해두면 일관된 정보를 전달할 수 있다는 장점이 있습니다. 물론 해당 데이터 외에도 각 업체의 알고리즘에 따라더 많은 정보를 수집하는 경우도 있습니다.
 \- _📝 [[What is the Open Graph protocol?]](http://ogp.me/)_



## 🔗 Links

- [[What is the Open Graph protocol?]](http://ogp.me/)
- [[jsoup: Java HTML Parser]](https://jsoup.org/)


## 📷 ScreenShot
![캡처](https://i.imgur.com/QZCkzfx.jpg)

```java
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

```

사용자에게 url입력을 받은후 `Jsoup` 라이브러리를 이용해 
해당 페이지의 meta정보 desc,image,title 정보를 각각 받아 뷰에 전송하는 코드
