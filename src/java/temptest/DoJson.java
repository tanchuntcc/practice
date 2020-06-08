package temptest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author 谭春
 * Date: 2020/6/4
 * Description:
 */
public class DoJson {
    public static StringBuilder doJson(String replyContent) {
        StringBuilder stringBuilder = new StringBuilder();
        //去除一些换行符、空格符和跳格符。
        if (replyContent == null) {
            return stringBuilder;
        }
        if (replyContent.contains("\n")) {
            replyContent = replyContent.replace("\n", "");
        }
        if (replyContent.contains("\\n")) {
            replyContent = replyContent.replace("\\n", "");
        }
        if (replyContent.contains("\t")) {
            replyContent = replyContent.replace("\t", "");
        }
        if (replyContent.contains("\\t")) {
            replyContent = replyContent.replace("\\t", "");
        }
        if (replyContent.contains("\r")) {
            replyContent = replyContent.replace("\r", "");
        }
        if (replyContent.contains("\\r")) {
            replyContent = replyContent.replace("\\r", "");
        }
        if (replyContent.contains("\\")) {
            replyContent = replyContent.replace("\\", " ");
        }
        // 去除ascii为22、25的字符（无用字符）
        int[] specialArr = new int[]{22, 25};
        for (int i = 0; i < specialArr.length; i++) {
            String specialStr = String.valueOf((char) specialArr[i]);
            if (replyContent.contains(specialStr)) {
                replyContent = replyContent.replace(specialStr, "");
            }
        }
        try {
            JSONObject jsonObject = JSONObject.parseObject(replyContent);
            //拿出Json数据中的ops中的元素
            JSONArray jsonArray = jsonObject.getJSONArray("ops");
            if (jsonArray != null && jsonArray.size() > 0) {
                //遍历ops元素里面各个属性。
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsObject = jsonArray.getJSONObject(i);
                    //拿出insert中的元素
                    Object insertObject = jsObject.get("insert");
                    String str = insertObject.toString();
                    //如果包含image，将image的内容移除 然后存入str中
                    if (str.contains("image")) {
                        JSONObject jsonO = JSONObject.parseObject(str);
                        jsonO.remove("image");
                        str = jsonO.toString();
                    }
                    //如果包含{}字段，将{image}然后存入stringBuilder
                    if ("{}".equals(str)) {
                        stringBuilder.append("{image}");
                        continue;
                    }
                    //将str放入stringBuilder
                    stringBuilder.append(str);
                }
            }else{
                return stringBuilder.append(replyContent);
            }
        } catch (Exception e) {
            stringBuilder.append(replyContent);
        }
        return stringBuilder;
    }
    private static void percentFormat() {
        //按系统预设百分比格式输出
        double d = 123.456;
        NumberFormat nf = NumberFormat.getPercentInstance();
        System.out.println(nf.format(d));//12,346%
        DecimalFormat format = new DecimalFormat( ",###,##0" );
        String fieldValue="12345678923";
        String s = format.format( new BigDecimal( fieldValue.toString() ) );
        System.out.println(s);
    }

    public static void main(String[] args) {
            String s="{\"ops\":[{\"insert\":\"测试流程55555555555555\\n\"},{\"insert\":{\"image\":\"http://gateway.v2.cloopm" +
        ".com:80/fileService/v1/file/image/picture/20190510/84bbbf30185b4861bc6af70c9e79ef94155749409774528537.png" +
        "\"}},{\"insert\":\"\\n正文\\n\\n项目\\n\\n\\n\"},{\"attributes\":{\"color\":\"#bbbbbb\"}," +
        "\"insert\":\"-来自知识KB1906110039\"},{\"insert\":\"\\n正文\\n\\n项目\\n\\n\\n\"}," +
        "{\"attributes\":{\"color\":\"#bbbbbb\"},\"insert\":\"-来自知识KB1906110039\"}," +
        "{\"insert\":\"\\n正文\\n\\n666\\n\\n\\n\"},{\"attributes\":{\"color\":\"#bbbbbb\"}," +
        "\"insert\":\"-来自知识KB1906110036\"},{\"insert\":\"\\n\"}]}";

        StringBuilder stringBuilder = doJson(s);
        System.out.println(stringBuilder.toString());

        percentFormat();
    }
}

