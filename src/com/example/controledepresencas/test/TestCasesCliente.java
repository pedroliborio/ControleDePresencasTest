package com.example.controledepresencas.test;

import com.example.controledepresencas.ActivityLogin;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class TestCasesCliente extends
		ActivityInstrumentationTestCase2<ActivityLogin> {

	private Solo solo;
	
	@SuppressWarnings("deprecation")
	public TestCasesCliente() {
		super("com.example.controledepresencas", ActivityLogin.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void logarValidoUsuario(){
		
	}

}
