package com.example.administrator.chunhui.bean;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Song Shuyu
 * Created by Administrator on 2019/1/20 0020 18:40
 * Created Sheepss
 * package is com.example.administrator.chunhui.bean
 * TODO
 */
public class News {


    /**
     * ERRORCODE : 0
     * RESULT : {"newsList":[{"publishTime":"2019-01-20 17:00:11","newsId":"63f947162d97d878c17f5a6f557d9d0d","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7368681630_640330/0","source":"冰点周刊","category":"要闻","title":"又一个被传销骗惨的家庭：母亲借了五万元，去学华林神奇带电的手"},{"publishTime":"2019-01-20 16:28:55","newsId":"c51954305dc5355b244ffb0f3756f0b3","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7368092693_640330/0","source":"新华国际","category":"要闻","title":"这次输油管爆炸揭露了墨西哥偷油到底有多疯狂"},{"publishTime":"2019-01-20 16:02:01","newsId":"6e3ac6b10680af8a8993094db5353deb","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7367905452_640330/0","source":"新京报","category":"要闻","title":"\u201c亿元贪官\u201d王保安受贿细节再曝光 副部级为这案子出具情况说明"},{"publishTime":"2019-01-20 15:17:21","newsId":"5c4620353ffe519cb982f24acf4d4a67","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7367331812_640330/0","source":"澎湃新闻","category":"要闻","title":"成都商报社原常务副总编辑谢文去世 曾签发全国首份汶川地震号外"},{"publishTime":"2019-01-20 15:12:21","newsId":"1ca4c3c1cec85cdd57fda7add954d7b7","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7367265936_640330/0","source":"澎湃新闻","category":"要闻","title":"失踪五年的劳工：上网直播\u201c锻炼说话\u201d 想起诉要回被侵吞工钱"},{"publishTime":"2019-01-20 15:00:49","newsId":"3090ea6e745aa93f2bff28302968d963","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7367689739_640330/0","source":"人民网舆情监测室","category":"要闻","title":"人民网舆情数据中心分析：副市长身兼46职背后的简政放权"},{"publishTime":"2019-01-20 14:05:11","newsId":"cf166c87fd5df9a27f5273f69b470073","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7366580127_640330/0","source":"JS娱乐","category":"要闻","title":"朱丹删除维护周一围动态：情绪控制能力太弱，我当猪队友了"},{"publishTime":"2019-01-20 13:33:17","newsId":"830d96014a8abc39a0fe19fc7f80905b","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7366382942_640330/0","source":"济南天桥公安","category":"要闻","title":"警方通报\u201c济南1家6口身亡\u201d：男子弑亲后放火跳楼 疑患抑郁症"},{"publishTime":"2019-01-20 12:05:32","newsId":"c0a7494b42d1ec3800c3608235f5b589","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7365460155_640330/0","source":"新周刊","category":"要闻","title":"港乐谢幕，谁还在听粤语歌？外人的唱衰，在港乐迷心中是新的开始"},{"publishTime":"2019-01-20 11:49:00","newsId":"ca21a56b73ea301dec382a26c18d2e8b","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363870069_640330/0","source":"观察者网军工频道","category":"要闻","title":"于敏之后，中国核武器怎么走？"},{"publishTime":"2019-01-20 11:48:39","newsId":"8491648c4243d36ab058695cd37fae47","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7365286257_640330/0","source":"侦探娱乐","category":"要闻","title":"周一围被列渣男行列，朱丹霸气维护老公：是对真正渣男的纵容"},{"publishTime":"2019-01-20 11:21:55","newsId":"4d8e7235252948f7707da8db3841c2ea","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7366085366_640330/0","source":"新晚报","category":"要闻","title":"25岁姑娘嫁亿万家产\u201c富二代\u201d不领证：不占你家便宜"},{"publishTime":"2019-01-20 11:05:55","newsId":"c7c4ab28f4425b0820947da2a4180e5b","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364837843_640330/0","source":"环球时报国内","category":"要闻","title":"辽宁海事局再发航行通告，中国航母动向牵动人心"},{"publishTime":"2019-01-20 10:56:00","newsId":"27d3a1a490a7d600e11e4603df88d44e","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364732816_640330/0","source":"海外网","category":"要闻","title":"\u201c特金会\u201d将在二月底举行 越南这两个城市呼声最高"},{"publishTime":"2019-01-20 10:53:12","newsId":"7fefe9200aeab1f390b1864867881e1c","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364852093_640330/0","source":"券商中国","category":"要闻","title":"A股全年蒸发14万亿楼市卖了14万亿，2019买房or买股"},{"publishTime":"2019-01-20 10:44:30","newsId":"f42ddacc0553983ca81513fcb4f41ff8","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364602682_640330/0","source":"较真","category":"要闻","title":"较真 | 中老年人更容易被谣言击中？答案可能跟你想的不一样"},{"publishTime":"2019-01-20 10:31:27","newsId":"cd5f488cd8cb0ad27c2395656fab010a","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364557419_640330/0","source":"南方人物周刊","category":"要闻","title":"中国观众熟悉的电影明星阿米尔·汗，何以成为\u201c印度良心\u201d？"},{"publishTime":"2019-01-20 10:17:49","newsId":"c67bef760a90840d465f478efc284c14","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364376257_640330/0","source":"海外网","category":"要闻","title":"智利中部发生6.9级地震 目前暂无海啸威胁"},{"publishTime":"2019-01-20 10:09:11","newsId":"63c498395329c518d754a7ed01393ca7","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364253499_640330/0","source":"霓虹","category":"要闻","title":"两名中国游客在日本大山里滑雪被困 在雪中挖洞藏身过夜"},{"publishTime":"2019-01-20 10:06:14","newsId":"39754653ff2976bc1b66e30a0dc8bc47","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7359979249_640330/0","source":"环球科学","category":"要闻","title":"150年前第一张元素周期表你见过吗？准确预测了缺失元素的性质"},{"publishTime":"2019-01-20 09:50:08","newsId":"31069f8299ac426282c2a8e304c9c4a8","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364060023_640330/0","source":"早安世界","category":"要闻","title":"早安世界：8万黄背心抵制马克龙作秀 潜水员与全球最大白鲨共舞"},{"publishTime":"2019-01-20 09:46:19","newsId":"88c8d89f1bcba59e0fcf07ef0e5569da","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364364140_640330/0","source":"新华社新闻","category":"要闻","title":"朝美代表将在瑞典举行工作会谈 涉及特金会等议题"},{"publishTime":"2019-01-20 09:08:59","newsId":"ac7ef2224f74e60f839b3de8f053f928","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363744386_640330/0","source":"博雅小学堂","category":"要闻","title":"伦敦中产妈妈：娃还没生出来，推娃就开始了，何时怀孕很重要"},{"publishTime":"2019-01-20 09:00:00","newsId":"a7a3a2bd9ce45cf29b9059c0cfeabfea","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363646775_640330/0","source":"图片故纸堆","category":"要闻","title":"历史上的今天：奥黛丽·赫本去世"},{"publishTime":"2019-01-20 08:53:42","newsId":"949b8454ff787bad6ddf5bde29e8309b","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363552405_196130/0","source":"","category":"要闻","title":"17岁生母活活虐死1岁女儿 2狗6猫却被\u201c富养\u201d"},{"publishTime":"2019-01-20 08:43:06","newsId":"9b307e6ecff58efa394f3a473d2fc987","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363430521_640330/0","source":"红星新闻","category":"要闻","title":"哈尔滨民警除夕夜出警遭暴力抗法遇害 主犯最高获刑13年"},{"publishTime":"2019-01-20 08:17:21","newsId":"a810351c08d461b46daa51f71440f9e3","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363304101_640330/0","source":"澎湃新闻","category":"要闻","title":"住建部通报：甘陕两县市斥巨资\u201c造门\u201d、照抄南方造景手法"},{"publishTime":"2019-01-20 08:05:05","newsId":"3393bb07c8734205529404f8a2d71ed1","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363187944_640330/0","source":"中国纪检监察报","category":"要闻","title":"国企高管痴迷期货交易 接连挪用过亿公款被查"},{"publishTime":"2019-01-20 08:03:39","newsId":"2e7e5b80d454ef63369d3b43d4fc33ab","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7358805568_640330/0","source":"漫步宇宙","category":"要闻","title":"\u201c关机重启\u201d确实管用，NASA就这样修复了哈勃主相机"},{"publishTime":"2019-01-20 08:03:02","newsId":"0190366c905a75aa0168a7a709d047dc","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7358262503_640330/0","source":"Vista看天下","category":"要闻","title":"在抗冻这件事上，民间智慧永远让你惊喜"}],"page":1,"allPage":2}
     */

