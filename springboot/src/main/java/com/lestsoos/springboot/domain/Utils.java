package com.lestsoos.springboot.domain;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    /**
     * 数组集合转化为指定对象集合
     * 指定的实体对象必须包含所以字段的构造方法，数组的元素的顺序将和构造方法顺序和类型一一对应
     * @param list
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> castEntity(List<Object[]> list, Class<T> clazz) throws Exception {
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
            Constructor<T> constructor = clazz.getConstructor(c2);
            returnList.add(constructor.newInstance(o));
        }

        return returnList;
    }
}
