package com.tomshidi.security.distributed.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.tomshidi.security.distributed.gateway.common.EncryptUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * token转发
 *
 * @author TomShiDi
 * @description
 * @date 2020/12/19 16:48
 **/
public class AuthFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        /**
         * 获取jwt令牌内容
         */
        RequestContext requestContext = RequestContext.getCurrentContext();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof OAuth2Authentication)) {
            // 无token访问网关内资源的情况
            return null;
        }
        OAuth2Authentication oauth2Authentication = (OAuth2Authentication) authentication;

        Authentication userAuthentication = oauth2Authentication.getUserAuthentication();
        if (userAuthentication != null) {
            Object principal = userAuthentication.getName();
            /**
             * 组装明文token，转发给微服务，放入header，名称为json-token
             */
            List<String> authorities = userAuthentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
            OAuth2Request oAuth2Request = oauth2Authentication.getOAuth2Request();
            Map<String, String> requestParameters = oAuth2Request.getRequestParameters();
            Map<String, Object> jsonToken = new HashMap<>(requestParameters);

            jsonToken.put("principal", principal);
            jsonToken.put("authorities", authorities);
            requestContext.addZuulRequestHeader("json-token",
                    EncryptUtil.encodeUTF8StringBase64(JSON.toJSONString(jsonToken)));
        }

        return null;
    }


    @Override
    public boolean isStaticFilter() {
        return super.isStaticFilter();
    }

    @Override
    public String disablePropertyName() {
        return super.disablePropertyName();
    }

    @Override
    public boolean isFilterDisabled() {
        return super.isFilterDisabled();
    }

    @Override
    public ZuulFilterResult runFilter() {
        return super.runFilter();
    }

    @Override
    public int compareTo(ZuulFilter filter) {
        return super.compareTo(filter);
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
