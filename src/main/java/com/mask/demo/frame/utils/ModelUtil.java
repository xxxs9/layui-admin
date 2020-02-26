package com.mask.demo.frame.utils;

import com.mask.demo.frame.beans.modelview.ModelView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;

/**
 * @author: mac
 * @description: Model工具类
 * @date: 2020-02-25 16:22
 */
@Slf4j
public class ModelUtil {

    /**
     * 填充Model
     * @param model Model
     * @param resBean 待填充的信息
     * */
    public static String fillModelAndReturnView(Model model,ModelView resBean){
          log.info("View Model填入参数:{}",resBean);
          //填充model并返回视图
          if(!resBean.getAttributes().isEmpty()){
              model.addAllAttributes(resBean.getAttributes());
          }

          return resBean.getReturnView();
    }
}
