package com.edu.exercise;

import java.util.Scanner;

public class Sungjuk03 {

	public static void main(String[] args) {

		/*
	 	성적 통계 프로그램
	 	
	 	통계를 산출할 학생의 수 - 입력 (o)
	 	
	 	동적할당 -> student[][]
	 	ex) 홍길동	90
	 				100
	 				85
	 				
				일지매	85
						90
						100
						
			....	
			
		이름, 과목점수 - 입력 (o)
				과목점수 >> 숫자로 입력받도록 >> 숫자가 아닌경우 다시 입력 (o)
				0 ~ 100 사이의 숫자 >> 초과한 경우 다시입력 (o)
		
		국어, 수학, 영어 최고 점수
		국어, 수학, 영어 최저 점수
		
		점수의 총합 (o)
		학생 수에 따른 평균 (o)
	 */
	Scanner sc = new Scanner(System.in);
	
	System.out.println("학생 수를 입력해주세요.");
	// 학생 수
	int studentNum = sc.nextInt();
	System.out.println("통계를 낼 학생은 "+studentNum+"명 입니다.");
	
	// 학생 배열
	String student[][] = new String[studentNum][4];
	
	// 학생 정보
	String info;
	
	// 과목
	String subject[] = {"국", "영", "수"};
	
	// 최대, 최소, 총합, 평균 init
	// minimum 값은 제일 큰 값(100)으로 초기화한다. 0으로 하면 0이 제일 작은 값이므로 비교할 수가 없다.
	// 또는 최소값가 최대값은 맨처음 학생의 처음과목 점수로 초기화한다. 현재 프로그램 흐름으로는 힘들다.
	int max = 0, min = 100, sum = 0, avg = 0;
	
	for (int i = 0; i < student.length; i++) {
		System.out.println("\n" + (i+1) + "번째 학생");
		System.out.println("이름, 국어, 영어, 수학점수를 입력해주세요(이름-국어-영어-수학)");
		info = sc.next();
		String infoArr[] = info.split("-");
		
		for(int x = 0; x < infoArr.length; x++)
			System.out.print(infoArr[x] + " ");
		
		out:for (int j = 0; j < infoArr.length; j++) {
			
			student[i][j] = infoArr[j];	//배열에 값 할당
			
			if (j > 0) {				//점수에 해당하는 배열이 숫자가 아닐때 다시 받기
				//숫자일경우
				if ((int)infoArr[j].charAt(0) < 59 && (int)infoArr[j].charAt(0) > 46) {
					// 0 ~ 100인지 판별
					int temp;
					temp = Integer.parseInt(infoArr[j]);
					if (temp > 100 || temp < 0) {
						System.out.println("점수는 0 ~ 100사이의 숫자를 입력해주세요.");
						i--;
						// break out;
						break;
					}
				}
				// 숫자가 아닐경우
				else {
					System.out.println("숫자가 아닙니다.");
					i--;
					// break out;
					break;
				}
			}
		} // for()
	} // for()
	for (int i = 0; i < student.length; i++) {
		for (int j = 0; j < student[i].length; j++) {
			// 이름
			if (j == 0) {
				System.out.println("이름 : " + student[i][j]);
			}
			// 점수
			else {
				System.out.println(subject[j-1]+" : "+student[i][j]);
				//총합
				sum += Integer.parseInt(student[i][j]);
				//최대
				if (max < Integer.parseInt(student[i][j])) {
					max = Integer.parseInt(student[i][j]);
				}
				//최소 : min의 값이 0으로 초기화 되어 있기 때문에 이곳에 못들어옴.
				if (min > Integer.parseInt(student[i][j])) {
					min = Integer.parseInt(student[i][j]);
				}
			}
		}
		System.out.println();
	}
	// 평균
	avg = sum / student.length;
	System.out.println("총합 : "+ sum);
	System.out.println("평균 : "+ avg);
	System.out.println("최대 : "+ max);
	System.out.println("최소 : "+ min);
	
	sc.close();
	}

}
