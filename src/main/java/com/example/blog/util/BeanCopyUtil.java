package com.example.blog.util;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeanCopyUtil {

    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(1);
        Set set = new HashSet(list);

    }
    public static <T> T copyObject(Object source, Class<T> target) {
        T temp = null;
        try {
            temp = target.newInstance();
            if (null != source) {
                org.springframework.beans.BeanUtils.copyProperties(source, temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static <T, S> List<T> copyList(List<S> source, Class<T> target) {
        List<T> list = new ArrayList<>();
        if (null != source && source.size() > 0) {
            for (Object obj : source) {
                list.add(BeanCopyUtil.copyObject(obj, target));
            }
        }
        return list;
    }

}