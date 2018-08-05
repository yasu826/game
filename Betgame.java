package HighLow;
import java.io.*;

public class Betgame {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String stp;
		boolean flag=true;
		int w=0,l=0,d=0;
		int ww=0;
		int money=3000;
		int get_money;
		int kijun=50;
		
		do {
			System.out.println("現在の所持金："+money+"円");
			System.out.println("基準値："+kijun);
			System.out.println("HIGH(H) or LOW(L)");
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
					get_money=(int)((100.0/(100-kijun))*250);
					System.out.println(get_money+"円勝ちました。");
					money+=get_money;
					System.out.println("現在の所持金："+money+"円");
				}else if(res=='L'&&c<kijun) {                         //低いと予想して勝ったとき
					System.out.println("あなたの勝ちです。");
					w+=1;
					ww+=1;
					System.out.println(ww+"連勝中");
					get_money=(int)((100.0/(kijun-0))*250);
					System.out.println(get_money+"円勝ちました。");
					money+=get_money;
					System.out.println("現在の所持金："+money+"円");
				}else if((res=='H'&&c<kijun)||(res=='L'&&c>kijun)) {
					System.out.println("あなたの負けです。500円を失います。");
					l+=1;
					ww=0;
					money-=500;
					System.out.println("現在の所持金："+money+"円");
				}else {
					System.out.println("引き分けです。");
					d+=1;
					ww=0;
					System.out.println("現在の所持金："+money+"円");
				}
				kijun=c;
				System.out.println("ゲームを終了しますか　e...はい, n...いいえ");
				stp=br.readLine();
				char stpr=stp.charAt(0);
				if(stpr=='e')
					flag=false;
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
