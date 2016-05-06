package com.berryjam.alibaba;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjinkun.
 * @date 16/4/20
 * @time 下午7:59
 */
interface AccountsTransfer {

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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId='" + userId + '\'' +
                ", balance=" + balance +
                '}';
    }
}

class AlibabaAccountsTransfer implements AccountsTransfer {
    protected static final Log log = LogFactory.getLog(AccountsTransfer.class);

    @Transactional
    public boolean transferAccount(Account fromAccount, Account toAccount, double money) {
        if (money > fromAccount.balance) {
            log.warn("余额不足");
            return false;
        } else {
            try {
                fromAccount.balance -= money;
                toAccount.balance += money;
                log.info("转账成功!转账金额:" + money + "." + fromAccount + ";" + toAccount);
            } catch (Exception e) {
                log.error("转账失败，事务回滚", e);
                return false;
            }
            return true;
        }
    }
}

class AlibabaProxyAccountsTranser implements AccountsTransfer {
    protected static final Log log = LogFactory.getLog(AccountsTransfer.class);

    private AccountsTransfer accountsTransfer = new AlibabaAccountsTransfer();

    Map<String, Account> map = new HashMap<String, Account>();

    @Transactional
    public boolean transferAccount(Account fromAccount, Account toAccount, double money) {
        Account proxyAccount = map.get(fromAccount.userId);
        try {
            if (accountsTransfer.transferAccount(fromAccount, proxyAccount, money)) {
                // saveHistory 记账
                if (accountsTransfer.transferAccount(proxyAccount, toAccount, money)) {
                    // saveHistory 记账
                    log.info("转账成功!转账金额:" + money + "." + fromAccount + ";" + toAccount);
                    return true;
                }
            } else {
                log.warn("转账失败，余额不足!");
            }
        } catch (Exception e) {
            log.error("转账失败", e);
        }
        return false;
    }
}

public class TransferAccountApp {

    public static void main(String[] args) {
        AccountsTransfer accountsTransfer = new AlibabaAccountsTransfer();
        Account xiaoHuang = new Account("xiaoHuang");
        xiaoHuang.setBalance(100);
        Account laoHuang = new Account("laoHuang");
        laoHuang.setBalance(200);
//        accountsTransfer.transferAccount(xiaoHuang, laoHuang, 50);
        AccountsTransfer accountsProxyTransfer = new AlibabaProxyAccountsTranser();
        accountsProxyTransfer.transferAccount(xiaoHuang, laoHuang, 200);
    }
}