package br.com.arthurhenriqu3.config;

import org.slf4j.LoggerFactory;

public class SystemConfiguration {

	public static void registerLogInfo(Class<?> className, String str) {
		LoggerFactory.getLogger(className).info(str);
	}

	public static void registerLogWarm(Class<?> className, String str) {
		LoggerFactory.getLogger(className).info(str);
	}

	public static void registerLogError(Class<?> className, String str) {
		LoggerFactory.getLogger(className).error(str);
	}
}