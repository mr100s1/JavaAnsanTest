package com.edu.exercise;

import javax.swing.JOptionPane;

//-----------------------------------------------------------------------------------------------------------
// 몇 개를 맞추었는지까지 출력하자!
//-----------------------------------------------------------------------------------------------------------
public class Lotto999 {

	public static void main(String[] args) {
		 
		int[] 	ball	= new int[6];
		int 	success = 0;
		String 	temp = "";
		
		temp = JOptionPane.showInputDialog("1 ~ 45사이의 숫자를 6개 입력하십시요."  + "끝내려면 -1을 입력하십시요.");
		String myBall[] = temp.split(" ");
		for(int i = 0; i < myBall.length; i++ )
			System.out.print(myBall[i] + "\t");
		System.out.println();
		
		// 중복된 번호를 추출하면 다시 추출하도록 한다.
		for( int i = 0; i < 6; i++ )
		{
			ball[i] = (int)(Math.random()*45 + 1);
			/*
			if( i != 0 && ball[i-1] == ball[i] )
				i--;
			*/
			// 2번째부터 앞의 방들과 같은 값이 있는지 비교해서 같은 값이 있으면 번호를 다시 추출한다.
			// if( i > 0 ) // 아래의 for문에서 j < i 이기 때문에 이 부분은 없어도 된다.
			// {
				for( int j = 0; j < i; j++ )
				{
					if( ball[j] == ball[i] )
						i--;	// 같은 값이 있으면 번호를 다시 추출하기 위하여 횟수를 1회 줄인다.
				}
			// }
		}
		// 추출된 번호와 내가 적은 번호가 같으면 success를 1증가시킨다.
		for( int i = 0; i < 6; i++ ) {
			for( int j = 0; j < 6; j++ ) {
				// System.out.print(i + ":" + j + "\n");
				//if( ball[i] == (int)args[j] )
				if( ball[i] == Integer.parseInt(myBall[j]) )
					success++;
			}
		}
		
		
		System.out.println("생성된 번호는");
		System.out.print(ball[0] + "\t" + ball[1] + "\t" + ball[2] + "\t" + ball[3] + "\t" + ball[4] + "\t" + ball[5]);
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");
		System.out.print("내가 맞춘 갯수는 " + success + "개입니다.\n");
		
		// 올림차순으로 정리한다.
		for (int i = 0; i < ball.length-1 ; i++ ) {
			/* 2개의 방을 비교하므로 방의 수보다 1개 적은 만큼만 비교하면 된다.
			 * 가로방향과 세로방향 모두 ball.length-1
			 * 맨 뒤에 방에 제일 큰 값이 가게되므로,
			 * 다음 부터는 큰값을 옮긴 방은 비교 안해도 되므로 1개씩 적게 비교하면 된다.
			 */
			for (int j = 0; j < ball.length-1-i; j++) {
				if(ball[j] > ball[j+1]) { // 다음방의 값이 크면 서로 바꾼다.
					int imsi	= ball[j];
					ball[j] 	= ball[j+1];
					ball[j+1] 	= imsi;
				} // end if
			} // end for j
		} // end for i
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.print("정렬된 번호\t");
		System.out.print(ball[0] + "\t" + ball[1] + "\t" + ball[2] + "\t" + ball[3] + "\t" + ball[4] + "\t" + ball[5] + "\n");
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.print("제출한 번호\t");
		for(int i = 0; i < myBall.length; i++ )
			System.out.print(myBall[i] + "\t");
		System.out.println("\n----------------------------------------------------------------------------");

		
	}
}
