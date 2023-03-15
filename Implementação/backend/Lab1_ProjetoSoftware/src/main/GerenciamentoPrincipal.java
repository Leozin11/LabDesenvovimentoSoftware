package main;

import main.controller.AlunoController;
import main.controller.FuncionarioController;
import main.controller.MatriculaController;
import main.model.Aluno;
import main.model.Disciplina;
import main.model.Requests.DisciplinaRequest;
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
    FuncionarioController funcionarioController = new FuncionarioController();

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

    private void cadastrarDisciplinas() throws Exception {

        DisciplinaRequest disciplinaDesejada = new DisciplinaRequest();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        disciplinaDesejada.setId(0L);

        System.out.print("Digite o nome da disciplina: ");
        disciplinaDesejada.setNome(input.readLine());
        System.out.println("");

        System.out.print("Digite o numero alternativo da disciplina: ");
        disciplinaDesejada.setNumero(input.readLine());
        System.out.println("");

        System.out.print("Digite o periodo regular da disciplina: ");
        disciplinaDesejada.setPeriodo(input.readLine());
        System.out.println("");

        System.out.print("Digite a carga horaria da disciplina: ");
        disciplinaDesejada.setCargaHoraria(input.readLine());
        System.out.println("");

        System.out.print("Digite o numero do curriculo da disciplina: ");
        disciplinaDesejada.setCurriculo(input.readLine());
        System.out.println("");


        System.out.print("Digite o numero do curriculo da disciplina: ");
        disciplinaDesejada.setPeso(Integer.parseInt(input.readLine()));
        System.out.println("");


        System.out.print("Discipline é obrigatoria? (Digite sim ou não)" );
        disciplinaDesejada.setObrigatoria (input.readLine().equals("sim") ? true :false);
        System.out.println("");

        Disciplina novaDisciplina =  funcionarioController.criarDisciplina(disciplinaDesejada);

        if (novaDisciplina != null){
            System.out.println("Disciplina Criada com sucesso: "+novaDisciplina.getId());
        }else{
            System.out.println("Falha criar disciplina");
        }

    }

   private static void menuPrincipal() {

        System.out.println("Seja Bem vindo a nossa escola !!!");
		System.out.println("\n\tMenu Principal:");
		System.out.println("1. Logar na plataforma");
		System.out.println("2. Realizar Matricula");
        System.out.println("3. Cadastrar Disciplina");

		System.out.println("30. Finalizar o menu principal");
		System.out.println("Digite a opcao desejada:");
	}

   private static void menuMatricula() {
        System.out.println("\n\tMenu Matrícula:");
		System.out.println("1. Realizar Matricula de Aluno");
		System.out.println("2. Realizar Matricula de Professor");

		System.out.println("3. Finalizar o menu de matrícula");
		System.out.println("Digite a opcao desejada:");
   }

   private static void menuLogin() {
        System.out.println("\n\tMenu Login:");
		System.out.println("1. Realizar Login de Aluno");
		System.out.println("2. Realizar Login de Professor");
                System.out.println("3. Realizar Login de Secretária");

		System.out.println("4. Finalizar o menu de login");
		System.out.println("Digite a opcao desejada:");
   }


   private static void menuAluno() {
        System.out.println("\n\tMenu Aluno:");
		System.out.println("1. Visualizar turma");

		System.out.println("2. Finalizar o menu de aluno");
		System.out.println("Digite a opcao desejada:");
    }
   private static void menuProfessor() {
        System.out.println("\n\tMenu Professor:");
		System.out.println("1. Visualizar turma");

		System.out.println("2. Finalizar o menu de professor");
		System.out.println("Digite a opcao desejada:");
   }

    private static void menuSecretaria() {
        System.out.println("\n\tMenu Secretaria:");
		System.out.println("1. Visualizar turma");
                System.out.println("2. Gerenciar curso");
                System.out.println("3. Gerenciar disciplina");
                System.out.println("4. Gerenciar currículo");

		System.out.println("5. Finalizar o menu de secretaria");
		System.out.println("Digite a opcao desejada:");
    }



    private static void menuCurso() {
        System.out.println("\n\tMenu Curso:");
		System.out.println("1. Criar");
		System.out.println("2. Editar");
                System.out.println("3. Visualizar");
                System.out.println("4. Deletar");

		System.out.println("5. Finalizar o menu de curso");
		System.out.println("Digite a opcao desejada:");
    }

    private static void menuDiploma() {
        System.out.println("\n\tMenu Curso:");
		System.out.println("1. Criar");
		System.out.println("2. Editar");
                System.out.println("3. Visualizar");
                System.out.println("4. Deletar");

		System.out.println("5. Finalizar o menu de diploma");
		System.out.println("Digite a opcao desejada:");
    }

    private static void menuCurrículo() {
        System.out.println("\n\tMenu Currículo:");
		System.out.println("1. Criar");
		System.out.println("2. Editar");
                System.out.println("3. Visualizar");
                System.out.println("4. Deletar");

		System.out.println("5. Finalizar o menu de currículo");
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
                        gerenciamentoPrincipal.cadastrarDisciplinas();

                    case 30:
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
        
        

        

        



    



