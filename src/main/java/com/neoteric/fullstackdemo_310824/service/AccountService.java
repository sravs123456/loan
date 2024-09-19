package com.neoteric.fullstackdemo_310824.service;

import com.neoteric.fullstackdemo_310824.exception.AccountCreationFailedException;
import com.neoteric.fullstackdemo_310824.model.Account;
import com.neoteric.fullstackdemo_310824.model.AccountAddressEntity;
import com.neoteric.fullstackdemo_310824.model.AccountEntity;
import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.swing.UIManager.get;

public class AccountService {

    public Account searchAccount(String accountnumber){
        SessionFactory sessionFactory= HibernateUtils.getSessionFactory();
        Session session=sessionFactory.openSession();
       // session.get(accountnumber.AccountEntity.class);
        Query<AccountEntity> query=session.createQuery("From AccountEntity a where a accountNumber=:inputAccountNuber");
        query.setParameter("inputAccountNumber",accountnumber);
        AccountEntity accountEntity=  query.list().get(0);
        return null;
    }

    public String oneToManyUsingUI(Account account) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber(UUID.randomUUID().toString());
        accountEntity.setName(account.getName());
        accountEntity.setPan(account.getPan());
        accountEntity.setBalance(account.getBalance());
        accountEntity.setMobileNumber(account.getMobileNum());

        List<AccountAddressEntity>accountAddressEntities=new ArrayList<>();
        AccountAddressEntity accountAddressEntity=new AccountAddressEntity();
        accountAddressEntity.setAddress1(account.getAddress().getAddress1());
        accountAddressEntity.setAddress2(account.getAddress().getAddress2());
        accountAddressEntity.setCity(account.getAddress().getCity());
        accountAddressEntity.setState(account.getAddress().getState());
        accountAddressEntity.setPincode(account.getAddress().getPincode());
        accountAddressEntity.setStatus(1);
        accountAddressEntity.setAccountEntity(accountEntity);

        accountAddressEntities.add(accountAddressEntity);
        accountEntity.setAccountAddressEntities(accountAddressEntities);
        session.persist(accountEntity);
        transaction.commit();
        return accountEntity.getAccountNumber();
    }

    public String createAccountUsingHibernate(Account account) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber(UUID.randomUUID().toString());
        accountEntity.setName(account.getName());
        accountEntity.setPan(account.getPan());
        accountEntity.setBalance(account.getBalance());
        accountEntity.setMobileNumber(account.getMobileNum());

        session.persist(accountEntity);
        transaction.commit();
        return accountEntity.getAccountNumber();
    }

    public String createAccount(Account account)  {
        String accountNumber = null;
        try {
            Connection connection = DBConnection.getConnection();
            Statement stmt = connection.createStatement();
            accountNumber = UUID.randomUUID().toString();

            String query = "insert into bank.account value (" + "'" + accountNumber + "'" + "," +
                    "'" + account.getName() + "'" + "," +
                    "'" + account.getPan() + "'" + "," +
                    "'" + account.getMobileNum() + "'" + "," +
                    account.getBalance() + ")";

            int status = stmt.executeUpdate(query);

            if (status == 1) {

                System.out.println("Account is created" + accountNumber);
            } else {

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in sql exception" + e);
        }
        catch (AccountCreationFailedException e){
            System.out.println("Exception"+e);
            throw e;
        }
        return accountNumber;
    }
}