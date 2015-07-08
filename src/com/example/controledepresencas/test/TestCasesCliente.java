package com.example.controledepresencas.test;

import com.example.controledepresencas.ActivityAlunoConsPresencas;
import com.example.controledepresencas.ActivityAula;
import com.example.controledepresencas.ActivityLogin;
import com.example.controledepresencas.ActivityPrincipal;
import com.example.controledepresencas.ActivityProfConsAlunoTurma;
import com.example.controledepresencas.ActivityRelatorioFinalAula;
import com.example.controledepresencas.fsm.*;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.Spinner;

public class TestCasesCliente extends
		ActivityInstrumentationTestCase2<ActivityLogin> {

	private Solo solo;
	private FSMCliente fsmCliente;
	
	@SuppressWarnings("deprecation")
	public TestCasesCliente() {
		super("com.example.controledepresencas", ActivityLogin.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
		fsmCliente = new FSMCliente();
	}
	
	//H013 H014
	public void testLogarValidoUsuarioProfessor(){
		String userName = "Eliane";
		String pass = "12345";
		
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());
		
			solo.assertCurrentActivity("Tela de Login", ActivityLogin.class);
			
			solo.clickOnEditText(0);
			solo.enterText(0,userName);
			
			solo.clickOnEditText(1);
			solo.enterText(1,pass);
			
			solo.clickOnButton(0);
			
			solo.waitForActivity(ActivityPrincipal.class);
		fsmCliente.loginServidor();
		assertEquals(true, fsmCliente.getState() == StatesCliente.logado.toString());
			solo.clickOnImageButton(0);
		fsmCliente.efetuarLogout();
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());		
	}
	
	//H011 H012
	public void testLogarValidoUsuarioAluno(){
		String userName = "Joao";
		String pass = "12345";
		
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());
		
			solo.assertCurrentActivity("Tela de Login", ActivityLogin.class);
			
			solo.clickOnEditText(0);
			solo.enterText(0,userName);
			
			solo.clickOnEditText(1);
			solo.enterText(1,pass);
			
			solo.clickOnButton(0);
			
			solo.waitForActivity(ActivityPrincipal.class);
		fsmCliente.loginServidor();
		assertEquals(true, fsmCliente.getState() == StatesCliente.logado.toString());
			solo.clickOnImageButton(0);
		fsmCliente.efetuarLogout();
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());		
	}
	
	//H011, H013
	public void testLogarInvalidoUsuario(){
		String userName = "Eliane";
		String pass = "54321";
		
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());
			
			solo.assertCurrentActivity("Tela de Login", ActivityLogin.class);
			
			solo.clickOnEditText(0);
			solo.enterText(0,userName);
			
			solo.clickOnEditText(1);
			solo.enterText(1,pass);
			
			solo.clickOnButton(0);
			
			solo.assertCurrentActivity("Tela de Login", ActivityLogin.class);
		fsmCliente.loginInvalido();
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());			
	}
	
	//H017
	public void testAlunoConsultaPresencaTurma(){
		String userName = "Joao";
		String pass = "12345";
		
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());
		
			solo.assertCurrentActivity("Tela de Login", ActivityLogin.class);
			
			solo.clickOnEditText(0);
			solo.enterText(0,userName);
			
			solo.clickOnEditText(1);
			solo.enterText(1,pass);
			
			solo.clickOnButton(0);
			
			solo.waitForActivity(ActivityPrincipal.class);
		fsmCliente.loginServidor();
		assertEquals(true, fsmCliente.getState() == StatesCliente.logado.toString());
			
			solo.clickOnButton(1);
			solo.waitForActivity(ActivityAlunoConsPresencas.class);
		
		fsmCliente.verificarPresencas();
		assertEquals(true, fsmCliente.getState() == StatesCliente.verificandoPresenca.toString());
		
			solo.goBack();
			solo.waitForActivity(ActivityPrincipal.class);
		
		fsmCliente.sairVerificacaoPresencas();	
		assertEquals(true, fsmCliente.getState() == StatesCliente.logado.toString());
		
			solo.clickOnImageButton(0);
		fsmCliente.efetuarLogout();
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());	
	}
	
	//H015
	public void testProfessorConsultaPresencaAlunoTurmas(){
		String userName = "Eliane";
		String pass = "12345";
		
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());
		
			solo.assertCurrentActivity("Tela de Login", ActivityLogin.class);
			
			solo.clickOnEditText(0);
			solo.enterText(0,userName);
			
			solo.clickOnEditText(1);
			solo.enterText(1,pass);
			
			solo.clickOnButton(0);
			
			solo.waitForActivity(ActivityPrincipal.class);
		fsmCliente.loginServidor();
		assertEquals(true, fsmCliente.getState() == StatesCliente.logado.toString());
			
			solo.clickOnButton(1);
			solo.waitForActivity(ActivityProfConsAlunoTurma.class);
		
		fsmCliente.verificarPresencas();
		assertEquals(true, fsmCliente.getState() == StatesCliente.verificandoPresenca.toString());
			
			int i = 1;
			while(!solo.isSpinnerTextSelected("Joao Luis")){
				i++;
				solo.pressSpinnerItem(0, i);
			}
			solo.sleep(5000);
			solo.goBack();
			solo.waitForActivity(ActivityPrincipal.class);
		
		fsmCliente.sairVerificacaoPresencas();	
		assertEquals(true, fsmCliente.getState() == StatesCliente.logado.toString());
		
			solo.clickOnImageButton(0);
			
		fsmCliente.efetuarLogout();
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());
	}
	
	//H004, H005, H009, H019, H023 
	public void testEntrarSairAulaProfessor(){
		String userName = "Eliane";
		String pass = "12345";
		
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());
		
			solo.assertCurrentActivity("Tela de Login", ActivityLogin.class);
			
			solo.clickOnEditText(0);
			solo.enterText(0,userName);
			
			solo.clickOnEditText(1);
			solo.enterText(1,pass);
			
			solo.clickOnButton(0);
			
			solo.waitForActivity(ActivityPrincipal.class);
		fsmCliente.loginServidor();
		assertEquals(true, fsmCliente.getState() == StatesCliente.logado.toString());
			
			solo.clickOnButton(0);
			solo.waitForActivity(ActivityAula.class);
			
		fsmCliente.entrarEmAula();
		assertEquals(true, fsmCliente.getState() == StatesCliente.emAula.toString());
			
			solo.sleep(5000);
			solo.clickOnButton(0);
			solo.waitForActivity(ActivityRelatorioFinalAula.class);
			
		fsmCliente.profFechaAula();
		assertEquals(true, fsmCliente.getState() == StatesCliente.visualizandoNotificacao.toString());
		
			solo.goBack();
			solo.waitForActivity(ActivityPrincipal.class);
		
		fsmCliente.sairNotificacao();			
		assertEquals(true, fsmCliente.getState() == StatesCliente.logado.toString());
		
			solo.clickOnImageButton(0);
			
		fsmCliente.efetuarLogout();
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());
	}
	
	//H006, H008, H022
	public void testEntrarSairAulaAluno(){
		String userName = "Joao";
		String pass = "12345";
		
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());
		
			solo.assertCurrentActivity("Tela de Login", ActivityLogin.class);
			
			solo.clickOnEditText(0);
			solo.enterText(0,userName);
			
			solo.clickOnEditText(1);
			solo.enterText(1,pass);
			
			solo.clickOnButton(0);
			
			solo.waitForActivity(ActivityPrincipal.class);
		fsmCliente.loginServidor();
		assertEquals(true, fsmCliente.getState() == StatesCliente.logado.toString());
			
			solo.clickOnButton(2);
			
			solo.clickOnButton(0);
			
			solo.waitForActivity(ActivityAula.class);
			
		fsmCliente.entrarEmAula();
		assertEquals(true, fsmCliente.getState() == StatesCliente.emAula.toString());
			
			solo.sleep(5000);
			solo.clickOnButton(0);
			solo.waitForActivity(ActivityPrincipal.class);
			
		fsmCliente.profFechaAula();
		assertEquals(true, fsmCliente.getState() == StatesCliente.visualizandoNotificacao.toString());
		fsmCliente.sairNotificacao();			
		assertEquals(true, fsmCliente.getState() == StatesCliente.logado.toString());

			solo.clickOnImageButton(0);
			
		fsmCliente.efetuarLogout();
		assertEquals(true, fsmCliente.getState() == StatesCliente.inativo.toString());
	}
	
}
