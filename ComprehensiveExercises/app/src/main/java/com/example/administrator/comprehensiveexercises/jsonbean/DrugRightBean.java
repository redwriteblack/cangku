package com.example.administrator.comprehensiveexercises.jsonbean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */

public class DrugRightBean {

    /**
     * code : 200
     * msg : 请求成功
     * data : {"count":"3","lists":[{"id":"3","name":"白云山 小柴胡颗粒 ","subtitle":"","style":"","catid":"4","brand_id":"0","keyword":"","description":"","content":null,"imgs":"","min_price":"0.00","max_price":"0.00","status":"1","specs":{"1":{"id":"1","name":"规格","value":["10g*10包*5件"],"style":"0","img":[""],"color":""}},"sku_total":"0","give_point":"-1","warn_number":"5","sort":"100","spec_id":"0","type_id":"1","weight":"0.00","volume":"0.00","delivery_template_id":"0","sku_id":"3","spu_id":"3","sku_name":"白云山 小柴胡颗粒 10g*10包*5件 ","sn":"NU150132030877-1","barcode":"","spec":[{"id":"1","name":"规格","value":"10g*10包*5件","style":"0","color":"","img":""}],"thumb":"./uploadfile/goods/95/fc/9e/37/597c54a1546db.jpg","status_ext":"0","number":"0","market_price":"0.00","shop_price":"0.00","show_in_lists":"1","prom_type":"","prom_id":"0","up_time":"0","update_time":"0","edition":"1","url":"/index.php?m=goods&c=index&a=detail&sku_id=3","img_list":["./uploadfile/goods/95/fc/9e/37/597c54a1546db.jpg"],"prom_price":"0.00","brand":null,"sales":0,"hits":"6","favorites":"0"},{"id":"1","name":"江中 健胃消食片 ","subtitle":"用于脾胃虚弱、消化不良、厌食症、胃胀腹胀【口服，可以咀嚼。成人一次3片，一日3次，小儿酌减】","style":"#ff0000","catid":"5","brand_id":"0","keyword":"","description":"","content":null,"imgs":"","min_price":"0.00","max_price":"0.00","status":"1","specs":{"1":{"id":"1","name":"规格","value":["0.8g*8片*4板"],"style":"0","img":[""],"color":""}},"sku_total":"0","give_point":"-1","warn_number":"5","sort":"100","spec_id":"0","type_id":"1","weight":"0.00","volume":"0.00","delivery_template_id":"0","sku_id":"2","spu_id":"1","sku_name":"江中 健胃消食片 0.8g*8片*4板 ","sn":"NU150131955491-1","barcode":"","spec":[{"id":"1","name":"规格","value":"0.8g*8片*4板","style":"0","color":"","img":""}],"thumb":"./uploadfile/goods/55/ef/4e/c3/597c51a462d53.jpg","status_ext":"0","number":"0","market_price":"0.00","shop_price":"0.00","show_in_lists":"1","prom_type":"","prom_id":"0","up_time":"0","update_time":"0","edition":"1","url":"/index.php?m=goods&c=index&a=detail&sku_id=2","img_list":["./uploadfile/goods/55/ef/4e/c3/597c51a462d53.jpg","./uploadfile/goods/aa/61/6f/8f/597c51a46e103.jpg","./uploadfile/goods/0a/1b/4d/49/597c51a4765d3.jpg"],"prom_price":"0.00","brand":null,"sales":0,"hits":"3","favorites":"0"},{"id":"2","name":"葵花 护肝片","subtitle":"","style":"","catid":"5","brand_id":"0","keyword":"","description":"","content":null,"imgs":"","min_price":"0.00","max_price":"0.00","status":"1","specs":[],"sku_total":"0","give_point":"-1","warn_number":"5","sort":"100","spec_id":"0","type_id":"1","weight":"0.00","volume":"0.00","delivery_template_id":"0","sku_id":"1","spu_id":"2","sku_name":"葵花 护肝片 0.35g*100片*8件 ","sn":"NU150131967711-1","barcode":"","spec":[{"id":"1","name":"规格","value":"0.35g*100片*8件","style":"0","color":"","img":""}],"thumb":"./uploadfile/goods/1b/2f/06/45/597c5212a963b.jpg","status_ext":"0","number":"0","market_price":"0.00","shop_price":"0.00","show_in_lists":"1","prom_type":"","prom_id":"0","up_time":"0","update_time":"0","edition":"1","url":"/index.php?m=goods&c=index&a=detail&sku_id=1","img_list":["./uploadfile/goods/1b/2f/06/45/597c5212a963b.jpg","./uploadfile/goods/43/d5/96/c0/597c5212b3e33.jpg"],"prom_price":"0.00","brand":null,"sales":0,"hits":"0","favorites":"0"}]}
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
         * count : 3
         * lists : [{"id":"3","name":"白云山 小柴胡颗粒 ","subtitle":"","style":"","catid":"4","brand_id":"0","keyword":"","description":"","content":null,"imgs":"","min_price":"0.00","max_price":"0.00","status":"1","specs":{"1":{"id":"1","name":"规格","value":["10g*10包*5件"],"style":"0","img":[""],"color":""}},"sku_total":"0","give_point":"-1","warn_number":"5","sort":"100","spec_id":"0","type_id":"1","weight":"0.00","volume":"0.00","delivery_template_id":"0","sku_id":"3","spu_id":"3","sku_name":"白云山 小柴胡颗粒 10g*10包*5件 ","sn":"NU150132030877-1","barcode":"","spec":[{"id":"1","name":"规格","value":"10g*10包*5件","style":"0","color":"","img":""}],"thumb":"./uploadfile/goods/95/fc/9e/37/597c54a1546db.jpg","status_ext":"0","number":"0","market_price":"0.00","shop_price":"0.00","show_in_lists":"1","prom_type":"","prom_id":"0","up_time":"0","update_time":"0","edition":"1","url":"/index.php?m=goods&c=index&a=detail&sku_id=3","img_list":["./uploadfile/goods/95/fc/9e/37/597c54a1546db.jpg"],"prom_price":"0.00","brand":null,"sales":0,"hits":"6","favorites":"0"},{"id":"1","name":"江中 健胃消食片 ","subtitle":"用于脾胃虚弱、消化不良、厌食症、胃胀腹胀【口服，可以咀嚼。成人一次3片，一日3次，小儿酌减】","style":"#ff0000","catid":"5","brand_id":"0","keyword":"","description":"","content":null,"imgs":"","min_price":"0.00","max_price":"0.00","status":"1","specs":{"1":{"id":"1","name":"规格","value":["0.8g*8片*4板"],"style":"0","img":[""],"color":""}},"sku_total":"0","give_point":"-1","warn_number":"5","sort":"100","spec_id":"0","type_id":"1","weight":"0.00","volume":"0.00","delivery_template_id":"0","sku_id":"2","spu_id":"1","sku_name":"江中 健胃消食片 0.8g*8片*4板 ","sn":"NU150131955491-1","barcode":"","spec":[{"id":"1","name":"规格","value":"0.8g*8片*4板","style":"0","color":"","img":""}],"thumb":"./uploadfile/goods/55/ef/4e/c3/597c51a462d53.jpg","status_ext":"0","number":"0","market_price":"0.00","shop_price":"0.00","show_in_lists":"1","prom_type":"","prom_id":"0","up_time":"0","update_time":"0","edition":"1","url":"/index.php?m=goods&c=index&a=detail&sku_id=2","img_list":["./uploadfile/goods/55/ef/4e/c3/597c51a462d53.jpg","./uploadfile/goods/aa/61/6f/8f/597c51a46e103.jpg","./uploadfile/goods/0a/1b/4d/49/597c51a4765d3.jpg"],"prom_price":"0.00","brand":null,"sales":0,"hits":"3","favorites":"0"},{"id":"2","name":"葵花 护肝片","subtitle":"","style":"","catid":"5","brand_id":"0","keyword":"","description":"","content":null,"imgs":"","min_price":"0.00","max_price":"0.00","status":"1","specs":[],"sku_total":"0","give_point":"-1","warn_number":"5","sort":"100","spec_id":"0","type_id":"1","weight":"0.00","volume":"0.00","delivery_template_id":"0","sku_id":"1","spu_id":"2","sku_name":"葵花 护肝片 0.35g*100片*8件 ","sn":"NU150131967711-1","barcode":"","spec":[{"id":"1","name":"规格","value":"0.35g*100片*8件","style":"0","color":"","img":""}],"thumb":"./uploadfile/goods/1b/2f/06/45/597c5212a963b.jpg","status_ext":"0","number":"0","market_price":"0.00","shop_price":"0.00","show_in_lists":"1","prom_type":"","prom_id":"0","up_time":"0","update_time":"0","edition":"1","url":"/index.php?m=goods&c=index&a=detail&sku_id=1","img_list":["./uploadfile/goods/1b/2f/06/45/597c5212a963b.jpg","./uploadfile/goods/43/d5/96/c0/597c5212b3e33.jpg"],"prom_price":"0.00","brand":null,"sales":0,"hits":"0","favorites":"0"}]
         */

