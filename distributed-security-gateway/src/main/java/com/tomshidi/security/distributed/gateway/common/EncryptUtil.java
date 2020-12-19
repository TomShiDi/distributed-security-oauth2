package com.tomshidi.security.distributed.gateway.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


/**
 * @author TomShiDi
 * @description
 * @date 2020/12/19 17:15
 **/
public class EncryptUtil {
    private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    public static String encodeBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] decodeBase64(String str) {
        return Base64.getDecoder().decode(str);
    }

    /**
     * Base64 encode 转换成成UTF8编码的字符串
     * @param str 待转换字符串
     * @return 转换结果
     */
    public static String encodeUTF8StringBase64(String str) {
        String utf8Str = null;
        try {
            utf8Str = new String(Base64.getEncoder().encode(str.getBytes(StandardCharsets.UTF_8)),
                    StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            logger.error("Base64转换错误: ", e);
        }
        return utf8Str;
    }

    /**
     * Base64 decode 解析成UTF8编码的字符串
     * @param str 待转换字符串
     * @return 解析结果
     */
    public static String decodeUTF8StringBase64(String str) {
        String utf8Str = null;
        try {
            utf8Str = new String(Base64.getDecoder().decode(str.getBytes(StandardCharsets.UTF_8)),
                    StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            logger.error("Base64转换错误: ", e);
        }
        return utf8Str;
    }
}
