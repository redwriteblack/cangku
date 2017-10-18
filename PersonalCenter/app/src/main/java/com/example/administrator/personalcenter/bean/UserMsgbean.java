package com.example.administrator.personalcenter.bean;

/**
 * Created by Administrator on 2017/10/12.
 */

public class UserMsgbean {

    /**
     * code : 200
     * msg : 操作成功
     * data : {"id":"110","username":"18438627201","password":"4e7665e914e591fdde9e96015ed65049","group_id":"1","encrypt":"Az6UtK","email":"","integral":"0","money":"0.00","mobile":"18438627201","register_time":"1507790290","register_ip":"42.236.205.208","login_time":"1507791615","login_ip":"42.236.205.208","login_num":"5","islock":"0","frozen_money":"0.00","exp":"0","emailstatus":"0","mobilestatus":"0","token":"1ba73UpjTxcAJohTQ605Y2g0oTaqoweMCYfsja4OYmB82QYXap","token_time":"1508396415","_address":null,"_group":{"id":"1","name":"注册会员","min_points":"0","max_points":"199","discount":"100","status":"0","sort":"100","description":""},"avatar":"./template/default/statics/images/member/default_head.png","counts":{"all":"0","cancel":"0","recycle":"0","deletes":"0","pay":"0","confirm":"0","delivery":"0","receipt":null,"finish":"0","load_comment":"0","going":"0","load_return":"0","load_refund":"0"}}
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
         * id : 110
         * username : 18438627201
         * password : 4e7665e914e591fdde9e96015ed65049
         * group_id : 1
         * encrypt : Az6UtK
         * email :
         * integral : 0
         * money : 0.00
         * mobile : 18438627201
         * register_time : 1507790290
         * register_ip : 42.236.205.208
         * login_time : 1507791615
         * login_ip : 42.236.205.208
         * login_num : 5
         * islock : 0
         * frozen_money : 0.00
         * exp : 0
         * emailstatus : 0
         * mobilestatus : 0
         * token : 1ba73UpjTxcAJohTQ605Y2g0oTaqoweMCYfsja4OYmB82QYXap
         * token_time : 1508396415
         * _address : null
         * _group : {"id":"1","name":"注册会员","min_points":"0","max_points":"199","discount":"100","status":"0","sort":"100","description":""}
         * avatar : ./template/default/statics/images/member/default_head.png
         * counts : {"all":"0","cancel":"0","recycle":"0","deletes":"0","pay":"0","confirm":"0","delivery":"0","receipt":null,"finish":"0","load_comment":"0","going":"0","load_return":"0","load_refund":"0"}
         */

