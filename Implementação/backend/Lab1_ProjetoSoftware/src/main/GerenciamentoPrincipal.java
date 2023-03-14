package main;

import main.controller.AlunoController;
import main.controller.MatriculaController;
import main.model.Aluno;
import main.model.Disciplina;
import main.model.Requests.MatriculaRequestAlunos;
import main.service.AlunoService;
import main.service.Impl.AlunoServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.Scanner;

public class GerenciamentoPrincipal {

    AlunoService alunoService = new AlunoServiceImpl();
    AlunoController alunoController = new AlunoController();

    MatriculaController matriculaController = new MatriculaController();
    public void selecionarDisciplinas(Long idAluno) throws Exception{

        Aluno aluno = alunoService.findAlunoById(idAluno);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Disciplina> disciplinasDisponiveis = (LinkedList<Disciplina>) aluno.getCurriculo().getDisciplinasDoCurriculo();
        LinkedList<Integer> idsDesejados = new LinkedList<Integer>();

        for (Disciplina disciplinaAtual:
             disciplinasDisponiveis) {
           System.out.println("Disciplna: "+disciplinaAtual.getNome()+" Código: "+disciplinaAtual.getId());

        }

        String entrada="";
        do{
            System.out.println("digite salvar a qualquer momento para finalizar as escolhas");
            System.out.println("digite o id das disciplinas que deseja se matricular: ");
            entrada = input.readLine();
            if(!entrada.equals("salvar")){
                idsDesejados.add(Integer.parseInt(entrada));
            }
                      
        }while (entrada.equals("salvar"));
       
        LinkedList<Disciplina> disciplinasSelecionadas = new LinkedList<Disciplina>();


        /*disciplinasSelecionadas = (LinkedList<Disciplina>) disciplinasDisponiveis
                .stream()
                .filter(f -> idsDesejados.contains(f.getId()))
                .collect(Collectors.toList());*/

        for (Disciplina disciplinaAtual:
                disciplinasDisponiveis) {

            if(idsDesejados.contains(disciplinaAtual.getId())){
                disciplinasSelecionadas.add(disciplinaAtual);

            }
        }

        LinkedList<Disciplina> resultado = (LinkedList<Disciplina>) alunoController.matricularEmDisciplinas (disciplinasSelecionadas,idAluno);

        if(resultado!=null){
            System.out.println("Matriculado com Sucesso");
            for (Disciplina disciplinaAtual:
                    resultado) {
                System.out.println("Disciplna: "+disciplinaAtual.getNome()+" Código: "+disciplinaAtual.getId());

            }

        }else {
            System.out.println("Não foi possivel se matricuar, requisitos não atendem");
        }
    }

    private void matricularAluno() throws Exception {

        MatriculaRequestAlunos requisicaoDeMatriculaAluno = new MatriculaRequestAlunos();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Digite o nome do aluno: ");
        requisicaoDeMatriculaAluno.setNome(input.readLine());
        System.out.println("");

        System.out.print("Digite o nome de um familiar do aluno: ");
        requisicaoDeMatriculaAluno.setNomeFamiliar(input.readLine());
        System.out.println("");

        System.out.print("Digite o nome de um documento legal do aluno: ");
        requisicaoDeMatriculaAluno.setDocumentoLegal(input.readLine());
        System.out.println("");

        System.out.print("Digite o nome do curso do aluno: ");
        requisicaoDeMatriculaAluno.setCurso(input.readLine());
        System.out.println("");

        System.out.print("Digite o numero do curriculo do aluno: ");
        requisicaoDeMatriculaAluno.setCurriculo(input.readLine());
        System.out.println("");

        requisicaoDeMatriculaAluno.setDataAtual(new Date());

        System.out.print("Digite o endereço completo do aluno: ");
        requisicaoDeMatriculaAluno.setEndereco(input.readLine());
        System.out.println("");

        Aluno novoAluno = matriculaController.matriculaAluno(requisicaoDeMatriculaAluno);

        if (novoAluno != null){
            System.out.println("Aluno cadastrado com sucesso, Matricula: "+novoAluno.getMatricula());
        }else{
            System.out.println("Falha ao matricular aluno");
        }


    }

    private static void menuPrincipal() {

        System.out.println("Seja Bem vindo a nossa escola !!!");
		System.out.println("\n\tMenu:");
		System.out.println("1. Logar na plataforma");
		System.out.println("2. Realizar Matricula");

		System.out.println("3. Finalizar o menu principal");
		System.out.println("Digite a opcao desejada:");
	}
    private static void menuMatricula() {
        System.out.println("\n\tMenu:");
		System.out.println("1. Realizar Matricula de Aluno");
		System.out.println("2. Realizar Matricula de Professor");

		System.out.println("3. Finalizar o menu de matrícula");
		System.out.println("Digite a opcao desejada:");
    }

    public static void main(String[] args) throws Exception {
        String entradaMenu, entradaMenuMatricula;
        Boolean isAtivo = true;
        GerenciamentoPrincipal gerenciamentoPrincipal = new GerenciamentoPrincipal();
        try (Scanner ler = new Scanner(System.in)){
            while (isAtivo) {
                menuPrincipal();

				entradaMenu = ler.nextLine();

                switch (Integer.parseInt(entradaMenu)) {
                    //logar na plataforma
                    case 1:
                     
                    break;
                    
                    
                    //realizar matriculas
                    case 2:
                   
                    menuMatricula();

                    entradaMenuMatricula = ler.nextLine();
    
                    switch (Integer.parseInt(entradaMenuMatricula)) {
                        //matricula do aluno
                        case 1:
                            gerenciamentoPrincipal.matricularAluno();
                            //gerenciamentoPrincipal.selecionarDisciplinas(Long.valueOf(1));
                            break;
                            case 2:

                            break;

                            case 3:

                            break;


                    }
                           

                    

                    case 3:
						isAtivo = false;
						System.out.println("Programa finalizado!");
						break;

					default:

						System.out.println("Comando inválido");
						break;
                
                }
            }
        }
    }
}
        
        

        

        



    



