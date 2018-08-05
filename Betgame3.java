package HighLow;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Betgame3 {   //カジノのルーレットです。

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean bet_flag,game_flag;
		int money,bet;
		ArrayList<ArrayList<Integer>> m36=new ArrayList<ArrayList<Integer>>();  //インサイドベット用の数字と賭け金を格納した二次元配列
		ArrayList<ArrayList<Integer>> m18=new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> m12=new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> m9=new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> m6=new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> m2=new ArrayList<ArrayList<Integer>>();  //アウトサイドベット用の数字と賭け金を格納した２次元配列
		ArrayList<ArrayList<Integer>> m3=new ArrayList<ArrayList<Integer>>();
		
		System.out.println("カジノのルーレットへようこそ！");
		do {
			System.out.print("今回のゲームの予算はいくらですか。");
			money=Integer.parseInt(br.readLine());          //所持金
			if(money<1000)
				System.out.println("最低でも1000円ないとゲームに参加できません。"); //1000円を最低の初期額とする
		}while(money<1000);
		System.out.println("あなたの予算："+money+"円");
		System.out.println();
		System.out.println("ーーーーーーーーーーーーーーーーーーーーーーーーーー");
		System.out.println("【ルーレット表】   (◯で囲まれたものは赤)");
		System.out.println("③,6,⑨,⑫,15,⑱,㉑,24,㉗,㉚,33,㊱   | 2 to 1 (3)");
		System.out.println("2,⑤,8,11, ⑭,17,20,㉓,26,29,㉜,35  | 2 to 1 (2)");
		System.out.println("①,4,⑦,10,13,⑯,⑲,22,㉕,28,31,㉞   | 2 to 1 (1)");
		System.out.println("| 1st 12  |  2nd 12  |  3rd 12  |");
		System.out.println("|1to18|EVEN|RED|BLACK|ODD|19to36|");
		System.out.println("************************************************************");
		
		do {
			game_flag=false; //ゲームを続けるかの判定
			do {
				bet_flag=false; //賭けを続けるかの判定
				do {
					System.out.println("賭け金を入力してください。");
					bet=Integer.parseInt(br.readLine());
					if(bet<100)
						System.out.println("最低でも100円の賭け金が必要となっております。"); //100円を最低のベット額とする
				}while(bet<100);
				money-=bet;
				System.out.println("賭けるエリアを選んでください。");
				System.out.println("[インサイドベット]...1, [アウトサイドベット]...2");
				int io=Integer.parseInt(br.readLine());
				
				switch(io) {
				case 1: System.out.println("選ぶ数字の個数を選択してください。");
						int num=Integer.parseInt(br.readLine());
						System.out.println("選んだ数字を順番に書いてください。");
						switch(num) {
						case 1:ArrayList<Integer> b1=new ArrayList<Integer>();
							   b1.add(Integer.parseInt(br.readLine()));
							   b1.add(bet);
							   m36.add(b1);
							   break;
						case 2:ArrayList<Integer> b2=new ArrayList<Integer>();
							   for(int i=0;i<2;i++)
								   b2.add(Integer.parseInt(br.readLine()));
							   b2.add(bet);
							   m18.add(b2);
							   break;
						case 3:ArrayList<Integer> b3=new ArrayList<Integer>();
							   for(int i=0;i<3;i++)
								   b3.add(Integer.parseInt(br.readLine()));
							   b3.add(bet);
							   m12.add(b3);
							   break;
						case 4:ArrayList<Integer> b4=new ArrayList<Integer>();
							   for(int i=0;i<4;i++)
								   b4.add(Integer.parseInt(br.readLine()));
							   b4.add(bet); 
							   m9.add(b4);
							   break;
						case 6:ArrayList<Integer> b6=new ArrayList<Integer>();
							   for(int i=0;i<6;i++)
								   b6.add(Integer.parseInt(br.readLine()));
							   b6.add(bet);
							   m6.add(b6);
							   break;
						}
						break;
				case 2: System.out.println("掛けるエリアを選んでください。");
					    System.out.println("[2 to 1 (3)]...1, [2 to 1 (2)]...2, [2 to 1 (1)]...3");
					    System.out.println("[1st 12]...4, [2nd 12]...5, [3rd 12]...6");
					    System.out.println("[1to18]...7, [EVEN]...8, [RED]...9, [BLACK]...10, [ODD]...11, [19to36]...12");
						int out=Integer.parseInt(br.readLine());
						
						switch(out) {
						case 1: ArrayList<Integer> a1=new ArrayList<Integer>();
								a1.addAll(Arrays.asList(3,6,9,12,15,18,21,24,27,30,33,36));
								a1.add(bet);m3.add(a1);break;
						case 2: ArrayList<Integer> a2=new ArrayList<Integer>();
								a2.addAll(Arrays.asList(2,5,8,11,14,17,20,23,26,29,32,35));
								a2.add(bet);m3.add(a2);break;
						case 3: ArrayList<Integer> a3=new ArrayList<Integer>();
								a3.addAll(Arrays.asList(1,4,7,10,13,16,19,22,25,28,31,34));
								a3.add(bet);m3.add(a3);break;
						case 4: ArrayList<Integer> a4=new ArrayList<Integer>();
								a4.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
								a4.add(bet);m3.add(a4);break;
						case 5: ArrayList<Integer> a5=new ArrayList<Integer>();
								a5.addAll(Arrays.asList(13,14,15,16,17,18,19,20,21,22,23,24));
								a5.add(bet);m3.add(a5);break;
						case 6: ArrayList<Integer> a6=new ArrayList<Integer>();
								a6.addAll(Arrays.asList(25,26,27,28,29,30,31,32,33,34,35,36));
								a6.add(bet);m3.add(a6);break;
						case 7: ArrayList<Integer> a7=new ArrayList<Integer>();
								a7.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18));
								a7.add(bet);m2.add(a7);break;
						case 8: ArrayList<Integer> a8=new ArrayList<Integer>();
								a8.addAll(Arrays.asList(2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36));	
								a8.add(bet);m2.add(a8);break;
						case 9: ArrayList<Integer> a9=new ArrayList<Integer>();
								a9.addAll(Arrays.asList(1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36));
								a9.add(bet);m2.add(a9);break;
						case 10: ArrayList<Integer> a10=new ArrayList<Integer>();
								a10.addAll(Arrays.asList(2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35));
								a10.add(bet);m2.add(a10);break;
						case 11: ArrayList<Integer> a11=new ArrayList<Integer>();
								a11.addAll(Arrays.asList(1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35));
								a11.add(bet);m2.add(a11);break;
						case 12: ArrayList<Integer> a12=new ArrayList<Integer>();
								a12.addAll(Arrays.asList(19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36));
								a12.add(bet);m2.add(a12);break;
						}
						break;
				}
				
				System.out.println("現在の所持金："+money+"円");
				System.out.println("さらに賭けますか？ 1...はい, 2...いいえ");
				if(Integer.parseInt(br.readLine())==1)
					bet_flag=true;
				System.out.println("ーーーーーーーーーーーーーーーーーーーーーーーーーー");
			}while(bet_flag);
			
			System.out.println("現在の所持金："+money+"円");
			System.out.println("ではルーレットを開始します。");
			int c=(int)(Math.random()*37);
			System.out.println("ルーレットの結果は"+c+"です。");
			int get_money=0;
			
			if(m36.size()!=0) {                                       //36倍のリターン
				int l=m36.size();
				for(int i=0;i<l;i++) {
					int ll=m36.get(i).size();
					for(int j=0;j<ll;j++) 
						if(m36.get(i).get(j)==c) 
							get_money+=(m36.get(i).get(ll-1))*36;
				}
			}
			if(m18.size()!=0) {                                       //18倍のリターン
				int l=m18.size();
				for(int i=0;i<l;i++) {
					int ll=m18.get(i).size();
					for(int j=0;j<ll;j++) 
						if(m18.get(i).get(j)==c) 
							get_money+=(m18.get(i).get(ll-1))*18;
				}
			}
			if(m12.size()!=0) {
				int l=m12.size();
				for(int i=0;i<l;i++) {
					int ll=m12.get(i).size();
					for(int j=0;j<ll;j++) 
						if(m12.get(i).get(j)==c) 
							get_money+=(m12.get(i).get(ll-1))*12;
				}
			}
			if(m9.size()!=0) {
				int l=m9.size();
				for(int i=0;i<l;i++) {
					int ll=m9.get(i).size();
					for(int j=0;j<ll;j++) 
						if(m9.get(i).get(j)==c) 
							get_money+=(m9.get(i).get(ll-1))*9;
				}
			}
			if(m6.size()!=0) {
				int l=m6.size();
				for(int i=0;i<l;i++) {
					int ll=m6.get(i).size();
					for(int j=0;j<ll;j++) 
						if(m6.get(i).get(j)==c) 
							get_money+=(m6.get(i).get(ll-1))*6;
				}
			}
			if(m2.size()!=0) {
				int l=m2.size();
				for(int i=0;i<l;i++) {
					int ll=m2.get(i).size();
					for(int j=0;j<ll;j++) 
						if(m2.get(i).get(j)==c) 
							get_money+=(m2.get(i).get(ll-1))*2;
				}
			}
			if(m3.size()!=0) {
				int l=m3.size();
				for(int i=0;i<l;i++) {
					int ll=m3.get(i).size();
					for(int j=0;j<ll;j++) 
						if(m3.get(i).get(j)==c) 
							get_money+=(m3.get(i).get(ll-1))*3;
				}
			}
			
			m36.clear(); //次のゲームに備えて空にしておく
			m18.clear();
			m12.clear();
			m9.clear();
			m6.clear();
			m2.clear();
			m3.clear();
			
			System.out.println(get_money+"円当たりました。");
			money+=get_money;
			System.out.println("現在の所持金："+money+"円");
			if(money<100) {
				System.out.println("所持金が100円を下回ったので、ゲームにこれ以上参加することは出来ません。");
				System.out.println("************************************************************");
				break;
			}
			System.out.println("まだゲームを続けますか？　1...はい, 2...いいえ");
			if(Integer.parseInt(br.readLine())==1)
				game_flag=true;
			System.out.println("************************************************************");
		}while(game_flag);
		
		System.out.println("現在の所持金："+money+"円");
		System.out.println("本日はカジノのルーレットへお越しいただき有難うございました。");
		System.out.println("またのご来場をお待ちしております。");
	}
}
