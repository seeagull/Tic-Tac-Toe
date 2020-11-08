import java.util.Random;
import java.util.Scanner;

public class TicTacToe
{
	public static void main(String[] args)
	{
		init_Board();
		print_Board();
		for (int i = 0 ; i < BORT_SIZE*BORT_SIZE; i++ ){
			move_Player(PLAYER_1);
			print_Board();
			if(isPlayerWins(PLAYER_1) == true ) {System.out.println("X-wins"); break;}
			move_Player(PLAYER_2);
			print_Board();
			if(isPlayerWins(PLAYER_2) == true ) {System.out.println("O-wins"); break;}
		}
	}


	static final int   BORT_SIZE = 14;  
	static final int   WIN_SIZE = 5;
	static final char  PLAYER_1 = 'X';
	static final char  PLAYER_2 = 'O';
	static final char  NULL ='-';

	static Scanner Enter = new Scanner(System.in);
	static Random random = new Random();
	static final char[][] BOARD = new char[BORT_SIZE][BORT_SIZE];


	static void init_Board()
	{
		for (int i = 0; i < BORT_SIZE; i++)
		{
			for (int j = 0; j < BORT_SIZE; j++)
			{
				BOARD[i][j] = NULL;
			}
		}
	}

	static void print_Board()
	{
		System.out.print("  \t");
		for (int i = 0; i < BORT_SIZE; i++ )
		{
			System.out.print(i + " \t" );
		}   System.out.println();
		for (int i = 0; i < BORT_SIZE; i++)
		{
			System.out.print(i+ " \t");
			for (int j = 0; j < BORT_SIZE; j++)
			{
				System.out.print(BOARD[i][j] + " \t");
			}
			System.out.println();
		}	
	}


	static void move_Player(char Player)
	{
		int x, y;

		System.out.println("Введите два числа через пробел");
		System.out.println("первое число отвечает за строку, вторая - за столбец");
		for( ; ; )
		{
			x = Enter.nextInt();
			y = Enter.nextInt();
			if (x < 0 || y < 0 || x >= BORT_SIZE || y >= BORT_SIZE) { continue; }
			if (BOARD[x][y] == NULL){break;}
		}
		BOARD[x][y] = Player;
	}

	static boolean isMovePossible(int x, int y)
	{
		if (x < 0 || y < 0 || x >= BORT_SIZE || y >= BORT_SIZE) { return false; }
		if (BOARD[x][y] == NULL)                                { return true; }
		return false;
	}

	static boolean isPlayerWins(char Player)
	{
		int count = 0;
		int i = 0;
		int j = 0;

		// победа, если собраны в столбик

		for ( i = 0 ; i < BORT_SIZE ; i++ ) 
		{
			for ( j = 0 ; j < BORT_SIZE ; j++ ) 
			{
				if (BOARD[i][j] == Player ) { count++;   }
				if (count == WIN_SIZE ) {return true; }       
				if (BOARD[i][j] != Player ) { count = 0; }
			}
		}

		// победа, если собраны с строку 

		for ( j = 0 ; j < BORT_SIZE ; j++ ) 
		{
			for ( i = 0 ; i < BORT_SIZE ; i++ ) 
			{
				if (BOARD[i][j] == Player ) { count++;   }
				if (count == WIN_SIZE ) {return true; }       
				if (BOARD[i][j] != Player ) { count = 0; }
			}
		}

		// победа, если ряд лежит на главной диагонали или ниже
	

		for ( int k1 = 0 ; k1 < BORT_SIZE ; k1++ ) 
		{
			i = k1;
			j = 0;

			for (int k2 = 0 ; k2 < BORT_SIZE - k1 ; k2 ++ ) 
			{
				if (BOARD[i][j] == Player ) { count++;   }
				if (count == WIN_SIZE ) {return true; }       
				if (BOARD[i][j] != Player ) { count = 0; }
				i++; j++;
			}
		}

		// победа если лежит на главной диагонали или выше

		for ( int k1 = 0 ; k1 < BORT_SIZE ; k1++ ) 
		{
			i = 0;
			j = k1;

			for (int k2 = 0 ; k2 < BORT_SIZE - k1 ; k2 ++ ) 
			{
				if (BOARD[i][j] == Player ) { count++;   }
				if (count == WIN_SIZE ) {return true; }       
				if (BOARD[i][j] != Player ) { count = 0; }
				i++; j++;
			}
		}

		// победа если лежит на побочной диагонали или ниже


		for ( int k1 = 0 ; k1 < BORT_SIZE ; k1++ )
		{

			i = k1;
			j = BORT_SIZE - 1;

			for (int k2 = 0 ; k2 < BORT_SIZE - k1 ; k2 ++ ) 
			{
				if (BOARD[i][j] == Player ) { count++;   }
				if (count == WIN_SIZE ) {return true; }       
				if (BOARD[i][j] != Player ) { count = 0; }
				i++; j--;
			}
		}

		// победа если на побочной или выше

		for ( int k1 = 0 ; k1 < BORT_SIZE ; k1++ ) 
		{

			i = 0;
			j = BORT_SIZE - k1 - 1;

			for (int k2 = 0 ; k2 < BORT_SIZE - k1 ; k2 ++ ) 
			{
				if (BOARD[i][j] == Player ) { count++;   }
				if (count == WIN_SIZE ) {return true; }       
				if (BOARD[i][j] != Player ) { count = 0; }
				i++; j--;
			}
		}
		return false;
	} 	
}
	