        private String count;
        private List<ListsBean> lists;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<ListsBean> getLists() {
            return lists;
        }

        public void setLists(List<ListsBean> lists) {
            this.lists = lists;
        }

        public static class ListsBean {
            /**
             * id : 3
             * name : 白云山 小柴胡颗粒
             * subtitle :
             * style :
             * catid : 4
             * brand_id : 0
             * keyword :
             * description :
             * content : null
             * imgs :
             * min_price : 0.00
             * max_price : 0.00
             * status : 1
             * specs : {"1":{"id":"1","name":"规格","value":["10g*10包*5件"],"style":"0","img":[""],"color":""}}
             * sku_total : 0
             * give_point : -1
             * warn_number : 5
             * sort : 100
             * spec_id : 0
             * type_id : 1
             * weight : 0.00
             * volume : 0.00
             * delivery_template_id : 0
             * sku_id : 3
             * spu_id : 3
             * sku_name : 白云山 小柴胡颗粒 10g*10包*5件
             * sn : NU150132030877-1
             * barcode :
             * spec : [{"id":"1","name":"规格","value":"10g*10包*5件","style":"0","color":"","img":""}]
             * thumb : ./uploadfile/goods/95/fc/9e/37/597c54a1546db.jpg
             * status_ext : 0
             * number : 0
             * market_price : 0.00
             * shop_price : 0.00
             * show_in_lists : 1
             * prom_type :
             * prom_id : 0
             * up_time : 0
             * update_time : 0
             * edition : 1
             * url : /index.php?m=goods&c=index&a=detail&sku_id=3
             * img_list : ["./uploadfile/goods/95/fc/9e/37/597c54a1546db.jpg"]
             * prom_price : 0.00
             * brand : null
             * sales : 0
             * hits : 6
             * favorites : 0
             */

