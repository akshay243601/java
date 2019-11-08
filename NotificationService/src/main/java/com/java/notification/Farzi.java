package com.java.notification;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.Data;
import org.apache.tomcat.util.buf.StringUtils;

import java.lang.reflect.Array;
import java.util.*;

public class Farzi {

    @Data
    class ResultLog {
        String key;
        String pplusValue;
        String paytmValue;
        String errorMessage;
    }

    public static void main (String args[]) {
        System.out.println(convertListIntoString(Arrays.asList("sf")));

    }


    private void reconData(Map<String, Object> map1, Map<String, Object> map2, List<ResultLog> logs) {
        if(null == map1 || null == map2) {
            ResultLog rl = new ResultLog();
            if(map1 == null) {
                rl.setErrorMessage("Map1 is null");
            } else {
                rl.setErrorMessage("Map2 is null");
            }
            logs.add(rl);
        } else {
            Set<String> map1Keys = map1.keySet();
            Set<String> map2Keys = map2.keySet();
            Set<String> allKeys = new HashSet<>();
            allKeys.addAll(map1Keys);
            allKeys.addAll(map2Keys);
            for (String key : allKeys) {
                if (!map1.containsKey(key) || !map2.containsKey(key)) {
                    if (!map1.containsKey(key)) {
                        getResultLog(key, map1.get(key), map2.get(key), "map1 is not having data for " + key);
                    } else {
                        getResultLog(key, map1.get(key), map2.get(key), "map1 is not having data for " + key);
                    }
                } else {
                    Object map1V = map1.get(key);
                    Object map2V = map2.get(key);
                    if(map1V.getClass() != map2V.getClass()) {
                        getResultLog(key, map1V, map2V, "map1 is having different data type  for " + key);
                    } else {

                    }
                }



            }
        }
    }

    private ResultLog getResultLog(String key, Object val1, Object val2, String errorMessage) {
        ResultLog rl = new ResultLog();
        rl.setErrorMessage(errorMessage);
        rl.setKey(key);
        if(val1 != null) {
            rl.setPaytmValue(val1.toString());
        }
        if(val2 != null){
            rl.setPplusValue(val2.toString());
        }
        return rl;
    }

   /* privte String getPayMethodKey(String payMethod, JSONOBject obj ) {
        if(!StringUtils.isEmpty(payMethod)) {
            String key = payMethod;
            if(null != obj && obj.hasKey("FEE_DESCIIJSDHJHDGSD") && )



        }
    }*/


    public static String convertListIntoString(List<String> list) {
        if(null != list && !list.isEmpty()) {
            StringBuilder val = new StringBuilder();
            boolean isStart = true;
            for(String s : list) {
                if(isStart) {
                    isStart = false;
                } else {
                    val.append(",");
                }
                val.append("'").append(s.trim()).append("'");
            }
            return val.toString();
        }
        return null;
    }

}
