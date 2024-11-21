package com.vmware.classes;

import com.vmware.interfaces.Left;
import com.vmware.interfaces.Right;

public class Demo implements Right, Left {

	

	public static void main(String[] args) {
		Demo d=new Demo();
		d.add();
		d.sub();
	}
}
