Feature: Login no site Americanas
	Scenario: Login de Usuario
		Given Eu acesso o site da Americanas
		When Eu clico em cadastrese e clico em Entrar e preencho o email "adrianateresinhamarlenedasneves-77@iname.com" e preencho a senha "MUwMAdISaB"
		And Eu clico em continuar 
		Then Eu acesso a pagina da Americanas com meu login
