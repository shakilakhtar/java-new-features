package com.test.javanew.concurrency.stampedlock;

import java.util.*;
import java.util.concurrent.locks.*;

public class IncomeTaxDept {
    private List<TaxPayer> taxPayersList;
    private double totalRevenue;
    private final StampedLock sl = new StampedLock();

    public IncomeTaxDept(long revenue, int numberOfTaxPayers) {
        this.totalRevenue = revenue;
        taxPayersList = new ArrayList<TaxPayer>(numberOfTaxPayers);
    }

    /**
     * This method is to show the feature of writeLock() method
     */
    public void payTax(TaxPayer taxPayer) {
        double taxAmount = taxPayer.getTaxAmount();
        long stamp = sl.writeLock();
        try {
            totalRevenue += taxAmount;
            System.out.println(taxPayer.getTaxPayerName() + " paid tax, now Total Revenue --->>> " + this.totalRevenue);
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    /**
     * This method is to show the feature of writeLock() method
     */
    public double getFederalTaxReturn(TaxPayer taxPayer) {
        double incomeTaxRetunAmount = taxPayer.getTaxAmount() * 10 / 100;
        long stamp = sl.writeLock();
        try {
            this.totalRevenue -= incomeTaxRetunAmount;
        } finally {
            sl.unlockWrite(stamp);
        }
        return incomeTaxRetunAmount;
    }

    /**
     * This method is to show the feature of readLock() method
     */
    public double getTotalRevenue() {
        long stamp = sl.readLock();
        try {
            return this.totalRevenue;
        } finally {
            sl.unlockRead(stamp);
        }
    }

    /**
     * This method is to show the feature of tryOptimisticRead() method
     */
    public double getTotalRevenueOptimisticRead() {
        long stamp = sl.tryOptimisticRead();
        double balance = this.totalRevenue;
        //calling validate(stamp) method to ensure that stamp is valid, if not then acquiring the read lock
        if (!sl.validate(stamp)) {
            System.out.println("stamp for tryOptimisticRead() is not valid now, so acquiring the read lock");
            stamp = sl.readLock();
        }
        try {
            balance = this.totalRevenue;
        } finally {
            sl.unlockRead(stamp);
        }
        return balance;
    }

    /**
     * This method is to show the feature of tryConvertToWriteLock() method
     */
    public double getStateTaxReturnUisngConvertToWriteLock(TaxPayer taxPayer) {
        double incomeTaxRetunAmount = taxPayer.getTaxAmount() * 5 / 100;
        long stamp = sl.readLock();
        //Trying to upgrade the lock from read to write
        stamp = sl.tryConvertToWriteLock(stamp);
        //Checking if tryConvertToWriteLock got success otherwise call writeLock method
        if (stamp == 0L) {
            System.out.println("stamp is zero for tryConvertToWriteLock(), so acquiring the write lock");
            stamp = sl.writeLock();
        }
        try {
            this.totalRevenue -= incomeTaxRetunAmount;
        } finally {
            sl.unlockWrite(stamp);
        }
        return incomeTaxRetunAmount;
    }

    public void registerTaxPayer(TaxPayer taxPayer) {
        taxPayersList.add(taxPayer);
    }

    public List<TaxPayer> getTaxPayersList() {
        return taxPayersList;
    }
}
