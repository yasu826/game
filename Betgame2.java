package HighLow;
import java.io.*;

public class Betgame2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String stp;
		boolean flag=true; //終了判定
		int w=0,l=0,d=0; //勝敗カウント
		int ww=0; //連勝カウント
		int money; //持ち金
		int kijun;
		System.out.print("今回のゲームの予算はいくらですか。");
		money=Integer.parseInt(br.readLine());
		System.out.println("------------------------------");
		System.out.println("所持金が10000円以上もしくは500円以下になったらゲームを終了します。");
		System.out.println("勝ちの場合は勝率に基づいたリターン（期待値は1000円）、");
		System.out.println("負の場合は0円、引き分けの場合は500円がもらえます。");
		System.out.println("------------------------------");
		System.out.println("あなたの予算："+money+"円");
		System.out.println();
		
		do {
			System.out.println("参加料500円を徴収いたします");
			money-=500;
			System.out.println("現在の所持金："+money+"円");
			System.out.print("0~100の間で基準値を決めてください。");
			String s=br.readLine();
			try {
				if(s.length()==0) {  //基準値の入力の際に何も書かずにEnterを押した場合は50を基準とする
					kijun=50;
				}else {
					kijun=Integer.parseInt(s);
					if(kijun==0||kijun==100) {
						System.out.println("負ける確率が０になります。もう一度やり直してください。");
						System.out.println("500円返金します。");
						money+=500;
						continue;
					}else if(kijun<0||kijun>100) {
						System.out.println("不適切な数が入力されました。");
						break;
					}
				}
				System.out.println("基準値："+kijun);
			}catch(NumberFormatException e) {
				System.out.println("不適切な数が入力されました。");
				break;
			}
			System.out.print("HIGH(H) or LOW(L) のどちらに賭けますか。");
			String str=br.readLine();
			String stru=str.toUpperCase(); //小文字が入力されたときは大文字に
			char res=stru.charAt(0);
			
			if(res=='H'||res=='L'||res=='h'||res=='l') {
				int c=(int)(Math.random()*101);
				System.out.println("コンピュータの出力値："+c);
				
				if(res=='H'&&c>kijun) {                               //高いと予想して勝ったとき
					System.out.println("あなたの勝ちです。");
					w+=1;
					ww+=1;
					System.out.println(ww+"連勝中");
					money+=(int)((100.0/(100-kijun))*500);
					System.out.println("現在の所持金："+money+"円");
				}else if(res=='L'&&c<kijun) {                         //低いと予想して勝ったとき
					System.out.println("あなたの勝ちです。");
					w+=1;
					ww+=1;
					System.out.println(ww+"連勝中");
					money+=(int)((100.0/(kijun-0))*500);
					System.out.println("現在の所持金："+money+"円");
				}else if((res=='H'&&c<kijun)||(res=='L'&&c>kijun)) {  //負けたとき
					System.out.println("あなたの負けです。");
					l+=1;
					ww=0;
					money-=0;
					System.out.println("現在の所持金："+money+"円");
				}else {                                               //引き分け
					System.out.println("引き分けです。");
					d+=1;
					ww=0;
					money+=500;
					System.out.println("現在の所持金："+money+"円");
				}
				System.out.println("ゲームを終了しますか　e...はい, n...いいえ");
				stp=br.readLine();
				char stpr=stp.charAt(0);
				if(stpr=='e')
					flag=false;
				System.out.println("------------------------------");
			}else {
				System.out.println("不適切な文字が入力されました");
				break;
			}
		}while(flag&&money<=10000&&money>=500);
		
		System.out.println(w+"勝"+l+"敗"+d+"分け");
		System.out.println("現在の所持金："+money+"円");
		System.out.println("ゲームを終了します。ありがとうございました。");
	}
}