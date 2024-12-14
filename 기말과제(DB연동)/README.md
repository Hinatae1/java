![GIFMaker_me (1)](https://github.com/user-attachments/assets/5b77874b-9b20-493c-b342-c6f18bd473e0)                   ---MySQL Workbench를 이용하여 java와 연동하여 출력하기---
<hr>
</br>1.MySQL와 이클립스 연동을 확인 합니다.

</br>설명이 잘되어 있는 사이트
</br>https://blog.naver.com/swoh1227/221058019495


                           ==확인용 DB==
</br>sampledb{id,name,dept}

	public class jdbc {
		public static void main(String[] args) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","12345");
				System.out.println("DB 연결 완료");
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC 드라이버 로드 에러");
			} catch (SQLException e) {
				System.out.println("DB 연결 오류");
			}
		}
	}
<hr>
2.연동이 확인 되면 새로운DB테이블을 만들어 학번,이름,학과,학번 내용을 입력합니다. 
</br>
                             ==DB: student==
</br>테이블 이름:new_table {id varchar(4) pk,   //학번
                    </br>  name varchar(4),    //이름
                    </br>  dept varchar(10),   //학과
                  </br>    grade varchar(1)}   //학년

</br>==들어간 학번,이름,학과,학년==

이름은 랜덤생성사이트에서 참고하였습니다.</br>
사용한 사이트
https://fanmooz.com/%ED%98%84%EB%8C%80-%EC%9D%B4%EB%A6%84%EC%83%9D%EC%84%B1%EA%B8%B0/

학과는 학교 학과를 참고하였습니다.

insert into new_table(id,name,dept,grade) values ('1001','구동현','컴퓨터소프트웨어과','1');</br>
insert into new_table(id,name,dept,grade) values ('1002','복세혁','기계공학과','2');</br>
insert into new_table(id,name,dept,grade) values ('1003','최병권','컴퓨터소프트웨어과','1');</br>
insert into new_table(id,name,dept,grade) values ('1004','정아리','웹툰디자인과','2');</br>
insert into new_table(id,name,dept,grade) values ('1005','양주환','간호학과','4');</br>
insert into new_table(id,name,dept,grade) values ('1006','추하랑','물리치료학과','2');</br>
insert into new_table(id,name,dept,grade) values ('1007','김수연','응급구조학과','3');</br>
insert into new_table(id,name,dept,grade) values ('1008','허지현','보건행정학과','1');</br>
insert into new_table(id,name,dept,grade) values ('1009','이혜민','전기과','1');</br>
insert into new_table(id,name,dept,grade) values ('1010','최은호','경찰경호학과','2');
<hr>
</br>3.DB테이블이 완성이 되면 이클립스에서 학번을 입력하면 이름,학과,학년이 출력되는 프로그램을 작성합니다.</br>

</br>// 사용자로부터 학번 입력받기</br>
String studentId = JOptionPane.showInputDialog(null, "4자리 학번을 입력하세요:", "학생 정보 조회", JOptionPane.QUESTION_MESSAGE);</br></br>
                             입력받는 화면</br>
                       ![3](https://github.com/user-attachments/assets/597f9ef5-c8c2-49dc-86d8-967da92d1927)

// 결과 출력
 JOptionPane.showMessageDialog(null, "이름: " + name + "\n학과: " + dept + "\n학년: " + grade,"학생 정보", JOptionPane.INFORMATION_MESSAGE);</br>
                            실행화면</br>
            ![2024-12-14 18-40-46](https://github.com/user-attachments/assets/cc3f8075-2971-42b7-815d-2f7e6a085c83)










