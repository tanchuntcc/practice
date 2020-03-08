//package test;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.tchirk.itsm.event.domain.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author 谭春
// * Date: 2020/2/10
// * Description:
// */
//public class testaa {
//    public static void main(String[] args) {
//        String st="{\n" +
//                "   \"esbInfo\":    {\n" +
//                "      \"requestTime\": \"2020-01-13 12:46:57:528\",\n" +
//                "      \"responseTime\": null,\n" +
//                "      \"returnCode\": null,\n" +
//                "      \"returnMsg\": null,\n" +
//                "      \"returnStatus\": null,\n" +
//                "      \"attr2\": \"\",\n" +
//                "      \"attr3\": \"\",\n" +
//                "      \"attr1\": \"\",\n" +
//                "      \"instId\": \"2019121101\"\n" +
//                "   },\n" +
//                "   \"queryInfo\":    {\n" +
//                "      \"totalPage\": 0,\n" +
//                "      \"totalRecord\": 0,\n" +
//                "      \"pageSize\": 0,\n" +
//                "      \"currentPage\": 0\n" +
//                "   },\n" +
//                "   \"resultInfo\":    {\n" +
//                "      \"messages\": [],\n" +
//                "      \"result\": true,\n" +
//                "      \"partsRet\":       [\n" +
//                "                  {\n" +
//                "            \"vak\": \"2000057\",\n" +
//                "            \"posnr\": \"0001\",\n" +
//                "            \"qmnum\": \"000200065100\",\n" +
//                "            \"fenum\": \"0001\",\n" +
//                "            \"matnr\": \"02215008020B7\",\n" +
//                "            \"ztype\": \"S\",\n" +
//                "            \"zmsg\": \"\"\n" +
//                "         },\n" +
//                "                  {\n" +
//                "            \"vak\": \"2000057\",\n" +
//                "            \"posnr\": \"0002\",\n" +
//                "            \"qmnum\": \"000200065100\",\n" +
//                "            \"fenum\": \"0002\",\n" +
//                "            \"matnr\": \"02215008020B7\",\n" +
//                "            \"ztype\": \"S\",\n" +
//                "            \"zmsg\": \"\"\n" +
//                "         }\n" +
//                "      ]\n" +
//                "   }\n" +
//                "}\n";
//        JSONObject jsonObject = JSONObject.parseObject(st);
//        SapVak sapVak = JSON.toJavaObject(jsonObject, SapVak.class);
//        ResultInfo resultInfo = sapVak.getResultInfo();
//        //创建一个List用于保存vak号
//        ArrayList<String> vakLists = new ArrayList<>();
//        List<RegReturn> regReturn = resultInfo.getRegReturn();
//        if (regReturn!=null) {
//            for (RegReturn aReturn : regReturn) {
//                String vak = aReturn.getVakNo();
//                vakLists.add(vak);
//            }
//        }
//        List<AnalysisRet> analysisRets = resultInfo.getAnalysisRet();
//        if (analysisRets!=null) {
//            for (AnalysisRet analysisRet : analysisRets) {
//                String vak = analysisRet.getVak();
//                vakLists.add(vak);
//            }
//        }
//        List<PartsRet> partsRets = resultInfo.getPartsRet();
//        if (partsRets!=null) {
//            for (PartsRet partsRet : partsRets) {
//                String vak = partsRet.getVak();
//                vakLists.add(vak);
//            }
//        }
//        System.out.println(vakLists);
//
//    }
//}
//
