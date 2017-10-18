package com.example.administrator.personalcenter.bean;

/**
 * Created by Administrator on 2017/10/13.
 */

public class RegistratBean {

    /**
     * code : 200
     * msg : 注册成功
     * data : {"token":"9a11ue/TKm3ZwRRn+hv+aOUAb1yst1cTDlbr8TCJfzvCfcGbOrVd","token_time":1507863057}
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
         * token : 9a11ue/TKm3ZwRRn+hv+aOUAb1yst1cTDlbr8TCJfzvCfcGbOrVd
         * token_time : 1507863057
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
