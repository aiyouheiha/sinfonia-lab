# Spring Boot Interceptor

## 1. implements HandlerInterceptor

```
@Component
public class TestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
            throws Exception {
        System.out.println("TestInterceptor ... ...");
        response.setHeader("Sinfonia-Lab-Test", "TESTED");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, 
                           Object handler, ModelAndView modelAndView) 
            throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
                                Object handler, Exception ex) 
            throws Exception {

    }
}
```

## 2. extends WebMvcConfigurerAdapter addInterceptors

```
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private TestInterceptor testInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(testInterceptor);
    }
}
```