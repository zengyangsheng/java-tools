package com.zeng.utils.data;

import java.util.Random;

/**
 * @author yangsheng.zeng
 * @date 2018/3/8 9:28
 */
public class RandomUtils {
    public static final Random random = new Random();

    /**
     * 获取区间的随机数
     * @param min 开始值
     * @param max 结束值
     * @return 随机数
     */
    public static final int randomSection(int min, int max) {
        // 若传值错误，直接返回最小值
        if (min >= max) {
            return min;
        }
        return random.nextInt(max - min + 1) + min;
    }
}
