package com.example.one.data.entity;

import java.util.List;

public class QuestionResponse {

    /**
     * res : 0
     * data : [{"id":2977,"title":"如何度过人生路口的迷茫期？","subtitle":"谁不是第一次做人呢？","category":3,"cover":"http://image.wufazhuce.com/FvgzCYGf8U4wzqS3p95BWLDCmGeH?imageView2/1/w/120/h/120","maketime":"2020-09-17 06:00:00"},{"id":2976,"title":"如何面对不同圈子相处的尴尬？","subtitle":"不是你不合群，而是群，不合你。","category":3,"cover":"http://image.wufazhuce.com/FsDmmTzKNGh6rc5WsI0iCdrUzU6g?imageView2/1/w/120/h/120","maketime":"2020-09-16 06:00:00"},{"id":2974,"title":"气场是如何培养的？","subtitle":"自信的人，一般气场都不会太弱。","category":3,"cover":"http://image.wufazhuce.com/FiwXcBGvOqApJy1bmHLis3byP102?imageView2/1/w/120/h/120","maketime":"2020-09-15 06:00:00"},{"id":2975,"title":"有哪些是因为年轻才会犯的错误?","subtitle":"青春用来犯错，成熟用来改错。","category":3,"cover":"http://image.wufazhuce.com/FmvPu0s2GUt9KoKVL7gPuKyTmQ-B?imageView2/1/w/120/h/120","maketime":"2020-09-14 06:00:00"},{"id":2973,"title":"哪一刻，你感觉自己在遭受生活的毒打？","subtitle":"没有钱的每一刻（泪目）。","category":3,"cover":"http://image.wufazhuce.com/FhY3h7tygZbHSi3YNb50owblmJTO?imageView2/1/w/120/h/120","maketime":"2020-09-13 06:00:00"},{"id":2967,"title":"为什么有的人不敢靠近自己喜欢的人？","subtitle":"我很丑，可是我很温柔。","category":3,"cover":"http://image.wufazhuce.com/FuI1wepxhdIbVMk76r2RsU-RJtWq?imageView2/1/w/120/h/120","maketime":"2020-09-12 06:00:00"},{"id":2971,"title":"什么事情最值得坚持？","subtitle":"先喜欢一件事，再坚持一件事。","category":3,"cover":"http://image.wufazhuce.com/Fh4FiQHNjg7ARYUcYpgVVkQS2Gxt?imageView2/1/w/120/h/120","maketime":"2020-09-11 06:00:00"},{"id":2972,"title":"如何提高自己对异性的吸引力？","subtitle":"爱情这道玄学题，光写\u201c解\u201d字可不够。","category":3,"cover":"http://image.wufazhuce.com/Fjw-ZiKkCzQXXkiBtT33M-Qd2uUv?imageView2/1/w/120/h/120","maketime":"2020-09-10 06:00:00"},{"id":2970,"title":"如何避免情绪化的行为？","subtitle":"人人都懂大道理，却难以控制小情绪。","category":3,"cover":"http://image.wufazhuce.com/Fj31kad8vIWfvmeCJAla3Idtkp3K?imageView2/1/w/120/h/120","maketime":"2020-09-09 06:00:00"},{"id":2969,"title":"运气能后天取得吗？","subtitle":"运气，是可以把控的玄学。","category":3,"cover":"http://image.wufazhuce.com/Fqkwbi4NkuffWiySipHWA7iRpbvg?imageView2/1/w/120/h/120","maketime":"2020-09-08 06:00:00"},{"id":2964,"title":"男生认真喜欢上女生会是什么样子？","subtitle":"喜欢一个人，有些行为是藏不住的。","category":3,"cover":"http://image.wufazhuce.com/FtlXGXrvAzVtgl59u2MMOVPeTa6w?imageView2/1/w/120/h/120","maketime":"2020-09-07 06:00:00"},{"id":2968,"title":"如何看待朋友间的暧昧？","subtitle":"我的思念化雨，你却撑起了伞。","category":3,"cover":"http://image.wufazhuce.com/FuCNRIhHcDZz6dlfAHk_Y0qNHEOf?imageView2/1/w/120/h/120","maketime":"2020-09-06 06:00:00"},{"id":2966,"title":"有哪些好的情绪宣泄方式？","subtitle":"生活一地鸡毛，不如把它点着。","category":3,"cover":"http://image.wufazhuce.com/FrzX39V4yWCM1Z1Onhg68hIHVuLF?imageView2/1/w/120/h/120","maketime":"2020-09-05 06:00:00"},{"id":2965,"title":"有哪些穷游的技巧？","subtitle":"花最少的钱，见最大的世界。","category":3,"cover":"http://image.wufazhuce.com/FpuYaTtqcZg9UGmbsiA04gU4a4gH?imageView2/1/w/120/h/120","maketime":"2020-09-04 06:00:00"},{"id":2963,"title":"你都立过什么样的flag？","subtitle":"我们都有一个小目标。","category":3,"cover":"http://image.wufazhuce.com/Fsl5GgqFk0aoE829wgqWDo8RVXJ_?imageView2/1/w/120/h/120","maketime":"2020-09-03 06:00:00"},{"id":2962,"title":"面对生活的打击，如何保持冷静理智？","subtitle":"生活是暴击的循环？","category":3,"cover":"http://image.wufazhuce.com/FsCm8NKoXr_ePCwvLyPcCS2NWz2C?imageView2/1/w/120/h/120","maketime":"2020-09-02 06:00:00"},{"id":2961,"title":"如何学会发现事物的隐藏价值？","subtitle":"在人间谋生，没有绝对的事。","category":3,"cover":"http://image.wufazhuce.com/FpjdUuZZBp43VjWBaVUnQnhKaqj0?imageView2/1/w/120/h/120","maketime":"2020-09-01 06:00:00"}]
     */

    private int res;
    private List<DataBean> data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2977
         * title : 如何度过人生路口的迷茫期？
         * subtitle : 谁不是第一次做人呢？
         * category : 3
         * cover : http://image.wufazhuce.com/FvgzCYGf8U4wzqS3p95BWLDCmGeH?imageView2/1/w/120/h/120
         * maketime : 2020-09-17 06:00:00
         */

        private String id;
        private String title;
        private String subtitle;
        private int category;
        private String cover;
        private String maketime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getMaketime() {
            return maketime;
        }

        public void setMaketime(String maketime) {
            this.maketime = maketime;
        }
    }
}
