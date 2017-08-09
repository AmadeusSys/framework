package permission;


import component.tool.ResponseData;
import component.tool.XMException;
import component.tool.YTEncryptionTool;
import data.model.data.object.UserInfoDO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import permission.service.DDService;
import permission.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tongyang on 2017/4/26.
 */
@Aspect
@Component
public class AopInterceptor {


    private static final Logger logger = LoggerFactory.getLogger(AopInterceptor.class);

    @Autowired
    private YTEncryptionTool ytEncryptionTool;

    @Autowired
    LoginService loginService;

    @Autowired
    DDService ddService;

    @Autowired
    ApplicationContext applicationContext;

    /**
     * 拦截接口控制器
     */
    @Pointcut("execution(public * com.xiangmaikeji..*(..) ) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void interceptRequestMapping(){}


    @Around("interceptRequestMapping()")
    public Object serviceAround(ProceedingJoinPoint pjp) throws Throwable{

        HttpServletRequest request = this.gethttpServletRequest(pjp);

        loginService.paseSign(request);

        this.writeUserInfo(request);

        Object object = pjp.proceed();

        return  ResponseData.initSuccess(object);

    }

    private void writeUserInfo(HttpServletRequest httpServletRequest) throws XMException {

        String uri = httpServletRequest.getRequestURI();

        Integer index = uri.indexOf("DDLoginService/GetToken");

        String tokenString = httpServletRequest.getParameter("appToken");

        if (index == 0 && tokenString != null){

            //获取BeanFactory
            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory)applicationContext.getAutowireCapableBeanFactory();

//创建bean信息.
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserInfoDO.class);

            beanDefinitionBuilder.addPropertyValue("user_info_name","张三");

//动态注册bean.
            defaultListableBeanFactory.registerBeanDefinition("testService",beanDefinitionBuilder.getBeanDefinition());


        }

    }

    /**
     * 通过 ProceedingJoinPoint 获取 Request并记录参数
     * @param pjp
     * @return
     */
    private HttpServletRequest gethttpServletRequest(ProceedingJoinPoint pjp){

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();

        ServletRequestAttributes sra = (ServletRequestAttributes) ra;

        HttpServletRequest request = sra.getRequest();

        logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", request.getRequestURL().toString(), request.getMethod(), request.getRequestURI(), request.getQueryString());

        return request;

    }

}
