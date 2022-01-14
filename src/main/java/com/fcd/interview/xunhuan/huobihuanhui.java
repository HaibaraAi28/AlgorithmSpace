package com.fcd.interview.xunhuan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class huobihuanhui {

    public static void main(String[] args) {

    }

    public class ConvRate {
        private String from;
        private String to;
        double rate;
    }





    //记录已知汇率关系，from和to形成唯一键值对
    HashMap<String, Double> record = new HashMap<>();
    HashMap<String,Integer> nationSet = new HashMap<>();

    //记录所有汇率关系
    double[][] convertForm = null;

    public void buildRecord(List<ConvRate> rateList) {

        int index = 0;
        for (ConvRate rate : rateList) {
            if(!nationSet.containsKey(rate.from)) {
                nationSet.put(rate.from, index++);
            }

            if(!nationSet.containsKey(rate.to)) {
                nationSet.put(rate.to, index++);
            }

            StringBuilder sb = new StringBuilder();
            sb.append(rate.from);
            sb.append('_');
            sb.append(rate.to);
            record.put(sb.toString(), rate.rate);
        }
    }

    /**
     * 初始化汇率表
     * @param rateList
     * @return
     */
    public void initForm(List<ConvRate> rateList) {

        int size = nationSet.size();
        double[][] form = new double[size][size];

        for (ConvRate rate : rateList) {
            StringBuilder sb = new StringBuilder();
            sb.append(rate.from);
            sb.append('_');
            sb.append(rate.to);

            form[nationSet.get(rate.from)][nationSet.get(rate.to)] = record.get(sb.toString());
        }

        convertForm = form;
    }

    public double GetConvRate(String from, String to) {
        return convertForm[nationSet.get(from)][nationSet.get(to)];
    }

    /**
     * 补充完整汇率表
     * @param form
     * @return
     */
    public double[][] fillForm(double[][] form) {
        for (int i = 0; i < form.length; i++) {
            for (int j = 0; j < form.length; j++) {
                if (i == j) {
                    form[i][j] = 1;
                    continue;
                }
                if (form[i][j] != 0) {
                    form[j][i] = 1 / form[i][j];

                    //搜索j行
                    for(int k = j; k < form.length; k++) {
                        if (form[j][k] != 0) {
                            form[i][k] = form[i][j] * form[j][k];
                        }
                    }
                } else {
                    form[i][j] = -1;
                }
            }
        }
        return form;
    }

}
