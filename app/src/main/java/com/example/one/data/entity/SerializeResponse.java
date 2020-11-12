package com.example.one.data.entity;

import java.util.List;

public class SerializeResponse {

    /**
     * res : 0
     * data : [{"id":1295,"title":"阳光灿烂·第四章：低等动物","subtitle":"文／蒋文龙","category":2,"cover":"http://image.wufazhuce.com/Fo5W3JQedEU0slgt4dejwYKk8Mca?imageView2/1/w/678/h/400","maketime":"2020-09-18 06:00:00","serial_id":88,"forward":"我是个无神论者，可我又相信\u201c爱很多人是要遭报应的\u201d这句话。","finished":false},{"id":1280,"title":"我的么啊·第十一章：一九四六","subtitle":"文／陈麒凌","category":2,"cover":"http://image.wufazhuce.com/FlmJlzt0tbiH6AxseQ2-vw7F-_BP?imageView2/1/w/678/h/400","maketime":"2020-09-17 06:00:00","serial_id":87,"forward":"好妈妈的标准像不像个跳高杆，一个女人必须付出无限的时间、精力还有情感，去冲那个杆。","finished":false},{"id":1259,"title":"打雪仗·终章：心之雪仗","subtitle":"文／肖睿","category":2,"cover":"http://image.wufazhuce.com/Fh572-uYwniR38kVDU95J_aVVjeI?imageView2/1/w/678/h/400","maketime":"2020-08-22 06:00:00","serial_id":85,"forward":"你是一个好人，希望你能积极认罪，让法庭能够轻判你。你为她做的那些事情她背不起。","finished":true},{"id":1269,"title":"维多利亚的派对·终章：火烧之云","subtitle":"文／吴沚默","category":2,"cover":"http://image.wufazhuce.com/FuyBndFcKQngI51GHJqMeBXTG9ha?imageView2/1/w/678/h/400","maketime":"2020-08-19 06:00:00","serial_id":86,"forward":"她突然发现他们的爱，只是动物之间，互相疗伤的短暂时刻。一旦身体康复，便会抢夺剩下的食物。","finished":true},{"id":1216,"title":"最后的审判（二）第二十七章：一败涂地","subtitle":"文／红拂夜奔不复还","category":2,"cover":"http://image.wufazhuce.com/FkeHGBcpv9hko1W6PBRwcG0l7T0S?imageView2/1/w/678/h/400","maketime":"2020-06-17 06:00:00","serial_id":83,"forward":"世界在下坠，落日高不可问。","finished":true},{"id":1209,"title":"分手遗迹清理员：不会占卜的吉普赛女孩·第八章","subtitle":"文／城迟","category":2,"cover":"http://image.wufazhuce.com/Fnrl1ynQCBfVTg7LjQW8FtIBWZvR?imageView2/1/w/678/h/400","maketime":"2020-06-13 06:00:00","serial_id":84,"forward":"冬季让离别显得冷清，人们能够不动声色地再也不见。而在夏日，情绪被温度加持，连悲伤都变得更为炙热。","finished":true},{"id":1160,"title":"即将来临·下一个世界：第十四章","subtitle":"文／李永明","category":2,"cover":"http://image.wufazhuce.com/FlyVdCTk9hvK1SKMfFeZh1X332gN?imageView2/1/w/678/h/400","maketime":"2020-04-23 06:00:00","serial_id":82,"forward":"通灵塔是与要塞以某种能量相连的，也就是说就像我看到他们一样，能看到我，所以我们离真正意义上的毁灭不远了\u2026\u2026","finished":true},{"id":1158,"title":"恶女阿尤·第十四章：尘埃落定","subtitle":"文／咸良","category":2,"cover":"http://image.wufazhuce.com/FuWm2aUojqqcxK6Eb_y5JNUmFVp-?imageView2/1/w/678/h/400","maketime":"2020-04-15 06:00:00","serial_id":81,"forward":"她双臂张开，举过头顶，高昂着头颅，像一个骄傲的体操运动员，完成了人生中最后一次表演后，完美地谢场。","finished":true},{"id":1134,"title":"世界得了健忘症·第二十二章：健忘","subtitle":"文／昔央","category":2,"cover":"http://image.wufazhuce.com/Fs98qrclDTpcZTkOpn86y1A96UZj?imageView2/1/w/678/h/400","maketime":"2020-03-19 06:00:00","serial_id":80,"forward":"一个女孩子活在这个世界上，做到何种程度才算是保护好了自己？","finished":true},{"id":1129,"title":"两次破碎·第二十二章：终场烟花","subtitle":"文／连筑","category":2,"cover":"http://image.wufazhuce.com/FiZ1IkEUa7RZvd_2jWBcilq702Th?imageView2/1/w/678/h/400","maketime":"2020-03-13 06:00:00","serial_id":79,"forward":"火球不停往天上窜，又散成无数个光点，转瞬即逝。没有声音，也看不出颜色。","finished":true},{"id":1087,"title":"魔都春梦·第十九章：尾声","subtitle":"文／老王子","category":2,"cover":"http://image.wufazhuce.com/FmgYjqjGVrrnhOI2Fi2dLJ6Pf77w?imageView2/1/w/678/h/400","maketime":"2020-01-28 06:00:00","serial_id":78,"forward":"想着一片苍茫的明天，其实那是我们最好，最开心，最有力量的时候。","finished":true},{"id":1082,"title":"铃兰·第二十四章·一束盛开的铃兰","subtitle":"文／夏阳","category":2,"cover":"http://image.wufazhuce.com/FhUzMx5BP5ekE8TrnAPQ-NpRQ1Pf?imageView2/1/w/678/h/400","maketime":"2020-01-22 06:00:00","serial_id":77,"forward":"这世界如此空旷，一切都在凋谢归零，除了他手中的铃兰花。","finished":true}]
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
         * id : 1295
         * title : 阳光灿烂·第四章：低等动物
         * subtitle : 文／蒋文龙
         * category : 2
         * cover : http://image.wufazhuce.com/Fo5W3JQedEU0slgt4dejwYKk8Mca?imageView2/1/w/678/h/400
         * maketime : 2020-09-18 06:00:00
         * serial_id : 88
         * forward : 我是个无神论者，可我又相信“爱很多人是要遭报应的”这句话。
         * finished : false
         */

        private String id;
        private String title;
        private String subtitle;
        private int category;
        private String cover;
        private String maketime;
        private String serial_id;
        private String forward;
        private boolean finished;

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

        public String getSerial_id() {
            return serial_id;
        }

        public void setSerial_id(String serial_id) {
            this.serial_id = serial_id;
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public boolean isFinished() {
            return finished;
        }

        public void setFinished(boolean finished) {
            this.finished = finished;
        }
    }
}