    private String ERRORCODE;
    private RESULTBean RESULT;

    public String getERRORCODE() {
        return ERRORCODE;
    }

    public void setERRORCODE(String ERRORCODE) {
        this.ERRORCODE = ERRORCODE;
    }

    public RESULTBean getRESULT() {
        return RESULT;
    }

    public void setRESULT(RESULTBean RESULT) {
        this.RESULT = RESULT;
    }

    public static class RESULTBean {
        /**
         * newsList : [{"publishTime":"2019-01-20 17:00:11","newsId":"63f947162d97d878c17f5a6f557d9d0d","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7368681630_640330/0","source":"冰点周刊","category":"要闻","title":"又一个被传销骗惨的家庭：母亲借了五万元，去学华林神奇带电的手"},{"publishTime":"2019-01-20 16:28:55","newsId":"c51954305dc5355b244ffb0f3756f0b3","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7368092693_640330/0","source":"新华国际","category":"要闻","title":"这次输油管爆炸揭露了墨西哥偷油到底有多疯狂"},{"publishTime":"2019-01-20 16:02:01","newsId":"6e3ac6b10680af8a8993094db5353deb","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7367905452_640330/0","source":"新京报","category":"要闻","title":"\u201c亿元贪官\u201d王保安受贿细节再曝光 副部级为这案子出具情况说明"},{"publishTime":"2019-01-20 15:17:21","newsId":"5c4620353ffe519cb982f24acf4d4a67","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7367331812_640330/0","source":"澎湃新闻","category":"要闻","title":"成都商报社原常务副总编辑谢文去世 曾签发全国首份汶川地震号外"},{"publishTime":"2019-01-20 15:12:21","newsId":"1ca4c3c1cec85cdd57fda7add954d7b7","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7367265936_640330/0","source":"澎湃新闻","category":"要闻","title":"失踪五年的劳工：上网直播\u201c锻炼说话\u201d 想起诉要回被侵吞工钱"},{"publishTime":"2019-01-20 15:00:49","newsId":"3090ea6e745aa93f2bff28302968d963","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7367689739_640330/0","source":"人民网舆情监测室","category":"要闻","title":"人民网舆情数据中心分析：副市长身兼46职背后的简政放权"},{"publishTime":"2019-01-20 14:05:11","newsId":"cf166c87fd5df9a27f5273f69b470073","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7366580127_640330/0","source":"JS娱乐","category":"要闻","title":"朱丹删除维护周一围动态：情绪控制能力太弱，我当猪队友了"},{"publishTime":"2019-01-20 13:33:17","newsId":"830d96014a8abc39a0fe19fc7f80905b","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7366382942_640330/0","source":"济南天桥公安","category":"要闻","title":"警方通报\u201c济南1家6口身亡\u201d：男子弑亲后放火跳楼 疑患抑郁症"},{"publishTime":"2019-01-20 12:05:32","newsId":"c0a7494b42d1ec3800c3608235f5b589","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7365460155_640330/0","source":"新周刊","category":"要闻","title":"港乐谢幕，谁还在听粤语歌？外人的唱衰，在港乐迷心中是新的开始"},{"publishTime":"2019-01-20 11:49:00","newsId":"ca21a56b73ea301dec382a26c18d2e8b","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363870069_640330/0","source":"观察者网军工频道","category":"要闻","title":"于敏之后，中国核武器怎么走？"},{"publishTime":"2019-01-20 11:48:39","newsId":"8491648c4243d36ab058695cd37fae47","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7365286257_640330/0","source":"侦探娱乐","category":"要闻","title":"周一围被列渣男行列，朱丹霸气维护老公：是对真正渣男的纵容"},{"publishTime":"2019-01-20 11:21:55","newsId":"4d8e7235252948f7707da8db3841c2ea","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7366085366_640330/0","source":"新晚报","category":"要闻","title":"25岁姑娘嫁亿万家产\u201c富二代\u201d不领证：不占你家便宜"},{"publishTime":"2019-01-20 11:05:55","newsId":"c7c4ab28f4425b0820947da2a4180e5b","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364837843_640330/0","source":"环球时报国内","category":"要闻","title":"辽宁海事局再发航行通告，中国航母动向牵动人心"},{"publishTime":"2019-01-20 10:56:00","newsId":"27d3a1a490a7d600e11e4603df88d44e","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364732816_640330/0","source":"海外网","category":"要闻","title":"\u201c特金会\u201d将在二月底举行 越南这两个城市呼声最高"},{"publishTime":"2019-01-20 10:53:12","newsId":"7fefe9200aeab1f390b1864867881e1c","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364852093_640330/0","source":"券商中国","category":"要闻","title":"A股全年蒸发14万亿楼市卖了14万亿，2019买房or买股"},{"publishTime":"2019-01-20 10:44:30","newsId":"f42ddacc0553983ca81513fcb4f41ff8","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364602682_640330/0","source":"较真","category":"要闻","title":"较真 | 中老年人更容易被谣言击中？答案可能跟你想的不一样"},{"publishTime":"2019-01-20 10:31:27","newsId":"cd5f488cd8cb0ad27c2395656fab010a","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364557419_640330/0","source":"南方人物周刊","category":"要闻","title":"中国观众熟悉的电影明星阿米尔·汗，何以成为\u201c印度良心\u201d？"},{"publishTime":"2019-01-20 10:17:49","newsId":"c67bef760a90840d465f478efc284c14","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364376257_640330/0","source":"海外网","category":"要闻","title":"智利中部发生6.9级地震 目前暂无海啸威胁"},{"publishTime":"2019-01-20 10:09:11","newsId":"63c498395329c518d754a7ed01393ca7","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364253499_640330/0","source":"霓虹","category":"要闻","title":"两名中国游客在日本大山里滑雪被困 在雪中挖洞藏身过夜"},{"publishTime":"2019-01-20 10:06:14","newsId":"39754653ff2976bc1b66e30a0dc8bc47","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7359979249_640330/0","source":"环球科学","category":"要闻","title":"150年前第一张元素周期表你见过吗？准确预测了缺失元素的性质"},{"publishTime":"2019-01-20 09:50:08","newsId":"31069f8299ac426282c2a8e304c9c4a8","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364060023_640330/0","source":"早安世界","category":"要闻","title":"早安世界：8万黄背心抵制马克龙作秀 潜水员与全球最大白鲨共舞"},{"publishTime":"2019-01-20 09:46:19","newsId":"88c8d89f1bcba59e0fcf07ef0e5569da","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7364364140_640330/0","source":"新华社新闻","category":"要闻","title":"朝美代表将在瑞典举行工作会谈 涉及特金会等议题"},{"publishTime":"2019-01-20 09:08:59","newsId":"ac7ef2224f74e60f839b3de8f053f928","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363744386_640330/0","source":"博雅小学堂","category":"要闻","title":"伦敦中产妈妈：娃还没生出来，推娃就开始了，何时怀孕很重要"},{"publishTime":"2019-01-20 09:00:00","newsId":"a7a3a2bd9ce45cf29b9059c0cfeabfea","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363646775_640330/0","source":"图片故纸堆","category":"要闻","title":"历史上的今天：奥黛丽·赫本去世"},{"publishTime":"2019-01-20 08:53:42","newsId":"949b8454ff787bad6ddf5bde29e8309b","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363552405_196130/0","source":"","category":"要闻","title":"17岁生母活活虐死1岁女儿 2狗6猫却被\u201c富养\u201d"},{"publishTime":"2019-01-20 08:43:06","newsId":"9b307e6ecff58efa394f3a473d2fc987","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363430521_640330/0","source":"红星新闻","category":"要闻","title":"哈尔滨民警除夕夜出警遭暴力抗法遇害 主犯最高获刑13年"},{"publishTime":"2019-01-20 08:17:21","newsId":"a810351c08d461b46daa51f71440f9e3","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363304101_640330/0","source":"澎湃新闻","category":"要闻","title":"住建部通报：甘陕两县市斥巨资\u201c造门\u201d、照抄南方造景手法"},{"publishTime":"2019-01-20 08:05:05","newsId":"3393bb07c8734205529404f8a2d71ed1","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7363187944_640330/0","source":"中国纪检监察报","category":"要闻","title":"国企高管痴迷期货交易 接连挪用过亿公款被查"},{"publishTime":"2019-01-20 08:03:39","newsId":"2e7e5b80d454ef63369d3b43d4fc33ab","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7358805568_640330/0","source":"漫步宇宙","category":"要闻","title":"\u201c关机重启\u201d确实管用，NASA就这样修复了哈勃主相机"},{"publishTime":"2019-01-20 08:03:02","newsId":"0190366c905a75aa0168a7a709d047dc","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7358262503_640330/0","source":"Vista看天下","category":"要闻","title":"在抗冻这件事上，民间智慧永远让你惊喜"}]
         * page : 1
         * allPage : 2
         */

