package com.wealthPark.restful.utils;

import com.wealthPark.restful.model.PurchaserProduct;

import java.text.SimpleDateFormat;
import java.util.*;

public class OutputFormatter {
    public static Map formatResult(List<PurchaserProduct> list, Date start, Date end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Map<String, List<String>>> result = new HashMap<String, Map<String, List<String>>>();
        if (list.size() > 0) {
            Map<String, List<String>> m = new HashMap<String, List<String>>();
            result.put(list.get(0).getPurchaserId().toString(), m);
            for (PurchaserProduct p : list) {
                if (p.getCreatedDate().getTime() < start.getTime() || p.getCreatedDate().getTime() > end.getTime()) continue; // filter out the records out of range.
                Map<String, List<String>> tmp = result.get(list.get(0).getPurchaserId().toString());
                if (tmp.get(sdf.format(p.getCreatedDate())) == null) {
                    List l = new ArrayList<String>();
                    l.add(p.getProductId());
                    tmp.put(sdf.format(p.getCreatedDate()), l);
                } else {
                    List l = tmp.get(sdf.format(p.getCreatedDate()));
                    l.add(p.getProductId());
                    tmp.put(sdf.format(p.getCreatedDate()), l);
                }
            }
        }
        return result;
    }
}
