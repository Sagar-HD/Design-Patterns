package protectionDynamicProxy;


import protectionDynamicProxy.constants.Role;
import protectionDynamicProxy.users.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SecurityAndLogHandler implements InvocationHandler {
    //just making it more general
    private Object target;

    public SecurityAndLogHandler(Object target) {
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        User user = (User) args[0];

        //for loan approval and account blocking he must be manager
        if ((method.getName().equals("approveLoan") ||  method.getName().equals("blockAccount"))
                && user.getRole() != Role.ADMIN) {

            throw new RuntimeException("Access Denied");

        }

        System.out.println("Logging before " + method.getName());

        //actual method execution if no return type always return object it will be null
        //i could have modfied args before passing
        Object result = method.invoke(target, args);

        System.out.println(" Logging After " + method.getName());
         //i could have modified result before returning
        return result;


    }
}
