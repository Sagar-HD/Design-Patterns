package protectionDynamicProxy.users;

import protectionDynamicProxy.constants.Role;


public class BankManager implements User {
    String name;
    private Role role;
     public BankManager(String name) {
        this.name = name;
        this.role = Role.ADMIN;
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
