package com.zzxx.exam.test;

import com.zzxx.exam.util.Config;

public class ConfigTest {
	public static void main(String[] args) {
		Config config = new Config("config.properties");
		int timeLimit = config.getInt("TimeLimit");
		System.out.println(timeLimit);
	}
}
