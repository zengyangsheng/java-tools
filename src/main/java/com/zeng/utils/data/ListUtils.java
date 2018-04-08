package com.zeng.utils.data;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsheng.zeng
 * @date 2018/3/1 15:56
 */
public class ListUtils extends CollectionUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListUtils.class);

    /**
     * 判断是否不为空
     * @param o
     * @return
     */
    public static Boolean isNotEmpty(List o) {
        return o != null && o.size() > 0;
    }

    /**
     * 判断是否为空
     * @param o
     * @return
     */
    public static Boolean isEmpty(List o) {
        return !isNotEmpty(o);
    }

    public static <T> List<T> selectValues(List o, String propertyName){
        if(o == null || propertyName == null){
            return null;
        }
        List<T> returnList = new ArrayList<>();
        for(int i=0; i<o.size(); i++){
            try {
                T value = (T) PropertyUtils.getProperty(o.get(i), propertyName);
                returnList.add(value);
            } catch (Exception e) {
                LOGGER.error("ListUtils getValues error : " + e.getMessage(), e);
                continue;
            }
        }
        return returnList;
    }

    /**
     * @Description: 将list根据指定属性返回对应map集合
     * @param [list, methodName, c]
     * @return java.util.Map<K,V>
    */
    public static <K,V> Map<K,V> list2Map(List<V> list,String methodName,Class<V> c){
        Map<K, V> map = new HashMap<>();
        if (list != null) {
            try {
                Method methodGetKey = c.getMethod(methodName);
                for (int i = 0; i < list.size(); i++) {
                    V value = list.get(i);
                    @SuppressWarnings("unchecked")
                    K key = (K) methodGetKey.invoke(list.get(i));
                    map.put(key, value);
                }
            } catch (Exception e) {
                throw new RuntimeException("转换异常");
            }
        }
        return map;
    }
}
