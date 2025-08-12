package com.Target.Product.onee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFreqHitIPAddress {
    public static void main(String[] args) {

        List<String> ipAddress = Arrays.asList(
                "192.62.86.41 –curl/X-GET ABC",
                "192.62.86.41 –curl/X-GET dsjhlj",
                "103.62.86.41 –curl/X-GET sj",
                "103.62.86.41 –curl/X-GET xxxxxxxxx",
                "192.62.86.41 –curl/X-GET js"
        );

        findMostFreqIPHIT(ipAddress);
    }

    public static void findMostFreqIPHIT(List<String> ipAddress) {
        Map<String, Integer> mapFreq = new HashMap<>();

        for (String s : ipAddress) {
            String trimIp = s.split("-")[0];
            mapFreq.put(trimIp, mapFreq.getOrDefault(trimIp, 0) + 1);
        }
        int maxIpHit = 0;
        String ip = "";
        for (Map.Entry<String, Integer> entry : mapFreq.entrySet()) {
            if (entry.getValue() > maxIpHit) {
                maxIpHit = entry.getValue();
                ip = entry.getKey();
            }
        }

        System.out.println(" ip : " + ip + " " + "count : " + maxIpHit);
    }
}