        private String id;
        private String username;
        private String password;
        private String group_id;
        private String encrypt;
        private String email;
        private String integral;
        private String money;
        private String mobile;
        private String register_time;
        private String register_ip;
        private String login_time;
        private String login_ip;
        private String login_num;
        private String islock;
        private String frozen_money;
        private String exp;
        private String emailstatus;
        private String mobilestatus;
        private String token;
        private String token_time;
        private Object _address;
        private GroupBean _group;
        private String avatar;
        private CountsBean counts;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }

        public String getEncrypt() {
            return encrypt;
        }

        public void setEncrypt(String encrypt) {
            this.encrypt = encrypt;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRegister_time() {
            return register_time;
        }

        public void setRegister_time(String register_time) {
            this.register_time = register_time;
        }

        public String getRegister_ip() {
            return register_ip;
        }

        public void setRegister_ip(String register_ip) {
            this.register_ip = register_ip;
        }

        public String getLogin_time() {
            return login_time;
        }

        public void setLogin_time(String login_time) {
            this.login_time = login_time;
        }

        public String getLogin_ip() {
            return login_ip;
        }

        public void setLogin_ip(String login_ip) {
            this.login_ip = login_ip;
        }

        public String getLogin_num() {
            return login_num;
        }

        public void setLogin_num(String login_num) {
            this.login_num = login_num;
        }

        public String getIslock() {
            return islock;
        }

        public void setIslock(String islock) {
            this.islock = islock;
        }

        public String getFrozen_money() {
            return frozen_money;
        }

        public void setFrozen_money(String frozen_money) {
            this.frozen_money = frozen_money;
        }

        public String getExp() {
            return exp;
        }

        public void setExp(String exp) {
            this.exp = exp;
        }

        public String getEmailstatus() {
            return emailstatus;
        }

        public void setEmailstatus(String emailstatus) {
            this.emailstatus = emailstatus;
        }

        public String getMobilestatus() {
            return mobilestatus;
        }

        public void setMobilestatus(String mobilestatus) {
            this.mobilestatus = mobilestatus;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getToken_time() {
            return token_time;
        }

        public void setToken_time(String token_time) {
            this.token_time = token_time;
        }

        public Object get_address() {
            return _address;
        }

        public void set_address(Object _address) {
            this._address = _address;
        }

        public GroupBean get_group() {
            return _group;
        }

        public void set_group(GroupBean _group) {
            this._group = _group;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public CountsBean getCounts() {
            return counts;
        }

        public void setCounts(CountsBean counts) {
            this.counts = counts;
        }

        public static class GroupBean {
            /**
             * id : 1
             * name : 注册会员
             * min_points : 0
             * max_points : 199
             * discount : 100
             * status : 0
             * sort : 100
             * description :
             */

            private String id;
            private String name;
            private String min_points;
            private String max_points;
            private String discount;
            private String status;
            private String sort;
            private String description;

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

            public String getMin_points() {
                return min_points;
            }

            public void setMin_points(String min_points) {
                this.min_points = min_points;
            }

            public String getMax_points() {
                return max_points;
            }

            public void setMax_points(String max_points) {
                this.max_points = max_points;
            }

            public String getDiscount() {
                return discount;
            }

            public void setDiscount(String discount) {
                this.discount = discount;
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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }

        public static class CountsBean {
            /**
             * all : 0
             * cancel : 0
             * recycle : 0
             * deletes : 0
             * pay : 0
             * confirm : 0
             * delivery : 0
             * receipt : null
             * finish : 0
             * load_comment : 0
             * going : 0
             * load_return : 0
             * load_refund : 0
             */

            private String all;
            private String cancel;
            private String recycle;
            private String deletes;
            private String pay;
            private String confirm;
            private String delivery;
            private Object receipt;
            private String finish;
            private String load_comment;
            private String going;
            private String load_return;
            private String load_refund;

            public String getAll() {
                return all;
            }

            public void setAll(String all) {
                this.all = all;
            }

            public String getCancel() {
                return cancel;
            }

            public void setCancel(String cancel) {
                this.cancel = cancel;
            }

            public String getRecycle() {
                return recycle;
            }

            public void setRecycle(String recycle) {
                this.recycle = recycle;
            }

            public String getDeletes() {
                return deletes;
            }

            public void setDeletes(String deletes) {
                this.deletes = deletes;
            }

            public String getPay() {
                return pay;
            }

            public void setPay(String pay) {
                this.pay = pay;
            }

            public String getConfirm() {
                return confirm;
            }

            public void setConfirm(String confirm) {
                this.confirm = confirm;
            }

            public String getDelivery() {
                return delivery;
            }

            public void setDelivery(String delivery) {
                this.delivery = delivery;
            }

            public Object getReceipt() {
                return receipt;
            }

            public void setReceipt(Object receipt) {
                this.receipt = receipt;
            }

            public String getFinish() {
                return finish;
            }

            public void setFinish(String finish) {
                this.finish = finish;
            }

            public String getLoad_comment() {
                return load_comment;
            }

            public void setLoad_comment(String load_comment) {
                this.load_comment = load_comment;
            }

            public String getGoing() {
                return going;
            }

            public void setGoing(String going) {
                this.going = going;
            }

            public String getLoad_return() {
                return load_return;
            }

            public void setLoad_return(String load_return) {
                this.load_return = load_return;
            }

            public String getLoad_refund() {
                return load_refund;
            }

            public void setLoad_refund(String load_refund) {
                this.load_refund = load_refund;
            }
        }
    }
}
