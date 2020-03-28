package array;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BitMap {
    //如果是统计文件中的数字，则需要进行文件读取。

    //使用BitSet实现查重和排序
    public static Set<Integer> bitCount(int[] arr) {
        Set<Integer> res = new HashSet<>();
        BitSet bitSet = new BitSet(arr.length);
        StringBuffer string = new StringBuffer();
        //如果存在则加入到set集合中，不存在则存入bitSet
        for (int i = 0; i < arr.length; i++) {
            if (bitSet.get(arr[i])) {
                res.add(arr[i]);
            } else {
                bitSet.set(arr[i]);
            }
        }

        //遍历bitSet，依次取出有值的索引，内部封装了length和get方法。
        for (int i = 0; i < bitSet.length(); i++) {
            if (bitSet.get(i)) {
                string.append(i).append(",");
            }
        }
        System.out.println(string.toString());
        return res;
    }

    //自己实现bitMap查重和排序
    public static Set<Integer> bitCountTwo(int[] arr) {
        Set<Integer> res = new HashSet<>();
        long[] bitSet = new long[arr.length];
        StringBuffer string = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            //当前元素属于long数组第几个
            int row = element >> 6;
            //如果存在放入set中
            if ((bitSet[row] & 1 << (element & 31)) != 0) {
                res.add(element);
            } else {
                //不存在放入bitSet中
                bitSet[row] |= (1 << element);
            }
        }
        int count=0;
        //第一次遍历先取到long数组的元素
        for (int i = 0; i < bitSet.length; i++) {
            //第二次遍历取到元素后遍历找到64位中有值的位数。
            for (int j = 0; j < 64; j++) {
                //使用1L左移，因为必须64位。(用1搞了老半天，debug发现左移33位时又回到最右边重新左移)
                if ((bitSet[i] & 1L << j) != 0) {
                    //i*64中i为当前元素所在区间，64为之前每个区间有64个值。当前值等于i*64+j
                    count++;
                    string.append(i * 64 + j).append(",");
                }
            }
        }
        System.out.println(count);
        System.out.println(string.toString());
        return res;
    }


    public static void main(String[] args) {
        int[] rom = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            rom[i] = random.nextInt(100000);
        }
        Set<Integer> t2 = bitCountTwo(rom);
        System.out.println(t2);
    }
}
