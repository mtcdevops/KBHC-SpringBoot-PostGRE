package com.example.demo.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class RoutingDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() { // (1)
		String result = (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) ? "slave" : "master";
//		System.out.println(result);
		return result;
	}
}