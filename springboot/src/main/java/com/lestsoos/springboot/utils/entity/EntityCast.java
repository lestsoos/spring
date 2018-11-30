package com.lestsoos.springboot.utils.entity;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EntityCast {
    /**
     * 数组集合转化为指定对象集合
     * 指定的实体对象必须包含所以字段的构造方法，数组的元素的顺序将和构造方法顺序和类型一一对应
     * @param list
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> castEntity(List<Object[]> list, Class<T> clazz) {
        List<T> returnList = new ArrayList<>();
        if (list.size() == 0){
            return returnList;
        }
        Class[] c2 = null;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors){
            Class[] tClass = constructor.getParameterTypes();
            if (tClass.length == list.get(0).length){
                c2 = tClass;
                break;
            }
        }
        //构造方法实例化对象
        for(Object[] o : list){

            try {
                Constructor<T> constructor = clazz.getConstructor(c2);
                returnList.add(constructor.newInstance(o));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                log.info("IllegalAccessException is {}" + e);
            } catch (InvocationTargetException e) {
                log.info("InvocationTargetException is {}" + e);
            } catch (NoSuchMethodException e) {
                log.info("NoSuchMethodException is {}" + e);
            }
        }

        return returnList;
    }

    public static <T> T castEntityOne(List<Object[]> list, Class<T> clazz) {
        List<T> returnList = castEntity(list, clazz);
        if(returnList.size() == 0)
            return null;

        return returnList.get(0);


    }
}
