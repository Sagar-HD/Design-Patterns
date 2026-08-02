package protectionDynamicProxy.BankAccount;

import protectionDynamicProxy.users.User;

public interface Account {
    int getBalance(User user);
    void withdraw(User user,int amount);
    void deposit(User user,int amount);
    void approveLoan(User user);
    void blockAccount(User user);

}
