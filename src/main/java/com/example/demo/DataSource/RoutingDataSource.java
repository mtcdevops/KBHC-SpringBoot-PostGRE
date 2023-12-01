package com.example.demo.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class RoutingDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		String result = (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) ? "slave" : "master";
		return result;
	}
}