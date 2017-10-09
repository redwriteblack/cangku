package com.example.administrator.comprehensiveexercises.jsonbean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */

public class DrugListBean {


    /**
     * code : 200
     * msg : 请求成功
     * data : [{"id":"11","name":"其他","parent_id":"1","type_id":"1","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"","url":"","level":1},{"id":"10","name":"营养健康类药","parent_id":"1","type_id":"1","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"","url":"","level":1},{"id":"9","name":"神经科用药","parent_id":"1","type_id":"1","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"","url":"","level":1},{"id":"8","name":"五官皮肤科药","parent_id":"1","type_id":"1","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"","url":"","level":1},{"id":"7","name":"男科女科类药","parent_id":"1","type_id":"1","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"","url":"","level":1},{"id":"6","name":"风湿骨科类药","parent_id":"1","type_id":"1","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"","url":"","level":1},{"id":"5","name":"肠胃肝胆类药","parent_id":"1","type_id":"1","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"","url":"","level":1},{"id":"4","name":"感冒清热类用药","parent_id":"1","type_id":"1","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"","url":"","level":1},{"id":"3","name":"慢性病类用药","parent_id":"1","type_id":"1","keywords":"","descript":"","show_in_nav":"0","grade":"","status":"1","sort":"100","img":"","url":"","level":1}]
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
         * id : 11
         * name : 其他
         * parent_id : 1
         * type_id : 1
         * keywords :
         * descript :
         * show_in_nav : 0
         * grade :
         * status : 1
         * sort : 100
         * img :
         * url :
         * level : 1
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
