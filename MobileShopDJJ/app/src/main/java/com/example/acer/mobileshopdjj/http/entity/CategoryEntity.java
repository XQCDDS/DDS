package com.example.acer.mobileshopdjj.http.entity;

import java.io.Serializable;

public class CategoryEntity implements Serializable {
    /**
     * cat_id
     * name
     * parent_id
     * cat_path
     * goods_count
     * sort
     * type_id
     * list_show
     * image
     * creatime
     * modifytime
     */
    private int cat_id;
    private String name;
    private int parent_id;
    private String cat_path;
    private int goods_count;
    private int sort;
    private int type_id;
    private int list_show;
    private String image;
    private String creatime;
    private String modifytime;

    public int getCat_id() { return cat_id; }
    public void setCat_id(int cat_id) { this.cat_id = cat_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getParent_id() { return parent_id; }
    public void setParent_id(int parent_id) { this.parent_id = parent_id; }

    public String getCat_path() { return cat_path; }
    public void setCat_path(String cat_path) { this.cat_path = cat_path; }

    public int getGoods_count() { return goods_count; }
    public void setGoods_count(int goods_count) { this.goods_count = goods_count; }

    public int getSort() { return sort; }
    public void setSort(int sort) { this.sort = sort; }

    public int getType_id() { return type_id; }
    public void setType_id(int type_id) { this.type_id = type_id; }

    public int getList_show() { return list_show; }
    public void setList_show(int list_show) { this.list_show = list_show; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getCreatime() { return creatime; }
    public void setCreatime(String creatime) { this.creatime = creatime; }

    public String getModifytime() { return modifytime; }
    public void setModifytime(String modifytime) { this.modifytime = modifytime; }
}
