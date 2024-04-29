package com.study.common.interceptor;

import com.study.common.exception.CommonException;
import com.study.common.exception.CommonErrorCode;
import com.study.common.holder.UserIdHolder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import static com.study.common.utils.Constant.X_USER_ID;

public class CustomHeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getHeader(X_USER_ID);
        if (!StringUtils.hasText(userId)) {
            throw new CommonException(CommonErrorCode.TEST_EXCEPTION);
        }

        UserIdHolder.setUserId(Long.valueOf(userId));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserIdHolder.removeUserId();
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
