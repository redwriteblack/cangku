package com.example.administrator.personalcenter.bean;

/**
 * Created by Administrator on 2017/10/12.
 */

public class Loginbean {

    /**
     * code : 200
     * msg : 登陆成功
     * data : {"token":"e6187jh5IqvC9WEBFub3LUe84Sk1k6mqtMYUNt2F0MEhV4+LoVpQ","token_time":1507797023}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * token : e6187jh5IqvC9WEBFub3LUe84Sk1k6mqtMYUNt2F0MEhV4+LoVpQ
         * token_time : 1507797023
         */

        private String token;
        private int token_time;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getToken_time() {
            return token_time;
        }

        public void setToken_time(int token_time) {
            this.token_time = token_time;
        }
    }
}
