package com.example.kshclf1.myapplication.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kshclf1 on 2017/5/8.
 */

public class OneType implements Serializable {


    /**
     * code : 200
     * datas : {"class_list":[{"gc_id":"2466","gc_name":"饼干糕点","type_id":"2","type_name":"饼干类","gc_parent_id":"0","commis_rate":"0","gc_sort":"1","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"","text":"饼干/传统糕点/西式糕点"},{"gc_id":"2490","gc_name":"酒水饮料","type_id":"5","type_name":"酒水容量","gc_parent_id":"0","commis_rate":"0","gc_sort":"2","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"","text":"水、饮料/中外名酒"},{"gc_id":"2505","gc_name":"茶冲乳品","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"0","gc_sort":"3","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"","text":"蜂蜜/牛奶乳品/咖啡/茗茶"},{"gc_id":"2528","gc_name":"粮油干货","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"0","gc_sort":"4","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"","text":"食用油/米面杂粮/干货"},{"gc_id":"2562","gc_name":"厨房调料","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"0","gc_sort":"5","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"","text":"调味料/调味酱汁/调味油/其他调料"},{"gc_id":"2593","gc_name":"方便速食","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"0","gc_sort":"6","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"","text":"速食品/罐头"},{"gc_id":"2614","gc_name":"休闲零食","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"0","gc_sort":"7","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"","text":"肉干肉脯/膨化食品/海味即食/奶酪/乳制品/坚果/蜜饯/雪糕/糖果/巧克力"},{"gc_id":"2696","gc_name":"清洁用品","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"0","gc_sort":"8","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"","text":"衣物清洁/纸品湿巾/家庭清洁/一次性用品/清洁/卫浴/个护化妆"},{"gc_id":"2766","gc_name":"生鲜食品","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"0","gc_sort":"9","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"","text":"水果、蔬菜/低温乳品/速冻食品/海鲜/水产品/肉/禽/蛋"},{"gc_id":"2795","gc_name":"进口食品","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"0","gc_sort":"10","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"","text":"牛奶乳品/糕点、饼干/糖果/巧克力/休闲零食/蜜饯/坚果/水/饮料/咖啡/茶/冲饮谷物/厨房调料/酒/方便速食/食用油品/大米/面食"}]}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private List<ClassListBean> class_list;

        public List<ClassListBean> getClass_list() {
            return class_list;
        }

        public void setClass_list(List<ClassListBean> class_list) {
            this.class_list = class_list;
        }

        public static class ClassListBean {
            /**
             * gc_id : 2466
             * gc_name : 饼干糕点
             * type_id : 2
             * type_name : 饼干类
             * gc_parent_id : 0
             * commis_rate : 0
             * gc_sort : 1
             * gc_virtual : 0
             * gc_title :
             * gc_keywords :
             * gc_description :
             * show_type : 1
             * image :
             * text : 饼干/传统糕点/西式糕点
             */

            private String gc_id;
            private String gc_name;
            private String type_id;
            private String type_name;
            private String gc_parent_id;
            private String commis_rate;
            private String gc_sort;
            private String gc_virtual;
            private String gc_title;
            private String gc_keywords;
            private String gc_description;
            private String show_type;
            private String image;
            private String text;

            public String getGc_id() {
                return gc_id;
            }

            public void setGc_id(String gc_id) {
                this.gc_id = gc_id;
            }

            public String getGc_name() {
                return gc_name;
            }

            public void setGc_name(String gc_name) {
                this.gc_name = gc_name;
            }

            public String getType_id() {
                return type_id;
            }

            public void setType_id(String type_id) {
                this.type_id = type_id;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }

            public String getGc_parent_id() {
                return gc_parent_id;
            }

            public void setGc_parent_id(String gc_parent_id) {
                this.gc_parent_id = gc_parent_id;
            }

            public String getCommis_rate() {
                return commis_rate;
            }

            public void setCommis_rate(String commis_rate) {
                this.commis_rate = commis_rate;
            }

            public String getGc_sort() {
                return gc_sort;
            }

            public void setGc_sort(String gc_sort) {
                this.gc_sort = gc_sort;
            }

            public String getGc_virtual() {
                return gc_virtual;
            }

            public void setGc_virtual(String gc_virtual) {
                this.gc_virtual = gc_virtual;
            }

            public String getGc_title() {
                return gc_title;
            }

            public void setGc_title(String gc_title) {
                this.gc_title = gc_title;
            }

            public String getGc_keywords() {
                return gc_keywords;
            }

            public void setGc_keywords(String gc_keywords) {
                this.gc_keywords = gc_keywords;
            }

            public String getGc_description() {
                return gc_description;
            }

            public void setGc_description(String gc_description) {
                this.gc_description = gc_description;
            }

            public String getShow_type() {
                return show_type;
            }

            public void setShow_type(String show_type) {
                this.show_type = show_type;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }


}
