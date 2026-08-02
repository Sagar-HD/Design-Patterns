package protectionDynamicProxy.BankAccount;

import protectionDynamicProxy.users.User;

public class BankAccountImpl implements Account{
    private int balance;
    private boolean isBlocked;
    private boolean isLoanApproved;

    public BankAccountImpl(int balance) {
        this.balance = balance;
    }
    public BankAccountImpl() {
        this.balance =0;
    }

    @Override
    public int getBalance(User user) {
        return balance;
    }

    @Override
    public void withdraw(User user,int amount) {
        balance-=amount;
        System.out.println("withdraw sucess");

    }

    @Override
    public void deposit(User user,int amount) {
        balance+=amount;
        System.out.println("deposit sucess");

    }

    @Override
    public void approveLoan(User user) {
        isLoanApproved=true;
        System.out.println("Loan approved");

    }

    @Override
    public void blockAccount(User user) {
        isBlocked=true;
        System.out.println("Account blocked");

    }
}
