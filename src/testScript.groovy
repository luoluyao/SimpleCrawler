/**
 * Created by luoluyao on 2017/11/9.
 */
import org.jsoup.Jsoup

def list = [];
Jsoup.connect("http://daily.zhihu.com/").get().select("body > div.main-content > div.container-fixed-width" +
        "> div.main-content-wrap > div > div > div > div > a").each {
    def url = it.attr("href")
    list.add("http://daily.zhihu.com"+url)
}
count = 0
def articleList = []
println(list)
list.each {it ->
    def tmp = Jsoup.connect(it).get()
    def text
    tmp.select("body > div.main-wrap.content-wrap > div.content-inner").each { one ->
        title = one.select("div > h2").text()
        author = one.select("div > div > div > span.author").text()
    }
    tmp.select("body > div.main-wrap.content-wrap > div.content-inner > div.question > div.answer > div.content > p").each {detail ->
        text += detail.text()
    }
    articleList.add(new Article(count, title, author, text))
    count++
}
print(articleList)