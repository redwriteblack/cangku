package com.example.administrator.comprehensiveexercises.jsonbean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */

public class MainBean {

    /**
     * code : 200
     * msg : 请求成功
     * data : [{"id":"13","name":"食品","parent_id":"0","type_id":"4","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"./uploadfile/goods/f1/21/d1/35/59b64a477f84e.jpg","url":"","level":0},{"id":"12","name":"保健品","parent_id":"0","type_id":"3","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"./uploadfile/goods/fb/5c/81/ed/59b64a3de66c1.png","url":"","level":0},{"id":"2","name":"医疗器械","parent_id":"0","type_id":"2","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"./uploadfile/goods/1b/2f/06/45/597c4f7272f23.jpg","url":"","level":0},{"id":"1","name":"药品","parent_id":"0","type_id":"1","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"./uploadfile/goods/4a/47/a0/db/59b64a2bdd85d.png","url":"","level":0}]
     */

    private int code;
    private String msg;

    private List<DataBean> data;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 13
         * name : 食品
         * parent_id : 0
         * type_id : 4
         * keywords :
         * descript :
         * show_in_nav : 0
         * grade :
         * status : 1
         * sort : 100
         * img : ./uploadfile/goods/f1/21/d1/35/59b64a477f84e.jpg
         * url :
         * level : 0
         */

        private String id;
        private String name;
        private String parent_id;
        private String type_id;
        private String keywords;
        private String descript;
        private String show_in_nav;
        private String grade;
        private String status;
        private String sort;
        private String img;
        private String url;
        private int level;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getType_id() {
            return type_id;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getDescript() {
            return descript;
        }

        public void setDescript(String descript) {
            this.descript = descript;
        }

        public String getShow_in_nav() {
            return show_in_nav;
        }

        public void setShow_in_nav(String show_in_nav) {
            this.show_in_nav = show_in_nav;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
}
