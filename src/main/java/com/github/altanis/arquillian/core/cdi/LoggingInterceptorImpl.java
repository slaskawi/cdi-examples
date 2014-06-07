package com.github.altanis.arquillian.core.cdi;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@LoggingInterceptor
public class LoggingInterceptorImpl {

    public static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getCanonicalName());

    @AroundInvoke
    public Object invoke(InvocationContext ctx) throws Exception {
        logger.info("Invoking method " + ctx.getMethod().getName());
        return ctx.proceed();
    }

}
