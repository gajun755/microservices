package com.lti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDbConfiguration {

	
		@Bean
		public DynamoDBMapper dynamoDBMapper() {
			return new DynamoDBMapper(buildAmazonDynamoDB());
		}
	
		private AmazonDynamoDB buildAmazonDynamoDB() {
			return AmazonDynamoDBClientBuilder
					.standard()
					.withEndpointConfiguration(
							new AwsClientBuilder.EndpointConfiguration(
							"dynamodb.eu-north-1.amazonaws.com","eu-north-1"
							)
							).withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIAVNUZ3TBWPOPHYWUZ", "4CVrzDlA1qGRbYC4lHWQkCswZ7BDuJNhC/M25Oyb"))).build();
		}
}
