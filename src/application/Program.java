package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitites.Lesson;
import entitites.Task;
import entitites.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("DADOS DA " + i + "° aula: ");
			System.out.print("Conteudo ou tarefa (c/t)? ");
			char option = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			
			if(option == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				list.add(new Video(title, url, seconds));
				
			}
			
			else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("quantidade de questões: ");
				int questionCount = sc.nextInt();
				list.add(new Task(title, description, questionCount));
			}
			
			System.out.println();
		}
		
		int sum = 0;
		for(Lesson c : list) {
			sum += c.duration();
			
		}
		
		System.out.println("Duração total do curso = " + sum);
		
		sc.close();
	}

}
