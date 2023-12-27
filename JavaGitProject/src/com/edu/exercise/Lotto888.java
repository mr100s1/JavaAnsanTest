package com.edu.exercise;

//-----------------------------------------------------------------------------------------------------------
class Lotto888 {

	 public static void main(String[] args) {

		int[] ball = new int[6];	// 추출한 로또번호를 저장할 배열을 만든다.
		for( int i = 0; i < 6; i++ )
			System.out.print(ball[i] + "\t");
		System.out.println();

		// 로또번호를 6개 추출한다. 1 ~ 45 사이의 정수값을 추출한다.
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
		System.out.print(ball[0] + "\t" + ball[1] + "\t" + ball[2] + "\t" + ball[3] + "\t" + ball[4] + "\t" + ball[5]);
		System.out.println();

		// 올림차순으로 정리한다.
		for (int i = 0; i < ball.length-1 ; i++ ) {
			/* 2개의 방을 비교하므로 방의 수보다 1개 적은 만큼만 비교하면 된다.
			 * 가로방향과 세로방향 모두 ball.length-1
			 * 맨 뒤에 방에 제일 큰 값이 가게되므로,
			 * 다음 부터는 큰값을 옮긴 방은 비교 안해도 되므로 1개씩 적게 비교하면 된다.
			 */
			for (int j = 0; j < ball.length-1-i; j++) {
				if(ball[j] > ball[j+1]) { // 다음방의 값이 크면 서로 바꾼다.
					int temp	= ball[j];
					ball[j] 	= ball[j+1];
					ball[j+1] 	= temp;
				} // end if
			} // end for j
		} // end for i
		
		System.out.print(ball[0] + "\t" + ball[1] + "\t" + ball[2] + "\t" + ball[3] + "\t" + ball[4] + "\t" + ball[5]);

	 }
}