package ok.mytest.com.tests.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 */
public class Gift {
    /**
     * currentCoin : 850
     * hots : [{"giftId":"1","name":"玫瑰花","summary":"","coin":"10","original_coin":"10","imgURL":"http://101.201.51.91:8077/static/gift/1.png","num":0},{"giftId":"2","name":"么么哒","summary":"","coin":"100","original_coin":"100","imgURL":"http://101.201.51.91:8077/static/gift/2.png","num":0},{"giftId":"3","name":"棒棒糖","summary":"","coin":"100","original_coin":"100","imgURL":"http://101.201.51.91:8077/static/gift/3.png","num":0},{"giftId":"4","name":"巧克力","summary":"","coin":"200","original_coin":"200","imgURL":"http://101.201.51.91:8077/static/gift/4.png","num":0},{"giftId":"5","name":"要抱抱","summary":"","coin":"300","original_coin":"300","imgURL":"http://101.201.51.91:8077/static/gift/5.png","num":0},{"giftId":"6","name":"香水","summary":"","coin":"500","original_coin":"500","imgURL":"http://101.201.51.91:8077/static/gift/6.png","num":0},{"giftId":"7","name":"水晶鞋","summary":"","coin":"1000","original_coin":"1000","imgURL":"http://101.201.51.91:8077/static/gift/7.png","num":0},{"giftId":"8","name":"砖石戒指","summary":"","coin":"2000","original_coin":"2000","imgURL":"http://101.201.51.91:8077/static/gift/8.png","num":0},{"giftId":"9","name":"皇冠","summary":"","coin":"5000","original_coin":"5000","imgURL":"http://101.201.51.91:8077/static/gift/9.png","num":0}]
     * red : [{"giftId":"100","name":"188","summary":"","coin":"188","original_coin":"188","imgURL":"http://101.201.51.91:8077/static/gift/100.png","num":0},{"giftId":"101","name":"588","summary":"","coin":"588","original_coin":"588","imgURL":"http://101.201.51.91:8077/static/gift/101.png","num":0},{"giftId":"102","name":"1888","summary":"","coin":"1888","original_coin":"1888","imgURL":"http://101.201.51.91:8077/static/gift/102.png","num":0},{"giftId":"103","name":"2888","summary":"","coin":"2888","original_coin":"2888","imgURL":"http://101.201.51.91:8077/static/gift/103.png","num":0},{"giftId":"104","name":"5000","summary":"","coin":"5000","original_coin":"5000","imgURL":"http://101.201.51.91:8077/static/gift/104.png","num":0},{"giftId":"105","name":"10000","summary":"","coin":"10000","original_coin":"10000","imgURL":"http://101.201.51.91:8077/static/gift/105.png","num":0},{"giftId":"106","name":"15000","summary":"","coin":"15000","original_coin":"15000","imgURL":"http://101.201.51.91:8077/static/gift/106.png","num":0},{"giftId":"107","name":"20000","summary":"","coin":"20000","original_coin":"20000","imgURL":"http://101.201.51.91:8077/static/gift/107.png","num":0}]
     * summarys : ["开始很美，过程很累，结局很悲，清醒很难。","所有深爱，都是秘密。你我之间的秘密。","百毒不侵的人 都曾无药可救过","我会和你吵架 但我不会轻易离开你","不要和我礼尚往来哦，我很朴素的~","收着，望你再接再厉！","不用太客气，虽然我很期待你的回礼。","希望我能将快乐,作为礼物送给你！","多说也无意，逛街购物随时待命！","听说，美丽会与你相伴到天涯。","没有你，世界会崩塌半边；有了你，世界会乐翻天","偌大的地球上能和你相遇，真的不容易"]
     */
        private int currentCoin;
        /**
         * giftId : 1
         * name : 玫瑰花
         * summary :
         * coin : 10
         * original_coin : 10
         * imgURL : http://101.201.51.91:8077/static/gift/1.png
         * num : 0
         */

        private List<HotsBean> hots;
        /**
         * giftId : 100
         * name : 188
         * summary :
         * coin : 188
         * original_coin : 188
         * imgURL : http://101.201.51.91:8077/static/gift/100.png
         * num : 0
         */

        private List<RedBean> red;
        private List<String> summarys;

        public int getCurrentCoin() {
            return currentCoin;
        }

        public void setCurrentCoin(int currentCoin) {
            this.currentCoin = currentCoin;
        }

        public List<HotsBean> getHots() {
            return hots;
        }

        public void setHots(List<HotsBean> hots) {
            this.hots = hots;
        }

        public List<RedBean> getRed() {
            return red;
        }

        public void setRed(List<RedBean> red) {
            this.red = red;
        }

        public List<String> getSummarys() {
            return summarys;
        }

        public void setSummarys(List<String> summarys) {
            this.summarys = summarys;
        }

        public static class HotsBean {
            private String giftId;
            private String name;
            private String summary;
            private String coin;
            private String original_coin;
            private String imgURL;
            private int num;

            public String getGiftId() {
                return giftId;
            }

            public void setGiftId(String giftId) {
                this.giftId = giftId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getCoin() {
                return coin;
            }

            public void setCoin(String coin) {
                this.coin = coin;
            }

            public String getOriginal_coin() {
                return original_coin;
            }

            public void setOriginal_coin(String original_coin) {
                this.original_coin = original_coin;
            }

            public String getImgURL() {
                return imgURL;
            }

            public void setImgURL(String imgURL) {
                this.imgURL = imgURL;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }

        public static class RedBean {
            private String giftId;
            private String name;
            private String summary;
            private String coin;
            private String original_coin;
            private String imgURL;
            private int num;

            public String getGiftId() {
                return giftId;
            }

            public void setGiftId(String giftId) {
                this.giftId = giftId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getCoin() {
                return coin;
            }

            public void setCoin(String coin) {
                this.coin = coin;
            }

            public String getOriginal_coin() {
                return original_coin;
            }

            public void setOriginal_coin(String original_coin) {
                this.original_coin = original_coin;
            }

            public String getImgURL() {
                return imgURL;
            }

            public void setImgURL(String imgURL) {
                this.imgURL = imgURL;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }
}
