Feature: Cadastro de Cliente
	Scenario: Cadastrar Cliente
		Given Eu acesso o site da Americas
		When Eu clico em cadastrese e clico em Cadastrar e preencho email "marcelanicoleevelynmonteiro_@engineer.com" e preencho senha "XDIXDmajyy" e preencho cpf "82904051384" e preencho nome "Marcela Nicole Evelyn Monteiro" e preencho data de nascimento "02041980" e clico em sexo Feminino e preencho telefone "8228682008"
		And E clico em criar seu cadastro		
		Then Eu acesso a pagina da Americanas com meu cadastro
