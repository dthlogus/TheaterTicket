package br.com.senai.principal.controle;

import br.com.senai.principal.Dao.Banco;
import br.com.senai.principal.modelo.Atracao;
import br.com.senai.principal.util.FaixaEtaria;
import br.com.senai.principal.util.Genero;
import br.com.senai.principal.util.Horario;
import br.com.senai.principal.util.Uteis;

import java.util.Scanner;

public class AtracaoControler {

    private Boolean continuar = true;
    private Integer opcao = 10000;
    private Scanner scan = new Scanner(System.in);

    public void iniciar(){
        while (continuar){
            System.out.println("Digite qual opção deseja usar");
            System.out.println("1. Cadastrar atração");
            System.out.println("2. Alterar atração");
            System.out.println("3. Deletar atração");
            System.out.println("4. Mostrar atrações");
            System.out.println("5. Mostrar Poltronas");
            System.out.println("0. Sair");
            try {
                opcao = Integer.valueOf(scan.nextLine());
            }catch(Exception e){
            }

            switch (opcao){
                case 1:
                    cadastrarAtracao(scan);
                    break;
                case 2:
                    alterarAtracao(scan);
                    break;
                case 3:
                    excluirAtracao(scan);
                    break;
                case 4:
                    mostrarTodasAsAtracoes();
                    break;
                case 5:
                    mostrarPoltrona(scan);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Foi digitado algum número que não esteja no menu, letra ou palavra, por favor, digite novamente.\n");
                    continuar = true;
                    break;
            }
        }
    }

    private void mostrarTodasAsAtracoes() {
        Banco banco = new Banco();
        banco.mostrarTodasAsAtracoes();
    }

    private void excluirAtracao(Scanner scan) {
        Integer id;
        Banco banco = new Banco();
        Atracao atracao;
        System.out.println("Qual o ID do cliente que deseja excluir?");
        id = Integer.valueOf(scan.nextLine());
        atracao = banco.buscarAtracaoPorId(id);
        if (!Uteis.validarId(atracao)){
            return;
        }
        banco.excluirAtracao(atracao);
    }

    private void alterarAtracao(Scanner scan) {
        Integer id;
        Banco banco = new Banco();
        Atracao atracao;
        System.out.println("Qual o ID do cliente que deseja alterar?");
        id = Integer.valueOf(scan.nextLine());
        atracao = banco.buscarAtracaoPorId(id);
        if (!Uteis.validarId(atracao)){
            return;
        }
        atracao = pegarDadosAtracao(atracao);
        banco.alterarAtracao(atracao);
        System.out.println("Alterado com sucesso");
    }

    private void cadastrarAtracao(Scanner scan) {
        Banco banco = new Banco();
        Atracao atracao = new Atracao();
        atracao = pegarDadosAtracao(atracao);
        banco.salvarAtracao(atracao);
    }

    private Atracao pegarDadosAtracao(Atracao atracao){
        System.out.println("Qual o nome da peça?");
        atracao.setNome(scan.nextLine());
        System.out.println("Faixa etaria da peça?");
        FaixaEtaria fe = FaixaEtaria.escolherFaixa(scan);
        while(fe == null){ // Ficará repitindo até que seja selecionado uma opção valida no Enum
            Uteis.validarEnum(fe);
            fe = FaixaEtaria.escolherFaixa(scan);
        } // Fim do While
        atracao.setFaixaEtaria(fe);
        Genero genero = Genero.escolherGerenero(scan);
        while(genero == null){ // Ficará repitindo até que seja selecionado uma opção valida no Enum
            Uteis.validarEnum(genero);
            genero = Genero.escolherGerenero(scan);
        } // Fim do While
        atracao.setGenero(genero);
        System.out.println("Qual é o diretor da peça?");
        atracao.setDiretor(scan.nextLine());
        Horario horario = Horario.escolherHorario(scan);
        while(horario == null){ // Ficará repitindo até que seja selecionado uma opção valida no Enum
            Uteis.validarEnum(horario);
            horario = Horario.escolherHorario(scan);
        } // Fim do While
        atracao.setHorario(horario);
        return atracao;
    }

    private void mostrarPoltrona(Scanner scan){
        Banco banco = new Banco();
        System.out.println("Qual é o ID da atração desejada?");
        Atracao atracao = banco.buscarAtracaoPorId(Integer.valueOf(scan.nextLine()));
        if (!Uteis.validarId(atracao)){
            return;
        }
        System.out.println(atracao.getPoltrona());
    }
}
