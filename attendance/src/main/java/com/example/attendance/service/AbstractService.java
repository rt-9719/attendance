package com.example.attendance.service;

import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Service;

import jp.co.future.uroborosql.UroboroSQL;
import jp.co.future.uroborosql.config.SqlConfig;
import jp.co.future.uroborosql.connection.DataSourceConnectionSupplierImpl;

@Service
public class AbstractService {

	// MySQLデータベースの接続設定
	DataSource dataSource = createDataSource(); // データソースの作成
	
	SqlConfig sqlConfig = UroboroSQL.builder(dataSource)
	        .setConnectionSupplier(new DataSourceConnectionSupplierImpl(dataSource))
	        .build();
	
	// データソースの設定
	private DataSource createDataSource() {
		ResourceBundle rb = ResourceBundle.getBundle("application");
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setUrl(rb.getString("spring.datasource.url"));
	    dataSource.setUsername(rb.getString("spring.datasource.username"));
	    dataSource.setPassword(rb.getString("spring.datasource.password"));
	    return dataSource;
	}
}
