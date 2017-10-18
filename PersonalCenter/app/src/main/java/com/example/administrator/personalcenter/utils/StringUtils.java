package com.example.administrator.personalcenter.utils;

/**
 * Created by Administrator on 2017/10/12.
 */

public class StringUtils {
        /*获取会员信息
        1、请求方式：GET
        2、请求地址：http://app.chnddk.com/index.php?m=member&c=app&a=userinfo*/
    public static String INDS ="http://app.chnddk.com";
    public static String MSG = INDS+"/index.php?m=member&c=app&a=userinfo";
    /*       登陆提交
             1、请求方式：POST
             2、请求地址：http://app.chnddk.com/index.php?m=member&c=public&a=app_login*/
    public static String LOGINMSG = INDS+"/index.php?m=member&c=public&a=app_login";
    /*  2、注册提交字段验证
      1、请求方式：POST
      2、请求地址：http://app.chnddk.com/index.php?m=member&c=public&a=app_register_check*/
    public static String REGISTRAT_YANZHENG = "http://app.chnddk.com/index.php?m=member&c=public&a=app_register_check";
   /* 1、注册提交
    1、请求方式：POST
    2、请求地址：http://app.chnddk.com/index.php?m=member&c=public&a=app_register*/
   public static String REGISTRAT ="http://app.chnddk.com/index.php?m=member&c=public&a=app_register";


}
