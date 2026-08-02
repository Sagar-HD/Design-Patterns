package protectionDynamicProxy;

import protectionDynamicProxy.BankAccount.Account;
import protectionDynamicProxy.BankAccount.BankAccountImpl;
import protectionDynamicProxy.users.AccountHolder;
import protectionDynamicProxy.users.BankManager;
import protectionDynamicProxy.users.User;

import java.lang.reflect.Proxy;

public class Test {

    public static Account getProxyFactory(Account account){

        return (Account) Proxy.newProxyInstance(
                Account.class.getClassLoader(),
                new Class[]{Account.class},
                new SecurityAndLogHandler(account)
        );

    }


    public static void main(String[] args) {
        Account account= new BankAccountImpl(100);

        BankManager bankManager = new BankManager("Sagar");
        AccountHolder accountHolder=new AccountHolder("Ram");

        //created proxy account
        Account proxyAccount = getProxyFactory(account);

        //calling methods for bank manager
        proxyAccount.withdraw(bankManager, 100);
        proxyAccount.deposit(bankManager,100);
        proxyAccount.approveLoan(bankManager);
        proxyAccount.blockAccount(bankManager);


        //calling method for account holder
        proxyAccount.withdraw(accountHolder, 100);
        proxyAccount.deposit(accountHolder,100);
        proxyAccount.approveLoan(accountHolder);
        proxyAccount.blockAccount(accountHolder);







    }
}
