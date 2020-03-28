package test;

import java.util.*;

/**
 * @author 谭春
 * Date: 2020/3/18
 * Description:
 */
public class Av {
        public static void main(String[] args) {
            Map map=new TreeMap();
            map.put("图书" , 4);
            map.put("音像" , 6);
            map.put("素材" , 9);
            map.put("音乐" , 8);
            map.put("影视" , 7);
            map.put("动漫" , 4);
            map.put("歌曲" , 3);
            map.put("图片" , 2);
            map.put("图标" , 6);
            ArrayList<Map.Entry<String,Integer>> entries= sortMap(map);
            for( int i=0;i<5;i++){
                System. out.print(entries.get(i).getKey()+":" +entries.get(i).getValue());
            }
        }
        public static ArrayList<Map.Entry<String,Integer>> sortMap(Map map){
            List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
            Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> obj1 , Map.Entry<String, Integer> obj2) {
                    return obj2.getValue() - obj1.getValue();
                }
            });
            return (ArrayList<Map.Entry<String, Integer>>) entries;
        }
    }


