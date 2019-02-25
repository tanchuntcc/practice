package string;

/**
 * Created by TanChun on 2019/1/21.
 * 统计在一个字符串中出现某个字符出现多少次
 */
public class CountNum {
    public static int getOccur(String src,String find){
        int o = 0;
        int index=-1;
        while((index=src.indexOf(find,index))>-1){
            ++index;
            ++o;
        }
        return o;
    }

    public static void main(String[] args) {
        String str = "ilovejavajavacdejavailha123java34javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javailovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3java";
        System.out.println(CountNum.getOccur(str, "a"));
    }
}
