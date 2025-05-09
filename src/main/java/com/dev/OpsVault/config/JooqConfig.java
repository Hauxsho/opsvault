package com.dev.OpsVault.config;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqConfig
{
	@Autowired
	private DataSource dataSource;

	@Bean
	public DSLContext dslContext()
	{
		return DSL.using(
			new DefaultConfiguration()
				.derive(dataSource)
				.derive(SQLDialect.POSTGRES)
		);
	}
}
