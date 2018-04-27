package com.jtx.admin.common;

import com.google.common.collect.Maps;
import com.jtx.admin.utils.DecimalCalculateUtil;
import com.jtx.admin.utils.MD5Util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

/**
 * @author
 *
 */
public class ClientEncrypedSign {
    private static final String SALT = "jiatianxianiubi";

    public static Map<String,String> encryptedSign(Map<String,String> params){
        ArrayList<String> keyList = new ArrayList<>(params.keySet());
        keyList.sort((String s1,String s2) -> s1.compareTo(s2));
        String paramValueStr = "";
        for (String s : keyList) {
            paramValueStr += params.get(s);
        }
        String sign = MD5Util.MD5EncodeUtf8(paramValueStr,SALT);
        params.put("sign",sign);
        return params;
    }


    public static void main(String[] args) {
        String a = "5.8";

        BigDecimal zhe = DecimalCalculateUtil.div(Double.parseDouble(a),10);
        BigDecimal d = DecimalCalculateUtil.sub(1.00, zhe.doubleValue());

        System.out.println(d);
//        Map<String,String> params = Maps.newHashMap();
//        params.put("token","0bec7d02-cbff-4703-b7c4-93754b033353");
//        String timeStamp = String.valueOf(System.currentTimeMillis());
//        params.put("timeStamp",timeStamp);
//        params.put("status","3");
//        params.put("model","大众");
//        params.put("color","灰色");
//        params.put("number","冀ASB941");
//        params.put("carId","ec193fed-57d2-4038-9b31-221e72b7ff4f");
//        params.put("description","我要反馈信息5123154");
//        params.put("contact","张三");
//        params.put("phone","18732015678");
//        params.put("address","河北省石家庄市新乐市新华路OPPO授权体验店");
//        params.put("note","公司");
//        params.put("addressDesc","在商店后门");
//        params.put("longitude","114.683843");
//        params.put("latitude","38.352668");
//        params.put("id","1523152846038520");



//        System.out.println(encryptedSign(params));

    }
}
