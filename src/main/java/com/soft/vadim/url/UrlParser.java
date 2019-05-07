package com.soft.vadim.url;

import java.util.Arrays;

public class UrlParser {
    static String n = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMN0PQRSTUVWXYZO123456789+/=";
//    public String unmaskVkUrl(String e){
//
//        if (e.contains("audio_api_unavailable")) {
//            String[] t = e.split("?extra=")[1].split("#");
//
//                     n = "".equals(t[1]) ? "" : Arrays.toString(o(t[1]));
//            if (t == o(t[0])) {
//                return e;
//            }
//            String[] nMas;
//            nMas = n.split("\t");
//            String[] r,s;
//            String ch="11";
//            for ( int  l = n.length();l>0; l--) {
//                if (s = nMas[l].split(String.valueOf ( Character.toChars(11) ))){
//
//                }
//                r = s.splice(0, 1, t)[0],
//                        !i[r]) {
//                    return e;
//                }
//                t = i[r].apply(null, s);
//            }
//            if (t && "http" === t.substr(0, 4)) {
//                return t;
//            }
//        }
//        return e;
//
//
//        return null;
//
//    }

    public static String o(String e) {
        if (e.length() % 4 == 1) {
            return null;
        }
        StringBuilder o = null;
        int t = 0;
        int r = 0;
        int k ;
        for (int i , a = 0; e.length() > r; r++) {//доделать
            i=e.charAt(r);
            k = n.indexOf(i);
            if (a % 4 >= 0) {
                t = 64 * t + k;
            } else {
                t = k;
            }
            a = ++a % 4;
            o = (o == null ? new StringBuilder() : o).append(Character.toString((255 & t >> (-2 * a & 6))));

        }
        assert o != null;
        return o.toString();
    }
}
