package com.berryjam.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjinkun.
 * @date 16/4/20
 * @time 下午7:59
 */
public interface AccountsTransfer {

    /**
     * 转账
     *
     * @param fromAccount 转出账号
     * @param toAccount   转入账号
     * @param money       转账金额
     */
    boolean transferAccount(Account fromAccount, Account toAccount, double money);
}

class Account {
    String userId;
    double balance;

    public Account(String userId) {
        this.userId = userId;
    }
}

class AlibabaAccountsTransfer implements AccountsTransfer {

    public boolean transferAccount(Account fromAccount, Account toAccount, double money) {
        if (money > fromAccount.balance) {
            System.out.println("余额不足");
            return false;
        } else {
            fromAccount.balance -= money;
            toAccount.balance += money;
            return true;
        }
    }
}

class AlibabaProxyAccountsTranser implements AccountsTransfer {
    Map<String, Account> map = new HashMap<String, Account>();

    public boolean transferAccount(Account fromAccount, Account toAccount, double money) {
        Account proxyAccount = map.get(fromAccount.userId);
        if (transferAccount(fromAccount, proxyAccount, money)) {
            // saveHistory 记账
            if (transferAccount(proxyAccount, toAccount, money)) {
                // saveHistory 记账
                return true;
            }
        }

        return false;
    }
}