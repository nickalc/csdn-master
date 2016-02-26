package com.example.lee.suesnews.utils;

import com.example.lee.suesnews.common.NewsTypes;

/**
 * 相关API
 * Created by Administrator on 2015/1/18.
 */
public class SuesApiUtils {

    public static final String NEWS_URL_MAIN = "http://news.sues.edu.cn";
    //各个页面主要url
    public static final String NEWS_URL_XXYW = "http://news.sues.edu.cn/s/593/t/301/p/31/list.htm";
    public static final String NEWS_URL_XYKX = "http://news.sues.edu.cn/s/593/t/301/p/32/list.htm";
    public static final String NEWS_URL_KJDT = "http://news.sues.edu.cn/s/593/t/301/p/33/list.htm";
    public static final String NEWS_URL_MTJJ = "http://news.sues.edu.cn/s/593/t/301/p/34/list.htm";
    public static final String NEWS_URL_BMXW = "http://news.sues.edu.cn/s/593/t/301/p/35/list.htm";

    //用于拼接的基础url
    private static final String NEWS_URL_XXYW_PART = "http://news.sues.edu.cn/s/593/t/301/p/31/i";
    private static final String NEWS_URL_XYKX_PART = "http://news.sues.edu.cn/s/593/t/301/p/32/i";
    private static final String NEWS_URL_KJDT_PART = "http://news.sues.edu.cn/s/593/t/301/p/33/i";
    private static final String NEWS_URL_MTJJ_PART = "http://news.sues.edu.cn/s/593/t/301/p/34/i";
    private static final String NEWS_URL_BMXW_PART = "http://news.sues.edu.cn/s/593/t/301/p/35/i";

    private static final String NEWS_URL_ALL_PART = "http://blog.csdn.net/hot.html";
    private static final String NEWS_URL_MOBILE_PART = "http://blog.csdn.net/mobile/hot.html";
    private static final String NEWS_URL_WEB_PART = "http://blog.csdn.net/web/hot.html";
    private static final String NEWS_URL_ENTERPRISE_PART = "http://blog.csdn.net/enterprise/hot.html";
    private static final String NEWS_URL_CODE_PART = "http://blog.csdn.net/code/hot.html";


    private static final String NEWS_URL_WWW_PART = "http://blog.csdn.net/www/hot.html";
    private static final String NEWS_URL_DATABASE_PART = "http://blog.csdn.net/database/hot.html";
    private static final String NEWS_URL_SYSTEM_PART = "http://blog.csdn.net/system/hot.html";
    private static final String NEWS_URL_CLOUD_PART = "http://blog.csdn.net/cloud/hot.html";
    private static final String NEWS_URL_SOFTWARE_PART = "http://blog.csdn.net/software/hot.html";
    private static final String NEWS_URL_OTHER_PART = "http://blog.csdn.net/other/hot.html ";



    private static final String URL_END = "/list.htm";
    private static final String TOTAL_PAGE_END = ".htm";

    //URL规则：
    //基础url + "/" + 当前页码 + URL_END = 对应页码的新闻页面url
    //基础url + TOTAL_PAGE_END = 该页面的新闻总条数

    /**
     * 根据url得到总页数
     * @param url
     * @return
     */
    private static int getTotalPageByUrl(String url){
        String htmlStr = null;
        try {
            htmlStr = HttpUtils.doGet(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int totalNewsItem = StringUtils.getIntFromString(htmlStr);  //新闻总条数
        int totalPage = totalNewsItem/21 + (totalNewsItem%21==0?0:1); //新闻总页数
        return totalPage;
    }



    /**
     * 获得相应页面的新闻总页数
     * @param newsType
     * @return
     */
    public static int getTotalPage(int newsType){
        int totalPage = 0;
        switch(newsType){
             case NewsTypes.CSND_TPYE_ALL:
                totalPage = getTotalPageByUrl(NEWS_URL_XXYW_PART+TOTAL_PAGE_END);
                break;
            case NewsTypes.CSND_TPYE_MOBILE:
                totalPage = getTotalPageByUrl(NEWS_URL_XYKX_PART+TOTAL_PAGE_END);
                break;
            case NewsTypes.CSND_TPYE_WEB:
                totalPage = getTotalPageByUrl(NEWS_URL_KJDT_PART+TOTAL_PAGE_END);
                break;
            case NewsTypes.CSND_TPYE_ENTERPRISE:
                totalPage = getTotalPageByUrl(NEWS_URL_MTJJ_PART+TOTAL_PAGE_END);
                break;
            case NewsTypes.CSND_TPYE_CODE:
                totalPage = getTotalPageByUrl(NEWS_URL_BMXW_PART+TOTAL_PAGE_END);
                break;
            default:
                break;
        }
        return totalPage;
    }

    /**
     * 得到相应页面的url
     * @param newsType
     * @param currentPage
     * @return
     */
    public static String getNewsUrl(int newsType,int currentPage){
       // int totalPage = getTotalPage(newsType);
        int pageUrl = currentPage + 1;  //url中的页码
        String currentPageString = Integer.toString(pageUrl);
        String url = null;
        switch(newsType){
            case NewsTypes.CSND_TPYE_ALL:
                url = NEWS_URL_ALL_PART + "?page=" + currentPageString;
                break;
            case NewsTypes.CSND_TPYE_MOBILE:
                url = NEWS_URL_MOBILE_PART+ "?page=" + currentPageString;
                break;
            case NewsTypes.CSND_TPYE_WEB:
                url = NEWS_URL_WEB_PART + "?page=" + currentPageString;
                break;
            case NewsTypes.CSND_TPYE_ENTERPRISE:
                url = NEWS_URL_ENTERPRISE_PART + "?page=" + currentPageString;
                break;
            case NewsTypes.CSND_TPYE_CODE:
                url = NEWS_URL_CODE_PART + "?page=" + currentPageString;
                break;
            case NewsTypes.CSND_TPYE_WWW:
                url = NEWS_URL_WWW_PART + "?page=" + currentPageString;
                break;
            case NewsTypes.CSND_TPYE_DATABASE:
                url = NEWS_URL_DATABASE_PART + "?page=" + currentPageString;
                break;
            case NewsTypes.CSND_TPYE_SYSTEM:
                url = NEWS_URL_SYSTEM_PART + "?page=" + currentPageString;
                break;
            case NewsTypes.CSND_TPYE_CLOUD:
                url = NEWS_URL_CLOUD_PART + "?page=" + currentPageString;
                break;
            case NewsTypes.CSND_TPYE_SOFTWARE:
                url = NEWS_URL_SOFTWARE_PART + "?page=" + currentPageString;
                break;
            case NewsTypes.CSND_TPYE_OTHER:
                url = NEWS_URL_OTHER_PART + "?page=" + currentPageString;
                break;
            default:
                break;
        }
       // url += URL_END;
        return url;
    }

}
