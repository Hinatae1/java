import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class jdbc {
	 public static void main(String[] args) {
	        // DB 연결 정보
	        String url = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String password = "12345";

	        try {
	            // JDBC 드라이버 로드
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // 데이터베이스 연결
	            Connection conn = DriverManager.getConnection(url, user, password);

	            // 사용자로부터 학번 입력받기
	            String studentId = JOptionPane.showInputDialog(null, "4자리 학번을 입력하세요:", "학생 정보 조회", JOptionPane.QUESTION_MESSAGE);

	            if (studentId != null && studentId.trim().length() == 4 && studentId.matches("\\d{4}")) {
	                // SQL 쿼리 실행
	                String query = "SELECT name, dept, grade FROM new_table WHERE id = ?";
	                PreparedStatement pstmt = conn.prepareStatement(query);
	                pstmt.setInt(1, Integer.parseInt(studentId));

	                ResultSet rs = pstmt.executeQuery();

	                // 결과 확인 및 출력
	                if (rs.next()) {
	                    String name = rs.getString("name");
	                    String dept = rs.getString("dept");
	                    int grade = rs.getInt("grade");

	                    // 결과 출력
	                    JOptionPane.showMessageDialog(null, "이름: " + name + "\n학과: " + dept + "\n학년: " + grade,
	                            "학생 정보", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(null, "해당 학번의 학생을 찾을 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
	                }

	                // 리소스 닫기
	                rs.close();
	                pstmt.close();
	            } else {
	                JOptionPane.showMessageDialog(null, "4자리 숫자의 학번을 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
	            }

	            conn.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "JDBC 드라이버를 찾을 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "DB 연결 실패: " + e.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "올바른 4자리 학번을 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
	        }
	    }
}