        private int page;
        private int allPage;
        private List<NewsListBean> newsList;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getAllPage() {
            return allPage;
        }

        public void setAllPage(int allPage) {
            this.allPage = allPage;
        }

        public List<NewsListBean> getNewsList() {
            return newsList;
        }

        public void setNewsList(List<NewsListBean> newsList) {
            this.newsList = newsList;
        }

        public static class NewsListBean {
            /**
             * publishTime : 2019-01-20 17:00:11
             * newsId : 63f947162d97d878c17f5a6f557d9d0d
             * newsImg : https://inews.gtimg.com/newsapp_ls/0/7368681630_640330/0
             * source : 冰点周刊
             * category : 要闻
             * title : 又一个被传销骗惨的家庭：母亲借了五万元，去学华林神奇带电的手
             */

            private String publishTime;
            private String newsId;
            private String newsImg;
            private String source;
            private String category;
            private String title;

            public String getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(String publishTime) {
                this.publishTime = publishTime;
            }

            public String getNewsId() {
                return newsId;
            }

            public void setNewsId(String newsId) {
                this.newsId = newsId;
            }

            public String getNewsImg() {
                return newsImg;
            }

            public void setNewsImg(String newsImg) {
                this.newsImg = newsImg;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }

    public static class VpAdapter extends FragmentPagerAdapter {
        private List<Fragment>fragments = new ArrayList<>();
        private List<String>tab = new ArrayList<>();

        public VpAdapter(FragmentManager fm, List<Fragment> fragments, List<String> tab) {
            super(fm);
            this.fragments = fragments;
            this.tab = tab;
        }

        public VpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tab.get(position);
        }
    }
}