            private String id;
            private String name;
            private String subtitle;
            private String style;
            private String catid;
            private String brand_id;
            private String keyword;
            private String description;
            private Object content;
            private String imgs;
            private String min_price;
            private String max_price;
            private String status;
            private SpecsBean specs;
            private String sku_total;
            private String give_point;
            private String warn_number;
            private String sort;
            private String spec_id;
            private String type_id;
            private String weight;
            private String volume;
            private String delivery_template_id;
            private String sku_id;
            private String spu_id;
            private String sku_name;
            private String sn;
            private String barcode;
            private String thumb;
            private String status_ext;
            private String number;
            private String market_price;
            private String shop_price;
            private String show_in_lists;
            private String prom_type;
            private String prom_id;
            private String up_time;
            private String update_time;
            private String edition;
            private String url;
            private String prom_price;
            private Object brand;
            private int sales;
            private String hits;
            private String favorites;
            private List<SpecBean> spec;
            private List<String> img_list;

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

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String getCatid() {
                return catid;
            }

            public void setCatid(String catid) {
                this.catid = catid;
            }

            public String getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(String brand_id) {
                this.brand_id = brand_id;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public Object getContent() {
                return content;
            }

            public void setContent(Object content) {
                this.content = content;
            }

            public String getImgs() {
                return imgs;
            }

            public void setImgs(String imgs) {
                this.imgs = imgs;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public SpecsBean getSpecs() {
                return specs;
            }

            public void setSpecs(SpecsBean specs) {
                this.specs = specs;
            }

            public String getSku_total() {
                return sku_total;
            }

            public void setSku_total(String sku_total) {
                this.sku_total = sku_total;
            }

            public String getGive_point() {
                return give_point;
            }

            public void setGive_point(String give_point) {
                this.give_point = give_point;
            }

            public String getWarn_number() {
                return warn_number;
            }

            public void setWarn_number(String warn_number) {
                this.warn_number = warn_number;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getSpec_id() {
                return spec_id;
            }

            public void setSpec_id(String spec_id) {
                this.spec_id = spec_id;
            }

            public String getType_id() {
                return type_id;
            }

            public void setType_id(String type_id) {
                this.type_id = type_id;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getVolume() {
                return volume;
            }

            public void setVolume(String volume) {
                this.volume = volume;
            }

            public String getDelivery_template_id() {
                return delivery_template_id;
            }

            public void setDelivery_template_id(String delivery_template_id) {
                this.delivery_template_id = delivery_template_id;
            }

            public String getSku_id() {
                return sku_id;
            }

            public void setSku_id(String sku_id) {
                this.sku_id = sku_id;
            }

            public String getSpu_id() {
                return spu_id;
            }

            public void setSpu_id(String spu_id) {
                this.spu_id = spu_id;
            }

            public String getSku_name() {
                return sku_name;
            }

            public void setSku_name(String sku_name) {
                this.sku_name = sku_name;
            }

            public String getSn() {
                return sn;
            }

            public void setSn(String sn) {
                this.sn = sn;
            }

            public String getBarcode() {
                return barcode;
            }

            public void setBarcode(String barcode) {
                this.barcode = barcode;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getStatus_ext() {
                return status_ext;
            }

            public void setStatus_ext(String status_ext) {
                this.status_ext = status_ext;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getMarket_price() {
                return market_price;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }

            public String getShop_price() {
                return shop_price;
            }

            public void setShop_price(String shop_price) {
                this.shop_price = shop_price;
            }

            public String getShow_in_lists() {
                return show_in_lists;
            }

            public void setShow_in_lists(String show_in_lists) {
                this.show_in_lists = show_in_lists;
            }

            public String getProm_type() {
                return prom_type;
            }

            public void setProm_type(String prom_type) {
                this.prom_type = prom_type;
            }

            public String getProm_id() {
                return prom_id;
            }

            public void setProm_id(String prom_id) {
                this.prom_id = prom_id;
            }

            public String getUp_time() {
                return up_time;
            }

            public void setUp_time(String up_time) {
                this.up_time = up_time;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getEdition() {
                return edition;
            }

            public void setEdition(String edition) {
                this.edition = edition;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getProm_price() {
                return prom_price;
            }

            public void setProm_price(String prom_price) {
                this.prom_price = prom_price;
            }

            public Object getBrand() {
                return brand;
            }

            public void setBrand(Object brand) {
                this.brand = brand;
            }

            public int getSales() {
                return sales;
            }

            public void setSales(int sales) {
                this.sales = sales;
            }

            public String getHits() {
                return hits;
            }

            public void setHits(String hits) {
                this.hits = hits;
            }

            public String getFavorites() {
                return favorites;
            }

            public void setFavorites(String favorites) {
                this.favorites = favorites;
            }

            public List<SpecBean> getSpec() {
                return spec;
            }

            public void setSpec(List<SpecBean> spec) {
                this.spec = spec;
            }

            public List<String> getImg_list() {
                return img_list;
            }

            public void setImg_list(List<String> img_list) {
                this.img_list = img_list;
            }

            public static class SpecsBean {
                /**
                 * 1 : {"id":"1","name":"规格","value":["10g*10包*5件"],"style":"0","img":[""],"color":""}
                 */

                @SerializedName("1")
                private _$1Bean _$1;

                public _$1Bean get_$1() {
                    return _$1;
                }

                public void set_$1(_$1Bean _$1) {
                    this._$1 = _$1;
                }

                public static class _$1Bean {
                    /**
                     * id : 1
                     * name : 规格
                     * value : ["10g*10包*5件"]
                     * style : 0
                     * img : [""]
                     * color :
                     */

                    private String id;
                    private String name;
                    private String style;
                    private String color;
                    private List<String> value;
                    private List<String> img;

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

                    public String getStyle() {
                        return style;
                    }

                    public void setStyle(String style) {
                        this.style = style;
                    }

                    public String getColor() {
                        return color;
                    }

                    public void setColor(String color) {
                        this.color = color;
                    }

                    public List<String> getValue() {
                        return value;
                    }

                    public void setValue(List<String> value) {
                        this.value = value;
                    }

                    public List<String> getImg() {
                        return img;
                    }

                    public void setImg(List<String> img) {
                        this.img = img;
                    }
                }
            }

            public static class SpecBean {
                /**
                 * id : 1
                 * name : 规格
                 * value : 10g*10包*5件
                 * style : 0
                 * color :
                 * img :
                 */

                private String id;
                private String name;
                private String value;
                private String style;
                private String color;
                private String img;

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

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getStyle() {
                    return style;
                }

                public void setStyle(String style) {
                    this.style = style;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }
            }
        }
    }
}
