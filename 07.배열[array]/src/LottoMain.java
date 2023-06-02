
public class LottoMain {

	public static void main(String[] args) {
		System.out.println("--------로또번호 6개 생성[중복번호 허용안됨]");
		int[] lottoNumber = {0,0,0,0,0,0};
		
		/*
		 * 번호생성
		 */
		
		/* -Quiz중복체크!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11
		 * 버블
		 */
	
		for(int i =0; i < lottoNumber.length; i++) {
			lottoNumber[i] = (int)( Math.random() * 45) + 1;
			/*for (int k = 0; k < lottoNumber.length; k++) {
				if(lottoNumber[i] == lottoNumber[k]) { // 이게 배열안에 있는 번호면  다시 하도록
					
				}*/
			
			}
		/*
		 * 번호출력
		 */
		for(int i =0; i < lottoNumber.length; i++) {
			System.out.print(lottoNumber[i]+ " ");
		}
		
	}

}
