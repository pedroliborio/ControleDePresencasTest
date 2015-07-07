package com.example.controledepresencas.fsm;

public class FSMCliente {

		// Estados{inativo, logado}
		private String state;
		

		public FSMCliente() {
			this.state = StatesCliente.inativo.toString();
		}

		public String getState() {
			return String.valueOf(state);
		}

		public void setState(String parm) {
			this.state = parm;
		}


		public void reset(boolean bln) {
			state = StatesCliente.inativo.toString();
		}

		// Condição de Guarda
		// "Para efetuar o login o Aluno deve estar inativo"
		public boolean loginServidorGuard() {

			return state.equals(StatesCliente.inativo.toString());

		}

		// H11
		// "Após logar o aluno passa pro estado logado"
		public 
		void loginServidor() {
			System.out.println("loginServidor: " + state + " --> "
					+ StatesCliente.logado.toString());
			state = StatesCliente.logado.toString();
		}

		// Condição de guarda
		// "Para efetuar logout precisa estar logado"
		public boolean loginInvalidoGuard() {
			return state.equals(StatesCliente.inativo.toString());
		}

		// H11
		// "Qdo digitar um login inválido, o cliente fica inativo"
		public 
		void loginInvalido() {
			System.out.println("loginInvalido: " + state + " --> "
					+ StatesCliente.inativo.toString());
					state = StatesCliente.inativo.toString();
		}
				
		// Condição de guarda
		// "Para efetuar logout precisa estar logado"
		public boolean efetuarLogoutGuard() {
			return state.equals(StatesCliente.logado.toString());
		}

		// H12
		// "Após efetuar logout o aluno fica em estado inativo."
		public 
		void efetuarLogout() {
			System.out.println("efetuarLogout: " + state + " --> "
					+ StatesCliente.inativo.toString());
			state = StatesCliente.inativo.toString();
		}
		
		// Condição de guarda
		// "Para entrar em aula, o aluno tem que estar logado"
		public boolean entrarEmAulaGuard() {
			return state.equals(StatesCliente.logado.toString());
		}

		// H06
		// "O aluno vai para o estado emAula quando seleciona uma sessão."
		public 
		void entrarEmAula() {
			System.out.println("entrarEmAula: " + state + " --> "
					+ StatesCliente.emAula.toString());
			state = StatesCliente.emAula.toString();

		}

		// Condição de guarda
		// "Para verificar sua lista de presença, o aluno tem que estar logado"
		public boolean verificarPresencasGuard() {
			return state.equals(StatesCliente.logado.toString());
		}
		
		// H17
		// "O aluno consulta a quantidade das suas presenças na turma."
		public 
		void verificarPresencas() {
			System.out.println("verificacaoPresencas: " + state + " --> "
					+ StatesCliente.verificandoPresenca.toString());
			state = StatesCliente.verificandoPresenca.toString();

		}
		
		// Condição de guarda
		// "Ao sair da verificação das presenças, o aluno retorna ao estado Logado"		
		public boolean sairVerificacaoPresencasGuard() {
			return state.equals(StatesCliente.verificandoPresenca.toString());
		}

		// H17
		// "O aluno finaliza a consulta a suas presenças."
		public 
		void sairVerificacaoPresencas() {
			System.out.println("verificacaoPresencas: " + state + " --> "
					+ StatesCliente.logado.toString());
			state = StatesCliente.logado.toString();

		}		
		
		
		// Condição de guarda
		// "O aluno encontra problema ao tentar entrar em aula (permance logado)"		
		public boolean failEntrarEmAulaGuard() {
			return state.equals(StatesCliente.logado.toString());
		}

		// H06
		// "O aluno não consegue entrar em aula por falha do servidor ou qq outro problema"		
		public 
		void failEntrarEmAula() {
			System.out.println("FailEntrarEmAula: " + state + " --> "
					+ StatesCliente.logado.toString());
			state = StatesCliente.logado.toString();

		}
		
		// Condição de guarda
		// "Ao sair da verificação das presenças (emAula), o aluno retorna ao estado Logado"		
		public boolean faillogoutAulaGuard() {
			return state.equals(StatesCliente.emAula.toString());
		}

		//Falha ao tentar sair da aula.
		public 
		void faillogoutAula() {
			System.out.println("faillogoutAula: " + state + " --> "
					+ StatesCliente.emAula.toString());
			state = StatesCliente.emAula.toString();

		}
		
		// Condição de guarda
		// "O aluno permanece em aula e enviando tick ao servidor para validar presença"			
		public boolean enviarTicketGuard() {
			return state.equals(StatesCliente.emAula.toString());
		}

		// H08
		// "Enquanto em aula, o aluno fica enviando tick para registrar presença"		
		public 
		void enviarTicket() {
			System.out.println("enviarTicket: " + state + " --> "
					+ StatesCliente.emAula.toString());
			state = StatesCliente.emAula.toString();
		}		

		/*
		// Condição de guarda
		// "O aluno sai do estado emAula para logado quando sair da aula"			
		public boolean sairdaAulaGuard() {
			return state.equals(StatesCliente.recebendoNotificacao.toString());
		}

		// O aluno pode sair da aula a qualquer momento.
		public 
		void sairdaAula() {
			System.out.println("sairdaAula: " + state + " --> "
					+ StatesCliente.logado.toString());
			state = StatesCliente.logado.toString();

		}
		*/
		
		// Condição de guarda
		// "O professor fecha a sessão da aula (emAula -> visualizandoNotificacao)"			
		public boolean profFechaAulaGuard() {
			return state.equals(StatesCliente.emAula.toString());
		}

		// H22
		// O aluno recebe notificacao ao sair da aula.
		public 
		void profFechaAula() {
			System.out.println("profFechaAula: " + state + " --> "
					+ StatesCliente.visualizandoNotificacao.toString());
			state = StatesCliente.visualizandoNotificacao.toString();

		}
		
		// Condição de guarda
		// "Aluno vê a notificação e sai da aula"     
		public boolean sairNotificacaoGuard() {
			return state.equals(StatesCliente.visualizandoNotificacao.toString());
		}

		// H22	
		public 
		void sairNotificacao() {
			System.out.println("sairNotificacao: " + state + " --> "
					+ StatesCliente.logado.toString());
			state = StatesCliente.logado.toString();
		}
		
}
