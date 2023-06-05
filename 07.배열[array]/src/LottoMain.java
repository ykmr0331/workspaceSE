
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
		 for (int i = 0; i < lottoNumber.length; i++) {
	            boolean isDuplicate; // 중복여부가 true인지 false인지
	            do { // do-while문 시작
	                isDuplicate = false; //중복여부 값을 false로 초기화
	                lottoNumber[i] = (int) (Math.random() * 45) + 1;

	                // 중복 체크
	                for (int j = 0; j < i; j++) {//i가 j보다 커야 앞에 이미 적힌 로또들이 지금 적은 로또번호랑 같은지 비교할 수 있다.
	                    if (lottoNumber[i] == lottoNumber[j]) {
	                        isDuplicate = true;
	                        break;
	                    }
	                }
	            } while (isDuplicate);
	        }

		/*
		 * 번호출력
		 */
		for(int i =0; i < lottoNumber.length; i++) {
			System.out.print(lottoNumber[i]+ " ");
		}
		
	}

}
