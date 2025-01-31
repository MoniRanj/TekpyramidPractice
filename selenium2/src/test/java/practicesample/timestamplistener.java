package practicesample;

import java.util.Date;

public class timestamplistener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String time=new Date().toString().replace(" ","_").replace(":","_");
		System.out.println(time);
				
	}

}
