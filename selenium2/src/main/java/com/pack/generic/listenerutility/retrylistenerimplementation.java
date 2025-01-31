package com.pack.generic.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retrylistenerimplementation implements IRetryAnalyzer {

	int count=0;
	int limcount=5;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<limcount)
		{
			count++;
			return true;
		}
		return false;
	}

}
