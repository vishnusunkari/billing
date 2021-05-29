package com.nic.billing.xray;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@ConditionalOnProperty(
		value = "AWS_XRAY_ENABLED",
		havingValue = "true",
		matchIfMissing = false)
@Configuration
public class AwsXrayConfig {

	@Bean
	public Filter TracingFilter() {
		return new AWSXRayServletFilter("billing");

	}
}