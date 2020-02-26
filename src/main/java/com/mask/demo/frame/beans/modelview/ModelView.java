package com.mask.demo.frame.beans.modelview;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mac
 * @description: 模型视图封装
 * @date: 2020-02-25 16:19
 */
@Data
public class ModelView {

    /**
     * 填充model的内容
     * */
    private Map<String,Object> attributes;

    /**
     * 返回视图名
     * */
    private String returnView;

    /**
     * 构造函数
     * */
    public ModelView(){
        this.attributes = new HashMap<String, Object>();
    }
}
