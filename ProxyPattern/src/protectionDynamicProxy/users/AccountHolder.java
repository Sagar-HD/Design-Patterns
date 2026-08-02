package protectionDynamicProxy.users;

import protectionDynamicProxy.constants.Role;

public class AccountHolder implements  User{
    String name;
    Role role;
    public AccountHolder(String name) {
        this.name = name;
        this.role = Role.USER;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Role getRole() {
        return role;
    }
}
